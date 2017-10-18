package com.bank.feature.position;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Position;

@RestController
@RequestMapping("/api/v1/positions")
public class PositionApi {

	private final IPositionService positionService;

	@Autowired
	public PositionApi(IPositionService positionService) {
		this.positionService = positionService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> list() {
		final List<Position> positions = positionService.findAll();
		return new ResponseEntity<>(positions, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
		final Position position = positionService.getOne(id);
		return new ResponseEntity<>(position, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody final Position position) {
		positionService.save(position);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody final Position position) {
		positionService.save(position);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
		positionService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
