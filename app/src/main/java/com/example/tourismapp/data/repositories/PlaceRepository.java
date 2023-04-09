package com.example.tourismapp.data.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tourismapp.data.model.Place;

import java.util.ArrayList;
import java.util.List;

public class PlaceRepository {

    private List<Place> placeList;
    private final MutableLiveData<List<Place>> placeListLiveData = new MutableLiveData<>();

    public PlaceRepository() {
        List<Place> placeList = new ArrayList<>();
        placeList.add(new Place(1, "Bolshoi Theater", "Theatre square"));
        placeList.add(new Place(2, "GES-2", "Bolotnaya Naberejnaya, 15"));
        placeList.add(new Place(3, "Lenin's Mausoleum", "Red Square"));
        placeListLiveData.setValue(placeList);
    }
    public void addPlace(Place place) {
        placeList.add(place);
        placeListLiveData.setValue(placeList);
    }

    public void removePlace(Place place) {
        placeList.remove(place);
        placeListLiveData.setValue(placeList);
    }

    public LiveData<List<Place>> getPlaceListLiveData() {
        return placeListLiveData;
    }
}
