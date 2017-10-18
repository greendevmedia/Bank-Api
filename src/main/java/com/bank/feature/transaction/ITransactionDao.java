package com.bank.feature.transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.model.Transaction;

public interface ITransactionDao extends JpaRepository<Transaction, Long> {

}
