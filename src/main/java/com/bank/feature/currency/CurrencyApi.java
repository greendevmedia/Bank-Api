package com.bank.feature.currency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Currency;

@RestController
@RequestMapping("/api/v1/currencies")
public class CurrencyApi {

	private final ICurrencyService currencyService;

	@Autowired
	public CurrencyApi(ICurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> list() {
		final List<Currency> currencyList = currencyService.findAll();
		return new ResponseEntity<>(currencyList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
		final Currency currency = currencyService.getOne(id);
		return new ResponseEntity<>(currency, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody final Currency currency) {
		currencyService.save(currency);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody final Currency currency) {
		currencyService.save(currency);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
		currencyService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
