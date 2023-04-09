package com.example.tourismapp.data.repositories;

import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tourismapp.data.model.UserSettings;

public class UserSettingsRepository {

    private final SharedPreferences sharedPrefs;
    private final MutableLiveData<UserSettings> settingsLiveData = new MutableLiveData<>();

    public UserSettingsRepository(SharedPreferences sharedPreferences) {
        sharedPrefs = sharedPreferences;
        settingsLiveData.setValue(new UserSettings("Moscow"));
    }

    public LiveData<UserSettings> getSettingsLiveData() {
        return settingsLiveData;
    }

    public void setLocation(String location) {
        settingsLiveData.setValue(new UserSettings(location));
        sharedPrefs.edit().putString("Location", location).apply();
    }
}
