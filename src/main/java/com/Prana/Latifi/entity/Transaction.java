package com.Prana.Latifi.entity;

import com.sun.mail.imap.protocol.ID;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "transaction")
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "profile_id", nullable = false)
  private Profile profile;

//  @ManyToMany(cascade = CascadeType.DETACH)
//  @JoinTable(
//      name = "transaction_item",
//      joinColumns = {@JoinColumn(name = "transaction_id")},
//      inverseJoinColumns = {@JoinColumn(name = "item_id")})
//  private List<Item> items;

  @ManyToMany
  private Map<String, Item> items;

  @Column(name = "cost")
  private long cost;

  @Column(name = "transaction_date")
  private long transactionDate;

  @Column(name = "is_paid")
  private boolean isPaid;

  public Transaction() {
    items = new HashMap<>();
  }

  public Transaction(Profile profile, Map<String, Item> items, long cost, long transactionDate, boolean isPaid) {
    this.profile = profile;
    this.items = items;
    this.cost = cost;
    this.transactionDate = transactionDate;
    this.isPaid = isPaid;
  }

  public Transaction(long id, Profile profile, Map<String, Item> items, long cost, long transactionDate, boolean isPaid) {
    this.id = id;
    this.profile = profile;
    this.items = items;
    this.cost = cost;
    this.transactionDate = transactionDate;
    this.isPaid = isPaid;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  public Map<String, Item> getItems() {
    return items;
  }

  public void setItems(Map<String, Item> items) {
    this.items = items;
  }

  public long getCost() {
    return cost;
  }

  public void setCost(long cost) {
    this.cost = cost;
  }

  public long getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(long transactionDate) {
    this.transactionDate = transactionDate;
  }

  public boolean isPaid() {
    return isPaid;
  }

  public void setPaid(boolean paid) {
    isPaid = paid;
  }
}
