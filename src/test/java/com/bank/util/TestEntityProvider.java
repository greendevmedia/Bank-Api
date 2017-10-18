package com.bank.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.bank.model.Account;
import com.bank.model.Client;
import com.bank.model.Credit;
import com.bank.model.CreditCard;
import com.bank.model.Currency;
import com.bank.model.DebitCard;
import com.bank.model.DocumentDetails;
import com.bank.model.DocumentType;
import com.bank.model.Employee;
import com.bank.model.Fees;
import com.bank.model.Position;
import com.bank.model.Terms;
import com.bank.model.Transaction;

public class TestEntityProvider {
	// Basic Values
	public static final String FIRST_NAME = "Mateusz";
	public static final String LAST_NAME = "Zielinski";
	public static final String EMAIL = "mail@mail.pl";
	public static final int TELEPHONE = 123456789;
	public static final String PASSWORD = "passwords";
	public static final LocalDate BIRTH_DATE = LocalDate.of(1987, 02, 02);
	public static final LocalDate CONTRACT_START = LocalDate.of(2015, 12, 12);
	public static final LocalDate CONTRACT_END = LocalDate.of(2019, 12, 12);
	public static final double SALARY = 2700;
	public static final int HOLIDAY_DAYS = 26;
	public static final String ACCOUNT_NUMBER = "12345678912345678912345678";
	public static final double MAX_DEBIT = 190;
	public static final boolean IS_MONTHLY_SALARY_TRANSFER = true;
	public static final double CREDIT_AMOUNT = 10000;
	public static final double INTEREST = 0.2;
	public static final double PROVISION = 89;
	public static final double INSTALLMENT_AMOUNT = 450;
	public static final long CARD_NUMBER = 1234123412341234L;
	public static final int CARD_CVC = 123;

	// Currency
	public static final Currency CURRENCY_USD = new Currency("USD");
	public static final Currency CURRENCY_EUR = new Currency("EUR");
	public static final List<Currency> CURRENCY_LIST = Arrays.asList(CURRENCY_USD, CURRENCY_EUR);

	// Position
	public static final Position POSITION = new Position("ANALYST");
	public static final List<Position> POSITION_LIST = Arrays.asList(POSITION);

	// DocumentDetails
	public static final DocumentDetails DOCUMENT_DETAILS = new DocumentDetails("CKK123456", DocumentType.PASSPORT);
	public static final List<DocumentDetails> DOCUMENT_DETAILS_LIST = Arrays.asList(DOCUMENT_DETAILS);

	// Fees
	public static final Fees FEES = new Fees(50, 0.10);
	public static final List<Fees> FEES_LIST = Arrays.asList(FEES);

	// Terms
	public static final Terms TERMS = new Terms(50);
	public static final List<Terms> TERMS_LIST = Arrays.asList(TERMS);

	// Transaction
	public static final Transaction TRANSACTION = new Transaction(LocalDate.now(), 50);
	public static final List<Transaction> TRANSACTION_LIST = Arrays.asList(TRANSACTION);

	// Client
	public static final DocumentDetails DOCUMENT_DETAILS_PASSPORT = new DocumentDetails("CFG123456",
			DocumentType.PASSPORT);
	public static final DocumentDetails DOCUMENT_DETAILS_PASSPORT_1 = new DocumentDetails("ABC123345",
			DocumentType.PASSPORT);
	public static final DocumentDetails DOCUMENT_DETAILS_PASSPORT_2 = new DocumentDetails("CER456123",
			DocumentType.PASSPORT);
	public static final DocumentDetails DOCUMENT_DETAILS_PASSPORT_3 = new DocumentDetails("JJJ123456",
			DocumentType.PASSPORT);
	public static final DocumentDetails DOCUMENT_DETAILS_PASSPORT_4 = new DocumentDetails("JPO123456",
			DocumentType.PASSPORT);
	public static final DocumentDetails DOCUMENT_DETAILS_PASSPORT_5 = new DocumentDetails("BKJ123456",
			DocumentType.PASSPORT);
	public static final DocumentDetails DOCUMENT_DETAILS_PASSPORT_6 = new DocumentDetails("BKJ123456",
			DocumentType.PASSPORT);

	public static final Client CLIENT_CORRECT = new Client(FIRST_NAME, LAST_NAME, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_PASSPORT, CONTRACT_START, CONTRACT_END);
	public static Client client = new Client(FIRST_NAME, LAST_NAME, EMAIL, TELEPHONE, PASSWORD, BIRTH_DATE,
			DOCUMENT_DETAILS_PASSPORT_1, CONTRACT_START, CONTRACT_END);
	public static final List<Client> CLIENT_LIST = Arrays.asList(CLIENT_CORRECT);

