package com.example.uipeformance.pre;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.uipeformance.R;


/**
 * @author sunxianglei
 * @date 2019/3/23
 */
public class UIConsumeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_activity_uiconsume);
        makeJank();
    }

    private void makeJank(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    // 模拟复杂操作
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1000);
    }

}
