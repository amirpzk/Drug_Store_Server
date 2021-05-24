package com.Prana.Latifi.response;

import com.Prana.Latifi.entity.Category;
import com.Prana.Latifi.entity.Item;

import javax.persistence.*;
import java.util.List;

public class CompanyDetailResponse {

  private long id;
  private String introduceCode;
  private boolean anyThingDiscounted;
  private List<CategoryResponse> categories;
  private int categoryDiscount;
  private List<ItemResponse> items;
  private int itemDiscount;

  public CompanyDetailResponse() {}

  public CompanyDetailResponse(
      long id,
      String introduceCode,
      boolean anyThingDiscounted,
      List<CategoryResponse> categories,
      int categoryDiscount,
      List<ItemResponse> items,
      int itemDiscount) {
    this.id = id;
    this.introduceCode = introduceCode;
    this.anyThingDiscounted = anyThingDiscounted;
    this.categories = categories;
    this.categoryDiscount = categoryDiscount;
    this.items = items;
    this.itemDiscount = itemDiscount;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getIntroduceCode() {
    return introduceCode;
  }

  public void setIntroduceCode(String introduceCode) {
    this.introduceCode = introduceCode;
  }

  public boolean isAnyThingDiscounted() {
    return anyThingDiscounted;
  }

  public void setAnyThingDiscounted(boolean anyThingDiscounted) {
    this.anyThingDiscounted = anyThingDiscounted;
  }

  public List<CategoryResponse> getCategories() {
    return categories;
  }

  public void setCategories(List<CategoryResponse> categories) {
    this.categories = categories;
  }

  public int getCategoryDiscount() {
    return categoryDiscount;
  }

  public void setCategoryDiscount(int categoryDiscount) {
    this.categoryDiscount = categoryDiscount;
  }

  public List<ItemResponse> getItems() {
    return items;
  }

  public void setItems(List<ItemResponse> items) {
    this.items = items;
  }

  public int getItemDiscount() {
    return itemDiscount;
  }

  public void setItemDiscount(int itemDiscount) {
    this.itemDiscount = itemDiscount;
  }
}
