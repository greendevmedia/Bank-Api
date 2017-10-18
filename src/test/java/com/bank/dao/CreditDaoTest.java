package com.bank.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;
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

import com.bank.feature.client.IClientDao;
import com.bank.feature.credit.ICreditDao;
import com.bank.feature.currency.ICurrencyDao;
import com.bank.feature.documentDetails.IDocumentDetailsDao;
import com.bank.model.Credit;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@DirtiesContext
@Transactional
public class CreditDaoTest {

	@Autowired
	private ICreditDao creditDao;

	@Autowired
	private IClientDao clientDao;

	@Autowired
	private ICurrencyDao currencyDao;

	@Autowired
	private IDocumentDetailsDao documentDetailsDao;

	@Test
	public void shouldSave() {
		currencyDao.save(TestEntityProvider.CURRENCY_CREDIT);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_CREDIT);
		clientDao.save(TestEntityProvider.CLIENT_CREDIT);
		creditDao.save(TestEntityProvider.CREDIT);
		assertNotNull(TestEntityProvider.CREDIT.getId());
	}

	@Test
	public void shouldBeList() {
		final int expectedSize = 2;
		final List<Credit> credits = creditDao.findAll();
		assertEquals(expectedSize, credits.size());
	}

	@Test
	public void shouldGetById() {
		final double expectedCreditAmount = 10000;
		final Long id = 1L;
		final Credit credit = creditDao.getOne(id);
		assertEquals(expectedCreditAmount, credit.getAmount(), 0.00);
	}

	@Test
	public void shouldDeleteNyId() {
		final Long id = 2L;
		final int expectedSize = 1;
		creditDao.delete(id);
		final List<Credit> credits = creditDao.findAll();
		assertEquals(expectedSize, credits.size());
	}

	@Test(expected = ValidationException.class)
	public void shouldThrowExceptionWhenSavingEmployeeWithNullValue() {
		final Credit credit = new Credit();
		creditDao.save(credit);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingTooLowInterest() {
		final double tooLowInterest = 0.0001;
		final Credit credit = TestEntityProvider.credit2;
		credit.setInterest(tooLowInterest);
		credit.setCurrency(TestEntityProvider.CURRENCY_CREDIT_1);
		credit.setOwner(TestEntityProvider.CLIENT_CREDIT_1);
		currencyDao.save(TestEntityProvider.CURRENCY_CREDIT_1);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_CREDIT_1);
		clientDao.save(TestEntityProvider.CLIENT_CREDIT_1);
		creditDao.save(credit);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingTooHighInterest() {
		final double tooHighInterest = 0.0001;
		final Credit credit = TestEntityProvider.credit2;
		credit.setInterest(tooHighInterest);
		credit.setCurrency(TestEntityProvider.CURRENCY_CREDIT_2);
		credit.setOwner(TestEntityProvider.CLIENT_CREDIT_2);
		currencyDao.save(TestEntityProvider.CURRENCY_CREDIT_2);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_CREDIT_2);
		clientDao.save(TestEntityProvider.CLIENT_CREDIT_2);
		creditDao.save(credit);

	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingTooLowProvision() {
		final double tooLowProvision = -1;
		final Credit credit = TestEntityProvider.credit2;
		credit.setProvision(tooLowProvision);
		credit.setCurrency(TestEntityProvider.CURRENCY_CREDIT_3);
		credit.setOwner(TestEntityProvider.CLIENT_CREDIT_3);
		currencyDao.save(TestEntityProvider.CURRENCY_CREDIT_3);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_CREDIT_3);
		clientDao.save(TestEntityProvider.CLIENT_CREDIT_3);
		creditDao.save(credit);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingTooLowInstallmenAmount() {
		final double tooLowInstallmentAmount = 0.5;
		final Credit credit = TestEntityProvider.credit2;
		credit.setInstallmentAmount(tooLowInstallmentAmount);
		credit.setCurrency(TestEntityProvider.CURRENCY_CREDIT_4);
		credit.setOwner(TestEntityProvider.CLIENT_CREDIT_4);
		currencyDao.save(TestEntityProvider.CURRENCY_CREDIT_4);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_CREDIT_4);
		clientDao.save(TestEntityProvider.CLIENT_CREDIT_4);
		creditDao.save(credit);
	}
}
