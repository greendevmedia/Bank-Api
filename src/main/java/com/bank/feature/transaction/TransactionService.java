package com.bank.feature.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Transaction;

@Service
@Transactional
public class TransactionService implements ITransactionService {

	private final ITransactionDao transactionDao;

	@Autowired
	public TransactionService(ITransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}

	@Override
	public List<Transaction> findAll() {
		return transactionDao.findAll();
	}

	@Override
	public Transaction getOne(Long id) {
		return transactionDao.getOne(id);
	}

	@Override
	public void delete(Transaction arg) {
		transactionDao.delete(arg);
	}

	@Override
	public void deleteById(Long id) {
		transactionDao.delete(id);
	}

	@Override
	public void save(Transaction arg) {
		transactionDao.save(arg);
	}

}
