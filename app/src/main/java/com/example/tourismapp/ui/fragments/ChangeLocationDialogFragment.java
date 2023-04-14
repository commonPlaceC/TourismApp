package com.example.tourismapp.ui.fragments;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tourismapp.databinding.FragmentChangeLocationBinding;
import com.example.tourismapp.ui.viewmodels.UserSettingsViewModel;

import java.util.Objects;

public class ChangeLocationDialogFragment extends DialogFragment {

    public static final String TAG = "ChangeLocationDialogFragment";
    public FragmentChangeLocationBinding binding;
    private UserSettingsViewModel viewModel;
    private String locationName = "";


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        binding = FragmentChangeLocationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        EditText editText = binding.editText;
        editText.setHint(locationName);
        builder.setView(view)
                .setTitle("Change Location")
                .setPositiveButton("Apply", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String input = editText.getText().toString();
                        setLocationToStorages(input);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Objects.requireNonNull(ChangeLocationDialogFragment.this.getDialog()).cancel();
                    }
                });

        return builder.create();
    }

    private void setLocationToStorages(String location) {
        SharedPreferences sharedPrefs = requireActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        viewModel = new ViewModelProvider(requireActivity()).get(UserSettingsViewModel.class);
        viewModel.init(requireActivity().getApplicationContext(), sharedPrefs);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!checkPermission()) {
                requestPermission();
            }
        }
        viewModel.setLocation(location);
    }

    boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            return Environment.isExternalStorageManager();
        }
        return ContextCompat.checkSelfPermission(requireContext(), WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                Uri uri = Uri.fromParts("package", requireContext().getPackageName(), null);
                intent.setData(uri);
                requireContext().startActivity(intent);
            }
        } else {
            if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(requireActivity(),
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        1);
            }
        }
    }
}