package com.example.mysoftware.controller.pager.menudatailpager;


import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mysoftware.controller.pager.MenuDetaiBasePager;

public class PhotosMenuDetailPager extends MenuDetaiBasePager {
    private TextView textView;
    public PhotosMenuDetailPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        return textView;
    }
    @Override
    public void initData() {
        super.initData();
        textView.setText("图组详情页面内容");
    }



}
