package com.bank.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Account {
	@Id
	@GeneratedValue
	private Long id;
	@NotBlank
	@Pattern(regexp = "[0-9]+")
	@Size(max = 26, min = 26)
	private String accountNumber;
	private double balance;
	@NotNull
	@OneToOne
	private Client owner;
	@NotNull
	@OneToOne
	private Currency currency;
	private double maxDebit;
	@OneToMany
	private List<Transaction> history;
	@NotNull
	private boolean isMonthlySalaryTransfer;

	public Account() {
	}

	public Account(String accountNumber, Client owner, Currency currency, double maxDebit,
			boolean isMonthlySalaryTransfer) {
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.currency = currency;
		this.maxDebit = maxDebit;
		this.isMonthlySalaryTransfer = isMonthlySalaryTransfer;
	}

	public void moneyWithdrawals(double witdrawalsAmount) {
		this.balance -= witdrawalsAmount;
	}

	public void moneyDepositing(double depositAmount) {
		this.balance += depositAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public double getMaxDebit() {
		return maxDebit;
	}

	public void setMaxDebit(double maxDebit) {
		this.maxDebit = maxDebit;
	}

	public double getBalance() {
		return balance;
	}

	public List<Transaction> getHistory() {
		return history;
	}

	public void setHistory(Transaction transaction) {
		this.history.add(transaction);
	}

	public boolean isMonthlySalaryTransfer() {
		return isMonthlySalaryTransfer;
	}

	public void setMonthlySalaryTransfer(boolean isMonthlySalaryTransfer) {
		this.isMonthlySalaryTransfer = isMonthlySalaryTransfer;
	}

}
