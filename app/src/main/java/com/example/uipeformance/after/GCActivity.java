package com.example.uipeformance.after;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.uipeformance.R;

public class GCActivity extends AppCompatActivity {

    private TranslateView translateView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_activity_gc);
//        translateView = findViewById(R.id.view_translate);
//        ObjectAnimator animator = ObjectAnimator.ofFloat(translateView, "translationY",
//                0, 1000);
//        animator.setDuration(2000);
//        animator.setRepeatCount(-1);
//        animator.start();
    }
}
