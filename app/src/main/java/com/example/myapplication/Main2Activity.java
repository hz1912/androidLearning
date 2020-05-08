package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.customerview.CustomerViewActivity;
import com.example.myapplication.datastorage.DataStorageActivity;

public class Main2Activity extends AppCompatActivity {


    private Button mBtnUi;

    private Button mBtnData;

    private Button mCustomerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mBtnUi = findViewById(R.id.btn_ui);
        mBtnData = findViewById(R.id.btn_data);
        mCustomerView = findViewById(R.id.btn_customer);
        OnClick onClick = new OnClick();
        mBtnUi.setOnClickListener(onClick);
        mBtnData.setOnClickListener(onClick);
        mCustomerView.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(Main2Activity.this, MainActivity.class);
                    break;
                case R.id.btn_data:
                    intent = new Intent(Main2Activity.this, DataStorageActivity.class);
                    break;
                case R.id.btn_customer:
                    intent = new Intent(Main2Activity.this, CustomerViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
