package com.example.uipeformance.pre;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


/**
 * @author sunxianglei
 * @date 2019/3/23
 */
public final class OverCardView extends View {

    private static final int WIDTH = 200;
    private static final int HEIGHT = 200;
    private static final int OFFSET = 50;
    private static final int COUNT = 3;

    private List<Paint> mPaints = new ArrayList<>(COUNT);
    private List<Rect> mRects = new ArrayList<>(COUNT);

    public OverCardView(Context context) {
        this(context, null);
    }

    public OverCardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        Paint paint1 = new Paint();
        paint1.setColor(Color.parseColor("#EBEBEB"));
        mPaints.add(paint1);
        Paint paint2 = new Paint();
        paint2.setColor(Color.parseColor("#D8D8D8"));
        mPaints.add(paint2);
        Paint paint3 = new Paint();
        paint3.setColor(Color.parseColor("#C4C4C4"));
        mPaints.add(paint3);

        mRects.add(new Rect(0, 0, WIDTH,HEIGHT));
        mRects.add(new Rect(OFFSET, 0, WIDTH + OFFSET,HEIGHT));
        mRects.add(new Rect(OFFSET * 2, 0, WIDTH + OFFSET * 2, HEIGHT));

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i=0;i<COUNT;i++){
            canvas.drawRect(mRects.get(i), mPaints.get(i));
        }
    }
}
