package com.example.swap.data.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Администратор on 01.02.2017.
 */
public class Planets {

    private @SerializedName("name") String name;
    private @SerializedName("rotation_period") int rotation_period;
    private @SerializedName("orbital_period") int orbital_period;
    private @SerializedName("diameter") String diameter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRotation_period() {
        return rotation_period;
    }

    public void setRotation_period(int rotation_period) {
        this.rotation_period = rotation_period;
    }

    public int getOrbital_period() {
        return orbital_period;
    }

    public void setOrbital_period(int orbital_period) {
        this.orbital_period = orbital_period;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

}
