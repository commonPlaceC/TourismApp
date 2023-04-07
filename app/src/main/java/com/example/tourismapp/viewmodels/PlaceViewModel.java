package com.example.tourismapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tourismapp.model.Place;
import com.example.tourismapp.repositories.PlaceRepository;

import java.util.List;

public class PlaceViewModel extends ViewModel {

    private MutableLiveData<List<Place>> placeListLiveData;
    private PlaceRepository placeRepository;

    public PlaceViewModel() {
        placeRepository = new PlaceRepository();
        placeListLiveData = (MutableLiveData<List<Place>>) placeRepository.getPlaceListLiveData();
    }

    public LiveData<List<Place>> getPlacesLiveData() {
        return placeListLiveData;
    }

    public void addPlace(Place place) {
        placeRepository.addPlace(place);
        placeListLiveData.setValue(placeRepository.getPlaceListLiveData().getValue());
    }

    public void removePlace(Place place) {
        placeRepository.removePlace(place);
        placeListLiveData.setValue(placeRepository.getPlaceListLiveData().getValue());
    }
 }
