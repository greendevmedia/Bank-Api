package com.bank.feature.documentDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.model.DocumentDetails;

public interface IDocumentDetailsDao extends JpaRepository<DocumentDetails, Long> {

}
