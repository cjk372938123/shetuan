package com.example.mysoftware.controller.fragment;

import android.content.Entity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.mysoftware.R;
import com.example.mysoftware.controller.activity.NewsActivity;
import com.example.mysoftware.controller.adapter.NewsAdapter;
import com.example.mysoftware.controller.adapter.VideoAdapter;
import com.example.mysoftware.controller.entity.NewsEntity;
import com.example.mysoftware.controller.entity.VideoEntity;
import com.scwang.smart.refresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private RefreshLayout refreshLayout;
    private LinearLayoutManager linearLayoutManager;
    private NewsAdapter newsAdapter;
    private List<NewsEntity> datas = new ArrayList<>();
    private int pageNum = 1;
    private TextView btn_news;

    public NewsFragment() {
    }

    public static NewsFragment newInstance() {
        NewsFragment fragment = new NewsFragment();
        return fragment;
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView() {
        recyclerView = mRootView.findViewById(R.id.recyclerView);
        refreshLayout = mRootView.findViewById(R.id.refreshLayout);
        btn_news = mRootView.findViewById(R.id.btn_news);
    }

    @Override
    protected void initData() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        newsAdapter = new NewsAdapter(getActivity());
        for (int i = 0; i < 6; i++) {
            NewsEntity newsEntity = new NewsEntity();
            newsEntity.setType(i);
            datas.add(newsEntity);
        }
        newsAdapter.setDatas(datas);
        recyclerView.setAdapter(newsAdapter);

        btn_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, NewsActivity.class);
                startActivity(intent);
             }
        });
    }
}