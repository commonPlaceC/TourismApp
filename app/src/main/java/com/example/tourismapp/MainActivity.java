package com.example.tourismapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
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
    private static final int REQUEST_CODE = 1;
    private ActivityMainBinding binding;

    ActivityResultLauncher<Intent> mStartForRegData = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        Bundle arguments = intent.getExtras();
                        String resultString = arguments.getString("Location");
                        Toast.makeText(getApplicationContext(), "New Location: " + resultString, Toast.LENGTH_LONG).show();
                        resultString = "Location: " + resultString;
                        ((TextView)findViewById(R.id.locationName)).setText(resultString);
                    }
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        TextView locationName = findViewById(R.id.locationName);
        ImageView myImageView = findViewById(R.id.Gas_image);

        Button myButton = findViewById(R.id.add_button);
        Log.d(TAG, binding.addButton.getText().toString());
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Tourism App", "Button clicked with programing method");
            }
        });

        String location = locationName.getText().toString();
        Button changeLocButton = findViewById(R.id.changeLocButton);
        changeLocButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddingPlaceActivity.class);
                intent.putExtra("Location", location);
                mStartForRegData.launch(intent);
            }
        });

        NavigationBarView bottomNavigationView = findViewById(R.id.bottomnav);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_nav:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.visits_nav:
                        startActivity(new Intent(getApplicationContext(), VisitsListActivtiy.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

    }

    public void myButtonOnClickListener(View view) {
        Log.d(TAG, "Button clicked with declaration method");
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String resultMessage = data.getStringExtra("Location");
            TextView editText = findViewById(R.id.locationName);
            editText.setText("Location: " + resultMessage);
        }
    }
}