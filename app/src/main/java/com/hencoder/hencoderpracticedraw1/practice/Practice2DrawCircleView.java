package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {

    public Practice2DrawCircleView(Context context) {
        super(context);
    }


    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    Paint mPaint1;
    Paint mPaint2;
    Paint mPaint3;
    Paint mPaint4;


    {
        mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint2.setStyle(Paint.Style.STROKE);

        mPaint3 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint3.setStyle(Paint.Style.FILL);
        mPaint3.setColor(Color.BLUE);

        mPaint4 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint4.setStyle(Paint.Style.STROKE);
        mPaint4.setStrokeWidth(20);
        mPaint4.setColor(Color.BLACK);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        练习内容：使用 canvas.drawCircle() 方法画圆
        //        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        canvas.drawCircle(350, 160, 120, mPaint1);

        canvas.drawCircle(700, 160, 120, mPaint2);

        canvas.drawCircle(350, 500, 120, mPaint3);

        canvas.drawCircle(700, 500, 120, mPaint4);
    }
}
