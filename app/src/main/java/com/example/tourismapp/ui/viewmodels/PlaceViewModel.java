package com.example.tourismapp.ui.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tourismapp.data.model.Place;
import com.example.tourismapp.data.repositories.PlaceRepository;

import java.util.List;

public class PlaceViewModel extends ViewModel {

    private LiveData<List<Place>> placeListLiveData;
    private PlaceRepository placeRepository;

    public PlaceViewModel() {
        placeRepository = new PlaceRepository();
        placeListLiveData = placeRepository.getPlaceListLiveData();
    }

    public LiveData<List<Place>> getPlacesLiveData() {
        return placeListLiveData;
    }

    public void addPlace(Place place) {
        placeRepository.addPlace(place);
    }

    public void removePlace(Place place) {
        placeRepository.removePlace(place);
    }
 }
