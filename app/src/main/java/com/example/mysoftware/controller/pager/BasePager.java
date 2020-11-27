package com.example.mysoftware.controller.pager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mysoftware.R;
import com.example.mysoftware.controller.activity.NewsActivity;
import com.example.mysoftware.controller.fragment.BaseFragment;

public class BasePager {

    public final Context context;

    /**
     * 视图，代表各个不同的页面
     */
    public View rootView;
    /**
     * 显示标题
     */
    public TextView mtv_title;

    /**
     * 点击侧滑的
     */
    public ImageButton ib_menu;

    /**
     * 加载各个子页面
     */
    public FrameLayout fl_content;

    public ImageButton ib_swich_list_grid;

    public Button btn_cart;

    public BasePager(Context context) {
        this.context = context;
        //构造方法一执行，视图就被初始化了
        rootView = initView();
    }

    /**
     * 用于初始化公共部分视图，并且初始化加载子视图的FrameLayout
     * @return
     */
    private View initView() {
        //基类的页面
        View view = View.inflate(context, R.layout.base_pager,null);
        mtv_title = (TextView) view.findViewById(R.id.mtv_title);
        ib_menu = (ImageButton) view.findViewById(R.id.ib_menu);
        fl_content = (FrameLayout) view.findViewById(R.id.fl_content);
        ib_swich_list_grid = (ImageButton) view.findViewById(R.id.ib_swich_list_grid);
        btn_cart = (Button) view.findViewById(R.id.btn_cart);
        ib_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsActivity newsActivity = (NewsActivity) context;
                newsActivity.getSlidingMenu().toggle();//关<->开
            }
        });
        return view;
    }

    /**
     * 初始化数据;当孩子需要初始化数据;或者绑定数据;联网请求数据并且绑定的时候，重写该方法
     */
    public void initData(){

    }
}
