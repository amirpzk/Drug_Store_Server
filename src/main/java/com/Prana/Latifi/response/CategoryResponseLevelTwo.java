package com.Prana.Latifi.response;

public class CategoryResponseLevelTwo {

    private long id;

    private String title;

    private String description;

    private String icon;


    public CategoryResponseLevelTwo() {
    }

    public CategoryResponseLevelTwo(long id, String title, String description, String icon) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.icon = icon;
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
}
