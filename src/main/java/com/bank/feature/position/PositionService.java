package com.bank.feature.position;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Position;

@Service
@Transactional
public class PositionService implements IPositionService {

	private final IPositionDao postionDao;

	@Autowired
	public PositionService(IPositionDao postionDao) {
		this.postionDao = postionDao;
	}

	@Override
	public List<Position> findAll() {
		return postionDao.findAll();
	}

	@Override
	public Position getOne(Long id) {
		return postionDao.getOne(id);
	}

	@Override
	public void delete(Position arg) {
		postionDao.delete(arg);
	}

	@Override
	public void deleteById(Long id) {
		postionDao.delete(id);
	}

	@Override
	public void save(Position arg) {
		postionDao.save(arg);
	}

}
