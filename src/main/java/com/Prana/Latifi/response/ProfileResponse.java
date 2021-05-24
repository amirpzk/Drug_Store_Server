package com.Prana.Latifi.response;

import com.Prana.Latifi.entity.CompanyDetail;
import com.Prana.Latifi.entity.ProfileType;
import com.Prana.Latifi.entity.Transaction;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class ProfileResponse {

  private Long id;
  private String avatar;
  private String firstName;
  private String lastName;
  private ProfileType type;
  private List<TransactionResponse> transactions;
  private CompanyDetailResponse companyDetail;

  public ProfileResponse() {}

  public ProfileResponse(
      Long id,
      String avatar,
      String firstName,
      String lastName,
      ProfileType type,
      List<TransactionResponse> transactions,
      CompanyDetailResponse companyDetail) {
    this.id = id;
    this.avatar = avatar;
    this.firstName = firstName;
    this.lastName = lastName;
    this.type = type;
    this.transactions = transactions;
    this.companyDetail = companyDetail;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
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

  public List<TransactionResponse> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<TransactionResponse> transactions) {
    this.transactions = transactions;
  }

  public CompanyDetailResponse getCompanyDetail() {
    return companyDetail;
  }

  public void setCompanyDetail(CompanyDetailResponse companyDetail) {
    this.companyDetail = companyDetail;
  }
}