	// Employee
	public static final DocumentDetails DOCUMENT_DETAILS_IDCARD_1 = new DocumentDetails("GGG555123",
			DocumentType.IDCARD);
	public static final DocumentDetails DOCUMENT_DETAILS_IDCARD_2 = new DocumentDetails("MMM345123",
			DocumentType.IDCARD);
	public static final DocumentDetails DOCUMENT_DETAILS_IDCARD_3 = new DocumentDetails("CBG768908",
			DocumentType.IDCARD);
	public static final DocumentDetails DOCUMENT_DETAILS_IDCARD_4 = new DocumentDetails("KLY123123",
			DocumentType.IDCARD);
	public static final DocumentDetails DOCUMENT_DETAILS_IDCARD_5 = new DocumentDetails("KPK123123",
			DocumentType.IDCARD);
	public static final DocumentDetails DOCUMENT_DETAILS_IDCARD_6 = new DocumentDetails("KQK123123",
			DocumentType.IDCARD);
	public static final DocumentDetails DOCUMENT_DETAILS_IDCARD_7 = new DocumentDetails("KMK123123",
			DocumentType.IDCARD);
	public static final DocumentDetails DOCUMENT_DETAILS_IDCARD_8 = new DocumentDetails("KMK123678",
			DocumentType.IDCARD);
	public static final DocumentDetails DOCUMENT_DETAILS_IDCARD_9 = new DocumentDetails("KMK127893",
			DocumentType.IDCARD);

	public static final Position POSITION_1 = new Position("CREDIT ANALYST");
	public static final Position POSITION_2 = new Position("Teste");
	public static final Position POSITION_3 = new Position("Developer");
	public static final Position POSITION_4 = new Position("Senior developer");
	public static final Position POSITION_5 = new Position("Data specialist");
	public static final Position POSITION_6 = new Position("Marketing specialist");
	public static final Position POSITION_7 = new Position("Bank specialist");
	public static final Position POSITION_8 = new Position("Director");
	public static final Position POSITION_9 = new Position("Quality Specialist");

	public static final Employee EMPLOYEE_CORRECT = new Employee(LAST_NAME, LAST_NAME, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_IDCARD_1, CONTRACT_START, CONTRACT_END, SALARY, HOLIDAY_DAYS, POSITION_1);
	public static Employee employee = new Employee(FIRST_NAME, LAST_NAME, EMAIL, TELEPHONE, PASSWORD, BIRTH_DATE,
			DOCUMENT_DETAILS_IDCARD_2, CONTRACT_START, CONTRACT_END, SALARY, HOLIDAY_DAYS, POSITION_1);
	public static final List<Employee> EMPLOYEE_LIST = Arrays.asList(EMPLOYEE_CORRECT);

	// Account
	public static final DocumentDetails DOCUMENT_DETAILS_ACCOUNT = new DocumentDetails("LLL123123",
			DocumentType.IDCARD);
	public static final DocumentDetails DOCUMENT_DETAILS_ACCOUNT_1 = new DocumentDetails("KOP123123",
			DocumentType.IDCARD);
	public static final DocumentDetails DOCUMENT_DETAILS_ACCOUNT_2 = new DocumentDetails("POL123123",
			DocumentType.IDCARD);
	public static final DocumentDetails DOCUMENT_DETAILS_ACCOUNT_3 = new DocumentDetails("HHH123123",
			DocumentType.IDCARD);
	public static final Currency CURRENCY_ACCOUNT = new Currency("CHF");
	public static final Currency CURRENCY_ACCOUNT_1 = new Currency("CHI");
	public static final Currency CURRENCY_ACCOUNT_2 = new Currency("DBE");
	public static final Currency CURRENCY_ACCOUNT_3 = new Currency("DBK");

