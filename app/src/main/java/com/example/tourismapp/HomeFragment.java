package com.example.tourismapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tourismapp.databinding.ActivityMainBinding;
import com.example.tourismapp.databinding.FragmentHomeBinding;
import com.google.android.material.navigation.NavigationBarView;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment {

    private static final String TAG = "Home";

    private FragmentHomeBinding binding;

    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

//        TextView locationName = binding.locationName;
        Button changeLocButton = binding.changeLocButton;
        changeLocButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
//        changeLocButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String location = locationName.getText().toString();
//                Intent intent = new Intent(getApplicationContext(), AddingPlaceActivity.class);
//                intent.putExtra("Location", location);
//                mStartForRegData.launch(intent);
//            }
//        });

        Button addPlace = binding.changeLocButton;
        addPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeLocationDialogFragment dialogFragment = new ChangeLocationDialogFragment();
                dialogFragment.show(getParentFragmentManager(), dialogFragment.TAG);
            }
        });

        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}