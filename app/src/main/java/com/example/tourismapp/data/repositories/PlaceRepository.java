package com.example.tourismapp.data.repositories;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.example.tourismapp.data.databases.AppDatabase;
import com.example.tourismapp.data.model.Place;
import com.example.tourismapp.data.model.PlaceDao;
import com.example.tourismapp.data.model.PlaceEntity;

import java.util.ArrayList;
import java.util.List;

public class PlaceRepository {

    private List<PlaceEntity> placeList;
    AppDatabase db;
    PlaceDao placeDao;
    private Context context;
    private final MutableLiveData<List<PlaceEntity>> placeListLiveData = new MutableLiveData<>();

    public PlaceRepository(Context context_) {
        this.context = context_;

        placeList = new ArrayList<>();
        AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, "places")
                .allowMainThreadQueries()
                .build();
        PlaceDao placeDao = db.placeDao();

        placeList.add(new PlaceEntity(1, "Bolshoi Theater", "Theatre square"));
        placeList.add(new PlaceEntity(2, "GES-2", "Bolotnaya Naberejnaya, 15"));
        placeList.add(new PlaceEntity(3, "Lenin's Mausoleum", "Red Square"));

        placeDao.insertAll(placeList);

        placeListLiveData.setValue(placeDao.getAll());
    }
    public void addPlace(PlaceEntity place) {
        placeDao.insert(place);
        placeListLiveData.setValue(placeList);
    }

    public void removePlace(PlaceEntity place) {
        placeDao.delete(place);
        placeListLiveData.setValue(placeList);
    }

    public LiveData<List<PlaceEntity>> getPlaceListLiveData() {
        return placeListLiveData;
    }
}
