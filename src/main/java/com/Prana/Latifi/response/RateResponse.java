package com.Prana.Latifi.response;

import javax.persistence.Column;

public class RateResponse {

    private long id;
    private String username;
    private long itemId;
    private int rate;

    public RateResponse(long id, String username, long itemId, int rate) {
        this.id = id;
        this.username = username;
        this.itemId = itemId;
        this.rate = rate;
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

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
