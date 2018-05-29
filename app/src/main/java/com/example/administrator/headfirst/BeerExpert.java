package com.example.administrator.headfirst;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/26 0026.
 */

public class BeerExpert {
    List<String> getBrands(String color){
        List<String> brands = new ArrayList<String>();
        if(color.equals("amber")){
            brands.add("Jack Amber");
            brands.add("Red Moose");
        }else {
            brands.add("Jail Pale Ale");
            brands.add("Gout Stout");
        }
        return brands;
    }
}
