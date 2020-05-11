package com.example.myapplication.customerviewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;


/**
 * viewPage 实现的动画效果
 */
public class MyViewPager extends ViewPager {

    private Handler handler;

    public MyViewPager(@NonNull Context context) {
        this(context, null);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        handler.postDelayed(task, 1000);
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                return false;
            }
        });
    }

    public Runnable task = new Runnable() {
        @Override
        public void run() {
            int current = getCurrentItem();
            current++;
            setCurrentItem(current);
            postDelayed(task, 1000);
        }
    };


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handler.removeCallbacks(task);
    }


}
