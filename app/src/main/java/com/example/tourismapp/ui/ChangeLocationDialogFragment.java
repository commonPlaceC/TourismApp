package com.example.tourismapp.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.tourismapp.databinding.FragmentChangeLocationBinding;
import com.example.tourismapp.model.UserSettings;
import com.example.tourismapp.viewmodels.UserSettingsViewModel;

import java.util.Objects;

public class ChangeLocationDialogFragment extends DialogFragment {

    public static final String TAG = "ChangeLocationDialogFragment";
    public FragmentChangeLocationBinding binding;
    private UserSettingsViewModel viewModel;
    private String locationName = "";


    public static ChangeLocationDialogFragment newInstance(String key, String value) {
        ChangeLocationDialogFragment dialogFragment = new ChangeLocationDialogFragment();
        Bundle args = new Bundle();
        args.putString(key, value);
        dialogFragment.setArguments(args);

        return dialogFragment;
    }

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
                        saveLocationToSharedPreferences(input);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Objects.requireNonNull(ChangeLocationDialogFragment.this.getDialog()).cancel();
                    }
                });

        return builder.create();
    }

    private void saveLocationToSharedPreferences(String location) {
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Location", location);
        editor.apply();
    }

}