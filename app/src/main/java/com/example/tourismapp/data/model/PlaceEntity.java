package com.example.tourismapp.data.model;

import androidx.room.*;

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

    @Ignore
    public PlaceEntity(int id, String name, String location, String description, int image_id) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.image_id = image_id;
    }

    public PlaceEntity(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public String getName() { return name; }
    public String getLocation() { return location; }
}
