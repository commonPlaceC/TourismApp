package com.example.tourismapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentResultListener;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tourismapp.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private static final String CHANNEL_ID = "no_1";
    private static final int REQUEST_CODE = 1;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                String result = bundle.getString("key");
                Log.i(TAG, result);
            }
        });

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        SharedPreferences prefs = getSharedPreferences("Visits", MODE_PRIVATE);
        prefs.edit().clear().apply();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Bolshoi Theatre", "Theatre Square, 1, Moskva, 125009");
        editor.apply();

        NavigationBarView bottomNavigationView = binding.bottomnav;
        switchFragment(new HomeFragment());
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            Fragment fragment;
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_nav:
                        fragment = new HomeFragment();
                        break;
                    case R.id.visits_nav:
                        fragment = new VisitsListFragment();
                        break;
                }
                if (fragment != null) {
                    switchFragment(fragment);
                    return true;
                }
                return false;
            }
        });

    }
    private void switchFragment(Fragment fragment) {;
            getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainerView, fragment)
                .commit();
    }
}