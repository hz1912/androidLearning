package com.example.myapplication.viewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 轮播图
 */
public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private List<Integer> dataList;

    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        viewPager = findViewById(R.id.view_pager);
        initData();
        pagerAdapter = new MyPagerAdapter(dataList);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(Integer.MAX_VALUE/2+1);
    }

    private void initData() {
        dataList = new ArrayList<>();
        dataList.add(R.drawable.pic0);
        dataList.add(R.drawable.pic02);
        dataList.add(R.drawable.pic03);
    }
}
