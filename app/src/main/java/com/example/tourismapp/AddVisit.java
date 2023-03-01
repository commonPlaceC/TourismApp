package com.example.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class AddVisit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_visit);

        Button addPlace = findViewById(R.id.add_place);
        addPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editLocation);
                String[] current_array = getResources().getStringArray(R.array.visits_array);
                String[] increased_array = new String[current_array.length + 1];
                System.arraycopy(current_array, 0, increased_array, 0, current_array.length);
                increased_array[increased_array.length - 1] = editText.getText().toString();
                getResources().getStringArray(R.array.visits_array);
                finish();
            }
        });

        Button cancel = findViewById(R.id.cancel_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish(); }
        });

    }
}