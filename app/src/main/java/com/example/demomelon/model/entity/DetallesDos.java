package com.example.demomelon.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetallesDos {

    @SerializedName("Genre")
    @Expose
    private String genre;
    @SerializedName("Poster")
    @Expose
    private String poster;
    @SerializedName("imdbRating")
    @Expose
    private String imdbRating;
    @SerializedName("imdbID")
    @Expose
    private String imdbID;
    @SerializedName("totalSeasons")
    @Expose
    private String totalSeasons;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(String totalSeasons) {
        this.totalSeasons = totalSeasons;
    }
}

