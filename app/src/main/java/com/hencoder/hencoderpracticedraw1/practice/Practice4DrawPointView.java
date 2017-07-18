package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice4DrawPointView extends View {

    public Practice4DrawPointView(Context context) {
        super(context);
    }


    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    Paint mPaint = new Paint();
    Paint mPaint1 = new Paint();
    Paint mPaint2 = new Paint();


    {
        mPaint.setStrokeWidth(50);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint1.setStrokeCap(Paint.Cap.BUTT);
        mPaint1.setStrokeWidth(50);
        mPaint2.setStrokeCap(Paint.Cap.SQUARE);
        mPaint2.setStrokeWidth(50);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        练习内容：使用 canvas.drawPoint() 方法画点
        //        一个圆点，一个方点
        //        圆点和方点的切换使用 mPaint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        canvas.drawPoint(100, 100, mPaint);
        canvas.drawPoint(200, 100, mPaint1);
        canvas.drawPoint(300, 100, mPaint2);
    }
}
