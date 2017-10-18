package com.bank.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class CreditCard extends Card {
	@NotNull
	@Min(0)
	private double cardLimit;
	private double balance;
	@NotNull
	@OneToOne
	private Currency currency;

	public CreditCard() {
	}

	public CreditCard(Client owner, long cardNumber, int cardCVC, LocalDate validDate, Fees fees, Terms terms,
			double limit,Currency currency) {
		super(owner, cardNumber, cardCVC, validDate, fees, terms);
		this.cardLimit = limit;
		this.currency = currency;
	}

	public double getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(double limit) {
		this.cardLimit = limit;
	}

	public double getBalance() {
		return balance;
	}

	public void moneyWithdrawals(double witdrawalsAmount) {
		this.balance -= witdrawalsAmount;
	}

	public void cardRepaid(double depositAmount) {
		this.balance += depositAmount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
