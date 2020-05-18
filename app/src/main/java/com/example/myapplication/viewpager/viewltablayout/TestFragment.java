package com.example.myapplication.viewpager.viewltablayout;


import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public final class TestFragment extends Fragment {

    private String s;

    public TestFragment(String s) {
        this.s = s;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        TextView te = view.findViewById(R.id.textView1);
        te.setText(s);
    }


}
