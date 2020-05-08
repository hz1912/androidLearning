package com.example.myapplication.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class AFragment extends Fragment {

    private TextView mTextView;

    private Activity activity;

    private Button mBtnChange;

    private Button mBtnReset;

    private Fragment bFragment;


    private Button mBtnMessage;






    public static AFragment newInstance(String title) {
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        Log.d("AFragment","-------onCreateView----------");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = view.findViewById(R.id.tv_title);
        mBtnChange = view.findViewById(R.id.btn_change);
        mBtnReset =view.findViewById(R.id.btn_rest);
//       给activity 传递消息
        mBtnMessage = view.findViewById(R.id.btn_message);
        if(getArguments()!=null){
            mTextView.setText(getArguments().getString("title"));
        }
        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment ==null){
                    bFragment = new BFragment();
                }
              Fragment fragment =getFragmentManager().findFragmentByTag("a");
                if(fragment!=null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.fl_container,bFragment).addToBackStack(null).commitAllowingStateLoss();
                }else{
                    getFragmentManager().beginTransaction().replace(R.id.fl_container, bFragment)//
                            .addToBackStack(null)// 添加到回退栈
                            .commitAllowingStateLoss();
                }
            }
        });
        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("我是新文字");

            }
        });

        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ContainerActivity)getActivity()).setData("贺壮壮");
            }
        });


    }


    //    重新与activity保持关系的时候会调用这个方法
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

    //    Fragment 回收掉的时候调用这个方法;
    @Override
    public void onDestroy() {
        super.onDestroy();
//        取消异步
    }
}
