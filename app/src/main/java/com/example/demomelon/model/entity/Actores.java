package com.example.demomelon.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Actores {
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("role")
    @Expose
    String role;
    @SerializedName("image")
    @Expose
    String image;

    public Actores(String name, String role, String image) {
        this.name = name;
        this.role = role;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
