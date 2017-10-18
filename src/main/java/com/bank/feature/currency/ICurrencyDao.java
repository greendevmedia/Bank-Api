package com.bank.feature.currency;

import com.bank.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICurrencyDao extends JpaRepository<Currency, Long> {

}
