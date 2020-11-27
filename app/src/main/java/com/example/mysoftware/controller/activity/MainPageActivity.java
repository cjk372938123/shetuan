package com.example.mysoftware.controller.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mysoftware.R;
import com.example.mysoftware.controller.adapter.MainPageFragmentAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainPageActivity extends AppCompatActivity {
    private ViewPager mLoopPager;
    private MainPageFragmentAdapter mMainPageFragmentAdapter;
    private static List<Integer> sPics = new ArrayList<>();
    private Handler handler;
//    static {
//        sPics.add(R.drawable.home);
//        sPics.add(R.drawable.welcome);
//        sPics.add(R.drawable._home);
//    }



//    @Override
//    public void onAttachedToWindow() {
//        super.onAttachedToWindow();
//    }
//    Runnable mLooperTask = new Runnable() {
//        @Override
//        public void run() {
//            int  currentItem = mLoopPager.getCurrentItem();
//            mLoopPager.setCurrentItem(++currentItem, false);
//            handler.postDelayed(this, 1000);
//        }
//    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
      // initView();

//        Random random = new Random();
//        for (int i = 0; i < 6; i++) {
//            sPics.add(Color.argb(random.nextInt(255), random.nextInt(255), random.nextInt(255), random.nextInt(255)));
//        }
//        mMainPageFragmentAdapter.setData(sPics);
//        mMainPageFragmentAdapter.notifyDataSetChanged();
    }

    private void initView() {

//        mLoopPager = this.findViewById(R.id.looper_pager);
//        mMainPageFragmentAdapter = new MainPageFragmentAdapter();
//        mLoopPager.setAdapter(mMainPageFragmentAdapter);
//        mLoopPager.setCurrentItem(100);
    }

}