	public static final Client CLIENT_ACCOUNT = new Client(FIRST_NAME, LAST_NAME, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_ACCOUNT, CONTRACT_START, CONTRACT_END);
	public static final Client CLIENT_ACCOUNT_1 = new Client(FIRST_NAME, LAST_NAME, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_ACCOUNT_1, CONTRACT_START, CONTRACT_END);
	public static final Client CLIENT_ACCOUNT_2 = new Client(FIRST_NAME, LAST_NAME, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_ACCOUNT_2, CONTRACT_START, CONTRACT_END);
	public static final Client CLIENT_ACCOUNT_3 = new Client(FIRST_NAME, LAST_NAME, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_ACCOUNT_3, CONTRACT_START, CONTRACT_END);
	public static final Account ACCOUNT = new Account(ACCOUNT_NUMBER, CLIENT_ACCOUNT, CURRENCY_ACCOUNT, MAX_DEBIT,
			IS_MONTHLY_SALARY_TRANSFER);
	public static Account account2 = new Account(ACCOUNT_NUMBER, CLIENT_ACCOUNT_1, CURRENCY_ACCOUNT_2, MAX_DEBIT,
			IS_MONTHLY_SALARY_TRANSFER);
	public static final List<Account> ACCOUNT_LIST = Arrays.asList(ACCOUNT);

	// Credit
	public static final DocumentDetails DOCUMENT_DETAILS_CREDIT = new DocumentDetails("LOP123123", DocumentType.IDCARD);
	public static final DocumentDetails DOCUMENT_DETAILS_CREDIT_1 = new DocumentDetails("LNP123123",
			DocumentType.IDCARD);
	public static final DocumentDetails DOCUMENT_DETAILS_CREDIT_2 = new DocumentDetails("LNP199923",
			DocumentType.IDCARD);
	public static final DocumentDetails DOCUMENT_DETAILS_CREDIT_3 = new DocumentDetails("LNP199923",
			DocumentType.IDCARD);
	public static final DocumentDetails DOCUMENT_DETAILS_CREDIT_4 = new DocumentDetails("LNP199908",
			DocumentType.IDCARD);

	public static final Currency CURRENCY_CREDIT = new Currency("PPP");
	public static final Currency CURRENCY_CREDIT_1 = new Currency("KKK");
	public static final Currency CURRENCY_CREDIT_2 = new Currency("KPK");
	public static final Currency CURRENCY_CREDIT_3 = new Currency("OPK");
	public static final Currency CURRENCY_CREDIT_4 = new Currency("OPG");

	public static final Client CLIENT_CREDIT = new Client(FIRST_NAME, LAST_NAME, EMAIL, TELEPHONE, PASSWORD, BIRTH_DATE,
			DOCUMENT_DETAILS_CREDIT, CONTRACT_START, CONTRACT_END);
	public static final Client CLIENT_CREDIT_1 = new Client(FIRST_NAME, LAST_NAME, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_CREDIT_1, CONTRACT_START, CONTRACT_END);
	public static final Client CLIENT_CREDIT_2 = new Client(FIRST_NAME, LAST_NAME, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_CREDIT_2, CONTRACT_START, CONTRACT_END);
	public static final Client CLIENT_CREDIT_3 = new Client(FIRST_NAME, LAST_NAME, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_CREDIT_3, CONTRACT_START, CONTRACT_END);
	public static final Client CLIENT_CREDIT_4 = new Client(FIRST_NAME, LAST_NAME, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_CREDIT_4, CONTRACT_START, CONTRACT_END);

	public static final Credit CREDIT = new Credit(CREDIT_AMOUNT, INTEREST, PROVISION, CLIENT_CREDIT,
			INSTALLMENT_AMOUNT, CURRENCY_CREDIT);
	public static Credit credit2 = new Credit(CREDIT_AMOUNT, INTEREST, PROVISION, CLIENT_CREDIT_1, INSTALLMENT_AMOUNT,
			CURRENCY_CREDIT_1);
	public static final List<Credit> CREDIT_LIST = Arrays.asList(CREDIT);
	
	// CreditCard
	public static final DocumentDetails DOCUMENT_DETAILS_CREDIT_CARD = new DocumentDetails("123456AKG",
			DocumentType.PASSPORT);
	public static final DocumentDetails DOCUMENT_DETAILS_CREDIT_CARD_1 = new DocumentDetails("123756AKG",
			DocumentType.PASSPORT);
	public static final DocumentDetails DOCUMENT_DETAILS_CREDIT_CARD_2 = new DocumentDetails("123096AKG",
			DocumentType.PASSPORT);
	public static final DocumentDetails DOCUMENT_DETAILS_CREDIT_CARD_3 = new DocumentDetails("123766AKG",
			DocumentType.PASSPORT);
	public static final DocumentDetails DOCUMENT_DETAILS_CREDIT_CARD_4 = new DocumentDetails("123436AKG",
			DocumentType.PASSPORT);
	public static final DocumentDetails DOCUMENT_DETAILS_CREDIT_CARD_5 = new DocumentDetails("123106AKG",
			DocumentType.PASSPORT);

