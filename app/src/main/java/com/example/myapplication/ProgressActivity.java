package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.myapplication.util.ToastUtils;

import java.security.PrivateKey;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar pb3;

    private Button mBtbStart;

    private Button mBtnProgressDialog1;

    private Button mBtnProgressDialog2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        pb3 = findViewById(R.id.pb3);
        mBtbStart =findViewById(R.id.btn_start);
        mBtnProgressDialog1 = findViewById(R.id.btn_progressdialog1);
        mBtnProgressDialog2 = findViewById(R.id.btn_progressdialog2);
        mBtbStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               handler.sendEmptyMessage(0);
            }
        });
        pb3.setProgress(30);
        mBtnProgressDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在下载");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtils.showMsg(ProgressActivity.this,"取消了");
                    }
                });
//                是否可以取消
//                progressDialog.setCancelable(false);
                progressDialog.show();
            }
        });
        mBtnProgressDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在下载......");
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "棒", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtils.showMsg(ProgressActivity.this,"取消了");
                    }
                });
                progressDialog.show();
            }
        });
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(pb3.getProgress()<100){
               handler.postDelayed(runnable,500);
            }else{
                ToastUtils.showMsg(ProgressActivity.this,"加载完成");
            }
        }
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            pb3.setProgress(pb3.getProgress()+5);
            handler.sendEmptyMessage(0);
        }
    };
}
