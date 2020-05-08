package com.example.myapplication.customerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class CustomerViewActivity extends AppCompatActivity {

    private Button mBtnTextVie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view);
        mBtnTextVie = findViewById(R.id.btn_tx);
        OnClick onClick = new OnClick();
        mBtnTextVie.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_ui:
                    intent = new Intent(CustomerViewActivity.this, TextViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
