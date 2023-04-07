package com.example.tourismapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.tourismapp.R;
import com.example.tourismapp.databinding.ActivityPlaceCardBinding;

public class PlaceCardActivity extends AppCompatActivity {

    private Bundle bundle;
    private static final String CHANNEL_ID = "no_1";

    private ActivityPlaceCardBinding binding;

    public void requestPermissions() {
        ActivityCompat.requestPermissions(PlaceCardActivity.this,
                new String[]{ Manifest.permission.POST_NOTIFICATIONS }, 1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void showNotification(String name, String text) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(PlaceCardActivity.this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentTitle(name)
                .setContentText(text);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(PlaceCardActivity.this);
        if (ActivityCompat.checkSelfPermission(PlaceCardActivity.this,
                Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions();
        }
        notificationManager.notify(1, builder.build());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = ActivityPlaceCardBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String name = getString(R.string.noti_channel_list);
            String description = getString(R.string.noti_channel_list_desc);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        bundle = getIntent().getExtras();
        String title = bundle.getString("str");
        int imgId = bundle.getInt("img");

        (binding.imageView).setImageResource(imgId);
        (binding.textView).setText(title);

        (binding.addButton).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showNotification(title, "Has been added to you visits list");
            }
        });

        (binding.trackButton).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlaceCardActivity.this, OverLayService.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    PlaceCardActivity.this.startForegroundService(intent);
                } else {
                    PlaceCardActivity.this.startService(intent);
                }
            }
        });
    }
}