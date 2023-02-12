package com.example.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TourismApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        CharSequence lifecycle = "onCreate";
        Toast.makeText(context, lifecycle, Toast.LENGTH_SHORT).show();
        Log.d(TAG, lifecycle.toString());
        Log.e(TAG, lifecycle.toString() + "Err");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Context context = getApplicationContext();
        CharSequence lifecycle = "onStart";
        Toast.makeText(context, lifecycle, Toast.LENGTH_SHORT).show();
        Log.d(TAG, lifecycle.toString());
        Log.e(TAG, lifecycle.toString() + "Err");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Context context = getApplicationContext();
        CharSequence lifecycle = "onStop";
        Toast.makeText(context, lifecycle, Toast.LENGTH_SHORT).show();
        Log.d(TAG, lifecycle.toString());
        Log.e(TAG, lifecycle.toString() + "Err");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Context context = getApplicationContext();
        CharSequence lifecycle = "onDestroy";
        Toast.makeText(context, lifecycle, Toast.LENGTH_SHORT).show();
        Log.d(TAG, lifecycle.toString());
        Log.e(TAG, lifecycle.toString() + "Err");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Context context = getApplicationContext();
        CharSequence lifecycle = "onPause";
        Toast.makeText(context, lifecycle, Toast.LENGTH_SHORT).show();
        Log.d(TAG, lifecycle.toString());
        Log.e(TAG, lifecycle.toString() + "Err");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Context context = getApplicationContext();
        CharSequence lifecycle = "onResume";
        Toast.makeText(context, lifecycle, Toast.LENGTH_SHORT).show();
        Log.d(TAG, lifecycle.toString());
        Log.e(TAG, lifecycle.toString() + "Err");
    }


}