package com.customexample.zzc.customviewcode.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.customexample.zzc.customviewcode.view.PathView;

public class PathViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PathView pathView=new PathView(this);
        setContentView(pathView);
    }
}
