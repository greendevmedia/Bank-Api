package com.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Currency {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	@Size(min =3, max=3)
	@Column(unique = true)
	private String currencyCode;

	public Currency() {
	}

	public Currency(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@Override
	public String toString() {
		return "Currency{" +
				"id=" + id +
				", currencyCode='" + currencyCode + '\'' +
				'}';
	}
}
