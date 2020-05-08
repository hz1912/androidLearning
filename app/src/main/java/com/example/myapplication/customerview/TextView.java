package com.example.myapplication.customerview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

import androidx.annotation.Nullable;

public class TextView extends View {
    /**
     * TextView textView = new TextView 调用
     *
     * @param context
     */
    public TextView(Context context) {
        super(context);
    }

    /**
     * 在布局中使用
     * <com.example.myapplication.customerview.TextView
     * android:layout_width="wrap_content"
     * android:layout_height="wrap_content">
     * </com.example.myapplication.customerview.TextView>
     *
     * @param context
     * @param attrs
     */
    public TextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    /**
     * 在布局中使用  在style中使用
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */

    public TextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    public TextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    /**
     * 测量模式
     * 自定义View的测量方法  布局的宽高都是由这个方法指定
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
//        MeasureSpec.AT_MOST  :wrap_content
//        MeasureSpec.EXACTLY: 具体的高度 100dp  match_parent fill_parent
//        MeasureSpec.UNSPECIFIED: 尽可能大  ListView ,ScrollView

//    ScrollView+listView 会显示不全 UNSPECIFIED

//    widthMeasureSpec  包含两个信息  模式mod 2位  值：30位
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heighMode = MeasureSpec.getMode(heightMeasureSpec);

        if (widthMode == MeasureSpec.AT_MOST) {

        } else if (widthMode == MeasureSpec.EXACTLY) {

        } else {

        }
    }


    /**
     * 绘制方法
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


    /**
     * 处理事件分发
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
