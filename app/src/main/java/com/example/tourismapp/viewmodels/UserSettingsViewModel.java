package com.example.tourismapp.viewmodels;

import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tourismapp.repositories.UserSettingsRepository;

public class UserSettingsViewModel extends ViewModel {
    private final UserSettingsRepository settingsRepository;

    private final MutableLiveData<String> nameLiveData = new MutableLiveData<>();

    public UserSettingsViewModel(UserSettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
        nameLiveData.setValue(settingsRepository.getLocation());
    }

    public LiveData<String> getLocationLiveData() {
        return nameLiveData;
    }

    public void setLocation(String location) {
        settingsRepository.setLocation(location);
        nameLiveData.setValue(location);
    }

}
