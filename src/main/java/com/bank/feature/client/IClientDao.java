package com.bank.feature.client;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.model.Client;

public interface IClientDao extends JpaRepository<Client, Long> {

}
