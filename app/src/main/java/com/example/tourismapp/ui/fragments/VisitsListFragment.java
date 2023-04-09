package com.example.tourismapp.ui.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tourismapp.R;
import com.example.tourismapp.databinding.FragmentVisitsListBinding;
import com.example.tourismapp.data.model.Item;
import com.example.tourismapp.data.model.Place;
import com.example.tourismapp.data.adapters.MyRecyclerViewAdapter;
import com.example.tourismapp.ui.viewmodels.PlaceViewModel;

import java.util.ArrayList;
import java.util.List;


public class VisitsListFragment extends Fragment {
    private FragmentVisitsListBinding binding;
    private PlaceViewModel placeViewModel;
    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;
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

        recyclerView = binding.listItem;
        adapter = new MyRecyclerViewAdapter(getContext(), new ArrayList<>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        placeViewModel = new ViewModelProvider(this).get(PlaceViewModel.class);
        placeViewModel.getPlacesLiveData().observe(getViewLifecycleOwner(), places -> {
            if (places != null) {
                List<Item> items = new ArrayList<>();
                for (Place place: places) {
                    items.add(new Item(place.getName() + " | " + place.getLocation()));
                }
                adapter.setItems(items);
            }
        });
    }
}