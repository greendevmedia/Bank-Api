package com.bank.feature.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.Employee;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeApi {

	private final IEmployeeService employeeService;

	@Autowired
	public EmployeeApi(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> list() {
		final List<Employee> employees = employeeService.findAll();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> byId(@PathVariable("id") final Long id) {
		final Employee employee = employeeService.getOne(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody final Employee employee) {
		employeeService.save(employee);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody final Employee employee) {
		employeeService.save(employee);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
		employeeService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
