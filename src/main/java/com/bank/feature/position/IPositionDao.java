package com.bank.feature.position;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.model.Position;

public interface IPositionDao extends JpaRepository<Position, Long> {

}