	public static final Fees FEES_CREDIT_CARD = new Fees(45, 0.5);
	public static final Fees FEES_CREDIT_CARD_1 = new Fees(42, 0.1);
	public static final Fees FEES_CREDIT_CARD_2 = new Fees(25, 0.25);
	public static final Fees FEES_CREDIT_CARD_3 = new Fees(15, 0.2);
	public static final Fees FEES_CREDIT_CARD_4 = new Fees(5, 0.1);
	public static final Fees FEES_CREDIT_CARD_5 = new Fees(21, 0.5);

	public static final Terms TERMS_CREDIT_CARD = new Terms(56);
	public static final Terms TERMS_CREDIT_CARD_1 = new Terms(46);
	public static final Terms TERMS_CREDIT_CARD_2 = new Terms(26);
	public static final Terms TERMS_CREDIT_CARD_3 = new Terms(216);
	public static final Terms TERMS_CREDIT_CARD_4 = new Terms(52);
	public static final Terms TERMS_CREDIT_CARD_5 = new Terms(16);

	public static final Currency CURRENCY_CREDIT_CARD = new Currency("QWE");
	public static final Currency CURRENCY_CREDIT_CARD_1 = new Currency("QWB");
	public static final Currency CURRENCY_CREDIT_CARD_2 = new Currency("QAB");
	public static final Currency CURRENCY_CREDIT_CARD_3 = new Currency("QQE");
	public static final Currency CURRENCY_CREDIT_CARD_4 = new Currency("QME");
	public static final Currency CURRENCY_CREDIT_CARD_5 = new Currency("QPE");

	public static final Client CLIENT_CREDIT_CARD = new Client(FIRST_NAME, ACCOUNT_NUMBER, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_CREDIT_CARD, CONTRACT_START, CONTRACT_END);
	public static final Client CLIENT_CREDIT_CARD_1 = new Client(FIRST_NAME, ACCOUNT_NUMBER, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_CREDIT_CARD_1, CONTRACT_START, CONTRACT_END);
	public static final Client CLIENT_CREDIT_CARD_2 = new Client(FIRST_NAME, ACCOUNT_NUMBER, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_CREDIT_CARD_2, CONTRACT_START, CONTRACT_END);
	public static final Client CLIENT_CREDIT_CARD_3 = new Client(FIRST_NAME, ACCOUNT_NUMBER, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_CREDIT_CARD_3, CONTRACT_START, CONTRACT_END);
	public static final Client CLIENT_CREDIT_CARD_4 = new Client(FIRST_NAME, ACCOUNT_NUMBER, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_CREDIT_CARD_4, CONTRACT_START, CONTRACT_END);
	public static final Client CLIENT_CREDIT_CARD_5 = new Client(FIRST_NAME, ACCOUNT_NUMBER, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_CREDIT_CARD_5, CONTRACT_START, CONTRACT_END);

	public static final CreditCard CREDIT_CARD = new CreditCard(CLIENT_CREDIT_CARD, CARD_NUMBER, CARD_CVC, CONTRACT_END,
			FEES_CREDIT_CARD, TERMS_CREDIT_CARD, MAX_DEBIT, CURRENCY_CREDIT_CARD);
	public static CreditCard creditCard = new CreditCard(CLIENT_CREDIT_CARD_1, CARD_NUMBER, CARD_CVC, CONTRACT_END,
			FEES_CREDIT_CARD_1, TERMS_CREDIT_CARD_1, MAX_DEBIT, CURRENCY_CREDIT_CARD_1);
	public static final List<CreditCard> CREDIT_CARD_LIST = Arrays.asList(CREDIT_CARD);

	// DebitCard
	public static final Fees FEES_DEBIT_CARD = new Fees(47, 0.5);
	public static final Fees FEES_DEBIT_CARD_1 = new Fees(22, 0.1);
	public static final Fees FEES_DEBIT_CARD_2 = new Fees(59, 0.25);
	public static final Fees FEES_DEBIT_CARD_3 = new Fees(15, 0.2);
	public static final Fees FEES_DEBIT_CARD_4 = new Fees(19, 0.3);

	public static final Terms TERMS_DEBIT_CARD = new Terms(56);
	public static final Terms TERMS_DEBIT_CARD_1 = new Terms(46);
	public static final Terms TERMS_DEBIT_CARD_2 = new Terms(26);
	public static final Terms TERMS_DEBIT_CARD_3 = new Terms(216);
	public static final Terms TERMS_DEBIT_CARD_4 = new Terms(26);

