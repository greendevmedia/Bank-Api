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

import com.bank.feature.documentDetails.DocumentDetailService;
import com.bank.feature.documentDetails.IDocumentDetailsDao;
import com.bank.model.DocumentDetails;
import com.bank.util.TestEntityProvider;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
public class DocumentDetailsServiceTest {

	@Mock
	private IDocumentDetailsDao documentDetailsDao;

	private DocumentDetailService documentDetailsService;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		documentDetailsService = new DocumentDetailService(documentDetailsDao);
	}

	@Test
	public void shouldFindAll() {
		Mockito.when(documentDetailsDao.findAll()).thenReturn(TestEntityProvider.DOCUMENT_DETAILS_LIST);
		final List<DocumentDetails> result = documentDetailsService.findAll();
		Mockito.verify(documentDetailsDao).findAll();
		assertEquals(TestEntityProvider.DOCUMENT_DETAILS_LIST.size(), result.size());
	}

	@Test
	public void shouldGetOne() {
		Mockito.when(documentDetailsDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.DOCUMENT_DETAILS);
		final DocumentDetails documentDetails = documentDetailsService.getOne(Matchers.anyLong());
		Mockito.verify(documentDetailsDao).getOne(Matchers.anyLong());
		assertEquals(TestEntityProvider.DOCUMENT_DETAILS.getDocumentType(), documentDetails.getDocumentType());
	}

	@Test
	public void shouldDelete() {
		Mockito.doNothing().when(documentDetailsDao).delete(Matchers.any(DocumentDetails.class));
		documentDetailsService.delete(TestEntityProvider.DOCUMENT_DETAILS);
		Mockito.verify(documentDetailsDao).delete(Matchers.any(DocumentDetails.class));
	}

	@Test
	public void shouldSave() {
		Mockito.when(documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS))
				.thenReturn(TestEntityProvider.DOCUMENT_DETAILS);
		documentDetailsService.save(TestEntityProvider.DOCUMENT_DETAILS);
		Mockito.verify(documentDetailsDao).save(TestEntityProvider.DOCUMENT_DETAILS);
	}
}
