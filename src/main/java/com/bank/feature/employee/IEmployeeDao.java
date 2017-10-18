package com.bank.feature.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.model.Employee;

public interface IEmployeeDao extends JpaRepository<Employee, Long> {

}
