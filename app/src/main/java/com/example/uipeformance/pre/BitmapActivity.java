package com.example.uipeformance.pre;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Trace;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.uipeformance.R;


/**
 * @author sunxianglei
 * @date 2019/4/4
 */
public class BitmapActivity extends AppCompatActivity {

    private ImageView bitmapIV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pre_activity_bitmap);
        bitmapIV = findViewById(R.id.iv_bitmap);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Trace.beginSection("BitmapActivity_BitmapUpLoadTime_pre");
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cpu_profiler);
        bitmapIV.setImageBitmap(bitmap);
        Trace.endSection();
    }
}
