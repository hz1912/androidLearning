package com.example.myapplication.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myapplication.R;


public class CustomDialog extends Dialog implements View.OnClickListener {

    private TextView mTvTitle,  mTvcancel, mTvConfirm;

    private String title, message, cancel, confirm;


    private IonCancelListener cancelListener;
    private IonConfirmListener confirmListener;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }


    public CustomDialog setCancel(String cancel, IonCancelListener listener)
    {
        this.cancel = cancel;
        this.cancelListener = listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IonConfirmListener listener)
    {
        this.confirm = confirm;
        this.confirmListener = listener;
        return this;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        mTvTitle = findViewById(R.id.tv_title);
        mTvcancel = findViewById(R.id.tv_cancel);
        mTvConfirm = findViewById(R.id.tv_confirm);

        WindowManager manager = getWindow().getWindowManager();
        Display display = manager.getDefaultDisplay();
        WindowManager.LayoutParams params = getWindow().getAttributes();
        Point size = new Point();
        display.getSize(size);
        // 宽度为当前屏幕的80%
        params.width = (int)(size.x * 0.8);
        getWindow().setAttributes(params);

        if (!TextUtils.isEmpty(title))
            mTvTitle.setText(title);
        if (!TextUtils.isEmpty(cancel))
            mTvcancel.setText(cancel);
        if (!TextUtils.isEmpty(confirm))
            mTvConfirm.setText(confirm);
        mTvcancel.setOnClickListener(this);
        mTvConfirm.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_cancel:
                if (cancelListener != null)
                    cancelListener.onCancel(this);
                dismiss();
                break;
            case R.id.tv_confirm:
                if (confirmListener != null)
                    confirmListener.onConfirm(this);
                dismiss();
                break;
        }
    }


    public interface IonCancelListener {
        void onCancel(CustomDialog dialog);
    }

    public interface IonConfirmListener {
        void onConfirm(CustomDialog dialog);
    }
}
