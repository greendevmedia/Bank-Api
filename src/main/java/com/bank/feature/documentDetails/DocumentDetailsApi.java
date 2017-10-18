package com.bank.feature.documentDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.DocumentDetails;
@RestController
@RequestMapping("/api/v1/documents-details")
public class DocumentDetailsApi {

	private final IDocumentDetailsService documentDetailsService;

	@Autowired
	public DocumentDetailsApi(IDocumentDetailsService documentDetailsService) {
		this.documentDetailsService = documentDetailsService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> list() {
		final List<DocumentDetails> detailsList = documentDetailsService.findAll();
		return new ResponseEntity<>(detailsList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
		final DocumentDetails documentDetails = documentDetailsService.getOne(id);
		return new ResponseEntity<>(documentDetails, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody final DocumentDetails details) {
		documentDetailsService.save(details);
		return new ResponseEntity<>(details, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody final DocumentDetails details) {
		documentDetailsService.save(details);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
		documentDetailsService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
