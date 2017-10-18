package com.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Fees {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	@DecimalMax("100") @DecimalMin("0") 
	private double monthlyCharge;
	@NotNull
	@DecimalMax("1.0") @DecimalMin("0.001") 
	private double interestRatePerYear;

	public Fees() {
	}

	public Fees(double monthlyCharge, double interestRatePerYear) {
		this.monthlyCharge = monthlyCharge;
		this.interestRatePerYear = interestRatePerYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getMonthlyCharge() {
		return monthlyCharge;
	}

	public void setMonthlyCharge(double monthlyCharge) {
		this.monthlyCharge = monthlyCharge;
	}

	public double getInterestRatePerYear() {
		return interestRatePerYear;
	}

	public void setInterestRatePerYear(double interestRatePerYear) {
		this.interestRatePerYear = interestRatePerYear;
	}

}
