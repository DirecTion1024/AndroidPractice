package com.example.workout;

public class Workout {
    private String name;
    private String description;

    private Workout(String name,String description){
        this.name = name;
        this.description = description;
    }

    public static final Workout[] workout = {
            new Workout("name1","description1"),
            new Workout("name2","description2"),
            new Workout("name3","description3"),
    };

    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return this.name;
    }
}
