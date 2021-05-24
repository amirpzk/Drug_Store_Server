package com.Prana.Latifi.response;

import java.util.List;

public class ConvertsationResponse {

  private long id;
  private String username;
  private String userFirstNamePlusLastName;
  private boolean hasAdminAnsweredLastMessage;
  private String title;
  private boolean isLastPmSeen;
  private List<MessageResponse> messageResponses;

  public ConvertsationResponse(
      long id,
      String username,
      String userFirstNamePlusLastName,
      boolean hasAdminAnsweredLastMessage,
      String title,
      boolean isLastPmSeen,
      List<MessageResponse> messageResponses) {
    this.id = id;
    this.username = username;
    this.userFirstNamePlusLastName = userFirstNamePlusLastName;
    this.hasAdminAnsweredLastMessage = hasAdminAnsweredLastMessage;
    this.title = title;
    this.isLastPmSeen = isLastPmSeen;
    this.messageResponses = messageResponses;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public List<MessageResponse> getMessageResponses() {
    return messageResponses;
  }

  public void setMessageResponses(List<MessageResponse> messageResponses) {
    this.messageResponses = messageResponses;
  }
}
