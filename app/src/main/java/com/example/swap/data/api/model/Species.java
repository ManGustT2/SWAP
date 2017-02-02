package com.example.swap.data.api.model;

import com.google.gson.annotations.SerializedName;

public class Species {

    private @SerializedName("name") String name;
    private @SerializedName("classification") String classification;
    private @SerializedName("designation") String designation;
    private @SerializedName("average_height") int average_height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getAverage_height() {
        return average_height;
    }

    public void setAverage_height(int average_height) {
        this.average_height = average_height;
    }
}
