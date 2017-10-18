package com.bank.feature.account;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.model.Account;

public interface IAccountDao extends JpaRepository<Account, Long> {

}
