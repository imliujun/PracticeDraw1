package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }


    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    String[] mNames = { "Foryo", "GB", "ICS", "JB", "KitKat", "L", "M" };

    float[] mHeight = { 0.02F, 0.08F, 0.1F, 0.18F, 0.15F, 0.3F, 0.13F };

    int[] mColor = { Color.RED, Color.BLUE, Color.CYAN, Color.YELLOW, Color.GREEN, Color.DKGRAY,
            Color.LTGRAY };

    RectF mRectF;
    RectF mMoveRectF;
    DisplayMetrics dm;

    int mDiameter;

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);


    {
        dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);

        mDiameter = dm.widthPixels / 2;
        mRectF = new RectF(mDiameter / 2F, 50, mDiameter * 1.5F, mDiameter + 10);

        mMoveRectF = new RectF(mRectF);
        mMoveRectF.left -= 20;
        mMoveRectF.right -= 20;
        mMoveRectF.top -= 20;
        mMoveRectF.bottom -= 20;

        mLinePaint.setColor(Color.WHITE);
        mLinePaint.setStrokeWidth(3);
        mTextPaint.setTextSize(24);
        mTextPaint.setColor(Color.WHITE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        综合练习
        //        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        float startAngle = 0;
        int margin = 20;
        float lineX;
        float lineY;
        float pointX;
        float pointY;
        float endLineX;
        float textX;
        RectF rectF;
        for (int i = 0; i < mNames.length; i++) {
            float sweepAngle = mHeight[i] * 360;
            mPaint.setColor(mColor[i]);

            float textAngle = startAngle + sweepAngle / 2;

            if (i == 5) {
                rectF = mMoveRectF;
            } else {
                rectF = mRectF;
            }

            canvas.drawArc(rectF, startAngle, sweepAngle, true, mPaint);
            pointX = (float) (rectF.centerX() +
                                      rectF.width() / 2 * Math.cos(textAngle * Math.PI / 180));
            pointY = (float) (rectF.centerY() +
                                      rectF.height() / 2 * Math.sin(textAngle * Math.PI / 180));
            lineX = (float) (rectF.centerX() + (rectF.width() / 2 + margin) *
                    Math.cos(textAngle * Math.PI / 180));
            lineY = (float) (rectF.centerY() + (rectF.height() / 2 + margin) *
                    Math.sin(textAngle * Math.PI / 180));

            canvas.drawLine(pointX, pointY, lineX, lineY, mLinePaint);

            if (textAngle >= 90 && textAngle <= 270) {
                endLineX = lineX - 100;
                textX = endLineX - 20;
                mTextPaint.setTextAlign(Paint.Align.RIGHT);
            } else {
                endLineX = lineX + 100;
                textX = endLineX + 20;
                mTextPaint.setTextAlign(Paint.Align.LEFT);
            }
            canvas.drawLine(lineX, lineY, endLineX, lineY, mLinePaint);
            canvas.drawText(mNames[i], textX, lineY + 3, mTextPaint);

            startAngle += sweepAngle + 2;
        }
    }
}
