package com.example.mysoftware.controller.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.example.mysoftware.R;
import com.example.mysoftware.controller.activity.NewsActivity;
import com.example.mysoftware.controller.domain.NewsCenterPagerBean;
import com.example.mysoftware.controller.domain.NewsCenterPagerBean2;
import com.example.mysoftware.controller.pager.NewsCenterPager;
import com.example.mysoftware.utils.LogUtil;
import com.hyphenate.util.DensityUtil;

import java.util.List;


public class LeftmenuFragment extends myBaseFragment {

    //private List<NewsCenterPagerBean.DataEntity> data;
    private List<NewsCenterPagerBean2.DetailPagerData> data;
    private LeftmenuFragmentAdapter adapter;
    private ListView listView;
    /**
     * 点击的位置
     */
    private int prePosition;


    @Override
    public View initView() {

        listView = new ListView(context);

        listView.setPadding(0, DensityUtil.dip2px(context, 36), 0, 0);

        listView.setDividerHeight(0);

        listView.setCacheColorHint(Color.TRANSPARENT);

        listView.setSelector(android.R.color.transparent);

        //设置item的点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //1.记录点击的位置，变成红色
                prePosition = position;
                adapter.notifyDataSetChanged();//getCount()-->getView

                //2.把左侧菜单关闭
                NewsActivity mainActivity = (NewsActivity) context;
                mainActivity.getSlidingMenu().toggle();//关<->开

                //3.切换到对应的详情页面：新闻详情页面，专题详情页面，图组详情页面，互动详情页面
                swichPager(prePosition);

            }
        });

        return listView;
    }
    /**
     * 根据位置切换不同详情页面
     * @param position
     */
    private void swichPager(int position) {
        NewsActivity newsActivity = (NewsActivity) context;
        NewsContentFragment contentFragment = newsActivity.getContentFragment();
        NewsCenterPager newsCenterPager = contentFragment.getNewsCenterPager();
        newsCenterPager.swichPager(position);
    }
    /**
     * 接收数据
     * @param data
     */
    public void setData(List<NewsCenterPagerBean2.DetailPagerData> data) {
        this.data = data;
        for(int i=0;i<data.size();i++){
            LogUtil.e("title=="+data.get(i).getTitle());
        }

        //设置适配器
        adapter   = new LeftmenuFragmentAdapter();
        listView.setAdapter(adapter);

        //设置默认页面
        swichPager(prePosition);

    }
    @Override
    public void initData() {
        super.initData();

    }
    class LeftmenuFragmentAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = (TextView) View.inflate(context, R.layout.item_leftmenu,null);
            textView.setText(data.get(position).getTitle());
//            if(position==prePosition){
//                //设置红色
//                textView.setEnabled(true);
//
//            }else{
//                textView.setEnabled(false);
//            }

            textView.setEnabled(position==prePosition);
            return textView;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


    }
}
