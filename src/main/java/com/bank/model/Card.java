package com.bank.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Card {
	@Id
	@GeneratedValue
	protected Long id;
	@OneToOne
	@NotNull
	protected Client owner;
	@NotNull
	@Digits(integer = 16, fraction = 0)
	@Min(0)
	protected long cardNumber;
	@NotNull
	@Digits(integer = 3, fraction = 0)
	protected int cardCVC;
	@NotNull
	protected LocalDate validDate;
	@ManyToOne
	@NotNull
	protected Fees fees;
	@ManyToOne
	@NotNull
	protected Terms terms;
	@OneToMany
	protected List<Transaction> cardHistory;

	public Card() {
	}

	public Card(Client owner, long cardNumber, int cardCVC, LocalDate validDate, Fees fees, Terms terms) {
		this.owner = owner;
		this.cardNumber = cardNumber;
		this.cardCVC = cardCVC;
		this.validDate = validDate;
		this.fees = fees;
		this.terms = terms;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCardCVC() {
		return cardCVC;
	}

	public void setCardCVC(int cardCVC) {
		this.cardCVC = cardCVC;
	}

	public LocalDate getValidDate() {
		return validDate;
	}

	public void setValidDate(LocalDate validDate) {
		this.validDate = validDate;
	}

	public Fees getFees() {
		return fees;
	}

	public void setFees(Fees fees) {
		this.fees = fees;
	}

	public Terms getTerms() {
		return terms;
	}

	public void setTerms(Terms terms) {
		this.terms = terms;
	}

	public List<Transaction> getHistory() {
		return cardHistory;
	}

	public void setHistory(Transaction transaction) {
		this.cardHistory.add(transaction);
	}

}
