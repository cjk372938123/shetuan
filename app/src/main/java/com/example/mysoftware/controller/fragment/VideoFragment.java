package com.example.mysoftware.controller.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.request.transition.Transition;
import com.example.mysoftware.R;
import com.example.mysoftware.controller.adapter.FindAdapter;
import com.example.mysoftware.controller.adapter.VideoAdapter;
import com.example.mysoftware.controller.api.Api;
import com.example.mysoftware.controller.api.ApiConfig;
import com.example.mysoftware.controller.api.TtitCallback;
import com.example.mysoftware.controller.entity.VideoEntity;
import com.example.mysoftware.controller.entity.VideoListResponse;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.gson.Gson;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class VideoFragment extends Fragment {
    private String title;
    List<VideoEntity> datas = new ArrayList<>();
    RecyclerView recyclerView;
    VideoAdapter videoAdapter;
    private RefreshLayout refreshLayout;
    private int pageNum = 1;
    private int categoryId;
//    private Handler mHandler = new Handler() {
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what) {
//                case 0:
//                    videoAdapter.setDatas(datas);
//                    videoAdapter.notifyDataSetChanged();
//                    break;
//            }
//        }
//    };

    public VideoFragment()
    {
            
    }
    public static VideoFragment newInstance(String title)
    {
        VideoFragment fragment = new VideoFragment();
        fragment.title = title;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_video, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        //getActivity():FindActivity 即为获取父组件的对象
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        refreshLayout = v.findViewById(R.id.refreshLayout);
        for (int i = 0; i < 8; i++) {
            VideoEntity ve = new VideoEntity();
//            ve.setTitle("123");
//            ve.setName("123");
//            ve.setDzCount(i*2);
//            ve.setCollectCount(i*4);
//            ve.setCommentCount(i*6);
            ve.setTitle("123");
            ve.setName("abc");
            ve.setCommentCount(i);
            ve.setCollectCount(i);
            datas.add(ve);
        }
        VideoAdapter videoAdapter = new VideoAdapter(getActivity(), datas);
        recyclerView.setAdapter(videoAdapter);
        return v;
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        videoAdapter = new VideoAdapter(getActivity());
//        recyclerView.setAdapter(videoAdapter);
//        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
//            @Override
//            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
//                //refreshLayout.finishRefresh(2000);//传入false表示刷新失败
//                pageNum = 1;
//                getVideoList(true);
//            }
//        });
//        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
//            @Override
//            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
//                refreshLayout.finishLoadMore(2000);//传入false表示加载失败
//                pageNum++;
//                getVideoList(false);
//            }
//        });
//        getVideoList(true);
//    }
//    private void getVideoList(final boolean isRefresh) {
//        HashMap<String, Object> params = new HashMap<>();
//        params.put("page", pageNum);
//        params.put("limit", ApiConfig.PAGE_SIZE);//每页有多少条
//        params.put("categoryId", categoryId);
//        Api.config(ApiConfig.VIDEO_LIST_BY_CATEGORY, params).getRequest(getActivity(), new TtitCallback() {
//            @Override
//            public void onSuccess(final String res) {
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (isRefresh) {
//                            refreshLayout.finishRefresh(true);
//                        } else {
//                            refreshLayout.finishLoadMore(true);
//                        }
//                        VideoListResponse response = new Gson().fromJson(res, VideoListResponse.class);
//                        if (response != null && response.getCode() == 0) {
//                            List<VideoEntity> list = response.getPage().getList();
//                            if (list != null && list.size() > 0) {
//                                if (isRefresh) {
//                                    datas = list;
//                                } else {
//                                    datas.addAll(list);
//                                }
//                                videoAdapter.setDatas(datas);
//                                videoAdapter.notifyDataSetChanged();
//                            } else {
//                                if (isRefresh) {
//                                    //showToastSyn("暂时无数据");
//                                    Toast.makeText(getActivity(), "暂时无数据", Toast.LENGTH_SHORT).show();
//
//                                } else {
//                                    //showToastSync("没有更多数据");
//                                    Toast.makeText(getActivity(), "没有更多数据", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        }
//                    }
//                });
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//                if (isRefresh) {
//                    refreshLayout.finishRefresh(true);
//                } else {
//                    refreshLayout.finishLoadMore(true);
//                }
//            }
//        });
//    }
}