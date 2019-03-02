package com.example.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_WORKOUT_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //得到片段的引用
        WorkoutDetailFragment workoutDetailFragment = (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        //从意图得到用户单击的训练项目的ID
        int workoutId = (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        //将训练项目ID传递给片段
        workoutDetailFragment.setWorkoutId(workoutId);
    }
}