package com.example.tourismapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tourismapp.databinding.ActivityMainBinding;
import com.example.tourismapp.databinding.FragmentHomeBinding;
import com.google.android.material.navigation.NavigationBarView;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment implements ChangeLocationDialogFragment.DialogListener {

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


        FragmentManager fm = requireActivity().getSupportFragmentManager();
        Button changeLocButton = binding.changeLocButton;

        changeLocButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = ((TextView)binding.locationName).getText().toString().substring(9);
                showMyDialog(location);
            }
        });

        Button addPlace = binding.addButton;
        addPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddVisitDialogFragment().show(
                        getParentFragmentManager(), AddVisitDialogFragment.TAG);
            }
        });

        return binding.getRoot();
    }

    public void showMyDialog(String arg) {
        String location = ((TextView)binding.locationName).getText().toString().substring(9);
        ChangeLocationDialogFragment dialogFragment = ChangeLocationDialogFragment.newInstance("Location", location);
        dialogFragment.setListener(this);
        dialogFragment.show(getParentFragmentManager(), ChangeLocationDialogFragment.TAG);
    }
    @Override
    public void onDialogResult(String result) {
        if (!result.isEmpty()) {
            String newLocationName = "Location: " + result;
            ((TextView)binding.locationName).setText(newLocationName);
        }
    }
}