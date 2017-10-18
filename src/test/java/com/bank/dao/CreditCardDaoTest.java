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

import com.bank.feature.client.IClientDao;
import com.bank.feature.creditCard.ICreditCardDao;
import com.bank.feature.currency.ICurrencyDao;
import com.bank.feature.documentDetails.IDocumentDetailsDao;
import com.bank.feature.fees.IFeesDao;
import com.bank.feature.terms.ITermsDao;
import com.bank.model.CreditCard;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@DirtiesContext
@Transactional
public class CreditCardDaoTest {

	@Autowired
	private ICreditCardDao creditCardDao;

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

	@Test
	public void shouldSave() {
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_CREDIT_CARD);
		feesDao.save(TestEntityProvider.FEES_CREDIT_CARD);
		termsDao.save(TestEntityProvider.TERMS_CREDIT_CARD);
		currencyDao.save(TestEntityProvider.CURRENCY_CREDIT_CARD);
		clientDao.save(TestEntityProvider.CLIENT_CREDIT_CARD);
		creditCardDao.save(TestEntityProvider.CREDIT_CARD);
		assertNotNull(TestEntityProvider.CREDIT_CARD.getId());
	}

	@Test
	public void shouldBeList() {
		final int expectedSize = 2;
		final List<CreditCard> creditCards = creditCardDao.findAll();
		assertEquals(expectedSize, creditCards.size());
	}

	@Test
	public void shouldGetById() {
		final double expectedCardLimit = 4000;
		final Long id = 1L;
		final CreditCard creditCard = creditCardDao.getOne(id);
		assertEquals(expectedCardLimit, creditCard.getCardLimit(), 0.00);
	}

	@Test
	public void shouldDeletebyId() {
		final Long id = 2L;
		final int expectedSize = 1;
		creditCardDao.delete(id);
		final List<CreditCard> crediCards = creditCardDao.findAll();
		assertEquals(expectedSize, crediCards.size());
	}

	@Test(expected = ValidationException.class)
	public void shouldThrowExceptionWhenSavingCreditCardWithNullValue() {
		final CreditCard creditCard = new CreditCard();
		creditCardDao.save(creditCard);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingTooLongCardNumber() {
		final long tooLongCardNumber = 1234123412341234553L;
		CreditCard creditCard = TestEntityProvider.creditCard;
		creditCard.setCardNumber(tooLongCardNumber);
		creditCard.setFees(TestEntityProvider.FEES_CREDIT_CARD_1);
		creditCard.setTerms(TestEntityProvider.TERMS_CREDIT_CARD_1);
		creditCard.setOwner(TestEntityProvider.CLIENT_CREDIT_CARD_1);
		creditCard.setCurrency(TestEntityProvider.CURRENCY_CREDIT_CARD_1);
		feesDao.save(TestEntityProvider.FEES_CREDIT_CARD_1);
		termsDao.save(TestEntityProvider.TERMS_CREDIT_CARD_1);
		currencyDao.save(TestEntityProvider.CURRENCY_CREDIT_CARD_1);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_CREDIT_CARD_1);
		clientDao.save(TestEntityProvider.CLIENT_CREDIT_CARD_1);
		creditCardDao.save(creditCard);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingMinusCardNumber() {
		final long minusCardNumber = -12341234L;
		CreditCard creditCard = TestEntityProvider.creditCard;
		creditCard.setCardNumber(minusCardNumber);
		creditCard.setFees(TestEntityProvider.FEES_CREDIT_CARD_2);
		creditCard.setTerms(TestEntityProvider.TERMS_CREDIT_CARD_2);
		creditCard.setOwner(TestEntityProvider.CLIENT_CREDIT_CARD_2);
		creditCard.setCurrency(TestEntityProvider.CURRENCY_CREDIT_CARD_2);
		feesDao.save(TestEntityProvider.FEES_CREDIT_CARD_2);
		termsDao.save(TestEntityProvider.TERMS_CREDIT_CARD_2);
		currencyDao.save(TestEntityProvider.CURRENCY_CREDIT_CARD_2);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_CREDIT_CARD_2);
		clientDao.save(TestEntityProvider.CLIENT_CREDIT_CARD_2);
		creditCardDao.save(creditCard);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingTooLongCVCNumber() {
		final int tooLongCVCNumber = 1234;
		CreditCard creditCard = TestEntityProvider.creditCard;
		creditCard.setCardCVC(tooLongCVCNumber);
		creditCard.setFees(TestEntityProvider.FEES_CREDIT_CARD_3);
		creditCard.setTerms(TestEntityProvider.TERMS_CREDIT_CARD_3);
		creditCard.setOwner(TestEntityProvider.CLIENT_CREDIT_CARD_3);
		creditCard.setCurrency(TestEntityProvider.CURRENCY_CREDIT_CARD_3);
		feesDao.save(TestEntityProvider.FEES_CREDIT_CARD_3);
		termsDao.save(TestEntityProvider.TERMS_CREDIT_CARD_3);
		currencyDao.save(TestEntityProvider.CURRENCY_CREDIT_CARD_3);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_CREDIT_CARD_3);
		clientDao.save(TestEntityProvider.CLIENT_CREDIT_CARD_3);
		creditCardDao.save(creditCard);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingMinusCVCNumber() {
		final int minusCVCNumber = -1234;
		CreditCard creditCard = TestEntityProvider.creditCard;
		creditCard.setCardCVC(minusCVCNumber);
		creditCard.setFees(TestEntityProvider.FEES_CREDIT_CARD_4);
		creditCard.setTerms(TestEntityProvider.TERMS_CREDIT_CARD_4);
		creditCard.setOwner(TestEntityProvider.CLIENT_CREDIT_CARD_4);
		creditCard.setCurrency(TestEntityProvider.CURRENCY_CREDIT_CARD_4);
		feesDao.save(TestEntityProvider.FEES_CREDIT_CARD_4);
		termsDao.save(TestEntityProvider.TERMS_CREDIT_CARD_4);
		currencyDao.save(TestEntityProvider.CURRENCY_CREDIT_CARD_4);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_CREDIT_CARD_4);
		clientDao.save(TestEntityProvider.CLIENT_CREDIT_CARD_4);
		creditCardDao.save(creditCard);
	}
	
	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingMinusCardLimit() {
		final double minusCardLimit = -1234;
		CreditCard creditCard = TestEntityProvider.creditCard;
		creditCard.setCardLimit(minusCardLimit);
		creditCard.setFees(TestEntityProvider.FEES_CREDIT_CARD_5);
		creditCard.setTerms(TestEntityProvider.TERMS_CREDIT_CARD_5);
		creditCard.setOwner(TestEntityProvider.CLIENT_CREDIT_CARD_5);
		creditCard.setCurrency(TestEntityProvider.CURRENCY_CREDIT_CARD_5);
		feesDao.save(TestEntityProvider.FEES_CREDIT_CARD_5);
		termsDao.save(TestEntityProvider.TERMS_CREDIT_CARD_5);
		currencyDao.save(TestEntityProvider.CURRENCY_CREDIT_CARD_5);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_CREDIT_CARD_5);
		clientDao.save(TestEntityProvider.CLIENT_CREDIT_CARD_5);
		creditCardDao.save(creditCard);
	}
}
