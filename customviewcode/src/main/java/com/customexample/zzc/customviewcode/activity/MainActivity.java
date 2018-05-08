package com.customexample.zzc.customviewcode.activity;

import android.os.Bundle;

import com.customexample.zzc.base.BaseActivity;
import com.customexample.zzc.customviewcode.R;
import com.customexample.zzc.customviewcode.databinding.ActivityMainPieBinding;
import com.customexample.zzc.customviewcode.entity.PieData;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<ActivityMainPieBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pie);
        showContentView();

        ArrayList<PieData> pieDataArrayList=new ArrayList<>();
            for (int i = 0; i < 5; i++) {
            PieData pieData=new PieData("张三"+i,3+3*i);
            pieDataArrayList.add(pieData);
        }
        bindingView.pieViewCircle.setData(pieDataArrayList);
        //setContentView(pieView);
    }
}
