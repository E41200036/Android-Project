package com.example.whatsappapplication_bottomnavigation;

public class Chat {
    private String name, chat, time;
    private int profile_image;

    public Chat(String name, String chat, String time, int profile_image) {
        this.name = name;
        this.chat = chat;
        this.time = time;
        this.profile_image = profile_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(int profile_image) {
        this.profile_image = profile_image;
    }
}
