package com.example.tourismapp.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tourismapp.R;
import com.example.tourismapp.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment implements ChangeLocationDialogFragment.DialogListener {

    private static final String TAG = "Home";
    private static final String CHANNEL_ID = "no_1";
    private FragmentHomeBinding binding;

    public HomeFragment() {
        super(R.layout.fragment_home);
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
                showMyDialog(location);
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

    public void showMyDialog(String arg) {
        String location = ((TextView) binding.locationName).getText().toString().substring(9);
        ChangeLocationDialogFragment dialogFragment = ChangeLocationDialogFragment.newInstance("Location", location);
        dialogFragment.setListener(this);
        dialogFragment.show(getParentFragmentManager(), ChangeLocationDialogFragment.TAG);
    }

    @Override
    public void onDialogResult(String result) {
        if (!result.isEmpty()) {
            String newLocationName = "Location: " + result;
            ((TextView) binding.locationName).setText(newLocationName);
        }
    }
}
