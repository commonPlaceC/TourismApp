package com.example.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddingPlaceActivity extends AppCompatActivity {

    public static final String TAG = "TourismApp";
    private static final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_place);

        String transmittedString = getIntent().getStringExtra("Location");
        Log.d(TAG, transmittedString);
        EditText editText = findViewById(R.id.editLocation);
        Button changeLocButton = findViewById(R.id.changeButton);
        if (editText != null) {
            editText.setText(transmittedString);
        }
        changeLocButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert editText != null;
                String result = String.valueOf(editText.getText());
                Intent intent = new Intent();
                intent.putExtra("Location", result);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}