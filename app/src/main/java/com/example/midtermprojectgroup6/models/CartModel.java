package com.example.midtermprojectgroup6.models;

import android.content.Intent;

import com.example.midtermprojectgroup6.models.MondayFavorite;

public class CartModel {
    int image;
    String day;
    String meal;
    String price;

    public CartModel(int image, String day, String meal, String price) {
        this.image = image;
        this.day = day;
        this.meal = meal;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}

