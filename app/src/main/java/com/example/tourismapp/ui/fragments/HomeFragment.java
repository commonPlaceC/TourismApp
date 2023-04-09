package com.example.tourismapp.ui.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tourismapp.R;
import com.example.tourismapp.data.model.Item;
import com.example.tourismapp.data.model.Place;
import com.example.tourismapp.databinding.FragmentHomeBinding;
import com.example.tourismapp.ui.activities.PlaceCardActivity;
import com.example.tourismapp.ui.viewmodels.PlaceViewModel;
import com.example.tourismapp.ui.viewmodels.UserSettingsViewModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private static final String TAG = "Home";
    private static final String CHANNEL_ID = "no_1";
    public UserSettingsViewModel viewModel;

    private SharedPreferences sharedPrefs;
    private FragmentHomeBinding binding;

    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPrefs = requireActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        viewModel = new ViewModelProvider(this).get(UserSettingsViewModel.class);
        viewModel.init(sharedPrefs);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        FragmentManager fm = requireActivity().getSupportFragmentManager();
        CardView cv1 = binding.firstCard;
        CardView cv2 = binding.secondCard;
        CardView cv3 = binding.thirdCard;
        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(), PlaceCardActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("str", "GAS-2");
                bundle.putInt("img", R.drawable.gas_image);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(), PlaceCardActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("str", "Bolshoi Theatre");
                bundle.putInt("img", R.drawable.bolshoi_theatre);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(), PlaceCardActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("str", "Biblioteka Imeni Lenina");
                bundle.putInt("img", R.drawable.lenin);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        Button changeLocButton = binding.changeLocButton;

        changeLocButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = ((TextView) binding.locationName).getText().toString().substring(9);
                showMyDialog();
            }
        });

        Button addPlace = binding.addButton;
        addPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddVisitDialogFragment().show(
                        getParentFragmentManager(), AddVisitDialogFragment.TAG);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(UserSettingsViewModel.class);
        viewModel.getLocationLiveData().observe(getViewLifecycleOwner(), userSettings -> {
            if (userSettings.getLocation() != null) {
                ((TextView)requireView().findViewById(R.id.locationName)).setText("Location: " + userSettings.getLocation());
            }
        });
    }

    public void showMyDialog() {
        ChangeLocationDialogFragment dialogFragment = new ChangeLocationDialogFragment();
        dialogFragment.show(getParentFragmentManager(), ChangeLocationDialogFragment.TAG);
    }
}
