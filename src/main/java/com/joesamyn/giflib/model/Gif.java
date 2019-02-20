package com.joesamyn.giflib.model;

import java.time.LocalDate;

// This is the POJO that will hold our gif data..

public class Gif {

    private String name;
    private int categoryId;
    private LocalDate dateUploaded;
    private String username;
    private boolean favorite;


    public Gif(String name, int categoryId, LocalDate dateUploaded, String username, boolean favorite) {
        this.name = name;
        this.categoryId = categoryId;
        this.dateUploaded = dateUploaded;
        this.username = username;
        this.favorite = favorite;
    }

    public String getName() {
        return name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public LocalDate getDateUploaded() {
        return dateUploaded;
    }

    public String getUsername() {
        return username;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setDateUploaded(LocalDate dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
