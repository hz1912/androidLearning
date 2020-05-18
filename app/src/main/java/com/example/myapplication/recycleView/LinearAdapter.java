package com.example.myapplication.recycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    private Context mContext;

    public OnItemClickListener listener;


    public LinearAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View View = layoutInflater.inflate(R.layout.layout_linear_item, parent, false);
        return new LinearViewHolder(View);
    }

    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.LinearViewHolder holder, final int position) {
        ImageView imageView = holder.imageView;
        holder.textView.setText("死亡病例成欧洲第一 探访疫情高峰下的英国重症监护室");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return 30;
    }


    class LinearViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
            imageView = itemView.findViewById(R.id.imag_1);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }
}
