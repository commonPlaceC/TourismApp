package com.example.tourismapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tourismapp.databinding.FragmentVisitsListBinding;
import java.util.Map;


public class VisitsListFragment extends Fragment {
    private FragmentVisitsListBinding binding;
    public VisitsListFragment() {
        super(R.layout.fragment_visits_list);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentVisitsListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        LinearLayout layout = binding.lLayout;

        SharedPreferences prefs = requireActivity().getSharedPreferences("Visits", Context.MODE_PRIVATE);
        Map<String,?> allPrefs = prefs.getAll();

        for (Map.Entry<String,?> entry : allPrefs.entrySet()){
            TextView textView = new TextView(getActivity());
            String textForView = entry.getKey().toString() + " | " + entry.getValue().toString();
            textView.setText(textForView);
            layout.addView(textView);
        }

        return binding.getRoot();
    }
}