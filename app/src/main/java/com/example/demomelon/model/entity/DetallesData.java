package com.example.demomelon.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetallesData {

    @SerializedName("data")
    @Expose
    private Detalles data;

    public Detalles getData() {
        return data;
    }
}
