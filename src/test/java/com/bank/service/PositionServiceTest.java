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

import com.bank.feature.position.IPositionDao;
import com.bank.feature.position.PositionService;
import com.bank.model.Position;
import com.bank.util.TestEntityProvider;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
public class PositionServiceTest {

	@Mock
	private IPositionDao positionDao;
	
	private PositionService positionService;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		positionService = new PositionService(positionDao);
	}

	@Test
	public void shouldFindAll() {
		Mockito.when(positionDao.findAll()).thenReturn(TestEntityProvider.POSITION_LIST);
		final List<Position> result = positionService.findAll();
		Mockito.verify(positionDao).findAll();
		assertEquals(TestEntityProvider.POSITION_LIST.size(), result.size());
	}

	@Test
	public void shouldGetOne() {
		Mockito.when(positionDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.POSITION);
		final Position position = positionService.getOne(Matchers.anyLong());
		Mockito.verify(positionDao).getOne(Matchers.anyLong());
		assertEquals(TestEntityProvider.POSITION.getPosition(), position.getPosition());
	}

	@Test
	public void shouldDelete() {
		Mockito.doNothing().when(positionDao).delete(Matchers.any(Position.class));
		positionService.delete(TestEntityProvider.POSITION);
		Mockito.verify(positionDao).delete(Matchers.any(Position.class));
	}

	@Test
	public void shouldSave() {
		Mockito.when(positionDao.save(TestEntityProvider.POSITION)).thenReturn(TestEntityProvider.POSITION);
		positionService.save(TestEntityProvider.POSITION);
		Mockito.verify(positionDao).save(TestEntityProvider.POSITION);
	}
}
