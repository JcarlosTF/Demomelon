package com.example.demomelon.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EpisodiosData {

    @SerializedName("data")
    @Expose
    private List<Episodios> data;


    public List<Episodios> getData() {
        return data;
    }

    public void setData(List<Episodios> data) {
        this.data = data;
    }
}
