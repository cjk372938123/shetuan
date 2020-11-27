package com.example.mysoftware.controller.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysoftware.R;
import com.example.mysoftware.controller.activity.community.practice.practiceMainActivity;

public class ChannelAdapter extends BaseAdapter {
    private final Context mContext;
    private Integer[] mImageIds = {R.mipmap.channelimg1,R.mipmap.channelimg2,R.mipmap.channelimg3,
                R.mipmap.channelimg4,R.mipmap.channelimg5,R.mipmap.channelimg6};
    private String[] mTitles = {"科技类","文艺类", "体育类",
                "学术类", "服务类", "其他"};

    public ChannelAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { View view = null;
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = View.inflate(mContext,R.layout.item_channel,null);
            viewHolder = new ViewHolder();
            viewHolder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_channel);
            viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_channel);
            convertView.setTag(viewHolder);
            viewHolder.iv_icon.setBackgroundResource(mImageIds[position]);
            viewHolder.tv_title.setText(mTitles[position]);
            viewHolder.tv_title.setTextColor(Color.BLACK);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
        }
    static class ViewHolder {
        ImageView iv_icon;
        TextView tv_title;
    }
    }


