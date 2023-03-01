package com.example.tourismapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tourismapp.databinding.FragmentHomeBinding;
import com.example.tourismapp.databinding.FragmentVisitsListBinding;


public class VisitsListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
        String[] list = getResources().getStringArray(R.array.visits_array);

        for (String item : list) {
            TextView textView = new TextView(getActivity());
            textView.setText(item);
            layout.addView(textView);
        }

        return inflater.inflate(R.layout.fragment_visits_list, container, false);
    }
}