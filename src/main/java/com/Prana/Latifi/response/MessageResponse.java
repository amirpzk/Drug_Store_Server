package com.Prana.Latifi.response;

import javax.persistence.Column;

public class MessageResponse {

    private long id;
    private boolean isUser;
    private String content;

    public MessageResponse(long id, boolean isUser, String content) {
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
