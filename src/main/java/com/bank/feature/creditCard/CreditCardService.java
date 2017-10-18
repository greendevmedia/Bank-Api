package com.bank.feature.creditCard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.CreditCard;

@Service
@Transactional
public class CreditCardService implements ICreditCardService {

	private final ICreditCardDao creditCardDao;

	@Autowired
	public CreditCardService(ICreditCardDao creditCardDao) {
		this.creditCardDao = creditCardDao;
	}

	@Override
	public List<CreditCard> findAll() {
		return creditCardDao.findAll();
	}

	@Override
	public CreditCard getOne(Long id) {
		return creditCardDao.getOne(id);
	}

	@Override
	public void delete(CreditCard arg) {
		creditCardDao.delete(arg);
	}

	@Override
	public void deleteById(Long id) {
		creditCardDao.delete(id);
	}

	@Override
	public void save(CreditCard arg) {
		creditCardDao.save(arg);
	}

}
