package com.example.workout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class WorkoutDetailFragment extends Fragment {
    private long workoutId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //保存局部变量workoutid，以防止横置屏幕时丢失导致detail显示出错
        if (savedInstanceState != null){
            workoutId = savedInstanceState.getLong("workoutId");
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    //在片段启动将要可见时调用更新它的视图
    public void onStart() {
        super.onStart();
        //getView方法得到片段的根视图，然后使用这个根视图得到两个文本视图的引用
        View view = getView();
        if(view != null){
            TextView title = view.findViewById(R.id.textTitle);
            Workout workout = Workout.workouts[(int) workoutId];
            title.setText(workout.getName());
            TextView description = view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putLong("workoutId",workoutId);
    }

    public void setWorkoutId(long workoutId) {
        this.workoutId = workoutId;
    }
}
