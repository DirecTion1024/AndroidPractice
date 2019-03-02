package com.example.workout;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {
    //为片段增加监听器
    static interface WorkoutListListener{
        void itemClicked(long id);
    };
    private WorkoutListListener listener;


    public WorkoutListFragment() {
        // Required empty public constructor
    }


    @Override
    //调用超类的onCreateView()方法，可以得到ListFragment的默认布局
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //获取全部的name数据并组成数组
        String[] names = new String[Workout.workouts.length];
        for (int i=0;i<names.length;i++){
            names[i]=Workout.workouts[i].getName();
        }
        //创建数组适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                //从布局充气泵得到上下文，添加默认视图，添加数组数据
                inflater.getContext(),android.R.layout.simple_list_item_1,names
                );
        //将数组适配器绑定到列表视图
        setListAdapter(adapter);
        //调用超类获取默认布局
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    //片段与活动关联时会调用这个方法
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listener = (WorkoutListListener) activity;
    }

    public void onListItemClick(ListView l,View v,int position,long id){
        if (listener != null){
            //单击ListView中的一项时告诉监听器
            listener.itemClicked(id);
        }
    }
}
