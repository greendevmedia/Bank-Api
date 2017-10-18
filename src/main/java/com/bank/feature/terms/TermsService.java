package com.bank.feature.terms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Terms;

@Service
@Transactional
public class TermsService implements ITermsService {

	private final ITermsDao termsDao;

	@Autowired
	public TermsService(ITermsDao termsDao) {
		this.termsDao = termsDao;
	}

	@Override
	public List<Terms> findAll() {
		return termsDao.findAll();
	}

	@Override
	public Terms getOne(Long id) {
		return termsDao.getOne(id);
	}

	@Override
	public void deleteById(Long id) {
		termsDao.delete(id);
	}

	@Override
	public void delete(Terms arg) {
		termsDao.delete(arg);
	}

	@Override
	public void save(Terms arg) {
		termsDao.save(arg);
	}

}
