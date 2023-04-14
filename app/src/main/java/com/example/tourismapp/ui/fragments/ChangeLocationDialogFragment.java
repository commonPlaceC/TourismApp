package com.example.tourismapp.ui.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
                        setLocationToSharedPreferences(input);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Objects.requireNonNull(ChangeLocationDialogFragment.this.getDialog()).cancel();
                    }
                });

        return builder.create();
    }

    private void setLocationToSharedPreferences(String location) {
        SharedPreferences sharedPrefs = requireActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        viewModel = new ViewModelProvider(requireActivity()).get(UserSettingsViewModel.class);
        viewModel.init(requireActivity().getApplicationContext(), sharedPrefs);
        viewModel.setLocation(location);
    }

}