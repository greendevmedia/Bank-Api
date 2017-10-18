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

import com.bank.feature.credit.CreditService;
import com.bank.feature.credit.ICreditDao;
import com.bank.model.Credit;
import com.bank.util.TestEntityProvider;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
public class CreditServiceTest {

	@Mock
	private ICreditDao creditDao;

	private CreditService creditService;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		creditService = new CreditService(creditDao);
	}

	@Test
	public void shouldFindAll() {
		Mockito.when(creditDao.findAll()).thenReturn(TestEntityProvider.CREDIT_LIST);
		final List<Credit> result = creditService.findAll();
		Mockito.verify(creditDao).findAll();
		assertEquals(TestEntityProvider.CREDIT_LIST.size(), result.size());
	}

	@Test
	public void shouldGetOne() {
		Mockito.when(creditDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.CREDIT);
		final Credit credit = creditService.getOne(Matchers.anyLong());
		Mockito.verify(creditDao).getOne(Matchers.anyLong());
		assertEquals(TestEntityProvider.CREDIT.getInstallmentAmount(), credit.getInstallmentAmount(), 0.00);
	}

	@Test
	public void shouldDelete() {
		Mockito.doNothing().when(creditDao).delete(Matchers.any(Credit.class));
		creditService.delete(TestEntityProvider.CREDIT);
		Mockito.verify(creditDao).delete(Matchers.any(Credit.class));
	}

	@Test
	public void shouldSave() {
		Mockito.when(creditDao.save(TestEntityProvider.CREDIT)).thenReturn(TestEntityProvider.CREDIT);
		creditService.save(TestEntityProvider.CREDIT);
		Mockito.verify(creditDao).save(TestEntityProvider.CREDIT);
	}
}
