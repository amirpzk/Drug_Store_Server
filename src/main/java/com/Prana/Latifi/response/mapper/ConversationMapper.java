package com.Prana.Latifi.response.mapper;

import com.Prana.Latifi.entity.Conversation;
import com.Prana.Latifi.response.ConvertsationResponse;

import java.util.ArrayList;
import java.util.List;

public class ConversationMapper {

  public static ConvertsationResponse convert(Conversation conversation) {
    if (conversation == null){
      return null;
    }
    return new ConvertsationResponse(
        conversation.getId(),
        conversation.getUsername(),
        conversation.getUserFirstNamePlusLastName(),
        conversation.isHasAdminAnsweredLastMessage(),
        conversation.getTitle(),
        conversation.isLastPmSeen(),
        MessageMapper.convertAll(conversation.getMessages()));
  }

  public static List<ConvertsationResponse> convertAll(List<Conversation> conversations) {
    List<ConvertsationResponse> responses = new ArrayList<>();
    for (Conversation conversation : conversations) {
      responses.add(convert(conversation));
    }
    return responses;
  }
}
