package com.example.starbuzz;

/**
 * Created by Administrator on 2018/6/4 0004.
 */

public class Drink {
    private String name;
    private String description;
    private String imageResourceId;

    public static final Drink[] drinks={
            new Drink("Latte","description1","image1"),
            new Drink("Cappuccino","description2","image2"),
            new Drink("Filter","description3","image3")
    };

    private Drink(String name,String description,String imageResourceId){
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }

    public String getImageResourceId(){
        return imageResourceId;
    }

    public String toString(){
        return this.name;
    }
}
