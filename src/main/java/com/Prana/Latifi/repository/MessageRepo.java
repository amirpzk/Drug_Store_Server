package com.Prana.Latifi.repository;

import com.Prana.Latifi.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
