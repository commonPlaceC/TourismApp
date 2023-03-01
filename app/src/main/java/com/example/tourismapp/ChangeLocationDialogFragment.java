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

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.tourismapp.databinding.FragmentChangeLocationBinding;
import com.example.tourismapp.databinding.FragmentHomeBinding;

public class ChangeLocationDialogFragment extends DialogFragment {

    public final String TAG = "ChangeLocationDialogFragment";
    public FragmentChangeLocationBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);
    }
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        Log.d(TAG, "_______________________");
        Toast.makeText(getActivity(), "sdf", Toast.LENGTH_SHORT).show();

        binding = FragmentChangeLocationBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        // Create a new AlertDialog builder
        return new AlertDialog.Builder(requireContext())
                .setMessage("Message")
                .setPositiveButton("ok", (dialog, which) -> {} )
                .create();
    }

}