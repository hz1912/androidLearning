package com.example.myapplication.viewpager.viewltablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.myapplication.R;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerTabLayoutActivity extends AppCompatActivity {

    private static final String[] CONTENT = new String[]{"推荐", "热点", "视频", "本地", "科技", "健康"};

    private List<Fragment> list = new ArrayList<Fragment>();
    private TabPageIndicator tabPageIndicator;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_tab_layout);
        FragmentPagerAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(),list);
        pager = findViewById(R.id.pager);
        tabPageIndicator = findViewById(R.id.indicator);
        pager.setAdapter(adapter);
        initData();
        tabPageIndicator.setViewPager(pager);
    }

    private void initData() {
        list.add(new TestFragment(CONTENT[0]));
        list.add(new TestFragment(CONTENT[1]));
        list.add(new TestFragment(CONTENT[2]));
        list.add(new TestFragment(CONTENT[3]));
        list.add(new TestFragment(CONTENT[4]));
        list.add(new TestFragment(CONTENT[5]));
    }

}
