package com.bank.feature.currency;

import com.bank.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CurrencyService implements ICurrencyService {

	private final ICurrencyDao currencyDao;

	@Autowired
	public CurrencyService(final ICurrencyDao currencyDao) {
		this.currencyDao = currencyDao;
	}

	@Override
	public List<Currency> findAll() {
		return currencyDao.findAll();
	}

	@Override
	public Currency getOne(final Long id) {
		return currencyDao.getOne(id);
	}

	@Override
	public void delete(final Currency arg) {
		currencyDao.delete(arg);
	}

	@Override
	public void deleteById(final Long id) {
		currencyDao.delete(id);
	}

	@Override
	public void save(final Currency arg) {
		currencyDao.save(arg);
	}

}
