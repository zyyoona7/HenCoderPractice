package com.zyyoona7.hencoder.draw4;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.zyyoona7.hencoder.R;

/**
 * Created by zyyoona7 on 2017/8/10.
 */

public class PracticeCameraView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    private Camera mCamera;
    private int degree;
    private ValueAnimator mValueAnimator;
    private Point mPoint1;
    private Point mPoint2;

    public PracticeCameraView(Context context) {
        this(context, null);
    }

    public PracticeCameraView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeCameraView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        mCamera = new Camera();
        mValueAnimator = ValueAnimator.ofInt(0, 180);
        mValueAnimator.setDuration(3000);
        mValueAnimator.setInterpolator(new LinearInterpolator());
        mValueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mValueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                degree = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        mValueAnimator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mValueAnimator.end();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int spacing = 200;

        int bitmapWidth = mBitmap.getWidth();
        int bitmapHeight = mBitmap.getHeight();


        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        if (mPoint1 == null) {
            mPoint1 = new Point(spacing, centerY - bitmapHeight / 2);
        }

        if (mPoint2 == null) {
            mPoint2 = new Point(getWidth() - spacing - bitmapWidth, centerY - bitmapHeight / 2);
        }

        int centerX1 = mPoint1.x + bitmapWidth / 2;
        int centerY1 = mPoint1.y + bitmapHeight / 2;

        int centerX2 = mPoint2.x + bitmapWidth / 2;
        int centerY2 = mPoint2.y + bitmapHeight / 2;

        canvas.save();
        mCamera.save();
        mCamera.rotateX(degree);
        canvas.translate(centerX1, centerY1);
        mCamera.applyToCanvas(canvas);
        canvas.translate(-centerX1, -centerY1);
        mCamera.restore();
        canvas.drawBitmap(mBitmap, spacing, centerY - bitmapHeight / 2, mPaint);
        canvas.restore();

        canvas.save();
        canvas.clipRect(mPoint2.x, mPoint2.y, mPoint2.x + bitmapWidth / 2, mPoint2.y + bitmapHeight);
        canvas.drawBitmap(mBitmap, mPoint2.x, mPoint2.y, mPaint);
        canvas.restore();

        canvas.save();
        if (degree < 90) {
            canvas.clipRect(mPoint2.x + bitmapWidth / 2, 0, mPoint2.x + bitmapWidth+100, getHeight());
        } else {
            canvas.clipRect(mPoint2.x-100, 0, mPoint2.x + bitmapWidth / 2, getHeight());

        }
        mCamera.save();
        mCamera.rotateY(-degree);
        canvas.translate(centerX2, centerY2);
        mCamera.applyToCanvas(canvas);
        canvas.translate(-centerX2, -centerY2);
        mCamera.restore();

        canvas.drawBitmap(mBitmap, mPoint2.x, mPoint2.y, mPaint);
        canvas.restore();
    }
}
