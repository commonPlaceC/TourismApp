package com.example.tourismapp.data.model;

import java.util.List;

public class Place {

    private int id;
    private String name;
    private String location;
    private String description;
    private int image_id;
    private List<String> tags;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Place(int id, String name, String location, String description, int image_id, List<String> tags) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.image_id = image_id;
        this.tags = tags;
    }

    public Place(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = "";
        this.image_id = 0;
        this.tags = null;
    }
}
