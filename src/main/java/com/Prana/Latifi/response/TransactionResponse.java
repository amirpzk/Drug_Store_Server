package com.Prana.Latifi.response;

import com.Prana.Latifi.entity.Item;
import com.Prana.Latifi.entity.Profile;
import com.Prana.Latifi.entity.ProfileType;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class TransactionResponse {

  private long id;
  private String firstName;
  private String lastName;
  private ProfileType type;
  private Map<String, ItemResponse> items;
  private long cost;
  private long transactionDate;

  public TransactionResponse() {}

  public TransactionResponse(
      long id,
      String firstName,
      String lastName,
      ProfileType type,
      Map<String, ItemResponse> items,
      long cost,
      long transactionDate) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.type = type;
    this.items = items;
    this.cost = cost;
    this.transactionDate = transactionDate;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public ProfileType getType() {
    return type;
  }

  public void setType(ProfileType type) {
    this.type = type;
  }

  public Map<String, ItemResponse> getItems() {
    return items;
  }

  public void setItems(Map<String ,ItemResponse> items) {
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
}
