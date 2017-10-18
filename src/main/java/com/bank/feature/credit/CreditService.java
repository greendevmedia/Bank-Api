package com.bank.feature.credit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Credit;

@Service
@Transactional
public class CreditService implements ICreditService {

	private final ICreditDao creditDao;

	@Autowired
	public CreditService(ICreditDao creditDao) {
		this.creditDao = creditDao;
	}

	@Override
	public List<Credit> findAll() {
		return creditDao.findAll();
	}

	@Override
	public Credit getOne(Long id) {
		return creditDao.getOne(id);
	}

	@Override
	public void delete(Credit arg) {
		creditDao.delete(arg);
	}

	@Override
	public void deleteById(Long id) {
		creditDao.delete(id);
	}

	@Override
	public void save(Credit arg) {
		creditDao.save(arg);
	}

}
