package com.Prana.Latifi.request;

import com.Prana.Latifi.entity.Category;

import javax.persistence.*;
import java.util.List;

public class ItemRequest {

    private long id;
    private String title;
    private String description;
    private long amountInShop;
    private String duration;
    private String howToUse;
    private String usingTip;
    private String usingDanger;
    private String secondTip;
    private String icon;
    private String image;
    private long price;
    private boolean active;
    private long amount;
    private boolean specialOffer;
    private long discount;
    private long soldAmount;
    private List<CategoryRequest> categories;

    public ItemRequest() {
    }

    public ItemRequest(long id, String title, String description, long amountInShop, String duration, String howToUse, String usingTip, String usingDanger, String secondTip, String icon, String image, long price, boolean active, long amount, boolean specialOffer, long discount, long soldAmount, List<CategoryRequest> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.amountInShop = amountInShop;
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

    public long getAmountInShop() {
        return amountInShop;
    }

    public void setAmountInShop(long amountInShop) {
        this.amountInShop = amountInShop;
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

    public long getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(long soldAmount) {
        this.soldAmount = soldAmount;
    }

    public List<CategoryRequest> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryRequest> categories) {
        this.categories = categories;
    }
}
