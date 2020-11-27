package com.example.mysoftware.controller.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mysoftware.R;

public class RecommendGridViewAdapter extends BaseAdapter {
    private final Context mContext;
    private Integer[] mImageIds = {R.mipmap.recommend1,R.mipmap.recommend2,R.mipmap.recommend3,
            R.mipmap.recommend4,R.mipmap.recommend5,R.mipmap.recommend6,R.mipmap.recommend7,R.mipmap.recommend8,R.mipmap.recommend9,
            R.mipmap.recommend10,R.mipmap.recommend11,R.mipmap.recommend12};

    public RecommendGridViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 12;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.item_recommend_grid_view,null);
            viewHolder = new ViewHolder();
            viewHolder.iv_recommend = (ImageView) convertView.findViewById(R.id.iv_recommend);
            convertView.setTag(viewHolder);
            viewHolder.iv_recommend.setBackgroundResource(mImageIds[position]);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //根据位置得到对应的数据
        //viewHolder.tv_name.setText();

        return convertView;
    }

    static class ViewHolder{
        ImageView iv_recommend;
        TextView tv_name;
    }
}
