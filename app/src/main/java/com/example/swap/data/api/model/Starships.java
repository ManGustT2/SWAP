package com.example.swap.data.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Администратор on 01.02.2017.
 */
public class Starships {
    private @SerializedName("name") String name;
    private @SerializedName("model") String model;
    private @SerializedName("manufacturer") String manufacturer;
    private @SerializedName("cost_in_credits") int cost_in_credits;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCost_in_credits() {
        return cost_in_credits;
    }

    public void setCost_in_credits(int cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
    }
}
