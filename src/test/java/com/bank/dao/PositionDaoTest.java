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

import com.bank.feature.position.IPositionDao;
import com.bank.model.Position;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@DirtiesContext
@Transactional
public class PositionDaoTest {

	@Autowired
	private IPositionDao positionDao;

	@Test
	public void shouldSave() {
		positionDao.save(TestEntityProvider.POSITION);
		assertNotNull(positionDao.getOne(TestEntityProvider.POSITION.getId()));
	}

	@Test
	public void shouldBeList() {
		final int expectedSize = 2;
		final List<Position> posistions = positionDao.findAll();
		assertEquals(expectedSize, posistions.size());
	}

	@Test
	public void shouldGetById() {
		final String expectedPosition = "ANALYST";
		final Long id = 1L;
		final Position result = positionDao.getOne(id);
		assertEquals(expectedPosition, result.getPosition());
	}

	@Test
	public void shouldDeleteById() {
		final Long id = 2L;
		final int expectedSize = 1;
		positionDao.delete(id);
		final List<Position> posistions = positionDao.findAll();
		assertEquals(expectedSize, posistions.size());
	}

	@Test(expected = ValidationException.class)
	public void shouldThrowExceptionWhenSavingPositionWithNullValue() {
		final Position position = new Position();
		positionDao.save(position);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingPositionWithTooShortValue() {
		final String tooShortPostionName = "Akto";
		final Position position = new Position(tooShortPostionName);
		positionDao.save(position);
	}
}
