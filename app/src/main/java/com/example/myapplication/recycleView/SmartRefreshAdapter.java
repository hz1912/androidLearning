package com.example.myapplication.recycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.R;

import java.util.List;

public class SmartRefreshAdapter extends RecyclerView.Adapter<SmartRefreshAdapter.MyViewHolder> {

    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public SmartRefreshAdapter(Context mContext, List<String> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public SmartRefreshAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(inflater.inflate(R.layout.smart_refresh_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SmartRefreshAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(mDatas.get(position));
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.smart_1);
        }
    }
}


