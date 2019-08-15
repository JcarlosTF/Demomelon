package com.example.demomelon.model.entity;

public class Series {
    private String banner;
    private int id;
    private String seriesName;

    public Series(String banner, int id, String seriesName) {
        this.banner = banner;
        this.id = id;
        this.seriesName = seriesName;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }
}
