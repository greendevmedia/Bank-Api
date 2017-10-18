package com.bank.model;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@MappedSuperclass
public abstract class User {
	@Id
	@GeneratedValue
	protected Long id;
	@NotBlank
	protected String firstName;
	@NotBlank
	protected String lastName;
	@NotBlank
	@Email
	protected String email;
	@NotNull
	@Digits(integer = 9, fraction = 0)
	protected int telephone;
	@NotBlank
	@Size(min = 8, max = 15)
	protected String password;
	@NotNull
	protected LocalDate birthDate;
	@OneToOne
	@NotNull
	protected DocumentDetails documentDetails;
	@NotNull
	protected LocalDate contractStart;
	protected LocalDate contractEnd;

	public User() {
	}

	public User(String firstName, String lastName, String email, int telephone, String password, LocalDate birthDate,
			DocumentDetails documentDetails, LocalDate contractStart, LocalDate contractEnd) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
		this.birthDate = birthDate;
		this.documentDetails = documentDetails;
		this.contractStart = contractStart;
		this.contractEnd = contractEnd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public DocumentDetails getDocumentDetails() {
		return documentDetails;
	}

	public void setDocumentDetails(DocumentDetails documentDetails) {
		this.documentDetails = documentDetails;
	}

	public LocalDate getContractStart() {
		return contractStart;
	}

	public void setContractStart(LocalDate contractStart) {
		this.contractStart = contractStart;
	}

	public LocalDate getContractEnd() {
		return contractEnd;
	}

	public void setContractEnd(LocalDate contractEnd) {
		this.contractEnd = contractEnd;
	}

}
