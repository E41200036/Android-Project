package com.example.whatsappapplication_bottomnavigation;

public class Call {
    private int call_profile, call_status, call_diff;
    private String call_name, call_time;

    public Call(int call_profile, int call_status, int call_diff, String call_name, String call_time) {
        this.call_profile = call_profile;
        this.call_status = call_status;
        this.call_diff = call_diff;
        this.call_name = call_name;
        this.call_time = call_time;
    }

    public int getCall_profile() {
        return call_profile;
    }

    public void setCall_profile(int call_profile) {
        this.call_profile = call_profile;
    }

    public int getCall_status() {
        return call_status;
    }

    public void setCall_status(int call_status) {
        this.call_status = call_status;
    }

    public int getCall_diff() {
        return call_diff;
    }

    public void setCall_diff(int call_diff) {
        this.call_diff = call_diff;
    }

    public String getCall_name() {
        return call_name;
    }

    public void setCall_name(String call_name) {
        this.call_name = call_name;
    }

    public String getCall_time() {
        return call_time;
    }

    public void setCall_time(String call_time) {
        this.call_time = call_time;
    }
}
