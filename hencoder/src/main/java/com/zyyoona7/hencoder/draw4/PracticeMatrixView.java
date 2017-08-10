package com.zyyoona7.hencoder.draw4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zyyoona7.hencoder.R;

/**
 * Created by zyyoona7 on 2017/8/10.
 */

public class PracticeMatrixView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    private Matrix mMatrix;

    public PracticeMatrixView(Context context) {
        this(context, null);
    }

    public PracticeMatrixView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeMatrixView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        mMatrix = new Matrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int spacing = 100;
        int bitmapWidth = mBitmap.getWidth();
        int bitmapHeight = mBitmap.getHeight();
        int width = getWidth();
        int height = getHeight();


        canvas.save();
        mMatrix.reset();
        mMatrix.postTranslate(100,0);
        mMatrix.postRotate(-30);
        canvas.concat(mMatrix);
        canvas.drawBitmap(mBitmap, spacing, spacing, mPaint);
        canvas.restore();

//        canvas.save();
//        mMatrix.reset();
//        mMatrix.preRotate(-30);
//        mMatrix.preTranslate(100,0);
//        canvas.concat(mMatrix);
//        canvas.drawBitmap(mBitmap, spacing, height - spacing - bitmapHeight, mPaint);
//        canvas.restore();
//
//        canvas.save();
//        mMatrix.reset();
//        mMatrix.postScale(0.5f,0.5f);
//        canvas.concat(mMatrix);
//        canvas.drawBitmap(mBitmap, width-spacing-bitmapWidth, spacing, mPaint);
//        canvas.restore();
//
//        canvas.save();
//        mMatrix.reset();
//        mMatrix.postSkew(0.5f,0f);
//        canvas.concat(mMatrix);
//        canvas.drawBitmap(mBitmap, width-spacing-bitmapWidth, height - spacing - bitmapHeight, mPaint);
//        canvas.restore();
    }
}
