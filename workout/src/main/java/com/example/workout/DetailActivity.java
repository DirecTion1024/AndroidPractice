package com.example.workout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_WORKOUT_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //得到片段的引用
        WorkoutDetailFragment workoutDetailFragment = (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        //从意图得到用户单击的训练项目的ID
        Log.d("workout", "EXTRA_WORKOUT_ID: "+getIntent().getExtras().get(EXTRA_WORKOUT_ID));
        int workoutId = Integer.parseInt(getIntent().getExtras().get(EXTRA_WORKOUT_ID).toString()) ;
        //将训练项目ID传递给片段
        workoutDetailFragment.setWorkoutId(workoutId);
    }
}
