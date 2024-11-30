package com.testing.api.models;

public class ExResources {

    private String name;
    private String trademark;
    private int stock;
    private int price;
    private String description;
    private String tags;
    private Boolean active;
    private String id;

    public ExResources(String name, String trademark, int stock, int price,String description,
                     String tags, Boolean active, String id) {
        this.name = name;
        this.trademark = trademark;
        this.stock = stock;
        this.price = price;
        this.description = description;
        this.tags = tags;
        this.active = active;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
