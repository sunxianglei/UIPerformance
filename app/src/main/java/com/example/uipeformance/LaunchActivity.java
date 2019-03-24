package com.example.uipeformance;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.uipeformance.pre.MainActivity;

public class LaunchActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        findViewById(R.id.btn_pre).setOnClickListener(this);
        findViewById(R.id.btn_after).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.btn_pre:
                intent.setClass(LaunchActivity.this, MainActivity.class);
                break;
            case R.id.btn_after:
                intent.setClass(LaunchActivity.this, com.example.uipeformance.after.MainActivity.class);
                break;
        }
        startActivity(intent);
    }
}
