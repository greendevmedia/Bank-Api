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

import com.bank.feature.account.AccountService;
import com.bank.feature.account.IAccountDao;
import com.bank.model.Account;
import com.bank.util.TestEntityProvider;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
public class AccountServiceTest {

	@Mock
	private IAccountDao accountDao;

	private AccountService accountService;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		accountService = new AccountService(accountDao);
	}

	@Test
	public void shouldFindAll() {
		Mockito.when(accountDao.findAll()).thenReturn(TestEntityProvider.ACCOUNT_LIST);
		final List<Account> result = accountService.findAll();
		Mockito.verify(accountDao).findAll();
		assertEquals(TestEntityProvider.ACCOUNT_LIST.size(), result.size(), 00);
	}

	@Test
	public void shouldGetOne() {
		Mockito.when(accountDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.ACCOUNT);
		final Account account = accountService.getOne(Matchers.anyLong());
		Mockito.verify(accountDao).getOne(Matchers.anyLong());
		assertEquals(TestEntityProvider.ACCOUNT.getCurrency(), account.getCurrency());
	}

	@Test
	public void shouldDelete() {
		Mockito.doNothing().when(accountDao).delete(Matchers.any(Account.class));
		accountService.delete(TestEntityProvider.ACCOUNT);
		Mockito.verify(accountDao).delete(Matchers.any(Account.class));
	}

	@Test
	public void shouldSave() {
		Mockito.when(accountDao.save(TestEntityProvider.ACCOUNT)).thenReturn(TestEntityProvider.ACCOUNT);
		accountService.save(TestEntityProvider.ACCOUNT);
		Mockito.verify(accountDao).save(TestEntityProvider.ACCOUNT);
	}

}
