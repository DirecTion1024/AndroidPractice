package com.example.workout;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*WorkoutDetailFragment frag = (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        frag.setWorkoutId(1);*/
    }

    @Override
    public void itemClicked(long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if(fragmentContainer != null){
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            //片段事务开始
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setWorkoutId(id);
            //替换片段，并将其增加到后退堆栈
            ft.replace(R.id.fragment_container,details);
            ft.addToBackStack(null);
            //得到新片段和老片段
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            //提交事务
            ft.commit();
        } else {
            Intent intent = new Intent(this,DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID,id);
            startActivity(intent);
        }
    }
}
