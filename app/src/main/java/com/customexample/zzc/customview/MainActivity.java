package com.customexample.zzc.customview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pie);
        Log.e("连接到组织测试","===");
        Intent intent=new Intent(MainActivity.this, com.customexample.zzc.customviewcode.activity.MainActivity.class);
        startActivity(intent);
    }
}
