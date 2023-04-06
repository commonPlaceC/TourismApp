package com.example.tourismapp.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.tourismapp.databinding.FragmentChangeLocationBinding;

import java.util.Objects;

public class ChangeLocationDialogFragment extends DialogFragment {

    public static final String TAG = "ChangeLocationDialogFragment";
    public FragmentChangeLocationBinding binding;
    private String locationName = "";

    public interface DialogListener {
        void onDialogResult(String result);
    }
    private DialogListener listener;
    public void setListener(DialogListener _listener) {
        listener = _listener;
    }

    public static ChangeLocationDialogFragment newInstance(String key, String value) {
        ChangeLocationDialogFragment dialogFragment = new ChangeLocationDialogFragment();
        Bundle args = new Bundle();
        args.putString(key, value);
        dialogFragment.setArguments(args);

        return dialogFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!(requireArguments().getString("Location")).isEmpty()) {
            locationName = requireArguments().getString("Location");
        }
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
                        listener.onDialogResult(input);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onDialogResult("");
                        Objects.requireNonNull(ChangeLocationDialogFragment.this.getDialog()).cancel();
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }

}