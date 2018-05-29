package com.example.administrator.headfirst;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickFindBeer(View view) {
        BeerExpert be = new BeerExpert();
        Spinner color = findViewById(R.id.color);
        TextView brands = findViewById(R.id.brands);
        //brands.setText(String.valueOf(color.getSelectedItem()));
        List<String> brandString = be.getBrands(String.valueOf(color.getSelectedItem()));
        StringBuilder brandsFormatted = new StringBuilder();
        for(String brand:brandString){
            brandsFormatted.append(brand).append("\n");
        }
        brands.setText(brandsFormatted);
    }
}
