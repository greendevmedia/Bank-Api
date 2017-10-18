package com.bank.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Employee extends User {
	@NotNull
	@Min(0)
	private double salary;
	@NotNull
	@Min(0)
	private int holidayDays;
	@ManyToOne
	@NotNull
	private Position position;

	public Employee() {
	}

	public Employee(String firstName, String lastName, String email, int telephone, String password,
			LocalDate birthDate, DocumentDetails documentDetails, LocalDate contractStart, LocalDate contractEnd,
			double salary, int holidayDays, Position position) {
		super(firstName, lastName, email, telephone, password, birthDate, documentDetails, contractStart, contractEnd);
		this.salary = salary;
		this.holidayDays = holidayDays;
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getHolidayDays() {
		return holidayDays;
	}

	public void setHolidayDays(int holidayDays) {
		this.holidayDays = holidayDays;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

}
