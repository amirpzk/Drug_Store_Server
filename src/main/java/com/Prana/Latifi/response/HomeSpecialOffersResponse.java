package com.Prana.Latifi.response;

import java.util.List;

public class HomeSpecialOffersResponse {

  private long id;
  private String title;
  private String duration;
  private String icon;
  private String image;
  private long price;
  private boolean active;
  private long amount;
  private long discount;

  public HomeSpecialOffersResponse() {}

  public HomeSpecialOffersResponse(
      long id,
      String title,
      String duration,
      String icon,
      String image,
      long price,
      boolean active,
      long amount,
      long discount) {
    this.id = id;
    this.title = title;
    this.duration = duration;
    this.icon = icon;
    this.image = image;
    this.price = price;
    this.active = active;
    this.amount = amount;
    this.discount = discount;
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

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
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

  public long getDiscount() {
    return discount;
  }

  public void setDiscount(long discount) {
    this.discount = discount;
  }
}
