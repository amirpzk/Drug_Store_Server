package com.Prana.Latifi.response;

import java.util.List;

public class ItemPaginationResponse {

  private long id;
  private String title;
  private String description;
  private String icon;
  private String image;
  private long price;
  private boolean active;
  private long amount;
  private boolean specialOffer;
  private long discount;
  private List<CategoryResponse> categories;
  private int totalAMountOfRates;
  private int totalRate;

  public ItemPaginationResponse() {}

  public ItemPaginationResponse(
      long id,
      String title,
      String description,
      String icon,
      String image,
      long price,
      boolean active,
      long amount,
      boolean specialOffer,
      long discount,
      List<CategoryResponse> categories,
      int totalAMountOfRates,
      int totalRate) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.icon = icon;
    this.image = image;
    this.price = price;
    this.active = active;
    this.amount = amount;
    this.specialOffer = specialOffer;
    this.discount = discount;
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

  public List<CategoryResponse> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryResponse> categories) {
    this.categories = categories;
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
