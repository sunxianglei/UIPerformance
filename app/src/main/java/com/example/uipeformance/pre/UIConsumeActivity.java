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
        makeLag();
    }

    private void makeLag(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    // 模拟复杂操作
                    Thread.sleep(1000);
                    int a = 0;
                    for(int i=0;i<1000000;i++){
                        a++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 2000);
    }

}
