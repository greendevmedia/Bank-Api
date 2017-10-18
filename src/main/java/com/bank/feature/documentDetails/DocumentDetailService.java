package com.bank.feature.documentDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.DocumentDetails;

@Service
@Transactional
public class DocumentDetailService implements IDocumentDetailsService {

	private final IDocumentDetailsDao documentDetailsDao;

	@Autowired
	public DocumentDetailService(IDocumentDetailsDao documentDetailsDao) {
		this.documentDetailsDao = documentDetailsDao;
	}

	@Override
	public List<DocumentDetails> findAll() {
		return documentDetailsDao.findAll();
	}

	@Override
	public DocumentDetails getOne(Long id) {
		return documentDetailsDao.getOne(id);
	}

	@Override
	public void delete(DocumentDetails arg) {
		documentDetailsDao.delete(arg);
	}

	@Override
	public void deleteById(Long id) {
		documentDetailsDao.delete(id);
	}

	@Override
	public void save(DocumentDetails arg) {
		documentDetailsDao.save(arg);
	}

}
