package com.example.tourismapp.data.model;

import androidx.room.*;

import java.util.List;

@Entity(tableName = "places")
public class PlaceEntity {
    @PrimaryKey
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "location")
    public String location;
    @ColumnInfo(name = "description")
    public String description;
    @ColumnInfo(name = "image_id")
    public int image_id;
}
