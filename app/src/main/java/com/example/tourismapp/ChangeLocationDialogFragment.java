package com.example.tourismapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.tourismapp.databinding.FragmentChangeLocationBinding;
import com.example.tourismapp.databinding.FragmentHomeBinding;

public class ChangeLocationDialogFragment extends DialogFragment {

    public static final String TAG = "ChangeLocationDialogFragment";
    public FragmentChangeLocationBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        binding = FragmentChangeLocationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        EditText editText = binding.editText;
        builder.setView(view)
                .setTitle("Change Location")
                .setPositiveButton("Apply", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String input = editText.getText().toString();
                        // Do something with the input here
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Close the dialog
                        ChangeLocationDialogFragment.this.getDialog().cancel();
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }

}