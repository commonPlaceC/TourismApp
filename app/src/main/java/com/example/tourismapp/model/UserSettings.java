package com.example.tourismapp.model;

public class UserSettings {
    private String location;

    public UserSettings(String location) {
        this.location = location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return location;
    }
}
