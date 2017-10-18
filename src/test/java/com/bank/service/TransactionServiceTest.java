package com.bank.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bank.feature.transaction.ITransactionDao;
import com.bank.feature.transaction.TransactionService;
import com.bank.model.Transaction;
import com.bank.util.TestEntityProvider;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
public class TransactionServiceTest {
	
	@Mock
	private ITransactionDao transactionDao;

	private TransactionService transactionService;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		transactionService = new TransactionService(transactionDao);
	}

	@Test
	public void shouldFindAll() {
		Mockito.when(transactionDao.findAll()).thenReturn(TestEntityProvider.TRANSACTION_LIST);
		final List<Transaction> result = transactionService.findAll();
		Mockito.verify(transactionDao).findAll();
		assertEquals(TestEntityProvider.TRANSACTION_LIST.size(), result.size());
	}

	@Test
	public void shouldGetOne() {
		Mockito.when(transactionDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.TRANSACTION);
		final Transaction transaction = transactionService.getOne(Matchers.anyLong());
		Mockito.verify(transactionDao).getOne(Matchers.anyLong());
		assertEquals(TestEntityProvider.TRANSACTION.getAmount(), transaction.getAmount(), 0.00);
	}

	@Test
	public void shouldDelete() {
		Mockito.doNothing().when(transactionDao).delete(Matchers.any(Transaction.class));
		transactionService.delete(TestEntityProvider.TRANSACTION);
		Mockito.verify(transactionDao).delete(Matchers.any(Transaction.class));
	}

	@Test
	public void shouldSave() {
		Mockito.when(transactionDao.save(TestEntityProvider.TRANSACTION)).thenReturn(TestEntityProvider.TRANSACTION);
		transactionService.save(TestEntityProvider.TRANSACTION);
		Mockito.verify(transactionDao).save(TestEntityProvider.TRANSACTION);
	}
}
