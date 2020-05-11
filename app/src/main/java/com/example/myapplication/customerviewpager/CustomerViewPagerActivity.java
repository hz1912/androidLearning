package com.example.myapplication.customerviewpager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class CustomerViewPagerActivity extends AppCompatActivity {

    private LooperPager looperPager;

    private List<PagerBean> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view_pager);
        initData();
        intView();
    }

    private void intView() {
        looperPager = findViewById(R.id.sob_looper_pager);
        looperPager.setData(new CustomerAdapter(dataList), new LooperPager.BindTitleListener() {
            @Override
            public String getTitle(int position) {
                return dataList.get(position%dataList.size()).getTitle();
            }
            @Override
            public int getCount() {
                return dataList.size();
            }
        });
    }



    private void initData() {
        dataList = new ArrayList<>();
        dataList.add(new PagerBean("图片1", R.drawable.pic0));
        dataList.add(new PagerBean("图片2", R.drawable.pic02));
        dataList.add(new PagerBean("图片3", R.drawable.pic03));
    }
}
