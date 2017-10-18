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

import com.bank.feature.terms.ITermsDao;
import com.bank.model.Terms;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
public class TermsDaoTest {

	@Autowired
	private ITermsDao termsDao;

	@Test
	public void shouldSave() {
		termsDao.save(TestEntityProvider.TERMS);
		assertNotNull(TestEntityProvider.TERMS.getId());
	}

	@Test
	public void shoulBeList() {
		final int expectedSize = 2;
		final List<Terms> termsList = termsDao.findAll();
		assertEquals(expectedSize, termsList.size());
	}

	@Test
	public void getById() {
		final double expectedInterestFreePeriod = 50;
		final Long id = 1L;
		final Terms terms = termsDao.getOne(id);
		assertEquals(expectedInterestFreePeriod, terms.getInterestFreePeriod(), 0.00);
	}

	@Test
	public void deleteById() {
		final Long id = 2L;
		final int expectedSize = 1;
		termsDao.delete(id);
		final List<Terms> termsList = termsDao.findAll();
		assertEquals(expectedSize, termsList.size());
	}

	@Test(expected = ValidationException.class)
	public void shouldThrowExceptionWhenSavingFeesWithZeroValue() {
		final Terms terms = new Terms();
		termsDao.save(terms);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingTermsWithTooSmallInterestFreePeriodValue() {
		final int tooSmallInterestFreePeriod = -1;
		final Terms terms = new Terms(tooSmallInterestFreePeriod);
		termsDao.save(terms);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingTermsWithTooBigInterestFreePeriodValue() {
		final int tooSmallInterestFreePeriod = 400;
		final Terms terms = new Terms(tooSmallInterestFreePeriod);
		termsDao.save(terms);
	}
}
