package com.example.myapplication.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class ContainerActivity extends AppCompatActivity {

    private Fragment aFragment;

    private TextView mTvtile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mTvtile = findViewById(R.id.tv_title);
//        实例化AFragment
        aFragment = AFragment.newInstance("我是标题");
//      把AFragment 添加到Activity
        getFragmentManager().beginTransaction().add(R.id.fl_container, aFragment, "a").commitAllowingStateLoss();
    }

    public void setData(String title) {
        mTvtile.setText(title);
    }

}
