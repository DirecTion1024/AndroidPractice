package com.example.starbuzz;

/**
 * Created by Administrator on 2018/6/7 0007.
 */

public class Drink {
    private String name;
    private String description;
    private int imageResourceId;

    public static final Drink[] drinks ={
            new Drink("Latte","description1", R.drawable.latte),
            new Drink("Cappuccino","description2", R.drawable.cappuccino),
            new Drink("Filter","description3",R.drawable.filter)
    };

    public Drink(String name, String description, int imageResource) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResource;
    }

    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }

    public String toString(){
        return this.name;
    }
}
