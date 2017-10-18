package com.bank.feature.fees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Fees;

@Service
@Transactional
public class FeesService implements IFeesService {

	private final IFeesDao feesDao;

	@Autowired
	public FeesService(IFeesDao feesDao) {
		this.feesDao = feesDao;
	}

	@Override
	public List<Fees> findAll() {
		return feesDao.findAll();
	}

	@Override
	public Fees getOne(Long id) {
		return feesDao.getOne(id);
	}

	@Override
	public void delete(Fees arg) {
		feesDao.delete(arg);
	}

	@Override
	public void deleteById(Long id) {
		feesDao.delete(id);
	}

	@Override
	public void save(Fees arg) {
		feesDao.save(arg);
	}

}
