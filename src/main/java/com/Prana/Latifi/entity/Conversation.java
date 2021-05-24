package com.Prana.Latifi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "conversation")
public class Conversation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "username")
  private String username;

  @Column(name = "user_first_name_plus_last_name")
  private String userFirstNamePlusLastName;

  @Column(name = "has_admin_answered_last_message")
  private boolean hasAdminAnsweredLastMessage;

  @Column(name = "title")
  private String title;

  @Column(name = "is_last_pm_seen")
  private boolean isLastPmSeen;

  @JoinColumn(name = "conversation_id")
  @OneToMany(cascade = CascadeType.ALL)
  private List<Message> messages;

  public Conversation() {}

  public Conversation(
      String username,
      String userFirstNamePlusLastName,
      boolean hasAdminAnsweredLastMessage,
      String title,
      boolean isLastPmSeen,
      List<Message> messages) {
    this.username = username;
    this.userFirstNamePlusLastName = userFirstNamePlusLastName;
    this.hasAdminAnsweredLastMessage = hasAdminAnsweredLastMessage;
    this.title = title;
    this.isLastPmSeen = isLastPmSeen;
    this.messages = messages;
  }

  public Conversation(
      long id,
      String username,
      String userFirstNamePlusLastName,
      boolean hasAdminAnsweredLastMessage,
      String title,
      boolean isLastPmSeen,
      List<Message> messages) {
    this.id = id;
    this.username = username;
    this.userFirstNamePlusLastName = userFirstNamePlusLastName;
    this.hasAdminAnsweredLastMessage = hasAdminAnsweredLastMessage;
    this.title = title;
    this.isLastPmSeen = isLastPmSeen;
    this.messages = messages;
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

  public void setHasAdminAnsweredLastMessage(boolean hasAdminAnswered) {
    this.hasAdminAnsweredLastMessage = hasAdminAnswered;
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

  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }
}
