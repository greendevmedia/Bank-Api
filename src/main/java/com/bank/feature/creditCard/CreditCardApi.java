package com.bank.feature.creditCard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.CreditCard;

@RestController
@RequestMapping("/api/v1/credit-cards")
public class CreditCardApi {

	private final ICreditCardService creditCardService;

	@Autowired
	public CreditCardApi(ICreditCardService creditCardService) {
		this.creditCardService = creditCardService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> list() {
		final List<CreditCard> creditCards = creditCardService.findAll();
		return new ResponseEntity<>(creditCards, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
		final CreditCard creditCard = creditCardService.getOne(id);
		return new ResponseEntity<>(creditCard, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody final CreditCard creditCard) {
		creditCardService.save(creditCard);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody final CreditCard creditCard) {
		creditCardService.save(creditCard);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
		creditCardService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
