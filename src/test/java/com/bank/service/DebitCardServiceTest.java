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

import com.bank.feature.debitCard.DebitCardService;
import com.bank.feature.debitCard.IDebitCardDao;
import com.bank.model.DebitCard;
import com.bank.util.TestEntityProvider;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
public class DebitCardServiceTest {

	@Mock
	private IDebitCardDao debitCardDao;

	private DebitCardService debitCardService;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		debitCardService = new DebitCardService(debitCardDao);
	}

	@Test
	public void shouldFindAll() {
		Mockito.when(debitCardDao.findAll()).thenReturn(TestEntityProvider.DEBIT_CARD_LIST);
		final List<DebitCard> result = debitCardService.findAll();
		Mockito.verify(debitCardDao).findAll();
		assertEquals(TestEntityProvider.DEBIT_CARD_LIST.size(), result.size());
	}

	@Test
	public void shouldGetOne() {
		Mockito.when(debitCardDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.DEBIT_CARD);
		final DebitCard debitCard = debitCardService.getOne(Matchers.anyLong());
		Mockito.verify(debitCardDao).getOne(Matchers.anyLong());
		assertEquals(TestEntityProvider.DEBIT_CARD.getCardNumber(), debitCard.getCardNumber());
	}

	@Test
	public void shouldDelete() {
		Mockito.doNothing().when(debitCardDao).delete(Matchers.any(DebitCard.class));
		debitCardService.delete(TestEntityProvider.DEBIT_CARD);
		Mockito.verify(debitCardDao).delete(Matchers.any(DebitCard.class));
	}

	@Test
	public void shouldSave() {
		Mockito.when(debitCardDao.save(TestEntityProvider.DEBIT_CARD)).thenReturn(TestEntityProvider.DEBIT_CARD);
		debitCardService.save(TestEntityProvider.DEBIT_CARD);
		Mockito.verify(debitCardDao).save(TestEntityProvider.DEBIT_CARD);
	}
}
