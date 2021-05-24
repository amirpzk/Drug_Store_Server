package com.Prana.Latifi.response;

import java.util.List;

public class CategoryResponse {

  private long id;

  private String title;

  private String description;

  private String icon;

  private List<CategoryResponseLevelTwo> children;

  public CategoryResponse() {}

  public CategoryResponse(
      long id,
      String title,
      String description,
      String icon,
      List<CategoryResponseLevelTwo> children) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.icon = icon;
    this.children = children;
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

  public List<CategoryResponseLevelTwo> getChildren() {
    return children;
  }

  public void setChildren(List<CategoryResponseLevelTwo> children) {
    this.children = children;
  }
}
