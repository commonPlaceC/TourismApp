package com.example.tourismapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.Manifest;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tourismapp.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment implements ChangeLocationDialogFragment.DialogListener {

    private static final String TAG = "Home";
    private static final String CHANNEL_ID = "no_1";
    private FragmentHomeBinding binding;

    public HomeFragment() {
        super(R.layout.fragment_home);
    }

    public void requestPermissions() {
        ActivityCompat.requestPermissions(requireActivity(),
                new String[]{ Manifest.permission.POST_NOTIFICATIONS }, 1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void showNotification(String name, String text) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireActivity(), CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher_foreground)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentTitle(name)
                .setContentText(text);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireActivity());
        if (ActivityCompat.checkSelfPermission(requireActivity(),
                Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions();
        }
        notificationManager.notify(1, builder.build());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        FragmentManager fm = requireActivity().getSupportFragmentManager();
        ImageView iv = binding.theatreImage;
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNotification("Bolshoi Theatre", "Some text here...");
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
                Intent intent = new Intent(requireActivity(), OverLayService.class);
                requireActivity().startService(intent);

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
