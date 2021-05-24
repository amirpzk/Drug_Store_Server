package com.Prana.Latifi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "user_profile")
public class Profile {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(mappedBy = "profile")
  @JsonIgnore
  private User user;

  @Column(name = "avatar")
  private String avatar;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "type")
  private ProfileType type;

  @OneToMany(mappedBy = "profile")
  private List<Transaction> transactions;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "company_detail_id", referencedColumnName = "id")
  private CompanyDetail companyDetail;

  @ElementCollection
  private List<Long> favourites;

  @JoinColumn(name = "profile_id")
  @OneToMany(cascade = CascadeType.ALL)
  private List<Conversation> conversations;

  public Profile() {
    transactions = new ArrayList<>();
    favourites = new ArrayList<>();
    conversations = new ArrayList<>();
  }

  public Profile(
      String avatar,
      String firstName,
      String lastName,
      ProfileType type,
      List<Transaction> transactions,
      CompanyDetail companyDetail) {
    this.avatar = avatar;
    this.firstName = firstName;
    this.lastName = lastName;
    this.type = type;
    this.transactions = transactions;
    this.companyDetail = companyDetail;
    favourites = new ArrayList<>();
    conversations = new ArrayList<>();
  }

  public Profile(
      Long id,
      String avatar,
      String firstName,
      String lastName,
      ProfileType type,
      List<Transaction> transactions,
      CompanyDetail companyDetail) {
    this.id = id;
    this.avatar = avatar;
    this.firstName = firstName;
    this.lastName = lastName;
    this.type = type;
    this.transactions = transactions;
    this.companyDetail = companyDetail;
    favourites = new ArrayList<>();
    conversations = new ArrayList<>();
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

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

  public CompanyDetail getCompanyDetail() {
    return companyDetail;
  }

  public void setCompanyDetail(CompanyDetail companyDetail) {
    this.companyDetail = companyDetail;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Long> getFavourites() {
    return favourites;
  }

  public void setFavourites(List<Long> favourites) {
    this.favourites = favourites;
  }

  public List<Conversation> getConversations() {
    return conversations;
  }

  public void setConversations(List<Conversation> conversations) {
    this.conversations = conversations;
  }
}
