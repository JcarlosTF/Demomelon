package com.example.demomelon.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActoresData {

    @SerializedName("data")
    @Expose
    private List<Actores> data;

    public List<Actores> getData() {
        return data;
    }

    public void setData(List<Actores> data) {
        this.data = data;
    }
}
