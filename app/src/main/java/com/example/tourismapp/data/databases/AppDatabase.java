package com.example.tourismapp.data.databases;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tourismapp.data.model.PlaceDao;
import com.example.tourismapp.data.model.PlaceEntity;

@Database(entities = {PlaceEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PlaceDao placeDao();
    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "my-db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
