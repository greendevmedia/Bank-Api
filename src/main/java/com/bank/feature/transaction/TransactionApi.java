package com.bank.feature.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Transaction;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionApi {

	private final ITransactionService transactionService;

	@Autowired
	public TransactionApi(ITransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> list() {
		final List<Transaction> transactions = transactionService.findAll();
		return new ResponseEntity<>(transactions, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
		final Transaction transaction = transactionService.getOne(id);
		return new ResponseEntity<>(transaction, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody final Transaction transaction) {
		transactionService.save(transaction);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody final Transaction transaction) {
		transactionService.save(transaction);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
		transactionService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
