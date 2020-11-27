package com.example.mysoftware.controller.pager.menudatailpager;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.mysoftware.R;
import com.example.mysoftware.controller.pager.MenuDetaiBasePager;

public class VoteMenuDetailPage extends MenuDetaiBasePager {
    private TextView textView;

    public VoteMenuDetailPage(Context context) {
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
        textView.setText("投票详情页面内容");
    }
}