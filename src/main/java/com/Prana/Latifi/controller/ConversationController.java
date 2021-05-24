package com.Prana.Latifi.controller;

import com.Prana.Latifi.helper.ResponseHelper;
import com.Prana.Latifi.request.ConversationRequest;
import com.Prana.Latifi.request.MessageRequest;
import com.Prana.Latifi.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conversation")
public class ConversationController {

  @Autowired private ConversationService conversationService;

  @PostMapping(value = "/create-conversation")
  public ResponseEntity createConversation(
      @RequestBody ConversationRequest conversationRequest,
      @RequestParam String token) {
    return ResponseHelper.response(
        conversationService.createNew(
            conversationRequest.getUserFirstNamePlusLastName(),
            conversationRequest.getTitle(),
            conversationRequest.getMessageRequest().isUser(),
            conversationRequest.getMessageRequest().getContent(),
            token));
  }

  @PostMapping(value = "/add-new-message")
  public ResponseEntity addNewMessage(
      @RequestBody MessageRequest messageRequest,
      @RequestParam Long conversationId,
      @RequestParam String token) {
    return ResponseHelper.response(
        conversationService.addMessage(
            conversationId, messageRequest.isUser(), messageRequest.getContent(), token));
  }

  @GetMapping(value = "/seen-conversation")
  public ResponseEntity seenConversation(
      @RequestParam long conversationId,
      @RequestParam boolean isUser,
      @RequestParam String token) {
    return ResponseHelper.response(
        conversationService.lastPmSeen(conversationId, isUser, token));
  }
}
