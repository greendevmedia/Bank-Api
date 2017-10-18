package com.bank.feature.debitCard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.DebitCard;

@RestController
@RequestMapping("/api/v1/debit-cards")
public class DebitCardApi {

	private final IDebitCardService debitCardService;

	@Autowired
	public DebitCardApi(IDebitCardService debitCardService) {
		this.debitCardService = debitCardService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> list() {
		final List<DebitCard> debitCards = debitCardService.findAll();
		return new ResponseEntity<>(debitCards, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
		final DebitCard debitCard = debitCardService.getOne(id);
		return new ResponseEntity<>(debitCard, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody final DebitCard debitCard) {
		debitCardService.save(debitCard);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody final DebitCard debitCard) {
		debitCardService.save(debitCard);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
		debitCardService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
