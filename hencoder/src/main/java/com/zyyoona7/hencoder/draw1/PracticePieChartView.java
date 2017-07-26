package com.zyyoona7.hencoder.draw1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class PracticePieChartView extends View {

    private Paint mPaint;

    private RectF mSmallRectF;
    private RectF mBigRectF;
    private Path mPath;

    private int mShortWidth;

    public PracticePieChartView(Context context) {
        this(context, null);
    }

    public PracticePieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticePieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(3);
        mPath = new Path();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mShortWidth = w > h ? h : w;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        canvas.drawColor(Color.parseColor("#2F4F4F"));
        canvas.translate(getWidth() / 2, getHeight() / 2);
        float x = mShortWidth / 2;
        float y = mShortWidth / 2;
        float bigOffset = 20;
        if (mSmallRectF == null) {
            mSmallRectF = new RectF(-x / 2, -y / 2, x / 2, y / 2);
        }
        if (mBigRectF == null) {
            mBigRectF = new RectF(-x / 2 - bigOffset, -y / 2 - bigOffset, x / 2 - bigOffset, y / 2 - bigOffset);
        }
        float offsetAngle = 2;
        drawArc(canvas, Color.YELLOW, 0, -60, mSmallRectF);
        drawArc(canvas, Color.parseColor("#4B0082"), 0 + offsetAngle, 5, mSmallRectF);
        drawArc(canvas, Color.parseColor("#838B8B"), 7 + offsetAngle, 10, mSmallRectF);
        drawArc(canvas, Color.parseColor("#008B45"), 19 + offsetAngle, 10, mSmallRectF);
        drawArc(canvas, Color.parseColor("#1C86EE"), 31 + offsetAngle, 50, mSmallRectF);
        drawArc(canvas, Color.parseColor("#B452CD"), 83 + offsetAngle, 100, mSmallRectF);
        drawArc(canvas, Color.parseColor("#EE2C2C"), 185, 115, mBigRectF);

        drawPathLeft(canvas, 30, 1, -1, 1, -1, "1/6");
        drawPathLeft(canvas, 4.5f, 1, 1, 1, -1, "1/72");
        drawPathLeft(canvas, 14f, 1, 1, 1, -1, "1/36");
        drawPathLeft(canvas, 26f, 1, 1, 1, -1, "1/36");
        drawPathLeft(canvas, 26f, 1, 1, 1, -1, "1/36");
        drawPathLeft(canvas, 58f, 1, 1, 1, 1, "5/36");
        drawPathRight(canvas, 133f, 1, 1, "10/36");
        drawPathBig(canvas, 117.5f, "25/72");
    }

    /**
     * @param canvas
     * @param angle  角度
     * @param xpn    x轴坐标 正 1，负 -1
     * @param ypn    y轴坐标 正 1，负 -1
     * @param xdpn   连到的x坐标是加还是减 正 1，负 -1
     * @param ydpn   连到的y坐标是加还是减 正 1，负 -1
     * @param text
     */
    private void drawPathLeft(Canvas canvas, float angle, int xpn, int ypn, int xdpn, int ydpn, String text) {
        float x = getX(angle) * xpn;
        float y = getY(angle) * ypn;
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath.reset();
        mPath.moveTo(x, y);
        mPath.lineTo(x + 30 * xdpn, y + 30 * ydpn);
        mPath.rLineTo(50, 0);
        canvas.drawPath(mPath, mPaint);
        mPaint.setTextSize(28);
        canvas.drawText(text, x + (80 + 5) * xdpn, y + 30 * ydpn, mPaint);
    }

    /**
     * @param canvas
     * @param angle  角度
     * @param xpn    x轴坐标 正 1，负 -1
     * @param ypn    y轴坐标 正 1，负 -1
     * @param text
     */
    private void drawPathRight(Canvas canvas, float angle, int xpn, int ypn, String text) {
        float x = getX(angle) * xpn;
        float y = getY(angle) * ypn;
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath.reset();
        mPath.moveTo(x, y);
        mPath.lineTo(x - 30, y + 30);
        mPath.rLineTo(-50, 0);
        canvas.drawPath(mPath, mPaint);
        mPaint.setTextSize(28);
        float textWidth = mPaint.measureText(text);
        canvas.drawText(text, x - 80 - 5 - textWidth, y + 30, mPaint);
    }

    /**
     * @param canvas
     * @param angle  角度
     * @param text
     */
    private void drawPathBig(Canvas canvas, float angle, String text) {
        float offset = 20;
        float x = getX(angle) - offset;
        float y = -getY(angle) - offset;
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath.reset();
        mPath.moveTo(x, y);
        mPath.lineTo(x - 30, y - 30);
        mPath.rLineTo(-50, 0);
        canvas.drawPath(mPath, mPaint);
        mPaint.setTextSize(28);
        float textWidth = mPaint.measureText(text);
        canvas.drawText(text, x - 80 - 5 - textWidth, y - 30, mPaint);
    }

    private void drawArc(Canvas canvas, int color, float startAngle, float sweep, RectF rectF) {
        mPaint.setColor(color);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, startAngle, sweep, true, mPaint);
    }

    private float getY(float angle) {
        return (float) (Math.sin(Math.toRadians(angle)) * (mShortWidth / 4));
    }

    private float getX(float angle) {
        return (float) (Math.cos(Math.toRadians(angle)) * (mShortWidth / 4));
    }
}
