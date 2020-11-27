package com.example.mysoftware.controller.fragment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.mysoftware.R;
import com.example.mysoftware.controller.activity.EditMainActivity;
import com.example.mysoftware.controller.activity.helpActivity;
import com.example.mysoftware.controller.adapter.HomeFragmentAdapter;
import com.example.mysoftware.controller.bean.ResultBeanData;
import com.example.mysoftware.utils.myConstants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class HomeFragment extends Base_Fragment {
    private static final String TAG =
            HomeFragment.class.getSimpleName();
    private RecyclerView rvHome;
    private ImageView ib_top;
    private TextView tv_search_home;
    private TextView tv_message_home;
    private ResultBeanData.ResultBean resultBean;
    private HomeFragmentAdapter adapter;
    private TextView tv_message_help;
    @Override
    public View initView() {
        Log.e(TAG, " 主页视图被初始化了");
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        rvHome = (RecyclerView) view.findViewById(R.id.rv_home);
        ib_top = (ImageView) view.findViewById(R.id.ib_top);
        tv_search_home = (TextView)view.findViewById(R.id.tv_search_home);
        tv_message_home = (TextView) view.findViewById(R.id.tv_message_home);
        tv_message_help = view.findViewById(R.id.tv_message_help);
        // 设置点击事件
        initListener();
        initData();
        return view;
    }

    private void initListener() {
// 置顶的监听
        ib_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// 回到顶部
                rvHome.scrollToPosition(0);
            }
        });
        tv_message_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, helpActivity.class);
                startActivity(intent);
            }
        });

// 消息的监听
        tv_message_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, EditMainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
        Log.e(TAG, "主页数据被初始化");
        //***********************
        adapter = new HomeFragmentAdapter(mContext);
        rvHome.setAdapter(adapter);

        rvHome.setLayoutManager(new GridLayoutManager(mContext, 1));



        getDataFromNet();
    }
    private void getDataFromNet()
    {
        String url = myConstants.URL;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback()
                {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG, "请求Error:" + e.getMessage());
                    }
                    //联网成功的时候回调

                    /**
                     *
                     * @param response 请求成功的数据
                     * @param id
                     */
                    @Override
                    public void onResponse(String response, int id) {
                        Log.e(TAG, "请求Response" + response);
                        processData(response);
                    }
                });
    }

    private void processData(String json) {
        ResultBeanData resultBeanData = JSON.parseObject(json, ResultBeanData.class);
        Log.e(TAG, "解析成功"+resultBean.getHot_info().get(0).getName());
    }
}


