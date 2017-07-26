package com.zyyoona7.hencoder.draw1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PracticeHistogramView extends View {

    private Paint mPaint;

    public PracticeHistogramView(Context context) {
        this(context, null);
    }

    public PracticeHistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeHistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        canvas.drawColor(Color.parseColor("#C1CDCD"));
        canvas.translate(getWidth() / 5.0f, getHeight() * 4 / 5.0f);
        mPaint.setColor(Color.WHITE);
        canvas.drawLine(0, 0, 0, -getHeight() * 3 / 5.0f, mPaint);
        canvas.drawLine(0, 0, getWidth() * 3 / 5.0f, 0, mPaint);
        float maxX = getWidth() * 3 / 5.0f;
        float maxY = -getHeight() * 3 / 5.0f;

        float spaceX = 20;
        float rectWidth = (maxX - 20 * 8) / 7.0f;

        float minRectHeight = (maxY * 4 / 5.0f) / 10;
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(30);
        for (int i = 0; i < 7; i++) {
            mPaint.setColor(Color.parseColor("#66CDAA"));
            canvas.drawRect(spaceX * (i + 1) + rectWidth * i, minRectHeight * (int) (Math.random() * 10 + 1), spaceX * (i + 1) + rectWidth * (i + 1), 0, mPaint);
            String text = "H " + (i + 1);
            float textWidth = mPaint.measureText(text);
            float leftPadding = (rectWidth - textWidth) / 2.0f;
            mPaint.setColor(Color.WHITE);
            canvas.drawText(text, spaceX * (i + 1) + rectWidth * i + leftPadding, 40, mPaint);
        }
    }
}
