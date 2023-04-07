package com.example.tourismapp.repositories;

import android.content.SharedPreferences;

public class UserSettingsRepository {

    private final SharedPreferences sharedPrefs;

    public UserSettingsRepository(SharedPreferences sharedPreferences) {
        sharedPrefs = sharedPreferences;
    }

    public String getLocation() {
        return sharedPrefs.getString("Location", "");
    }

    public void setLocation(String location) {
        sharedPrefs.edit().putString("Location", location).apply();
    }
}