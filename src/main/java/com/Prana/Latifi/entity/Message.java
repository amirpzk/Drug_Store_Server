package com.Prana.Latifi.entity;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "is_user")
    private boolean isUser;

    @Column(name = "content")
    private String content;

    public Message() {
    }

    public Message(boolean isUser, String content) {
        this.isUser = isUser;
        this.content = content;
    }

    public Message(long id, boolean isUser, String content) {
        this.id = id;
        this.isUser = isUser;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
