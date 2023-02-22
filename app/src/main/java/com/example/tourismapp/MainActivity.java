package com.example.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.view.Window;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TourismApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        TextView myTextView = findViewById(R.id.textView4);
        ImageView myImageView = findViewById(R.id.imageView);

        Button myButton = findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Tourism App", "Button clicked with programing method");
            }
        });
    }

    public void myButtonOnClickListener(View view) {
        Log.d(TAG, "Button clicked with daclaration method");
    }
}