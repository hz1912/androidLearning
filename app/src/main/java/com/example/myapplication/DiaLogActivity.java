package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.util.ToastUtils;

public class DiaLogActivity extends AppCompatActivity {


    private Button mBtnDialog1;

    private Button mBtnDialog2;

    private Button mBtnDialog3;

    private Button mBtnDialog4;


    private Button mBtnDialog5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dia_log);
        OnClick onClick = new OnClick();
        mBtnDialog1 = findViewById(R.id.btn_dialog1);
        mBtnDialog2 = findViewById(R.id.btn_dialog2);
        mBtnDialog3 = findViewById(R.id.btn_dialog3);
        mBtnDialog4 = findViewById(R.id.btn_dialog4);
        mBtnDialog5 = findViewById(R.id.btn_dialog5);
        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);
        mBtnDialog5.setOnClickListener(onClick);
    }


    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DiaLogActivity.this);
                    builder.setTitle("请回答")//
                            .setMessage("你觉得课程如何")//
                            .setIcon(R.drawable.smile)
                            .setPositiveButton("棒", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtils.showMsg(DiaLogActivity.this, "你很诚实");
                                }
                            }).setNeutralButton("还行", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtils.showMsg(DiaLogActivity.this, "睁眼说瞎话");
                        }
                    }).show();
                    break;
                case R.id.btn_dialog2:
                    final String[] array = new String[]{"男", "女"};
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(DiaLogActivity.this);
                    builder1.setTitle("请回答")//
                            .setItems(array, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtils.showMsg(DiaLogActivity.this, array[which]);
                                }
                            }).show();
                    break;
                case R.id.btn_dialog3:
                    final String[] arra3 = new String[]{"男", "女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DiaLogActivity.this);
                    builder3.setTitle("请选择性别")//
                            .setSingleChoiceItems(arra3, 0, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtils.showMsg(DiaLogActivity.this, arra3[which]);
                                }
                            }).show();
                    break;
                case R.id.btn_dialog4:
                    final String[] arra4 = new String[]{"唱歌", "跳舞", "打篮球"};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DiaLogActivity.this);
                    boolean[] isSelected = new boolean[]{false, false, true};
                    builder4.setTitle("选择兴趣").setMultiChoiceItems(arra4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtils.showMsg(DiaLogActivity.this, arra4[which] + ":" + isChecked);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).setNeutralButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).show();
                    break;
                case R.id.btn_dialog5:
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(DiaLogActivity.this);
                    builder5.setTitle("请先登录");
                    View view = LayoutInflater.from(DiaLogActivity.this).inflate(R.layout.layout_dialog, null);
                    EditText etUserName = view.findViewById(R.id.et_username);
                    EditText etPassword = view.findViewById(R.id.et_password);
                    builder5.setView(view);
                    builder5.show();
                    break;

            }
        }
    }
}
