package com.bank.feature.fees;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.model.Fees;

public interface IFeesDao extends JpaRepository<Fees, Long> {

}
