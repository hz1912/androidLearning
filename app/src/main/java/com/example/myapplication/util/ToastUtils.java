package com.example.myapplication.util;

import android.content.Context;
import android.widget.Toast;

import java.util.Objects;

public class ToastUtils {


    public static Toast mToast;

    public static  void showMsg(Context context, String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(context, msg, Toast.LENGTH_LONG);

        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }
}
