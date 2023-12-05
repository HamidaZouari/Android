package com.example.mobileandroidnative;

public class ModelCard {
    private int imageView;
    private String name;

    ModelCard(String name){
      //  this.imageView=imageView;
        this.name=name;
    }
    public int getImageView() {
        return imageView;
    }

    public String getName() {
        return name;
    }
}
