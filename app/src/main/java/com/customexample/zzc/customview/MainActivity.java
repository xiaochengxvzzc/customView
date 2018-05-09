package com.customexample.zzc.customview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.customexample.zzc.base.BaseActivity;
import com.customexample.zzc.base.utils.PerfectClickListener;
import com.customexample.zzc.customview.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("连接到组织测试","===");
        showContentView();
        initListener();

    }

    private void initListener() {
        bindingView.button.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                Intent intent=new Intent(MainActivity.this, com.customexample.zzc.customviewcode.activity.MainActivity.class);
                startActivity(intent);
            }
        });
        bindingView.button2.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                Intent intent=new Intent(MainActivity.this, com.customexample.zzc.customviewcode.activity.PathViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
