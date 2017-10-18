package com.bank.feature.debitCard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.DebitCard;

@Service
@Transactional
public class DebitCardService implements IDebitCardService {

	private final IDebitCardDao debitCardDao;

	@Autowired
	public DebitCardService(IDebitCardDao debitCardDao) {
		this.debitCardDao = debitCardDao;
	}

	@Override
	public List<DebitCard> findAll() {
		return debitCardDao.findAll();
	}

	@Override
	public DebitCard getOne(Long id) {
		return debitCardDao.getOne(id);
	}

	@Override
	public void delete(DebitCard arg) {
		debitCardDao.delete(arg);
	}

	@Override
	public void deleteById(Long id) {
		debitCardDao.delete(id);
	}

	@Override
	public void save(DebitCard arg) {
		debitCardDao.save(arg);
	}

}
