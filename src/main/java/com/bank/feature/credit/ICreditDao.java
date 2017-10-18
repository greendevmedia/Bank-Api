package com.bank.feature.credit;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.model.Credit;

public interface ICreditDao extends JpaRepository<Credit, Long> {

}
