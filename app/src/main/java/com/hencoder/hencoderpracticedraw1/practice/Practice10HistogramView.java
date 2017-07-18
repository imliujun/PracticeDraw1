package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }


    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    int mLeft;
    int mBottom;
    int mRight;
    int mTop;
    DisplayMetrics dm;

    float[] mLinePoints;

    Paint mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint mColumnPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    String[] mNames = { "Foryo", "GB", "ICS", "JB", "KitKat", "L", "M" };

    double[] mHeight = { 0.1, 0.2, 0.25, 0.5, 0.7, 0.85, 0.4 };

    int columnW;

    int columnMaxH;

    int columnSpacing = 15;

    int mNameY;

    int mNameSize = 30;


    {
        dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        mTop = 10;
        mLeft = 50;
        mRight = dm.widthPixels - 50;
        mBottom = 500;

        mLinePoints = new float[] { mLeft, mTop, mLeft, mBottom, mLeft, mBottom, mRight, mBottom };
        mLinePaint.setColor(Color.WHITE);
        mLinePaint.setStrokeWidth(2);

        columnW = (mRight - mLeft) / 7 - columnSpacing * 2;
        columnMaxH = mBottom - mTop;

        mTextPaint.setTextAlign(Paint.Align.CENTER);
        mTextPaint.setColor(Color.WHITE);
        mNameY = mBottom + mNameSize;

        mColumnPaint.setColor(Color.GREEN);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        综合练习
        //        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        //画坐标线
        canvas.drawLines(mLinePoints, mLinePaint);

        //画name
        mTextPaint.setTextSize(mNameSize);
        int nameX = mLeft + columnSpacing + columnW / 2;
        for (String name : mNames) {
            canvas.drawText(name, nameX, mNameY, mTextPaint);
            nameX += columnW + columnSpacing;
        }

        mTextPaint.setTextSize(48);
        canvas.drawText("直方图", dm.widthPixels / 2, getHeight() - 30, mTextPaint);

        int left = mLeft + columnSpacing;
        int top;
        int right;
        int bottom = mBottom - 1;
        for (double h : mHeight) {
            int height = (int) (columnMaxH * h);
            top = mBottom - height;
            right = left + columnW;
            canvas.drawRect(left, top, right, bottom, mColumnPaint);
            left += columnSpacing + columnW;
        }
    }
}
