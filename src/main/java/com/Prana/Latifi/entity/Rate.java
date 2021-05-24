package com.Prana.Latifi.entity;

import javax.persistence.*;

@Entity
@Table(name = "rank")
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "item_id")
    private long itemId;
    @Column(name = "rate")
    private int rate;

    public Rate() {
    }

    public Rate(String username, long itemId, int rate) {
        this.username = username;
        this.itemId = itemId;
        this.rate = rate;
    }

    public Rate(long id, String username, long itemId, int rate) {
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
