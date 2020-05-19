package com.example.myapplication.recycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class SmartRefreshLayoutActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    List<String> dataList = null;

    private SmartRefreshAdapter smartRefreshAdapter;

    private SmartRefreshLayout smartRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_refresh_layout);
        recyclerView = findViewById(R.id.recyclerView);
        smartRefreshLayout = findViewById(R.id.refreshLayout);
        initDataList();
        smartRefreshAdapter = new SmartRefreshAdapter(SmartRefreshLayoutActivity.this, dataList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(smartRefreshAdapter);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });
    }

    private void initDataList() {
        dataList = new ArrayList<>();
        dataList.add("1");
        dataList.add("2");
        dataList.add("3");
        dataList.add("4");
        dataList.add("5");
        dataList.add("6");
        dataList.add("7");
        dataList.add("8");
        dataList.add("9");
        dataList.add("10");
    }
}
