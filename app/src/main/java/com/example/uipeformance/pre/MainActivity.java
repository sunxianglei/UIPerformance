package com.example.uipeformance.pre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uipeformance.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mHierarchyBtn, mOverdrawBtn, mGCBtn, mUIBtn, mRecyclerViewBtn, mListViewBtn, mBitmapBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_activity_main);
        mHierarchyBtn = findViewById(R.id.btn_hierarchy);
        mHierarchyBtn.setOnClickListener(this);
        mOverdrawBtn = findViewById(R.id.btn_overdraw);
        mOverdrawBtn.setOnClickListener(this);
        mGCBtn = findViewById(R.id.btn_gc);
        mGCBtn.setOnClickListener(this);
        mUIBtn = findViewById(R.id.btn_ui);
        mUIBtn.setOnClickListener(this);
        mRecyclerViewBtn = findViewById(R.id.btn_recyclerview);
        mRecyclerViewBtn.setOnClickListener(this);
        mListViewBtn = findViewById(R.id.btn_listview);
        mListViewBtn.setOnClickListener(this);
        mBitmapBtn = findViewById(R.id.btn_bitmap);
        mBitmapBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btn_hierarchy:
                intent.setClass(MainActivity.this, HierarchyActivity.class);
                break;
            case R.id.btn_overdraw:
                intent.setClass(MainActivity.this, OverdrawActivity.class);
                break;
            case R.id.btn_gc:
                intent.setClass(MainActivity.this, GCActivity.class);
                break;
            case R.id.btn_ui:
                intent.setClass(MainActivity.this, UIConsumeActivity.class);
                break;
            case R.id.btn_recyclerview:
                break;
            case R.id.btn_listview:
                break;
            case R.id.btn_bitmap:
                intent.setClass(MainActivity.this, BitmapActivity.class);
                break;
        }
        startActivity(intent);
    }
}
