package com.example.tourismapp.viewmodels;

import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tourismapp.repositories.UserSettingsRepository;

public class UserSettingsViewModel extends ViewModel {

    private MutableLiveData<String> location = new MutableLiveData<>();
    private UserSettingsRepository repository;


    public void init(SharedPreferences sharedPrefs) {
        repository = new UserSettingsRepository(sharedPrefs);
        location.setValue(repository.getLocation());
    }

    public String getLocationLiveData() {
        return repository.getLocation();
    }

    public void setLocation(String location) {
        repository.setLocation(location);
    }
}
