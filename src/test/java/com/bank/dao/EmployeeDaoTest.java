package com.bank.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import com.bank.util.TestEntityProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bank.feature.documentDetails.IDocumentDetailsDao;
import com.bank.feature.employee.IEmployeeDao;
import com.bank.feature.position.IPositionDao;
import com.bank.model.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@DirtiesContext
@Transactional
public class EmployeeDaoTest {

	@Autowired
	private IEmployeeDao employeeDao;

	@Autowired
	private IDocumentDetailsDao documentDetailsDao;

	@Autowired
	private IPositionDao positionDao;

	@Test
	public void shouldSave() {
		positionDao.save(TestEntityProvider.POSITION_1);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_1);
		employeeDao.save(TestEntityProvider.EMPLOYEE_CORRECT);
		assertNotNull(TestEntityProvider.EMPLOYEE_CORRECT.getId());
	}

	@Test
	public void shouldBeList() {
		final int expectedSize = 2;
		final List<Employee> employees = employeeDao.findAll();
		assertEquals(expectedSize, employees.size());
	}

	@Test
	public void getById() {
		final String name = "Adrian";
		final Long id = 1L;
		final Employee employee = employeeDao.getOne(id);
		assertEquals(name, employee.getFirstName());
	}

	@Test
	public void deleteById() {
		final Long id = 2L;
		final int expectedSize = 1;
		employeeDao.delete(id);
		final List<Employee> employees = employeeDao.findAll();
		assertEquals(expectedSize, employees.size());
	}

	@Test(expected = ValidationException.class)
	public void shouldThrowExceptionWhenSavingEmployeeWithNullValue() {
		final Employee employee = new Employee();
		employeeDao.save(employee);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingEmployeeWithBlankFirstName() {
		final String blankFirstName = "";
		final Employee employee = TestEntityProvider.employee;
		employee.setFirstName(blankFirstName);
		employee.setDocumentDetails(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_2);
		employee.setPosition(TestEntityProvider.POSITION_2);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_2);
		positionDao.save(TestEntityProvider.POSITION_2);
		employeeDao.save(employee);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingEmployeeWithBlankLastName() {
		final String blankLastName = "";
		final Employee employee = TestEntityProvider.employee;
		employee.setLastName(blankLastName);
		employee.setDocumentDetails(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_3);
		employee.setPosition(TestEntityProvider.POSITION_3);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_3);
		positionDao.save(TestEntityProvider.POSITION_3);
		employeeDao.save(employee);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingEmployeeWithWrongEmail() {
		final String wrongEmail = "a.pl";
		final Employee employee = TestEntityProvider.employee;
		employee.setEmail(wrongEmail);
		employee.setDocumentDetails(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_4);
		employee.setPosition(TestEntityProvider.POSITION_4);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_4);
		positionDao.save(TestEntityProvider.POSITION_4);
		employeeDao.save(employee);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingEmployeeWithTooLongTelephone() {
		final int tooLongTelephone = 1234567890;
		final Employee employee = TestEntityProvider.employee;
		employee.setTelephone(tooLongTelephone);
		employee.setDocumentDetails(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_5);
		employee.setPosition(TestEntityProvider.POSITION_5);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_5);
		positionDao.save(TestEntityProvider.POSITION_5);
		employeeDao.save(employee);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingEmployeeWithTooLongPassword() {
		final String tooLongPassword = "tooLongPasswordForEmployee";
		final Employee employee = TestEntityProvider.employee;
		employee.setPassword(tooLongPassword);
		employee.setDocumentDetails(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_6);
		employee.setPosition(TestEntityProvider.POSITION_6);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_6);
		positionDao.save(TestEntityProvider.POSITION_6);
		employeeDao.save(employee);
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingEmployeeWithTooShortPassword() {
		final String tooShortPassword = "Pass";
		final Employee employee = TestEntityProvider.employee;
		employee.setPassword(tooShortPassword);
		employee.setDocumentDetails(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_7);
		employee.setPosition(TestEntityProvider.POSITION_7);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_7);
		positionDao.save(TestEntityProvider.POSITION_7);
		employeeDao.save(employee);
		
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingEmployeeWithTooLowSalary() {
		final double tooLowSalary = -10;
		final Employee employee = TestEntityProvider.employee;
		employee.setSalary(tooLowSalary);
		employee.setDocumentDetails(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_8);
		employee.setPosition(TestEntityProvider.POSITION_8);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_8);
		positionDao.save(TestEntityProvider.POSITION_8);
		employeeDao.save(employee);
	
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldThrowExceptionWhenSavingEmployeeWithTooShortHolidays() {
		final int tooShortHolidays = -1;
		final Employee employee = TestEntityProvider.employee;
		employee.setHolidayDays(tooShortHolidays);
		employee.setDocumentDetails(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_9);
		employee.setPosition(TestEntityProvider.POSITION_9);
		documentDetailsDao.save(TestEntityProvider.DOCUMENT_DETAILS_IDCARD_9);
		positionDao.save(TestEntityProvider.POSITION_9);
		employeeDao.save(employee);
	}
}
