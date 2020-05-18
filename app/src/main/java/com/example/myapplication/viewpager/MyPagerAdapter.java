package com.example.myapplication.viewpager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

;import com.example.myapplication.R;

import java.util.List;

public class MyPagerAdapter extends PagerAdapter {
    private List<Integer> list;

    public MyPagerAdapter(List<Integer> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View item = LayoutInflater.from(container.getContext()).inflate(R.layout.view_pager, container, false);
        ImageView imageView = item.findViewById(R.id.cover);
        int pre = position % list.size();
        imageView.setImageResource(list.get(pre));
        if (imageView.getParent() instanceof ViewGroup) {
            ((ViewGroup) imageView.getParent()).removeView(imageView);
        }
        container.addView(imageView);
        return imageView;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
