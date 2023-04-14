package com.example.tourismapp.ui.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tourismapp.data.model.Place;
import com.example.tourismapp.data.model.PlaceEntity;
import com.example.tourismapp.data.repositories.PlaceRepository;

import java.util.List;

public class PlaceViewModel extends ViewModel {

    private LiveData<List<PlaceEntity>> placeListLiveData;
    private PlaceRepository placeRepository;

    public void init(Context context) {
        placeRepository = new PlaceRepository(context);
        placeListLiveData = placeRepository.getPlaceListLiveData();
    }

    public LiveData<List<PlaceEntity>> getPlacesLiveData() {
        return placeListLiveData;
    }

    public void addPlace(PlaceEntity place) {
        placeRepository.addPlace(place);
    }

    public void removePlace(PlaceEntity place) {
        placeRepository.removePlace(place);
    }
 }
