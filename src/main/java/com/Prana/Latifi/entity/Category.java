package com.Prana.Latifi.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "icon")
    private String icon;

    @ManyToOne
    private Category parent;

    @OneToMany(mappedBy="parent")
    private List<Category> children;


    public Category() {
    }

    public Category(long id, String title, String description, String icon, Category parent, List<Category> children) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.parent = parent;
        this.children = children;
    }

    public Category(String title, String description, String icon, Category parent, List<Category> children) {
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.parent = parent;
        this.children = children;
    }

    public Category(String title, String description, String icon, Category parent) {
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.parent = parent;
    }

    public Category(long id, String title, String description, String icon, Category parent) {
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

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }
}
