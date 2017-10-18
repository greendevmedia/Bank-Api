package com.bank.feature.terms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Terms;

@RestController
@RequestMapping("/api/v1/terms")
public class TermsApi {

	private final ITermsService termsService;

	@Autowired
	public TermsApi(ITermsService termsService) {
		this.termsService = termsService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> list() {
		final List<Terms> termsList = termsService.findAll();
		return new ResponseEntity<>(termsList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
		final Terms terms = termsService.getOne(id);
		return new ResponseEntity<>(terms, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody final Terms terms) {
		termsService.save(terms);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody final Terms terms) {
		termsService.save(terms);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
		termsService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
