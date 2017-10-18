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

import com.bank.feature.creditCard.CreditCardService;
import com.bank.feature.creditCard.ICreditCardDao;
import com.bank.model.CreditCard;
import com.bank.util.TestEntityProvider;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
public class CreditCardServiceTest {

	@Mock
	private ICreditCardDao creditCardDao;

	private CreditCardService creditCardService;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		creditCardService = new CreditCardService(creditCardDao);
	}

	@Test
	public void shouldFindAll() {
		Mockito.when(creditCardDao.findAll()).thenReturn(TestEntityProvider.CREDIT_CARD_LIST);
		final List<CreditCard> result = creditCardService.findAll();
		Mockito.verify(creditCardDao).findAll();
		assertEquals(TestEntityProvider.CREDIT_CARD_LIST.size(), result.size());
	}

	@Test
	public void shouldGetOne() {
		Mockito.when(creditCardDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.CREDIT_CARD);
		final CreditCard creditCard = creditCardService.getOne(Matchers.anyLong());
		Mockito.verify(creditCardDao).getOne(Matchers.anyLong());
		assertEquals(TestEntityProvider.CREDIT_CARD.getCardNumber(), creditCard.getCardNumber());
	}

	@Test
	public void shouldDelete() {
		Mockito.doNothing().when(creditCardDao).delete(Matchers.any(CreditCard.class));
		creditCardService.delete(TestEntityProvider.CREDIT_CARD);
		Mockito.verify(creditCardDao).delete(Matchers.any(CreditCard.class));
	}

	@Test
	public void shouldSave() {
		Mockito.when(creditCardDao.save(TestEntityProvider.CREDIT_CARD)).thenReturn(TestEntityProvider.CREDIT_CARD);
		creditCardService.save(TestEntityProvider.CREDIT_CARD);
		Mockito.verify(creditCardDao).save(TestEntityProvider.CREDIT_CARD);
	}
}
