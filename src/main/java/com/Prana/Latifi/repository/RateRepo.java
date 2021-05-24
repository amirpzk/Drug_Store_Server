package com.Prana.Latifi.repository;

import com.Prana.Latifi.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepo extends JpaRepository<Rate, Long> {

    Rate findByUsername(String username);

    Rate findByUsernameAndItemId(String username, Long itemId);

}
