package com.bank.feature.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Employee;

@Service
@Transactional
public class EmployeeService implements IEmployeeService {

	private final IEmployeeDao employeeDao;

	@Autowired
	public EmployeeService(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public Employee getOne(Long id) {
		return employeeDao.getOne(id);
	}

	@Override
	public void delete(Employee arg) {
		employeeDao.delete(arg);
	}

	@Override
	public void deleteById(Long id) {
		employeeDao.delete(id);
	}

	@Override
	public void save(Employee arg) {
		employeeDao.save(arg);
	}

}
