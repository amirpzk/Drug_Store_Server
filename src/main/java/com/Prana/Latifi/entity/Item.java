package com.Prana.Latifi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "duration")
  private String duration;

  @Column(name = "how_to_use")
  private String howToUse;

  @Column(name = "using_tip")
  private String usingTip;

  @Column(name = "using_danger")
  private String usingDanger;

  @Column(name = "second_tip")
  private String secondTip;

  @Column(name = "icon")
  private String icon;

  @Column(name = "image")
  private String image;

  @Column(name = "price")
  private long price;

  @Column(name = "active")
  private boolean active;

  @Column(name = "amount")
  private long amount;

  @Column(name = "special_offer")
  private boolean specialOffer;

  @Column(name = "discount")
  private long discount;

  @Column(name = "sold_amount")
  private long soldAmount;

  @ManyToMany(cascade = CascadeType.DETACH)
  @JoinTable(
      name = "item_category",
      joinColumns = {@JoinColumn(name = "item_id")},
      inverseJoinColumns = {@JoinColumn(name = "category_id")})
  private List<Category> categories;

  @Column(name = "total_amount_of_rates")
  private int totalAMountOfRates;

  @Column(name = "total_rate")
  private int totalRate;

  public Item() {
    categories = new ArrayList<>();
  }

  public Item(
      String title,
      String description,
      String duration,
      String howToUse,
      String usingTip,
      String usingDanger,
      String secondTip,
      String icon,
      String image,
      long price,
      boolean active,
      long amount,
      boolean specialOffer,
      long discount,
      long soldAmount,
      List<Category> categories,
      int totalAMountOfRates,
      int totalRate) {
    this.title = title;
    this.description = description;
    this.duration = duration;
    this.howToUse = howToUse;
    this.usingTip = usingTip;
    this.usingDanger = usingDanger;
    this.secondTip = secondTip;
    this.icon = icon;
    this.image = image;
    this.price = price;
    this.active = active;
    this.amount = amount;
    this.specialOffer = specialOffer;
    this.discount = discount;
    this.soldAmount = soldAmount;
    this.categories = categories;
    this.totalAMountOfRates = totalAMountOfRates;
    this.totalRate = totalRate;
  }

  public Item(
      long id,
      String title,
      String description,
      String duration,
      String howToUse,
      String usingTip,
      String usingDanger,
      String secondTip,
      String icon,
      String image,
      long price,
      boolean active,
      long amount,
      boolean specialOffer,
      long discount,
      long soldAmount,
      List<Category> categories,
      int totalAMountOfRates,
      int totalRate) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.duration = duration;
    this.howToUse = howToUse;
    this.usingTip = usingTip;
    this.usingDanger = usingDanger;
    this.secondTip = secondTip;
    this.icon = icon;
    this.image = image;
    this.price = price;
    this.active = active;
    this.amount = amount;
    this.specialOffer = specialOffer;
    this.discount = discount;
    this.soldAmount = soldAmount;
    this.categories = categories;
    this.totalAMountOfRates = totalAMountOfRates;
    this.totalRate = totalRate;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public String getHowToUse() {
    return howToUse;
  }

  public void setHowToUse(String howToUse) {
    this.howToUse = howToUse;
  }

  public String getUsingTip() {
    return usingTip;
  }

  public void setUsingTip(String usingTip) {
    this.usingTip = usingTip;
  }

  public String getUsingDanger() {
    return usingDanger;
  }

  public void setUsingDanger(String usingDanger) {
    this.usingDanger = usingDanger;
  }

  public String getSecondTip() {
    return secondTip;
  }

  public void setSecondTip(String secondTip) {
    this.secondTip = secondTip;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }

  public boolean isSpecialOffer() {
    return specialOffer;
  }

  public void setSpecialOffer(boolean specialOffer) {
    this.specialOffer = specialOffer;
  }

  public long getDiscount() {
    return discount;
  }

  public void setDiscount(long discount) {
    this.discount = discount;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  public long getSoldAmount() {
    return soldAmount;
  }

  public void setSoldAmount(long soldAmount) {
    this.soldAmount = soldAmount;
  }

  public int getTotalAMountOfRates() {
    return totalAMountOfRates;
  }

  public void setTotalAMountOfRates(int totalAMountOfRates) {
    this.totalAMountOfRates = totalAMountOfRates;
  }

  public int getTotalRate() {
    return totalRate;
  }

  public void setTotalRate(int totalRate) {
    this.totalRate = totalRate;
  }
}