	public static final Currency CURRENCY_DEBIT_CARD = new Currency("QWE");
	public static final Currency CURRENCY_DEBIT_CARD_1 = new Currency("QPB");
	public static final Currency CURRENCY_DEBIT_CARD_2 = new Currency("QQB");
	public static final Currency CURRENCY_DEBIT_CARD_3 = new Currency("QLE");
	public static final Currency CURRENCY_DEBIT_CARD_4 = new Currency("QLL");

	public static final DocumentDetails DOCUMENT_DETAILS_DEBIT_CARD = new DocumentDetails("123456AJU",
			DocumentType.PASSPORT);
	public static final DocumentDetails DOCUMENT_DETAILS_DEBIT_CARD_1 = new DocumentDetails("1237TYAKG",
			DocumentType.PASSPORT);
	public static final DocumentDetails DOCUMENT_DETAILS_DEBIT_CARD_2 = new DocumentDetails("1230IOAKG",
			DocumentType.PASSPORT);
	public static final DocumentDetails DOCUMENT_DETAILS_DEBIT_CARD_3 = new DocumentDetails("1237OPAKG",
			DocumentType.PASSPORT);
	public static final DocumentDetails DOCUMENT_DETAILS_DEBIT_CARD_4 = new DocumentDetails("3237OPAKG",
			DocumentType.PASSPORT);

	public static final Client CLIENT_DEBIT_CARD = new Client(FIRST_NAME, ACCOUNT_NUMBER, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_DEBIT_CARD, CONTRACT_START, CONTRACT_END);
	public static final Client CLIENT_DEBIT_CARD_1 = new Client(FIRST_NAME, ACCOUNT_NUMBER, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_DEBIT_CARD_1, CONTRACT_START, CONTRACT_END);
	public static final Client CLIENT_DEBIT_CARD_2 = new Client(FIRST_NAME, ACCOUNT_NUMBER, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_DEBIT_CARD_2, CONTRACT_START, CONTRACT_END);
	public static final Client CLIENT_DEBIT_CARD_3 = new Client(FIRST_NAME, ACCOUNT_NUMBER, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_DEBIT_CARD_3, CONTRACT_START, CONTRACT_END);
	public static final Client CLIENT_DEBIT_CARD_4 = new Client(FIRST_NAME, ACCOUNT_NUMBER, EMAIL, TELEPHONE, PASSWORD,
			BIRTH_DATE, DOCUMENT_DETAILS_DEBIT_CARD_4, CONTRACT_START, CONTRACT_END);

	public static final Account ACCOUNT_DEBIT_CARD = new Account(ACCOUNT_NUMBER, CLIENT_DEBIT_CARD, CURRENCY_DEBIT_CARD,
			MAX_DEBIT, IS_MONTHLY_SALARY_TRANSFER);
	public static final Account ACCOUNT_DEBIT_CARD_1 = new Account(ACCOUNT_NUMBER, CLIENT_DEBIT_CARD_1,
			CURRENCY_DEBIT_CARD_1, MAX_DEBIT, IS_MONTHLY_SALARY_TRANSFER);
	public static final Account ACCOUNT_DEBIT_CARD_2 = new Account(ACCOUNT_NUMBER, CLIENT_DEBIT_CARD_2,
			CURRENCY_DEBIT_CARD_2, MAX_DEBIT, IS_MONTHLY_SALARY_TRANSFER);
	public static final Account ACCOUNT_DEBIT_CARD_3 = new Account(ACCOUNT_NUMBER, CLIENT_DEBIT_CARD_3,
			CURRENCY_DEBIT_CARD_3, MAX_DEBIT, IS_MONTHLY_SALARY_TRANSFER);
	public static final Account ACCOUNT_DEBIT_CARD_4 = new Account(ACCOUNT_NUMBER, CLIENT_DEBIT_CARD_4,
			CURRENCY_DEBIT_CARD_4, MAX_DEBIT, IS_MONTHLY_SALARY_TRANSFER);

	public static final DebitCard DEBIT_CARD = new DebitCard(CLIENT_DEBIT_CARD, CARD_NUMBER, CARD_CVC, CONTRACT_END,
			FEES_DEBIT_CARD, TERMS_DEBIT_CARD, ACCOUNT_DEBIT_CARD);
	public static DebitCard debitCard = new DebitCard(CLIENT_DEBIT_CARD_1, CARD_NUMBER, CARD_CVC, CONTRACT_START,
			FEES_DEBIT_CARD_1, TERMS_DEBIT_CARD_1, ACCOUNT_DEBIT_CARD_1);
	public static final List<DebitCard> DEBIT_CARD_LIST = Arrays.asList(DEBIT_CARD);

}