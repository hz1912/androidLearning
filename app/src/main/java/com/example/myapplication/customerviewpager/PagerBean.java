package com.example.myapplication.customerviewpager;

public class PagerBean {
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    int resId;

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public PagerBean(String title, int resId) {
        this.title = title;
        this.resId = resId;
    }
}
