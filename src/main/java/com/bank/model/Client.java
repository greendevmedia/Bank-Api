package com.bank.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Client extends User {

	public Client() {
	}

	public Client(String firstName, String lastName, String email, int telephone, String password, LocalDate birthDate,
			DocumentDetails documentDetails, LocalDate contractStart, LocalDate contractEnd) {
		super(firstName, lastName, email, telephone, password, birthDate, documentDetails, contractStart, contractEnd);

	}

}
