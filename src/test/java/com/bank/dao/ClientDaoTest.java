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
import com.bank.feature.documentDetails.IDocumentDetailsDao;
import com.bank.model.Client;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@DirtiesContext
@Transactional
public class ClientDaoTest {

	@Autowired
	private IClientDao clientDao;

	@Autowired
	private IDocumentDetailsDao documentDetailsDao;

	@Test
	public void shouldSave() {
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_PASSPORT);
		clientDao.save(TestEntityProvider.CLIENT_CORRECT);
		assertNotNull(TestEntityProvider.CLIENT_CORRECT.getId());
	}

	@Test
	public void shouldBeList() {
		final int expectedSize = 2;
		final List<Client> clients = clientDao.findAll();
		assertEquals(expectedSize, clients.size());
	}

	@Test
	public void getById() {
		final Long id = 1L;
		final Client client = clientDao.getOne(id);
		assertEquals("Franek", client.getFirstName());
	}

	@Test
	public void deleteById() {
		final Long id = 2L;
		final int expectedSize = 1;
		clientDao.delete(id);
		final List<Client> clients = clientDao.findAll();
		assertEquals(expectedSize, clients.size());
	}

	@Test(expected = ValidationException.class)
	public void shouldThrowExceptionWhenSavingClientWithNullValue() {
		final Client client = new Client();
		clientDao.save(client);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingClientBlankFirstName() {
		final String blankFirstname = "";
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_PASSPORT_1);
		Client client = TestEntityProvider.client;
		client.setFirstName(blankFirstname);
		clientDao.save(client);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingClientWithBlankLastName() {
		final String blankLastName = "";
		final Client client = TestEntityProvider.client;
		client.setLastName(blankLastName);
		client.setDocumentDetails(TestEntityProvider.DOCUMENT_DETAILS_PASSPORT_2);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_PASSPORT_2);
		clientDao.save(client);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingClientWithWrongEmail() {
		final String wrongEmail = "Ar.pl";
		final Client client = TestEntityProvider.client;
		client.setEmail(wrongEmail);
		client.setDocumentDetails(TestEntityProvider.DOCUMENT_DETAILS_PASSPORT_3);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_PASSPORT_3);
		clientDao.save(client);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingClientWithTooLongTelephone() {
		final int tooLongTelephone = 1234567891;
		final Client client = TestEntityProvider.client;
		client.setTelephone(tooLongTelephone);
		client.setDocumentDetails(TestEntityProvider.DOCUMENT_DETAILS_PASSPORT_4);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_PASSPORT_4);
		clientDao.save(client);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingClientWithToLongPassword() {
		final String tooLongPassword = "passwordnumber1toolong";
		final Client client = TestEntityProvider.client;
		client.setPassword(tooLongPassword);
		client.setDocumentDetails(TestEntityProvider.DOCUMENT_DETAILS_PASSPORT_5);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_PASSPORT_5);
		clientDao.save(client);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingClientWithTooShortPassword() {
		final String tooShortPassword = "pass";
		final Client client = TestEntityProvider.client;
		client.setDocumentDetails(TestEntityProvider.DOCUMENT_DETAILS_PASSPORT_6);
		client.setPassword(tooShortPassword);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_PASSPORT_6);
		clientDao.save(client);
	}
}