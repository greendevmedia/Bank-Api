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
import com.bank.feature.debitCard.IDebitCardDao;
import com.bank.feature.documentDetails.IDocumentDetailsDao;
import com.bank.feature.fees.IFeesDao;
import com.bank.feature.terms.ITermsDao;
import com.bank.model.DebitCard;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@DirtiesContext
@Transactional
public class DebitCardDaoTest {

	@Autowired
	private IDebitCardDao debitCardDao;

	@Autowired
	private IDocumentDetailsDao documentDetailsDao;

	@Autowired
	private IFeesDao feesDao;

	@Autowired
	private ITermsDao termsDao;

	@Autowired
	private IClientDao clientDao;

	@Autowired
	private ICurrencyDao currencyDao;

	@Autowired
	private IAccountDao accountdao;

	@Test
	public void shouldSave() {
		feesDao.save(TestEntityProvider.FEES_DEBIT_CARD);
		termsDao.save(TestEntityProvider.TERMS_DEBIT_CARD);
		currencyDao.save(TestEntityProvider.CURRENCY_DEBIT_CARD);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_DEBIT_CARD);
		clientDao.save(TestEntityProvider.CLIENT_DEBIT_CARD);
		accountdao.save(TestEntityProvider.ACCOUNT_DEBIT_CARD);
		debitCardDao.save(TestEntityProvider.DEBIT_CARD);
		assertNotNull(TestEntityProvider.DEBIT_CARD.getId());
	}

	@Test
	public void shouldBeList() {
		final int expectedSize = 2;
		final List<DebitCard> debitCards = debitCardDao.findAll();
		assertEquals(expectedSize, debitCards.size());
	}

	@Test
	public void shouldGetById() {
		final int expectedCVC = 999;
		final Long id = 1L;
		final DebitCard debitCard = debitCardDao.getOne(id);
		assertEquals(expectedCVC, debitCard.getCardCVC(), 0.00);
	}

	@Test
	public void shouldDeleteById() {
		final Long id = 2L;
		final int expectedSize = 1;
		debitCardDao.delete(id);
		final List<DebitCard> debitCards = debitCardDao.findAll();
		assertEquals(expectedSize, debitCards.size());
	}

	@Test(expected = ValidationException.class)
	public void shouldThrowExceptionWhenSavingDebitCardWithNullValue() {
		final DebitCard debitCard = new DebitCard();
		debitCardDao.save(debitCard);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingTooLongCardNumber() {
		final long tooLongCardNumber = 1234123412341234553L;
		DebitCard debitCard = TestEntityProvider.debitCard;
		debitCard.setCardNumber(tooLongCardNumber);
		debitCard.setFees(TestEntityProvider.FEES_DEBIT_CARD_1);
		debitCard.setTerms(TestEntityProvider.TERMS_DEBIT_CARD_1);
		debitCard.setOwner(TestEntityProvider.CLIENT_DEBIT_CARD_1);
		debitCard.setAccount(TestEntityProvider.ACCOUNT_DEBIT_CARD_1);
		feesDao.save(TestEntityProvider.FEES_DEBIT_CARD_1);
		termsDao.save(TestEntityProvider.TERMS_DEBIT_CARD_1);
		currencyDao.save(TestEntityProvider.CURRENCY_DEBIT_CARD_1);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_DEBIT_CARD_1);
		clientDao.save(TestEntityProvider.CLIENT_DEBIT_CARD_1);
		accountdao.save(TestEntityProvider.ACCOUNT_DEBIT_CARD_1);
		debitCardDao.save(debitCard);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingMinusCardNumber() {
		final long minusCardNumber = -12341234123412345L;
		DebitCard debitCard = TestEntityProvider.debitCard;
		debitCard.setCardNumber(minusCardNumber);
		debitCard.setFees(TestEntityProvider.FEES_DEBIT_CARD_2);
		debitCard.setTerms(TestEntityProvider.TERMS_DEBIT_CARD_2);
		debitCard.setOwner(TestEntityProvider.CLIENT_DEBIT_CARD_2);
		debitCard.setAccount(TestEntityProvider.ACCOUNT_DEBIT_CARD_2);
		feesDao.save(TestEntityProvider.FEES_DEBIT_CARD_2);
		termsDao.save(TestEntityProvider.TERMS_DEBIT_CARD_2);
		currencyDao.save(TestEntityProvider.CURRENCY_DEBIT_CARD_2);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_DEBIT_CARD_2);
		clientDao.save(TestEntityProvider.CLIENT_DEBIT_CARD_2);
		accountdao.save(TestEntityProvider.ACCOUNT_DEBIT_CARD_2);
		debitCardDao.save(debitCard);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingTooLongCVCNumber() {
		final int tooLongCVC = 1234;
		DebitCard debitCard = TestEntityProvider.debitCard;
		debitCard.setCardCVC(tooLongCVC);
		debitCard.setFees(TestEntityProvider.FEES_DEBIT_CARD_3);
		debitCard.setTerms(TestEntityProvider.TERMS_DEBIT_CARD_3);
		debitCard.setOwner(TestEntityProvider.CLIENT_DEBIT_CARD_3);
		debitCard.setAccount(TestEntityProvider.ACCOUNT_DEBIT_CARD_3);
		feesDao.save(TestEntityProvider.FEES_DEBIT_CARD_3);
		termsDao.save(TestEntityProvider.TERMS_DEBIT_CARD_3);
		currencyDao.save(TestEntityProvider.CURRENCY_DEBIT_CARD_3);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_DEBIT_CARD_3);
		clientDao.save(TestEntityProvider.CLIENT_DEBIT_CARD_3);
		accountdao.save(TestEntityProvider.ACCOUNT_DEBIT_CARD_3);
		debitCardDao.save(debitCard);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingMinusCVCNumber() {
		final int minusCVC = -1234;
		DebitCard debitCard = TestEntityProvider.debitCard;
		debitCard.setCardCVC(minusCVC);
		debitCard.setFees(TestEntityProvider.FEES_DEBIT_CARD_4);
		debitCard.setTerms(TestEntityProvider.TERMS_DEBIT_CARD_4);
		debitCard.setOwner(TestEntityProvider.CLIENT_DEBIT_CARD_4);
		debitCard.setAccount(TestEntityProvider.ACCOUNT_DEBIT_CARD_4);
		feesDao.save(TestEntityProvider.FEES_DEBIT_CARD_4);
		termsDao.save(TestEntityProvider.TERMS_DEBIT_CARD_4);
		currencyDao.save(TestEntityProvider.CURRENCY_DEBIT_CARD_4);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_DEBIT_CARD_4);
		clientDao.save(TestEntityProvider.CLIENT_DEBIT_CARD_4);
		accountdao.save(TestEntityProvider.ACCOUNT_DEBIT_CARD_4);
		debitCardDao.save(debitCard);
	}
}
