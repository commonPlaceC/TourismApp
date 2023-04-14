package com.example.tourismapp.ui.viewmodels;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tourismapp.data.model.UserSettings;
import com.example.tourismapp.data.repositories.UserSettingsRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserSettingsViewModel extends ViewModel {

    private UserSettingsRepository repository;
    private Context context;


    public void init(Context context, SharedPreferences sharedPrefs) {
        this.context = context;
        repository = new UserSettingsRepository(sharedPrefs);
    }

    public LiveData<UserSettings> getLocationLiveData() {
        return repository.getSettingsLiveData();
    }

    public void setLocation(String location) {
        class FileStoreUtility {
            public void saveToFile(String fileName, String data, Context context_) {
                File file = new File(context_.getFilesDir(), fileName + ".txt");
                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(data.getBytes());
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        FileStoreUtility fsu = new FileStoreUtility();
        fsu.saveToFile("Location", location, context);

        repository.setLocation(location);
    }
}

