package com.example.tourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddingPlaceActivity extends AppCompatActivity {

    public static final String TAG = "AddingPlace";
    private static final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_adding_place);

        Bundle arguments = getIntent().getExtras();
        String transmittedString = arguments.get("Location").toString();

        EditText editText = findViewById(R.id.editLocation);
        editText.setHint(transmittedString);
        Button changeLocButton = findViewById(R.id.changeButton);
        changeLocButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent res = new Intent();
                Bundle resBundle = new Bundle();
                resBundle.putString("Location", ((EditText)(findViewById(R.id.editLocation))).getText().toString());
                res.putExtras(resBundle);
                setResult(RESULT_OK, res);
                finish();
            }
        });
    }
}