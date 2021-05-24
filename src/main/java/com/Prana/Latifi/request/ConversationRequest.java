package com.Prana.Latifi.request;

import javax.persistence.Column;

public class ConversationRequest {

  private String username;
  private String userFirstNamePlusLastName;
  private boolean hasAdminAnsweredLastMessage;
  private String title;
  private boolean isLastPmSeen;
  private MessageRequest messageRequest;

  public ConversationRequest() {}

  public ConversationRequest(
      String username,
      String userFirstNamePlusLastName,
      boolean hasAdminAnsweredLastMessage,
      String title,
      boolean isLastPmSeen,
      MessageRequest messageRequest) {
    this.username = username;
    this.userFirstNamePlusLastName = userFirstNamePlusLastName;
    this.hasAdminAnsweredLastMessage = hasAdminAnsweredLastMessage;
    this.title = title;
    this.isLastPmSeen = isLastPmSeen;
    this.messageRequest = messageRequest;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUserFirstNamePlusLastName() {
    return userFirstNamePlusLastName;
  }

  public void setUserFirstNamePlusLastName(String userFirstNamePlusLastName) {
    this.userFirstNamePlusLastName = userFirstNamePlusLastName;
  }

  public boolean isHasAdminAnsweredLastMessage() {
    return hasAdminAnsweredLastMessage;
  }

  public void setHasAdminAnsweredLastMessage(boolean hasAdminAnsweredLastMessage) {
    this.hasAdminAnsweredLastMessage = hasAdminAnsweredLastMessage;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isLastPmSeen() {
    return isLastPmSeen;
  }

  public void setLastPmSeen(boolean lastPmSeen) {
    isLastPmSeen = lastPmSeen;
  }

  public MessageRequest getMessageRequest() {
    return messageRequest;
  }

  public void setMessageRequest(MessageRequest messageRequest) {
    this.messageRequest = messageRequest;
  }
}
