package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.widget.CustomDialog;

public class CustomDiaLogActivity extends AppCompatActivity {

    private Button mbtnDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dia_log);
        mbtnDialog = findViewById(R.id.btn_customdialog);
        mbtnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(CustomDiaLogActivity.this);
                customDialog.setTitle("提示");
                customDialog.setMessage("确认删除吗");
                customDialog.setCancel("取消", new CustomDialog.IonCancelListener() {
                    @Override
                    public void onCancel(CustomDialog dialog) {

                    }
                });
                customDialog.setConfirm("确认", new CustomDialog.IonConfirmListener() {
                    @Override
                    public void onConfirm(CustomDialog dialog) {
                    }
                });
                customDialog.show();
            }
        });
    }
}
