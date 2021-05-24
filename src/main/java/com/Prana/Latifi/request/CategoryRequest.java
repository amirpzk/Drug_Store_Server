package com.Prana.Latifi.request;

import com.Prana.Latifi.entity.Category;

public class CategoryRequest {

    private long id;
    private String title;
    private String description;
    private String icon;
    private com.Prana.Latifi.entity.Category parent;

    public CategoryRequest() {
    }

    public CategoryRequest(long id, String title, String description, String icon, com.Prana.Latifi.entity.Category parent) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.parent = parent;
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

    public com.Prana.Latifi.entity.Category getParent() {
        return parent;
    }

    public void setParent(com.Prana.Latifi.entity.Category parent) {
        this.parent = parent;
    }
}
