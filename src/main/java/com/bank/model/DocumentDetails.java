package com.bank.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class DocumentDetails {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull
	@Size(min = 9, max = 9)
	private String documentNumber;
	@NotNull
	@Enumerated(EnumType.STRING)
	private DocumentType documentType;

	public DocumentDetails() {
	}

	public DocumentDetails(String documentNumber, DocumentType documentType) {
		this.documentNumber = documentNumber;
		this.documentType = documentType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

}
