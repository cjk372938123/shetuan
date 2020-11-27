package com.example.mysoftware.controller.activity;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mysoftware.R;
import com.example.mysoftware.controller.adapter.FindAdapter;
import com.example.mysoftware.controller.fragment.VideoFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FindActivity extends Activity {
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "热门", "iOS", "Android"
            , "前端", "后端", "设计", "工具资源"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        ViewPager viewPager;
        SlidingTabLayout slidingTabLayout;
        viewPager = findViewById(R.id.fixedViewPager);
        slidingTabLayout = findViewById(R.id.slidingTabLayout);
        for (String title : mTitles) {
            mFragments.add(VideoFragment.newInstance(title));
        }
//       viewPager.setAdapter(new FindAdapter(mTitles, mFragments));
//        slidingTabLayout.setViewPager(viewPager);
    }
}