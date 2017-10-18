package com.bank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Credit {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	private double amount;
	@NotNull
	@DecimalMax("1.0") @DecimalMin("0.001") 
	private double interest;
	@NotNull
	@Min(0)
	private double provision;
	@NotNull
	@OneToOne
	private Client owner;
	@NotNull
	@Min(1)
	private double installmentAmount;
	@NotNull
	@OneToOne
	private Currency currency;

	public Credit() {
	}

	public Credit(double amount, double interest, double provision, Client owner, double installmentAmount,
			Currency currency) {
		super();
		this.amount = amount;
		this.interest = interest;
		this.provision = provision;
		this.owner = owner;
		this.installmentAmount = installmentAmount;
		this.currency = currency;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public double getProvision() {
		return provision;
	}

	public void setProvision(double provision) {
		this.provision = provision;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}

	public double getInstallmentAmount() {
		return installmentAmount;
	}

	public void setInstallmentAmount(double installmentAmount) {
		this.installmentAmount = installmentAmount;
	}

	public double getAllCreditCoast() {
		return (this.amount + (this.amount * this.interest)) + provision;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
