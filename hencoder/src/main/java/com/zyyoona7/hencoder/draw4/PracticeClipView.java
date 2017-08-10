package com.zyyoona7.hencoder.draw4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zyyoona7.hencoder.R;

/**
 * Created by zyyoona7 on 2017/8/10.
 */

public class PracticeClipView extends View {

    private Paint mPaint;
    private Bitmap mBitmap;
    private Path mPath;

    public PracticeClipView(Context context) {
        this(context, null);
    }

    public PracticeClipView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeClipView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPath.reset();
        int spacing = 100;

        int bitmapWidth = mBitmap.getWidth();
        int bitmapHeight = mBitmap.getHeight();

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int width = getWidth();

        //clipRect
        canvas.save();
        canvas.clipRect(spacing, centerY - bitmapHeight / 2, spacing + bitmapWidth, centerY);
        canvas.drawBitmap(mBitmap, spacing, centerY - bitmapHeight / 2, mPaint);
        canvas.restore();

        //clipPath
        mPath.addCircle(width - bitmapWidth / 2 - spacing, centerY, bitmapWidth / 3, Path.Direction.CW);
        canvas.save();
        canvas.clipPath(mPath);
        canvas.drawBitmap(mBitmap, width - bitmapWidth - spacing, centerY - bitmapHeight / 2, mPaint);
        canvas.restore();
    }
}
