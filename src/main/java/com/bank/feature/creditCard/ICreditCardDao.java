package com.bank.feature.creditCard;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.model.CreditCard;

public interface ICreditCardDao extends JpaRepository<CreditCard, Long> {

}
