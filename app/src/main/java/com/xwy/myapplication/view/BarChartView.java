package com.xwy.myapplication.view;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import com.xwy.myapplication.R;
import com.xwy.myapplication.utils.DisplayUtils;

/**
 * Created by Administrator on 2019/2/12.
 */

public class BarChartView extends View {
    private int circleBackgroundColor;
    private Paint mPaint;

    public int getCircleBackgroundColor() {
        return circleBackgroundColor;
    }

    public void setCircleBackgroundColor(int circleBackgroundColor) {
        this.circleBackgroundColor = circleBackgroundColor;
        mPaint.setColor(circleBackgroundColor);
        invalidate();
    }

    public BarChartView(Context context) {
        super(context);
        init(context,null);
    }

    public BarChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public BarChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attrs) {
        TypedArray typedArray =context.obtainStyledAttributes(attrs,R.styleable.BarChartView);
        circleBackgroundColor = typedArray.getColor(R.styleable.BarChartView_circle_background_color,0xFFFF);
        mPaint = new Paint();
        mPaint.setColor(circleBackgroundColor);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int width = widthSpecSize;
        int height = heightSpecSize;
        int wrapContentWidth = 600;
        int wrapContentHeight = 200;
        if (widthSpecMode == MeasureSpec.AT_MOST&&heightSpecMode == MeasureSpec.AT_MOST){
            width = wrapContentWidth;
            height = wrapContentHeight;
        }else if (widthSpecMode ==MeasureSpec.AT_MOST){
            width = wrapContentWidth;
            height = heightSpecSize;
        }else if (heightSpecMode == MeasureSpec.AT_MOST){
            width = widthSpecSize;
            height = wrapContentHeight;
        }
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int paddingStart;
        int paddingEnd;
        int paddingTop;
        int paddingBottom;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
             paddingStart= getPaddingStart();
             paddingEnd = getPaddingEnd();
        }else {
            paddingStart = getPaddingLeft();
            paddingEnd = getPaddingRight();
        }
        paddingTop = getPaddingTop();
        paddingBottom = getPaddingBottom();
        float radius = Math.min(width,height)/2.0f;
        canvas.drawCircle((width-paddingStart-paddingEnd)/2.0f+paddingStart,(height-paddingTop-paddingBottom)/2.0f+paddingTop,radius,mPaint);
    }
}
