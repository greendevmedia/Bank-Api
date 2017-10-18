package com.bank.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
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

import com.bank.feature.transaction.ITransactionDao;
import com.bank.model.Transaction;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
public class TransactionDaoTest {

	@Autowired
	private ITransactionDao trasactionDao;

	@Test
	public void shouldSave() {
		trasactionDao.save(TestEntityProvider.TRANSACTION);
		assertNotNull(TestEntityProvider.TRANSACTION.getId());
	}

	@Test
	public void shouldBeList() {
		final int expectedSize = 2;
		final List<Transaction> transactions = trasactionDao.findAll();
		assertEquals(expectedSize, transactions.size());
	}

	@Test
	public void getById() {
		final double expectedTransactionValue = 50;
		final Long id = 1L;
		final Transaction transaction = trasactionDao.getOne(id);
		assertEquals(expectedTransactionValue, transaction.getAmount(), 0.00);
	}

	@Test
	public void delete() {
		final Long id = 2L;
		final int expectedSize = 1;
		trasactionDao.delete(id);
		final List<Transaction> transactions = trasactionDao.findAll();
		assertEquals(expectedSize, transactions.size());
	}

	@Test(expected = ValidationException.class)
	public void shouldThrowExceptionWhenSavingTransactionWithNullValue() {
		final Transaction transaction = new Transaction();
		trasactionDao.save(transaction);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingTransactionWithTooSmallAmount() {
		final double tooSmallAmount = 0;
		final Transaction transaction = new Transaction(LocalDate.now(), tooSmallAmount);
		trasactionDao.save(transaction);
	}
}
