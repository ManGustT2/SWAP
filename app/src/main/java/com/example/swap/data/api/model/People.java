package com.example.swap.data.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Администратор on 01.02.2017.
 */
public class People {

    private @SerializedName("name") String name;
    private @SerializedName("height") int height;
    private @SerializedName("mass") int mass;
    private @SerializedName("hair_color") String hair_color;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

}
