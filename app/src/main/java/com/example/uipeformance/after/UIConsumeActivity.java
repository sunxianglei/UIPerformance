package com.example.uipeformance.after;

import android.os.Bundle;
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
        setContentView(R.layout.after_activity_uiconsume);
        fixJank();
    }

    private void fixJank(){
        new Thread(() -> {
            try {
                // 模拟复杂操作
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}
