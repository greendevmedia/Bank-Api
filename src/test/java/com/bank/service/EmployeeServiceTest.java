package com.bank.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bank.feature.employee.EmployeeService;
import com.bank.feature.employee.IEmployeeDao;
import com.bank.model.Employee;
import com.bank.util.TestEntityProvider;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
public class EmployeeServiceTest {

	@Mock
	private IEmployeeDao employeeDao;

	private EmployeeService employeeService;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		employeeService = new EmployeeService(employeeDao);
	}

	@Test
	public void shouldFindAll() {
		Mockito.when(employeeDao.findAll()).thenReturn(TestEntityProvider.EMPLOYEE_LIST);
		final List<Employee> result = employeeService.findAll();
		Mockito.verify(employeeDao).findAll();
		assertEquals(TestEntityProvider.EMPLOYEE_LIST.size(), result.size());
	}

	@Test
	public void shouldGetOne() {
		Mockito.when(employeeDao.getOne(Matchers.anyLong())).thenReturn(TestEntityProvider.EMPLOYEE_CORRECT);
		final Employee employee = employeeService.getOne(Matchers.anyLong());
		Mockito.verify(employeeDao).getOne(Matchers.anyLong());
		assertEquals(TestEntityProvider.EMPLOYEE_CORRECT.getEmail(), employee.getEmail());
	}

	@Test
	public void shouldDelete() {
		Mockito.doNothing().when(employeeDao).delete(Matchers.any(Employee.class));
		employeeService.delete(TestEntityProvider.EMPLOYEE_CORRECT);
		Mockito.verify(employeeDao).delete(Matchers.any(Employee.class));
	}

	@Test
	public void shouldSave() {
		Mockito.when(employeeDao.save(TestEntityProvider.EMPLOYEE_CORRECT))
				.thenReturn(TestEntityProvider.EMPLOYEE_CORRECT);
		employeeService.save(TestEntityProvider.EMPLOYEE_CORRECT);
		Mockito.verify(employeeDao).save(TestEntityProvider.EMPLOYEE_CORRECT);
	}
}
