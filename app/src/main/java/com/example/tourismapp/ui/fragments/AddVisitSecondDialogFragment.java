package com.example.tourismapp.ui.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.view.View;
import android.widget.EditText;

import com.example.tourismapp.databinding.FragmentAddVisitDialogBinding;
import com.example.tourismapp.databinding.FragmentAddVisitSecondDialogBinding;

public class AddVisitSecondDialogFragment extends DialogFragment {
    public static final String TAG = "AddVisitSecond";
    public FragmentAddVisitSecondDialogBinding binding;
    private String arg;

    public static AddVisitSecondDialogFragment newInstance(String key, String value) {
        AddVisitSecondDialogFragment dialogFragment = new AddVisitSecondDialogFragment();
        Bundle args = new Bundle();
        args.putString(key, value);
        dialogFragment.setArguments(args);

        return dialogFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            arg = getArguments().getString("Place");
        }
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = FragmentAddVisitSecondDialogBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        EditText editText = binding.editText;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view)
                .setTitle(arg + "'s location")
                .setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String locationName = ((EditText)binding.editText).getText().toString();
                        AddVisitThirdDialogFragment dialogFragment = AddVisitThirdDialogFragment.newInstance(arg, locationName);
                        dialogFragment.show(getParentFragmentManager(), AddVisitThirdDialogFragment.TAG);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) { }
                });

        return builder.create();
    }
}