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

    DisplayMetrics dm;

    int mDiameter;

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);


    {
        dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);

        mDiameter = dm.widthPixels / 2;
        mRectF = new RectF(mDiameter / 2F, 50, mDiameter * 1.5F, mDiameter + 10);

        mTextPaint.setTextSize(24);
        mTextPaint.setColor(Color.WHITE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        综合练习
        //        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        float startAngle = 0;
        for (int i = 0; i < mNames.length; i++) {
            float sweepAngle = mHeight[i] * 360;
            mPaint.setColor(mColor[i]);
            if (i == 5) {
                RectF rectF = new RectF(mRectF);
                rectF.left -= 20;
                rectF.right -= 20;
                rectF.top -= 20;
                rectF.bottom -= 20;
                canvas.drawArc(rectF, startAngle, sweepAngle, true, mPaint);
            } else {
                canvas.drawArc(mRectF, startAngle, sweepAngle, true, mPaint);
            }

            float textAngle = startAngle + sweepAngle / 2;

            float pointX = (float) (mRectF.centerX() + mRectF.width() / 2 *
                    Math.cos(textAngle * Math.PI / 180));
            float pointY = (float) (mRectF.centerY() + mRectF.height() / 2 *
                    Math.sin(textAngle * Math.PI / 180));
            canvas.drawText(mNames[i], pointX, pointY, mTextPaint);

            startAngle += sweepAngle + 2;
        }
    }
}
