package com.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Terms {
	@Id
	@GeneratedValue
	private Long id;
	@Min(1)
	@Max(366)
	@NotNull
	private int interestFreePeriod;

	public Terms() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Terms(int interestFreePeriod) {
		this.interestFreePeriod = interestFreePeriod;
	}

	public int getInterestFreePeriod() {
		return interestFreePeriod;
	}

	public void setInterestFreePeriod(int interestFreePeriod) {
		this.interestFreePeriod = interestFreePeriod;
	}

}
