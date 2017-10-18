package com.bank.feature.terms;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.model.Terms;

public interface ITermsDao extends JpaRepository<Terms, Long> {

}
