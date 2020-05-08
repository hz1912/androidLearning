package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    private Button mBtnToast1;
    private Button mBtnToast2;
    private Button mBtnToast3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        mBtnToast1 = findViewById(R.id.btn_toast1);
        mBtnToast2 = findViewById(R.id.btn_toast2);
        mBtnToast3 = findViewById(R.id.btn_toast3);
        OnClick onClick = new OnClick();

        mBtnToast1.setOnClickListener(onClick);
        mBtnToast2.setOnClickListener(onClick);
        mBtnToast3.setOnClickListener(onClick);
    }


    public class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_toast1:
                    Toast.makeText(getApplicationContext(), "你好", Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_toast2:
                    Toast toastCenter = Toast.makeText(getApplicationContext(), "剧中", Toast.LENGTH_SHORT);
                    toastCenter.setGravity(Gravity.CENTER, 0, 0);
                    toastCenter.show();
                    break;
                case R.id.btn_toast3:
                    Toast toastCustom = new Toast(getApplicationContext());
                    LayoutInflater layoutInflater = LayoutInflater.from(ToastActivity.this);
                    View view = layoutInflater.inflate(R.layout.layout_toast, null);
                    ImageView imageView = view.findViewById(R.id.iv_toast);
                    imageView.setImageResource(R.drawable.smile);
                    TextView textView = view.findViewById(R.id.tv_toast);
                    textView.setText("自定义Toast");
                    toastCustom.setView(view);
                    toastCustom.setDuration(Toast.LENGTH_LONG);
                    toastCustom.show();
                    break;
            }

        }
    }
}
