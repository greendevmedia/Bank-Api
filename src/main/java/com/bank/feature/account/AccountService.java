package com.bank.feature.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Account;

@Service
@Transactional
public class AccountService implements IAccountService {

	private final IAccountDao accountDao;

	@Autowired
	public AccountService(final IAccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public List<Account> findAll() {
		return accountDao.findAll();
	}

	@Override
	public Account getOne(Long id) {
		return accountDao.getOne(id);
	}

	@Override
	public void delete(Account arg) {
		accountDao.delete(arg);
	}

	@Override
	public void deleteById(Long id) {
		accountDao.delete(id);
	}

	@Override
	public void save(Account arg) {
		accountDao.save(arg);
	}

}
