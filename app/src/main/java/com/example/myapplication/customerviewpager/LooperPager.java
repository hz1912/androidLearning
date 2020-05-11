package com.example.myapplication.customerviewpager;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;

public class LooperPager extends LinearLayout {
    private ViewPager mViewpager;
    private LinearLayout mPointContainer;
    private TextView mTitleTv;
    private BindTitleListener mTitlelistener = null;
    private PagerAdapter mInnerAdapter;


    public LooperPager(Context context) {
        this(context, null);
    }

    public LooperPager(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LooperPager(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.looper_pager_layout, this, true);
        init();
    }

    private void init() {
        initView();
        initEvent();
    }


    /**
     * ViewPager 事件监听
     */

    private void initEvent() {
        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                    切换回调
            }

            @Override
            public void onPageSelected(int position) {
//                   切换停下来  设置标题
                if (mTitlelistener != null) {
                    mTitleTv.setText(mTitlelistener.getTitle(position % mInnerAdapter.getCount()));
                }
                updateIndicator();
            }


            /**
             *     @param state The new scroll state.
             *     @see ViewPager#SCROLL_STATE_IDLE
             *     @see ViewPager#SCROLL_STATE_DRAGGING
             *     @see ViewPager#SCROLL_STATE_SETTLING
             * @param state
             */
            @Override
            public void onPageScrollStateChanged(int state) {
//                 状态的改变  滑动
            }
        });
    }


    public interface BindTitleListener {
        String getTitle(int position);

        int getCount();

    }

    public void setData(PagerAdapter innerAdapter, BindTitleListener listener) {
        mTitlelistener = listener;
        mInnerAdapter = innerAdapter;
        mViewpager.setAdapter(innerAdapter);
        mViewpager.setCurrentItem(Integer.MAX_VALUE / 2);
//      根据数据的个数动态的创建圆点 indicator 指示器
        updateIndicator();


    }

    /**
     * 设置圆点
     */
    private void updateIndicator() {
        if (mInnerAdapter != null) {
            int count = mTitlelistener.getCount();
            mPointContainer.removeAllViews();
            for (int i = 0; i < count; i++) {
                View view = new View(getContext());
                if (mViewpager.getCurrentItem() % mTitlelistener.getCount() == i) {
                    view.setBackgroundColor(Color.parseColor("#ff0000"));
                } else {
                    view.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(SizeUtils.dip2px(getContext(), 10), SizeUtils.dip2px(getContext(), 10));
                layoutParams.setMargins(SizeUtils.dip2px(getContext(), 5), 0, SizeUtils.dip2px(getContext(), 5), 0);
                view.setLayoutParams(layoutParams);
                mPointContainer.addView(view);
            }
        }
    }


    /**
     * 获取UI组件
     */
    private void initView() {
        mViewpager = this.findViewById(R.id.looper_pager_vp);
        mPointContainer = this.findViewById(R.id.looper_point_container);
        mTitleTv = this.findViewById(R.id.looper_title);
    }

}
