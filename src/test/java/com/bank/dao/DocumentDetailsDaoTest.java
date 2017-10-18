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
import com.bank.feature.documentDetails.IDocumentDetailsDao;
import com.bank.model.DocumentDetails;
import com.bank.model.DocumentType;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@DirtiesContext
@Transactional
public class DocumentDetailsDaoTest {

	@Autowired
	private IDocumentDetailsDao documentDetailsDao;

	@Test
	public void save() {
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS);
		assertNotNull(TestEntityProvider.DOCUMENT_DETAILS.getId());
	}

	@Test
	public void list() {
		final int expectedSize = 2;
		final List<DocumentDetails> documentDetailsList = documentDetailsDao.findAll();
		assertEquals(expectedSize, documentDetailsList.size());
	}

	@Test
	public void getById() {
		final Long id = 1L;
		final DocumentDetails documentDetails = documentDetailsDao.getOne(id);
		assertEquals(DocumentType.IDCARD, documentDetails.getDocumentType());
	}

	@Test
	public void deleteById() {
		final Long id = 2L;
		final int expectedSize = 1;
		documentDetailsDao.delete(id);
		final List<DocumentDetails> documentDetailsList = documentDetailsDao.findAll();
		assertEquals(expectedSize, documentDetailsList.size());
	}

	@Test(expected = ValidationException.class)
	public void shouldThrowExceptionWhenSavingDocumentDetailsWithNullValue() {
		final DocumentDetails documentDetails = new DocumentDetails();
		documentDetailsDao.save(documentDetails);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingDocumentDetailsWithTooLongDocumentNumberValue() {
		final String tooLongDocumentNumber = "AGK1234567";
		final DocumentDetails documentDetails = new DocumentDetails(tooLongDocumentNumber, DocumentType.IDCARD);
		documentDetailsDao.save(documentDetails);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingDocumentDetailsWithTooShortDocumentNumberValue() {
		final String tooShortDocumentumber = "EZK12345";
		final DocumentDetails documentDetails = new DocumentDetails(tooShortDocumentumber, DocumentType.PASSPORT);
		documentDetailsDao.save(documentDetails);
	}
}
