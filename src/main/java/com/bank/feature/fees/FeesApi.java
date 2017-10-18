package com.bank.feature.fees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Fees;

@RestController
@RequestMapping("/api/v1/fees")
public class FeesApi {

	private final IFeesService feesService;

	@Autowired
	public FeesApi(IFeesService feesService) {
		this.feesService = feesService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> list() {
		final List<Fees> feesList = feesService.findAll();
		return new ResponseEntity<>(feesList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
		final Fees fees = feesService.getOne(id);
		return new ResponseEntity<>(fees, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody final Fees fees) {
		feesService.save(fees);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody final Fees fees) {
		feesService.save(fees);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
		feesService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
