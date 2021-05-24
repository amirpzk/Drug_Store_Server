package com.Prana.Latifi.response.mapper;

import com.Prana.Latifi.entity.Message;
import com.Prana.Latifi.response.MessageResponse;

import java.util.ArrayList;
import java.util.List;

public class MessageMapper {

  public static MessageResponse convert(Message message) {
    if (message == null){
      return null;
    }
    return new MessageResponse(message.getId(), message.isUser(), message.getContent());
  }

  public static List<MessageResponse> convertAll(List<Message> messages) {
    List<MessageResponse> responses = new ArrayList<>();
    for (Message message : messages) {
      responses.add(convert(message));
    }
    return responses;
  }
}
