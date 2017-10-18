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

import com.bank.feature.currency.CurrencyService;
import com.bank.feature.currency.ICurrencyDao;
import com.bank.model.Currency;
import com.bank.util.TestEntityProvider;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
public class CurrencyServiceTest {

	@Mock
	private ICurrencyDao currencyDao;

	private CurrencyService currencyService;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		currencyService = new CurrencyService(currencyDao);
	}

	@Test
	public void shouldFindAll() {
		Mockito.when(currencyDao.findAll()).thenReturn(TestEntityProvider.CURRENCY_LIST);
		final List<Currency> result = currencyService.findAll();
		Mockito.verify(currencyDao).findAll();
		assertEquals(TestEntityProvider.CURRENCY_LIST.size(), result.size());
	}

	@Test
	public void shouldGetOne() {
		Mockito.when(currencyDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.CURRENCY_USD);
		final Currency currency = currencyService.getOne(Matchers.anyLong());
		Mockito.verify(currencyDao).getOne(Matchers.anyLong());
		assertEquals(TestEntityProvider.CURRENCY_USD.getCurrencyCode(), currency.getCurrencyCode());
	}

	@Test
	public void shouldDelete() {
		Mockito.doNothing().when(currencyDao).delete(Matchers.any(Currency.class));
		currencyService.delete(TestEntityProvider.CURRENCY_USD);
		Mockito.verify(currencyDao).delete(Matchers.any(Currency.class));
	}

	@Test
	public void shouldSave() {
		Mockito.when(currencyDao.save(TestEntityProvider.CURRENCY_USD)).thenReturn(TestEntityProvider.CURRENCY_USD);
		currencyService.save(TestEntityProvider.CURRENCY_USD);
		Mockito.verify(currencyDao).save(TestEntityProvider.CURRENCY_USD);
	}

}