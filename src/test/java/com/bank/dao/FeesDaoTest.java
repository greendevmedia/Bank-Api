package com.bank.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import com.bank.util.TestEntityProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.bank.feature.fees.IFeesDao;
import com.bank.model.Fees;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@DirtiesContext
@Transactional
public class FeesDaoTest {

	@Autowired
	private IFeesDao feesDao;
	
	private static final double CORRECT_INTEREST_PER_YEAR = 0.5;
	private static final double CORRECT_MONTHLY_CHARGE = 90;

	@Test
	public void shouldSave() {
		feesDao.save(TestEntityProvider.FEES);
		assertNotNull(TestEntityProvider.FEES.getId());
	}

	@Test
	public void shouldBeList() {
		final int expectedSize = 2;
		final List<Fees> feesList = feesDao.findAll();
		assertEquals(expectedSize, feesList.size());
	}

	@Test
	public void getById() {
		final double expectedInterestPerYear = 0.10;
		final Long id = 1L;
		final Fees fees = feesDao.getOne(id);
		assertEquals(expectedInterestPerYear, fees.getInterestRatePerYear(), 0.00);
	}

	@Test
	public void deleteByID() {
		final Long id = 2L;
		final int expectedSize = 1;
		feesDao.delete(id);
		final List<Fees> feesList = feesDao.findAll();
		assertEquals(expectedSize, feesList.size());
	}

	@Test(expected = ValidationException.class)
	public void shouldThrowExceptionWhenSavingFeesWithNullValue() {
		final Fees fees = new Fees();
		feesDao.save(fees);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingFeesWithTooSmallMonthlyChargeValue() {
		final double tooSmallMonthlyCharge = -1;
		final Fees fees = new Fees(tooSmallMonthlyCharge, CORRECT_INTEREST_PER_YEAR);
		feesDao.save(fees);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingFeesWithTooBigMonthlyChargeValue() {
		final double tooBigMonthlyCharge = 101;
		final Fees fees = new Fees(tooBigMonthlyCharge, CORRECT_INTEREST_PER_YEAR);
		feesDao.save(fees);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingFeesWithTooSmallInterestRatePerYearValue() {
		final double tooSmallInterestRatePerYear = 0.0005;
		final Fees fees = new Fees(CORRECT_MONTHLY_CHARGE, tooSmallInterestRatePerYear);
		feesDao.save(fees);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingFeesWithTooBigInterestRatePerYearValue() {
		final double tooBigInterestRatePerYear = 1.1;
		final Fees fees = new Fees(CORRECT_MONTHLY_CHARGE, tooBigInterestRatePerYear);
		feesDao.save(fees);
	}
}
