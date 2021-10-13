package com.example.whatsappapplication_bottomnavigation;

public class Status {
    private String status_name, status_time;
    private int status_image;

    public Status(String status_name, String status_time, int status_image) {
        this.status_name = status_name;
        this.status_time = status_time;
        this.status_image = status_image;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    public String getStatus_time() {
        return status_time;
    }

    public void setStatus_time(String status_time) {
        this.status_time = status_time;
    }

    public int getStatus_image() {
        return status_image;
    }

    public void setStatus_image(int status_image) {
        this.status_image = status_image;
    }
}
