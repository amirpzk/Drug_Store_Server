package com.Prana.Latifi.request;

public class RoleRequest {

  private long id;
  private String name;
  private String description;

  public RoleRequest() {
  }

  public RoleRequest(long id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }
}
