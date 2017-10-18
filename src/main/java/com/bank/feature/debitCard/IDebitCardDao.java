package com.bank.feature.debitCard;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.model.DebitCard;

public interface IDebitCardDao extends JpaRepository<DebitCard, Long> {

}
