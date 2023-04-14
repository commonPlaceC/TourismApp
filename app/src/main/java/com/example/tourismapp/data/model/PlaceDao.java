package com.example.tourismapp.data.model;
import androidx.room.*;

import java.util.List;

@Dao
public interface PlaceDao {
    @Query("SELECT * FROM places")
    List<PlaceEntity> getAll();

    @Query("SELECT * FROM places WHERE name = :name")
    PlaceEntity findByName(String name);

    @Query("SELECT * FROM places WHERE id = :id")
    PlaceEntity findById(int id);

    @Query("SELECT * FROM places WHERE id IN (:ids)")
    List<PlaceEntity> loadAllByIds(int[] ids);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PlaceEntity place);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<PlaceEntity> places);

    @Delete
    void delete(PlaceEntity place);
}
