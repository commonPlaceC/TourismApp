package com.example.tourismapp;

public class Item {
    private final String text;
    private final int imageId;

    public Item(String text) {
        this.text = text;
        this.imageId = 0;
    }
    public Item(String text, int imageId) {
        this.text = text;
        this.imageId = imageId;
    }

    public String getText() { return this.text; }
    public int getImageId() { return this.imageId; }
}
