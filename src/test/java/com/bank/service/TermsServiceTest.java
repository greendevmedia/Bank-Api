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

import com.bank.feature.terms.ITermsDao;
import com.bank.feature.terms.TermsService;
import com.bank.model.Terms;
import com.bank.util.TestEntityProvider;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
public class TermsServiceTest {

	@Mock
	private ITermsDao termsDao;

	private TermsService termsService;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		termsService = new TermsService(termsDao);
	}

	@Test
	public void shouldFindAll() {
		Mockito.when(termsDao.findAll()).thenReturn(TestEntityProvider.TERMS_LIST);
		final List<Terms> result = termsService.findAll();
		Mockito.verify(termsDao).findAll();
		assertEquals(TestEntityProvider.TERMS_LIST.size(), result.size());
	}

	@Test
	public void shouldGetOne() {
		Mockito.when(termsDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.TERMS);
		final Terms terms = termsService.getOne(Matchers.anyLong());
		Mockito.verify(termsDao).getOne(Matchers.anyLong());
		assertEquals(TestEntityProvider.TERMS.getInterestFreePeriod(), terms.getInterestFreePeriod(), 0.00);
	}

	@Test
	public void shouldDelete() {
		Mockito.doNothing().when(termsDao).delete(Matchers.any(Terms.class));
		termsService.delete(TestEntityProvider.TERMS);
		Mockito.verify(termsDao).delete(Matchers.any(Terms.class));
	}

	@Test
	public void shouldSave() {
		Mockito.when(termsDao.save(TestEntityProvider.TERMS)).thenReturn(TestEntityProvider.TERMS);
		termsService.save(TestEntityProvider.TERMS);
		Mockito.verify(termsDao).save(TestEntityProvider.TERMS);
	}
}
