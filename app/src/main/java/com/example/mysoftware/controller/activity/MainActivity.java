package com.example.mysoftware.controller.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.mysoftware.R;
import com.example.mysoftware.controller.entity.TabEntity;
import com.example.mysoftware.controller.fragment.ChatFragment;
import com.example.mysoftware.controller.fragment.ContactListFragment;
import com.example.mysoftware.controller.fragment.FindFragment;
import com.example.mysoftware.controller.fragment.HomeFragment;
import com.example.mysoftware.controller.fragment.MainPageFragment;
import com.example.mysoftware.controller.fragment.NewsFragment;
import com.example.mysoftware.controller.fragment.SettingFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.example.mysoftware.controller.adapter.*;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.hyphenate.util.DensityUtil;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private RadioGroup rg_main;
    private ChatFragment chatFragment;
    private ContactListFragment contactListFragment;
    private SettingFragment settingFragment;

//    //***************************************
    private String[] mTitles = {"首页", "消息", "联系人", "发现", "其他"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect,R.mipmap.collect_unselect,
            R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.collect_selected,
            R.mipmap.tab_more_select};
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ViewPager viewPager;
    private CommonTabLayout commonTabLayout;
//    //****************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        //initData();

        //initListener();
    }

    private void initListener() {
//        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                Fragment fragment = null;
//
//                switch (checkedId)
//                {
//                    case R.id.rb_main_chat:
//                        fragment = chatFragment;
//                        break;
//                    case R.id.rb_main_contact:
//                        fragment = contactListFragment;
//                        break;
//                    case R.id.rb_main_setting:
//                        fragment = settingFragment;
//                        break;
//                }
//                switchFragment(fragment);
//            }
//        });
//        //默认选择一个页面
//        rg_main.check(R.id.rb_main_contact);
    }

    private void switchFragment(Fragment fragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        //最后要提交
//        fragmentManager.beginTransaction().replace(R.id.fl_main, fragment).commit();
    }

    private void initData() {
//        chatFragment = new ChatFragment();
//        contactListFragment = new ContactListFragment();
//        settingFragment = new SettingFragment();
    }

    private void initView() {
        //rg_main = findViewById(R.id.rg_main);

//        //**********************
        viewPager = findViewById(R.id.viewPager);
        commonTabLayout = findViewById(R.id.commonTabLayout);
        mFragments.add(new HomeFragment());
        mFragments.add(new ChatFragment());
        mFragments.add(new ContactListFragment());
        mFragments.add(new NewsFragment());
        mFragments.add(new SettingFragment());
        for(int i = 0;i < mTitles.length;i++)
        {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        commonTabLayout.setTabData(mTabEntities);
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
                }
        });
        viewPager.setOffscreenPageLimit(mFragments.size());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                commonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mTitles, mFragments));
//        //**********************
    }
}