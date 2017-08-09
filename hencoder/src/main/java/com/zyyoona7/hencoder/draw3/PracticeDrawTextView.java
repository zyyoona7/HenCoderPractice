package com.zyyoona7.hencoder.draw3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zyyoona7 on 2017/8/9.
 */

public class PracticeDrawTextView extends View {
    private TextPaint mPaint;

    public PracticeDrawTextView(Context context) {
        this(context, null);
    }

    public PracticeDrawTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PracticeDrawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(48);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float with = getWidth();
        String srcText = "zyyoona7";
        String slText = "StaticLayout：" + srcText;
        mPaint.reset();
        setTextSize();
        StaticLayout staticLayout = new StaticLayout(slText, mPaint, 400, Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        canvas.save();
        canvas.translate((with - 400) / 2, 100);
        staticLayout.draw(canvas);
        canvas.restore();

        String dlText = "删除线：" + srcText;
        canvas.save();
        canvas.translate((with - mPaint.measureText(dlText)) / 2, 100 * 2 + mPaint.getFontSpacing() * 2);
        mPaint.reset();
        setTextSize();
        mPaint.setStrikeThruText(true);
        canvas.drawText(dlText, 0, 48, mPaint);
        canvas.restore();

        String ulText = "下划线：" + srcText;
        canvas.save();
        canvas.translate((with - mPaint.measureText(ulText)) / 2, 100 * 3 + mPaint.getFontSpacing() * 3);
        mPaint.reset();
        setTextSize();
        mPaint.setUnderlineText(true);
        canvas.drawText(ulText, 0, 48, mPaint);
        canvas.restore();

        String sxText="setTextSkewX()："+srcText;
        canvas.save();
        canvas.translate((with - mPaint.measureText(sxText)) / 2, 100 * 4 + mPaint.getFontSpacing() * 4);
        mPaint.reset();
        setTextSize();
        mPaint.setTextSkewX(-0.4f);
        canvas.drawText(sxText,0,48,mPaint);
        canvas.restore();

        String scxText="setTextScaleX()："+srcText;
        canvas.save();
        canvas.translate((with - mPaint.measureText(scxText)) / 2, 100 * 5 + mPaint.getFontSpacing() * 5);
        mPaint.reset();
        setTextSize();
        mPaint.setTextScaleX(1.4f);
        canvas.drawText(scxText,0,48,mPaint);
        canvas.restore();

    }

    private void setTextSize(){
        mPaint.setTextSize(48);
    }
}
