package com.Prana.Latifi.request;

import javax.persistence.Column;

public class MessageRequest {

    private boolean isUser;
    private String content;

    public MessageRequest() {
    }

    public MessageRequest(boolean isUser, String content) {
        this.isUser = isUser;
        this.content = content;
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
