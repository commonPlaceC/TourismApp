package com.example.tourismapp.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.View;

public class AddVisitThirdDialogFragment extends DialogFragment {


    public static final String TAG = "AddVisitThird";
    public FragmentAddVisitThirdBinding binding;

    private String place;
    private String location;

    public static AddVisitThirdDialogFragment newInstance(String key, String value) {
        AddVisitThirdDialogFragment dialogFragment = new AddVisitThirdDialogFragment();
        Bundle args = new Bundle();
        args.putString("Place", key);
        args.putString("Location", value);
        dialogFragment.setArguments(args);

        return dialogFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            place = getArguments().getString("Place");
            location = getArguments().getString("Location");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = FragmentAddVisitThirdBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view)
                .setTitle("Confirm")
                .setMessage("Add " + place + " | " + location + " ?")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        SharedPreferences prefs = requireActivity().getSharedPreferences("Visits", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString(place, location);
                        editor.apply();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        return builder.create();
    }
}