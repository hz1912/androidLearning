package com.example.myapplication.loadpaging;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LoadingPage extends FrameLayout {

    private static final int PAGE_LOADING_STATE = 1;

    private static final int PAGE_ERROR_STATE = 2;

    private static final int PAGE_EMPTY_STATE = 3;

    private static final int PAGE_SUCCESS_STATE = 4;

    private int PAGE_CURRENT_STATE = 1;

    private View loadingView;

    private View errorView;

    private View emptyView;

    private View successView;

    private LayoutParams lp;



    public LoadingPage(@NonNull Context context) {
        this(context, null);
    }

    public LoadingPage(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, null, 0);
    }

    public LoadingPage(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
