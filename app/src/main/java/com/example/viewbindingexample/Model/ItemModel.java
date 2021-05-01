package com.example.viewbindingexample.Model;

public class ItemModel {

    private String image;
    private String country;
    private String description;


    public ItemModel(String image, String country, String description) {
        this.image = image;
        this.country = country;
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
