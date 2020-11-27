package com.example.mysoftware.controller.activity;

import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.VideoView;


import com.example.mysoftware.R;
import com.example.mysoftware.controller.adapter.MyCollectAdapter;
import com.example.mysoftware.controller.entity.VideoEntity;
import com.example.mysoftware.controller.listener.OnItemChildClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: wei
 * @date: 2020-10-05
 **/
public class MyCollectActivity extends BaseActivity implements OnItemChildClickListener {
    private RecyclerView recyclerView;
    private MyCollectAdapter videoAdapter;
    private LinearLayoutManager linearLayoutManager;
    private List<VideoEntity> datas = new ArrayList<>();
    protected VideoView mVideoView;
//    protected StandardVideoController mController;
//    protected ErrorView mErrorView;
//    protected CompleteView mCompleteView;
//    protected TitleView mTitleView;
    /**
     * 当前播放的位置
     */
    protected int mCurPos = -1;
    /**
     * 上次播放的位置，用于页面切回来之后恢复播放
     */
    protected int mLastPos = mCurPos;


    @Override
    protected int initLayout() {
        return R.layout.activity_mycollect;
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    protected void initData() {
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        videoAdapter = new MyCollectAdapter(this);
        videoAdapter.setOnItemChildClickListener(this);
        recyclerView.setAdapter(videoAdapter);
    }


    @Override
    public void onItemChildClick(int position) {

    }
}
