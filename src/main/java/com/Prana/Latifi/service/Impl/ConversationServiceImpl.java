package com.Prana.Latifi.service.Impl;

import com.Prana.Latifi.entity.Conversation;
import com.Prana.Latifi.entity.Message;
import com.Prana.Latifi.exception.ForbiddenForYou;
import com.Prana.Latifi.exception.NoTokenInRequest;
import com.Prana.Latifi.jwt.JwtFactory;
import com.Prana.Latifi.jwt.UserRoleModel;
import com.Prana.Latifi.repository.ConversationRepo;
import com.Prana.Latifi.repository.MessageRepo;
import com.Prana.Latifi.response.ConvertsationResponse;
import com.Prana.Latifi.response.mapper.ConversationMapper;
import com.Prana.Latifi.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConversationServiceImpl implements ConversationService {

  @Autowired private ConversationRepo conversationRepo;
  @Autowired private MessageRepo messageRepo;
  @Autowired private JwtFactory jwtFactory;

  @Override
  public ConvertsationResponse createNew(
      String userFirstNameAndLastName,
      String title,
      boolean messageIsUser,
      String messageContent,
      String token) {
    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);


    Message message = new Message(messageIsUser, messageContent);
    List<Message> messages = new ArrayList<>();
    messages.add(message);

    Conversation conversation =
        new Conversation(
            userRoleModel.getUsername(),
            userFirstNameAndLastName,
            false,
            title,
            false,
            messages);

    return ConversationMapper.convert(conversationRepo.save(conversation));
  }

  @Override
  public ConvertsationResponse addMessage(
      long conversationId,
      boolean messageIsUser,
      String messageContent,
      String token) {
    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);


    Conversation conversation = conversationRepo.findById(conversationId).get();
    conversation.getMessages().add(new Message(messageIsUser, messageContent));
    if (messageIsUser){
      conversation.setHasAdminAnsweredLastMessage(false);
    } else {
      conversation.setHasAdminAnsweredLastMessage(true);
    }
    conversation.setLastPmSeen(false);

    return ConversationMapper.convert(conversationRepo.save(conversation));

  }

  @Override
  public ConvertsationResponse lastPmSeen(
      long conversationId, boolean isUser, String token) {
    if (token == null || token.isEmpty()) {
      throw new NoTokenInRequest();
    }
    UserRoleModel userRoleModel = jwtFactory.parseToken(token);


    Conversation conversation = conversationRepo.findById(conversationId).get();
    conversation.setLastPmSeen(true);
    conversation.setHasAdminAnsweredLastMessage(!isUser);

    return ConversationMapper.convert(conversationRepo.save(conversation));
  }
}
