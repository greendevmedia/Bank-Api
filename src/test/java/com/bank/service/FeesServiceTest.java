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

import com.bank.feature.fees.FeesService;
import com.bank.feature.fees.IFeesDao;
import com.bank.model.Fees;
import com.bank.util.TestEntityProvider;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
public class FeesServiceTest {

	@Mock
	private IFeesDao feesDao;

	private FeesService feesService;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		feesService = new FeesService(feesDao);
	}

	@Test
	public void shouldFindAll() {
		Mockito.when(feesDao.findAll()).thenReturn(TestEntityProvider.FEES_LIST);
		final List<Fees> result = feesService.findAll();
		Mockito.verify(feesDao).findAll();
		assertEquals(TestEntityProvider.FEES_LIST.size(), result.size());
	}

	@Test
	public void shouldGetOne() {
		Mockito.when(feesDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.FEES);
		final Fees fees = feesService.getOne(Matchers.anyLong());
		Mockito.verify(feesDao).getOne(Matchers.anyLong());
		assertEquals(TestEntityProvider.FEES.getMonthlyCharge(), fees.getMonthlyCharge(), 0.00);
	}

	@Test
	public void shouldDelete() {
		Mockito.doNothing().when(feesDao).delete(Matchers.any(Fees.class));
		feesService.delete(TestEntityProvider.FEES);
		Mockito.verify(feesDao).delete(Matchers.any(Fees.class));
	}

	@Test
	public void shouldSave() {
		Mockito.when(feesDao.save(TestEntityProvider.FEES)).thenReturn(TestEntityProvider.FEES);
		feesService.save(TestEntityProvider.FEES);
		Mockito.verify(feesDao).save(TestEntityProvider.FEES);
	}

}
