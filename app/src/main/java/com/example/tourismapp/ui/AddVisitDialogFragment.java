package com.example.tourismapp.ui;

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

public class AddVisitDialogFragment extends DialogFragment {

    public static final String TAG = "AddVisit";
    public FragmentAddVisitDialogBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = FragmentAddVisitDialogBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        EditText editText = binding.editText;
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view)
                .setTitle("New Visit Place")
                .setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String placeName = ((EditText)binding.editText).getText().toString();
                        AddVisitSecondDialogFragment dialogFragment = AddVisitSecondDialogFragment.newInstance("Place", placeName);
                        dialogFragment.show(getParentFragmentManager(), AddVisitSecondDialogFragment.TAG);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        return builder.create();
    }
}