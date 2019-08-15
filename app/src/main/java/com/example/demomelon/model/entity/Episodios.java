package com.example.demomelon.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Episodios {
    @SerializedName("overview")
    @Expose
    String overview;
    @SerializedName("filename")
    @Expose
    String filename;
    @SerializedName("episodeName")
    @Expose
    String episodeName;
    @SerializedName("firstAired")
    @Expose
    String firstAired;
    @SerializedName("siteRating")
    @Expose
    String siteRating;

    public Episodios(String overview, String filename, String episodeName, String firstAired, String siteRating) {
        this.overview = overview;
        this.filename = filename;
        this.episodeName = episodeName;
        this.firstAired = firstAired;
        this.siteRating = siteRating;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public String getFirstAired() {
        return firstAired;
    }

    public void setFirstAired(String firstAired) {
        this.firstAired = firstAired;
    }

    public String getSiteRating() {
        return siteRating;
    }

    public void setSiteRating(String siteRating) {
        this.siteRating = siteRating;
    }
}