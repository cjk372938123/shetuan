package com.example.mysoftware.controller.pager.menudatailpager;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.mysoftware.R;
import com.example.mysoftware.controller.activity.NewsActivity;
import com.example.mysoftware.controller.domain.NewsCenterPagerBean;
import com.example.mysoftware.controller.domain.NewsCenterPagerBean2;
import com.example.mysoftware.controller.pager.MenuDetaiBasePager;
import com.example.mysoftware.controller.pager.menudatailpager.tabdetailpager.TabDetailPager;
import com.example.mysoftware.controller.pager.menudatailpager.tabdetailpager.TopicDetailPager;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.viewpagerindicator.TabPageIndicator;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


public class TopicMenuDetailPager extends MenuDetaiBasePager {


    @ViewInject(R.id.tabPageIndicator)
    private TabPageIndicator tabPageIndicator;


    @ViewInject(R.id.viewpager)
    private ViewPager viewPager;


    @ViewInject(R.id.ib_tab_next)
    private ImageButton ib_tab_next;

    private List<NewsCenterPagerBean2.DetailPagerData.ChildrenData> children;

    /**
     * 页签页面的集合-页面
     */
    private ArrayList<TopicDetailPager> tabDetailPagers;


    public TopicMenuDetailPager(Context context) {
        super(context);
    }

    public TopicMenuDetailPager(Context context, NewsCenterPagerBean2.DetailPagerData detailPagerData) {
        super(context);
        children = detailPagerData.getChildren();
    }


    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.newsmenu_detail_pager, null);
        x.view().inject(TopicMenuDetailPager.this, view);
        ib_tab_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            }
        });

        return view;
    }
    @Override
    public void initData() {
        super.initData();

        //准备新闻详情页面的数据
        tabDetailPagers = new ArrayList<>();
        for(int i=0;i<children.size();i++){
            tabDetailPagers.add(new TopicDetailPager(context,children.get(i)));
        }

        viewPager.setAdapter(new MyNewsMenuDetailPagerAdapter());

        tabPageIndicator.setViewPager(viewPager);

        tabPageIndicator.setOnPageChangeListener(new MyOnPageChangeListener());

    }
    private int tempPositon = 0 ;

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if(position==0){
                //SlidingMenu可以全屏滑动
                isEnableSlidingMenu(SlidingMenu.TOUCHMODE_FULLSCREEN);
            }else{
                //SlidingMenu不可以滑动
                isEnableSlidingMenu(SlidingMenu.TOUCHMODE_NONE);
            }
            tempPositon = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    /**
     根据传人的参数设置是否让SlidingMenu可以滑动
     */
    private void isEnableSlidingMenu(int touchmodeFullscreen) {
        NewsActivity newsActivity = (NewsActivity) context;
        newsActivity.getSlidingMenu().setTouchModeAbove(touchmodeFullscreen);
    }
    class MyNewsMenuDetailPagerAdapter extends PagerAdapter {

        @Override
        public CharSequence getPageTitle(int position) {
            return children.get(position).getTitle();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TopicDetailPager tabDetailPager  =tabDetailPagers.get(position);
            View rootView = tabDetailPager.rootView;
            tabDetailPager.initData();//初始化数据
            container.addView(rootView);
            return rootView;
        }

        @Override
        public int getCount() {
            return tabDetailPagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
}
