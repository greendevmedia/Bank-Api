package com.bank.feature.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Account;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountApi {

	private final IAccountService accountService;

	@Autowired
	public AccountApi(IAccountService accountService) {
		this.accountService = accountService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> list() {
		final List<Account> accounts = accountService.findAll();
		return new ResponseEntity<>(accounts, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
		final Account account = accountService.getOne(id);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody final Account account) {
		accountService.save(account);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody final Account account) {
		accountService.save(account);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
		accountService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
