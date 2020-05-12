package com.example.myapplication.viewpager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.customerviewpager.CustomerViewPagerActivity;

public class ViewPageActivity extends AppCompatActivity {


    private Button viewPager;

    private Button customerviewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page);
        viewPager = findViewById(R.id.btn_viewpager);
        customerviewPager = findViewById(R.id.btn_cunstomer_viewpager);
        setListeners();
    }


    private void setListeners() {
        ViewPageActivity.onClick onClick = new ViewPageActivity.onClick();
        viewPager.setOnClickListener(onClick);
        customerviewPager.setOnClickListener(onClick);
    }

    private class onClick implements View.OnClickListener {
        Intent intent = null;

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_viewpager:
                    intent = new Intent(ViewPageActivity.this, ViewPagerActivity.class);
                    break;
                case R.id.btn_cunstomer_viewpager:
                    intent = new Intent(ViewPageActivity.this, CustomerViewPagerActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
