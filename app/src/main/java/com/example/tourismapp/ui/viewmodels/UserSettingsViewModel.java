package com.example.tourismapp.ui.viewmodels;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;

import androidx.activity.result.ActivityResultLauncher;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tourismapp.data.model.UserSettings;
import com.example.tourismapp.data.repositories.UserSettingsRepository;
import com.example.tourismapp.ui.fragments.HomeFragment;

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

            public void saveToFileSharedStorage(String fileName, String data, Context context) {

                String type = Environment.DIRECTORY_DOWNLOADS;
                File file = new File(Environment.getExternalStoragePublicDirectory(type), fileName + ".txt");

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
        fsu.saveToFileSharedStorage("Location", location, context);

        repository.setLocation(location);
    }
}

