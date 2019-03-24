package com.example.uipeformance.pre;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class TranslateView extends View {

    private Paint mPaint;
    private int y;

    public TranslateView(Context context) {
        this(context, null);
    }

    public TranslateView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i=0;i<1000;i++){
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
            mPaint.setColor(Color.GREEN);
        }
        canvas.drawCircle( 50 ,y, 50, mPaint);
        y++;
        if(y == 200){
            y = 0;
        }
        invalidate();
    }

}
