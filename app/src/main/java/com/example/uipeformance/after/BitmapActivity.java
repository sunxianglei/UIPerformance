package com.example.uipeformance.after;

import android.content.res.Resources;
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
        setContentView(R.layout.after_activity_bitmap);
        bitmapIV = findViewById(R.id.iv_bitmap);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Trace.beginSection("BitmapActivity_BitmapUpLoadTime_after");
        Bitmap bitmap = compressBitmap(getResources(), R.drawable.cpu_profiler,
                75, 75);
        bitmapIV.setImageBitmap(bitmap);
        Trace.endSection();
    }

    private Bitmap compressBitmap(Resources res, int resId, int reqWidth, int reqHeight){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight){
        int height = options.outHeight;
        int width = options.outWidth;
        int inSampleSize = 1;
        if(height > reqHeight || width > reqWidth){
            int halfWidth = width / 2;
            int halfHeight = height / 2;
            while((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth){
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }

}
