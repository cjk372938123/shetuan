package com.example.mysoftware.controller.pager.menudatailpager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.example.mysoftware.controller.pager.MenuDetaiBasePager;
import com.google.gson.Gson;



public class InteracMenuDetailPager extends MenuDetaiBasePager {
    private TextView textView;

    public InteracMenuDetailPager(Context context) {
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
        textView.setText("主题详情页面内容");
    }
}
