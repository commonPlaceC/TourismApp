package com.example.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class VisitsListActivtiy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_visits_list);

        LinearLayout layout = findViewById(R.id.l_layout);
        ArrayList<String> list = new ArrayList<>();
        list.add("FFKFJK");
        list.add("sdfsdf");

        for (String item : list) {
            TextView textView = new TextView(this);
            textView.setText(item);
            layout.addView(textView);
        }
    }
}