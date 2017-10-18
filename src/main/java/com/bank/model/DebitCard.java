package com.bank.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class DebitCard extends Card {
	@OneToOne
	@NotNull
	private Account account;

	public DebitCard() {
	}

	public DebitCard(Client owner, long cardNumber, int cardCVC, LocalDate validDate, Fees fees, Terms terms,
			Account account) {
		super(owner, cardNumber, cardCVC, validDate, fees, terms);
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void moneyWithdrawals(double witdrawalsAmount) {
		this.account.moneyWithdrawals(witdrawalsAmount);
	}

	public void moneyDepositing(double depositAmount) {
		this.account.moneyDepositing(depositAmount);
	}

}
