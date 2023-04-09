package com.example.tourismapp.ui.viewmodels;

import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tourismapp.data.model.UserSettings;
import com.example.tourismapp.data.repositories.UserSettingsRepository;

public class UserSettingsViewModel extends ViewModel {

    private UserSettingsRepository repository;


    public void init(SharedPreferences sharedPrefs) {
        repository = new UserSettingsRepository(sharedPrefs);
    }

    public LiveData<UserSettings> getLocationLiveData() {
        return repository.getSettingsLiveData();
    }

    public void setLocation(String location) {
        repository.setLocation(location);
    }
}
