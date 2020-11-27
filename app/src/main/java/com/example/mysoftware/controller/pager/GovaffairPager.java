package com.example.mysoftware.controller.pager;


import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.example.mysoftware.utils.LogUtil;

public class GovaffairPager extends BasePager {

    public GovaffairPager(Context context) {
        super(context);
    }
    @Override
    public void initData() {
        super.initData();
        LogUtil.e("主页面数据被初始化了..");
        //1.设置标题
        mtv_title.setText("购物车");
        //2.联网请求，得到数据，创建视图
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        //3.把子视图添加到BasePager的FrameLayout中
        fl_content.addView(textView);
        //4.绑定数据
        textView.setText("购物车页面内容");

    }
}
