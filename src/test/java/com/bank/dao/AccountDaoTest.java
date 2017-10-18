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

import com.bank.feature.account.IAccountDao;
import com.bank.feature.client.IClientDao;
import com.bank.feature.currency.ICurrencyDao;
import com.bank.feature.documentDetails.IDocumentDetailsDao;
import com.bank.model.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@DirtiesContext
@Transactional
public class AccountDaoTest {

	@Autowired
	private IAccountDao accountDao;

	@Autowired
	private IClientDao clientDao;

	@Autowired
	private ICurrencyDao currencyDao;

	@Autowired
	private IDocumentDetailsDao documentDetailsDao;

	@Test
	public void shouldSave() {
		currencyDao.save(TestEntityProvider.CURRENCY_ACCOUNT);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_ACCOUNT);
		clientDao.save(TestEntityProvider.CLIENT_ACCOUNT);
		accountDao.save(TestEntityProvider.ACCOUNT);
		assertNotNull(TestEntityProvider.ACCOUNT.getId());
	}

	@Test
	public void shouldBeList() {
		final int expectedSize = 2;
		final List<Account> accounts = accountDao.findAll();
		assertEquals(expectedSize, accounts.size());
	}

	@Test
	public void getById() {
		final String expectedNumber = "12333678912345678912345678";
		final Long id = 1L;
		final Account account = accountDao.getOne(id);
		assertEquals(expectedNumber, account.getAccountNumber());
	}

	@Test
	public void deleteById() {
		final Long id = 2L;
		final int expectedSize = 1;
		accountDao.delete(id);
		final List<Account> accounts = accountDao.findAll();
		assertEquals(expectedSize, accounts.size());
	}

	@Test(expected = ValidationException.class)
	public void shouldThrowExceptionWhenSavingAccountWithNullValue() {
		final Account account = new Account();
		accountDao.save(account);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingTooLongAccountNumber() {
		final String tooLongAccountNumber = "123456789123456789123456789012123";
		final Account account = TestEntityProvider.account2;
		account.setAccountNumber(tooLongAccountNumber);
		account.setCurrency(TestEntityProvider.CURRENCY_ACCOUNT_1);
		account.setOwner(TestEntityProvider.CLIENT_ACCOUNT_1);
		currencyDao.save(TestEntityProvider.CURRENCY_ACCOUNT_1);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_ACCOUNT_1);
		clientDao.save(TestEntityProvider.CLIENT_ACCOUNT_1);
		accountDao.save(account);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingTooShortAccountNumber() {
		final String tooShortAccountNumber = "123456789123456789";
		final Account account = TestEntityProvider.account2;
		account.setAccountNumber(tooShortAccountNumber);
		account.setCurrency(TestEntityProvider.CURRENCY_ACCOUNT_2);
		account.setOwner(TestEntityProvider.CLIENT_ACCOUNT_2);
		currencyDao.save(TestEntityProvider.CURRENCY_ACCOUNT_2);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_ACCOUNT_2);
		clientDao.save(TestEntityProvider.CLIENT_ACCOUNT_2);
		accountDao.save(account);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingAccountNumberWithLetter() {
		final String accountNumberWithLetters = "12345678912345678912345tyu";
		final Account account = TestEntityProvider.account2;
		account.setAccountNumber(accountNumberWithLetters);
		account.setCurrency(TestEntityProvider.CURRENCY_ACCOUNT_3);
		account.setOwner(TestEntityProvider.CLIENT_ACCOUNT_3);
		currencyDao.save(TestEntityProvider.CURRENCY_ACCOUNT_3);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_ACCOUNT_3);
		clientDao.save(TestEntityProvider.CLIENT_ACCOUNT_3);
		accountDao.save(account);
	}
}
