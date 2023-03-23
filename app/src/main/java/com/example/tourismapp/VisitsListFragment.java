package com.example.tourismapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tourismapp.databinding.FragmentVisitsListBinding;

import java.util.ArrayList;
import java.util.List;
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
        //inflating
        binding = FragmentVisitsListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        Bundle result = new Bundle();
        result.putString("bundleKey", "result");
        getParentFragmentManager().setFragmentResult("key", result);


        SharedPreferences prefs = requireActivity().getSharedPreferences("Visits", Context.MODE_PRIVATE);
        Map<String,?> allPrefs = prefs.getAll();
        List<Item> itemArrayList = new ArrayList<>();



        for (Map.Entry<String,?> entry : allPrefs.entrySet()){
            itemArrayList.add(new Item(
                    entry.getKey().toString() + " | " + entry.getValue().toString()
            ));
        }

        RecyclerView itemList = binding.listItem;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(requireContext(), itemArrayList);
        itemList.setLayoutManager(layoutManager);
        itemList.setAdapter(adapter);

        return binding.getRoot();
    }
}