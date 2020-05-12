package com.example.myapplication.customerviewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
        handler.postDelayed(task, 1000);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        handler.removeCallbacks(task);
                        break;
                    case MotionEvent.ACTION_UP:
                        handler.postDelayed(task, 1000);
                        break;
                }
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
            handler.postDelayed(task, 2000);
        }
    };


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handler.removeCallbacks(task);
    }

}
