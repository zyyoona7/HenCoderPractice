package com.zyyoona7.hencoder.draw2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PracticeGradientView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private LinearGradient mLinearGradient;
    private LinearGradient mLinearGradient1;
    private LinearGradient mLinearGradient2;
    private RadialGradient mRadialGradient;
    private RadialGradient mRadialGradient1;
    private RadialGradient mRadialGradient2;
    private SweepGradient mSweepGradient;
    private SweepGradient mSweepGradient1;
    private SweepGradient mSweepGradient2;

    public PracticeGradientView(Context context) {
        super(context);
        init();
    }

    public PracticeGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PracticeGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

//    {
//        // 用 Paint.setShader(shader) 设置一个 LinearGradient
//        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3
//    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        width = width > height ? height : width;
        setMeasuredDimension(width, width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float spacing = 10;
        float width = getWidth();
        float circleRadius = width / 6 - spacing;
        if (mLinearGradient == null) {
            mLinearGradient = new LinearGradient(circleRadius + spacing, spacing, circleRadius + spacing, circleRadius * 2 + spacing, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        }
        if (mLinearGradient1 == null) {
            mLinearGradient1 = new LinearGradient(circleRadius + spacing, circleRadius * 2 + spacing * 2, circleRadius + spacing, circleRadius * 4 + spacing * 2, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.MIRROR);
        }
        if (mLinearGradient2 == null) {
            mLinearGradient2 = new LinearGradient(circleRadius + spacing, circleRadius * 4 + spacing * 3, circleRadius + spacing, circleRadius * 6 + spacing * 3, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.REPEAT);
        }

        mPaint.setShader(null);
        mPaint.setShader(mLinearGradient);
        canvas.drawCircle(circleRadius + spacing, circleRadius + spacing, circleRadius, mPaint);
        mPaint.setShader(null);
        mPaint.setShader(mLinearGradient1);
        canvas.drawCircle(circleRadius + spacing, circleRadius * 3 + spacing * 2, circleRadius, mPaint);
        mPaint.setShader(null);
        mPaint.setShader(mLinearGradient2);
        canvas.drawCircle(circleRadius + spacing, circleRadius * 5 + spacing * 3, circleRadius, mPaint);

        if (mRadialGradient == null) {
            mRadialGradient = new RadialGradient(circleRadius * 3 + spacing * 2, circleRadius + spacing, circleRadius * 2 / 3, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        }
        if (mRadialGradient1 == null) {
            mRadialGradient1 = new RadialGradient(circleRadius * 3 + spacing * 2, circleRadius * 3 + spacing * 2, circleRadius * 2 / 3, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.MIRROR);
        }
        if (mRadialGradient2 == null) {
            mRadialGradient2 = new RadialGradient(circleRadius * 3 + spacing * 2, circleRadius * 5 + spacing * 3, circleRadius * 2 / 3, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"), Shader.TileMode.REPEAT);
        }

        mPaint.setShader(null);
        mPaint.setShader(mRadialGradient);
        canvas.drawCircle(circleRadius * 3 + spacing * 2, circleRadius + spacing, circleRadius, mPaint);
        mPaint.setShader(null);
        mPaint.setShader(mRadialGradient1);
        canvas.drawCircle(circleRadius * 3 + spacing * 2, circleRadius * 3 + spacing * 2, circleRadius, mPaint);
        mPaint.setShader(null);
        mPaint.setShader(mRadialGradient2);
        canvas.drawCircle(circleRadius * 3 + spacing * 2, circleRadius * 5 + spacing * 3, circleRadius, mPaint);

        if (mSweepGradient == null) {
            mSweepGradient = new SweepGradient(circleRadius * 5 + spacing * 3, circleRadius + spacing, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"));
        }
        if (mSweepGradient1 == null) {
            mSweepGradient1 = new SweepGradient(circleRadius * 5 + spacing * 3, circleRadius * 3 + spacing * 2, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"));
        }
        if (mSweepGradient2 == null) {
            mSweepGradient2 = new SweepGradient(circleRadius * 5 + spacing * 3, circleRadius * 5 + spacing * 3, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"));
        }

        mPaint.setShader(null);
        mPaint.setShader(mSweepGradient);
        canvas.drawCircle(circleRadius * 5 + spacing * 3, circleRadius + spacing, circleRadius, mPaint);
        mPaint.setShader(null);
        mPaint.setShader(mSweepGradient1);
        canvas.drawCircle(circleRadius * 5 + spacing * 3, circleRadius * 3 + spacing * 2, circleRadius, mPaint);
        mPaint.setShader(null);
        mPaint.setShader(mSweepGradient2);
        canvas.drawCircle(circleRadius * 5 + spacing * 3, circleRadius * 5 + spacing * 3, circleRadius, mPaint);

    }
}
