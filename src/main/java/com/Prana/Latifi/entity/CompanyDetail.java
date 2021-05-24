package com.Prana.Latifi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company_detail")
public class CompanyDetail {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToOne(mappedBy = "companyDetail")
  private Profile profile;

  @Column(name = "introduce_code")
  private String introduceCode;

  @Column(name = "is_anything_discounted")
  private boolean anyThingDiscounted;

  @Column(name = "any_thing_discount")
  private int anyThingDiscount;

  @ManyToMany(cascade = CascadeType.DETACH)
  @JoinTable(
      name = "company_detail_category",
      joinColumns = {@JoinColumn(name = "company_detail_id")},
      inverseJoinColumns = {@JoinColumn(name = "category_id")})
  private List<Category> categories;

  @Column(name = "category_discount")
  private int categoryDiscount;

  @ManyToMany(cascade = CascadeType.DETACH)
  @JoinTable(
      name = "company_detail_item",
      joinColumns = {@JoinColumn(name = "company_detail_id")},
      inverseJoinColumns = {@JoinColumn(name = "item_id")})
  private List<Item> items;

  @Column(name = "item_discount")
  private int itemDiscount;

  @JoinColumn(name = "company_detail_id")
  @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  private List<Profile> itroducedProfiles;

  public CompanyDetail() {}

  public CompanyDetail(
      String introduceCode,
      boolean anyThingDiscounted,
      int anyThingDiscount,
      List<Category> categories,
      int categoryDiscount,
      List<Item> items,
      int itemDiscount,
      List<Profile> itroducedProfiles) {
    this.introduceCode = introduceCode;
    this.anyThingDiscounted = anyThingDiscounted;
    this.anyThingDiscount = anyThingDiscount;
    this.categories = categories;
    this.categoryDiscount = categoryDiscount;
    this.items = items;
    this.itemDiscount = itemDiscount;
    this.itroducedProfiles = itroducedProfiles;
  }

  public CompanyDetail(
      long id,
      String introduceCode,
      boolean anyThingDiscounted,
      int anyThingDiscount,
      List<Category> categories,
      int categoryDiscount,
      List<Item> items,
      int itemDiscount,
      List<Profile> itroducedProfiles) {
    this.id = id;
    this.introduceCode = introduceCode;
    this.anyThingDiscounted = anyThingDiscounted;
    this.anyThingDiscount = anyThingDiscount;
    this.categories = categories;
    this.categoryDiscount = categoryDiscount;
    this.items = items;
    this.itemDiscount = itemDiscount;
    this.itroducedProfiles = itroducedProfiles;
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

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  public int getCategoryDiscount() {
    return categoryDiscount;
  }

  public void setCategoryDiscount(int categoryDiscount) {
    this.categoryDiscount = categoryDiscount;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public int getItemDiscount() {
    return itemDiscount;
  }

  public void setItemDiscount(int itemDiscount) {
    this.itemDiscount = itemDiscount;
  }

  public int getAnyThingDiscount() {
    return anyThingDiscount;
  }

  public void setAnyThingDiscount(int anyThingDiscount) {
    this.anyThingDiscount = anyThingDiscount;
  }

  public List<Profile> getItroducedProfiles() {
    return itroducedProfiles;
  }

  public void setItroducedProfiles(List<Profile> itroducedProfiles) {
    this.itroducedProfiles = itroducedProfiles;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }
}
