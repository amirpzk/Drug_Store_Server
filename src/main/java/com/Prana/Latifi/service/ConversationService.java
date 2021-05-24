package com.Prana.Latifi.service;

import com.Prana.Latifi.response.ConvertsationResponse;

public interface ConversationService {

  ConvertsationResponse createNew(
      String userFirstNameAndLastName,
      String title,
      boolean messageIsUser,
      String messageContent,
      String token);

  ConvertsationResponse addMessage(
      long conversationId,
      boolean messageIsUser,
      String messageContent,
      String token);

  ConvertsationResponse lastPmSeen(
      long conversationId, boolean isUser, String token);
}
