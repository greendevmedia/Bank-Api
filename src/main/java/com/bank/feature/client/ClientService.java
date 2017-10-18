package com.bank.feature.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Client;

@Service
@Transactional
public class ClientService implements IClientService {

	private final IClientDao clientDao;

	@Autowired
	public ClientService(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public List<Client> findAll() {
		return clientDao.findAll();
	}

	@Override
	public Client getOne(Long id) {
		return clientDao.getOne(id);
	}

	@Override
	public void delete(Client arg) {
		clientDao.delete(arg);
	}

	@Override
	public void deleteById(final Long id) {
		clientDao.delete(id);
	}

	@Override
	public void save(Client arg) {
		clientDao.save(arg);
	}

}
