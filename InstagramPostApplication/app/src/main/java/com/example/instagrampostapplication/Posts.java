package com.example.instagrampostapplication;

public class Posts {
    private String title, author, location, date_post;
    private Integer profile_image;

    public Posts(String title, String author, String location, String date_post, Integer profile_image) {
        this.title = title;
        this.author = author;
        this.location = location;
        this.date_post = date_post;
        this.profile_image = profile_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate_post() {
        return date_post;
    }

    public void setDate_post(String date_post) {
        this.date_post = date_post;
    }

    public Integer getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(Integer profile_image) {
        this.profile_image = profile_image;
    }
}
