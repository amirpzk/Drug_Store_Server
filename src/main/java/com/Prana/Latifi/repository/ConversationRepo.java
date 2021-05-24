package com.Prana.Latifi.repository;

import com.Prana.Latifi.entity.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepo extends JpaRepository<Conversation, Long> {
}
