package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.animation.AnimationActivity;
import com.example.myapplication.customerviewpager.CustomerViewPagerActivity;
import com.example.myapplication.fragment.ContainerActivity;
import com.example.myapplication.jump.AActivity;
import com.example.myapplication.recycleView.RecycleViewActivity;
import com.example.myapplication.viewpager.ViewPageActivity;
import com.example.myapplication.viewpager.ViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnTextView;

    private Button mBtnButton;

    private Button mEditText;
    private Button mRadioButton;

    private Button mCheckBox;

    private Button mImageView;

    private Button mRecyclearView;

    private Button mWebView;

    private Button mToast;


    private Button mDiaLog;

    private Button mProGressDiaLog;

    private Button mCustomDialog;

    private Button mPopupWindow;

    private Button mJumpl;

    private Button fragment;

    private Button animation;

    private Button viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTextView = this.findViewById(R.id.btn_textview);
        mBtnButton = this.findViewById(R.id.btn_button);
        mEditText = this.findViewById(R.id.btn_editText);
        mRadioButton = this.findViewById(R.id.btn_radiobutton);
        mCheckBox = this.findViewById(R.id.btn_checkbox);
        mImageView = this.findViewById(R.id.btn_imageview);
        mRecyclearView = this.findViewById(R.id.btn_recyclearview);
        mWebView = findViewById(R.id.btn_webview);
        mToast = findViewById(R.id.btn_toast);
        mDiaLog = findViewById(R.id.btn_dialog);
        mProGressDiaLog = findViewById(R.id.btn_progressdialog);
        mCustomDialog = findViewById(R.id.btn_customdialog_1);
        mPopupWindow = findViewById(R.id.btn_popupwindow);
        mJumpl = findViewById(R.id.btn_jump);
        fragment = findViewById(R.id.btn_fragment);
        animation = findViewById(R.id.btn_animation);
        viewPager = findViewById(R.id.btn_viewpager);

        setListeners();
    }

    private void setListeners() {
        onClick onClick = new onClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mEditText.setOnClickListener(onClick);
        mRadioButton.setOnClickListener(onClick);
        mCheckBox.setOnClickListener(onClick);
        mImageView.setOnClickListener(onClick);
        mRecyclearView.setOnClickListener(onClick);
        mWebView.setOnClickListener(onClick);
        mToast.setOnClickListener(onClick);
        mDiaLog.setOnClickListener(onClick);
        mProGressDiaLog.setOnClickListener(onClick);
        mCustomDialog.setOnClickListener(onClick);
        mPopupWindow.setOnClickListener(onClick);
        mJumpl.setOnClickListener(onClick);
        fragment.setOnClickListener(onClick);
        animation.setOnClickListener(onClick);
        viewPager.setOnClickListener(onClick);

    }

    private class onClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_textview:
                    intent = new Intent(MainActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button:
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_editText:
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radiobutton:
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox:
                    intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_imageview:
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_recyclearview:
                    intent = new Intent(MainActivity.this, RecycleViewActivity.class);
                    break;
                case R.id.btn_webview:
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_toast:
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    intent = new Intent(MainActivity.this, DiaLogActivity.class);
                    break;
                case R.id.btn_progressdialog:
                    intent = new Intent(MainActivity.this, ProgressActivity.class);
                    break;

                case R.id.btn_customdialog_1:
                    intent = new Intent(MainActivity.this, CustomDiaLogActivity.class);
                    break;

                case R.id.btn_popupwindow:
                    intent = new Intent(MainActivity.this, PopupWindowActivity.class);
                    break;
                case R.id.btn_jump:
                    intent = new Intent(MainActivity.this, AActivity.class);
                    break;
                case R.id.btn_fragment:
                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_animation:
                    intent = new Intent(MainActivity.this, AnimationActivity.class);
                    break;
                case R.id.btn_viewpager:
                    intent = new Intent(MainActivity.this, ViewPageActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }


    //        mBtnButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ButtonActivity.class);
//                startActivity(intent);
//            }
//        });
//        mEditText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, EditTextActivity.class);
//                startActivity(intent);
//            }
//        });
}
