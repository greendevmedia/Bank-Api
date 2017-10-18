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

import com.bank.feature.currency.ICurrencyDao;
import com.bank.model.Currency;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@DirtiesContext
@Transactional
public class CurrencyDaoTest {

	@Autowired
	private ICurrencyDao currencyDao;

	@Test
	public void shouldSave() {
		currencyDao.save(TestEntityProvider.CURRENCY_USD);
		assertNotNull(TestEntityProvider.CURRENCY_USD.getId());
	}

	@Test
	public void shouldBeList() {
		final int expectedSize = 2;
		final List<Currency> result = currencyDao.findAll();
		assertEquals(expectedSize, result.size());
	}

	@Test
	public void shouldGetById() {
		final String CURRENCY_CODE = "MKJ";
		final Long id = 1L;
		final Currency result = currencyDao.getOne(id);
		assertEquals(CURRENCY_CODE, result.getCurrencyCode());
	}

	@Test
	public void shouldDeleteById() {
		final Long id = 2L;
		final int expectedSize = 1;
		currencyDao.delete(id);
		final List<Currency> result = currencyDao.findAll();
		assertEquals(expectedSize, result.size());
	}

	@Test(expected = ValidationException.class)
	public void shouldThrowExceptionWhenSavingCurrencyWithNullValue() {
		final Currency currency = new Currency();
		currencyDao.save(currency);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingCurrencyWithTooLongValue() {
		final String tooLongCurrencyCode = "USDE";
		final Currency currency = new Currency(tooLongCurrencyCode);
		currencyDao.save(currency);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingCurrencyWithTooShortValue() {
		final String tooShortCurrencyCode = "EU";
		final Currency currency = new Currency(tooShortCurrencyCode);
		currencyDao.save(currency);
	}
}