package com.example.mysoftware.controller.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mysoftware.R;
import com.example.mysoftware.controller.activity.MapActivity;
import com.example.mysoftware.controller.activity.community.practice.chuangKeActivity;
import com.example.mysoftware.controller.activity.community.practice.electronicHobbyistActivity;
import com.example.mysoftware.controller.activity.community.practice.electronicIdeaActivity;
import com.example.mysoftware.controller.activity.community.practice.electronicPkActivity;
import com.example.mysoftware.controller.activity.community.practice.huaXueActivity;
import com.example.mysoftware.controller.activity.community.practice.mathModelActivity;
import com.example.mysoftware.controller.activity.community.practice.robotActivity;
import com.example.mysoftware.controller.activity.community.practice.shengWuActivity;
import com.example.mysoftware.controller.activity.community.practice.weiBoActivity;
import com.example.mysoftware.controller.activity.community.practice.wuLiActivity;
import com.example.mysoftware.controller.entity.practiceMainEntity;

import java.util.List;

//public class practiceMainAdapter extends RecyclerView.Adapter<practiceMainAdapter.InnerHolder> {
//
//    private TextView mTitle;
//    private ImageView mIcon;
//    private Context mContext;
//    private final List<ItemBean> mData;
//
//    public practiceMainAdapter(List<ItemBean> data) {
//        mData = data;
//    }
//
//    public practiceMainAdapter(Context context, List<ItemBean> data) {
//        mContext = context;
//        mData = data;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        int type = mData.get(position).getType();
//        return type;
//    }
//
//    @Override
//    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        View view = View.inflate(viewGroup.getContext(), R.layout.item1,null);
////        return new InnerHolder(view);
//        if (viewType == 1) {
//            View view = LayoutInflater.from(mContext).inflate(R.layout.item1, parent, false);
//            return new practiceMainAdapter.ViewHolderOne(view);
//        } else if (viewType == 2) {
//            View view = LayoutInflater.from(mContext).inflate(R.layout.item2, parent, false);
//            return new practiceMainAdapter.ViewHolderTwo(view);
//        } else {
//            View view = LayoutInflater.from(mContext).inflate(R.layout.news_item_three, parent, false);
//            return new practiceMainAdapter.ViewHolderThree(view);
//        }
//    }
//
//
//
//
//    @Override
//    public void onBindViewHolder(@NonNull InnerHolder holder, int position, @NonNull List<Object> payloads) {
//        int type = getItemViewType(position);
//        ItemBean itemBean = mData.get(position);
//        if (type == 1) {
//            practiceMainAdapter.ViewHolderOne vh =  holder;
//            NewsAdapter.ViewHolderOne vh = (NewsAdapter.ViewHolderOne) holder;
//        } else if (type == 2) {
//            NewsAdapter.ViewHolderTwo vh = (NewsAdapter.ViewHolderTwo) holder;
//        } else {
//            NewsAdapter.ViewHolderThree vh = (NewsAdapter.ViewHolderThree) holder;
//        }
//    }
//
//
//    @Override
//    public int getItemCount() {
//        if(mData != null)
//        {
//            return mData.size();
//        }
//        return 0;
//    }
//    public class ViewHolderOne extends RecyclerView.ViewHolder
//    {
//        public ViewHolderOne(@NonNull View itemView) {
//            super(itemView);
//        }
//    }
//    public class ViewHolderTwo extends RecyclerView.ViewHolder
//    {
//        public ViewHolderTwo(@NonNull View itemView) {
//            super(itemView);
//        }
//    }
//    public class ViewHolderThree extends RecyclerView.ViewHolder
//    {
//        public ViewHolderThree(@NonNull View itemView) {
//            super(itemView);
//        }
//    }
//    public class InnerHolder extends RecyclerView.ViewHolder {
//        public InnerHolder(@NonNull View itemView) {
//            super(itemView);
//            //找到条目事件
//            mTitle = itemView.findViewById(R.id.item1_title);
//            mIcon = itemView.findViewById(R.id.item1_img);
//
//        }
//        //这个方法用于放置数据
//        public void setData(ItemBean itemBean)
//        {
//            mIcon.setImageResource(itemBean.icon);
//            mTitle.setText(itemBean.title);
//        }
//    }
//}
public class practiceMainAdapter extends RecyclerView.Adapter<ViewHolder>
{
    private Context mContext;
    private List<practiceMainEntity> datas;
    private LinearLayout linearLayout;

    public practiceMainAdapter(Context context, List<practiceMainEntity> datas) {
        mContext = context;
        this.datas = datas;
    }

    public practiceMainAdapter(List<practiceMainEntity> datas) {
        this.datas = datas;
    }

    public practiceMainAdapter(Context context) {
        mContext = context;
    }
    public void setDatas(List<practiceMainEntity> datas)
    {
        this.datas = datas;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item1, parent, false);
            linearLayout = view.findViewById(R.id.elepre);
            return new practiceMainAdapter.ViewHolderOne(view);
        } else if (viewType == 2) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item2, parent, false);
            linearLayout = view.findViewById(R.id.elepk);
            return new practiceMainAdapter.ViewHolderTwo(view);
        } else if(viewType == 3){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item3, parent, false);
            linearLayout = view.findViewById(R.id.eleidea);
            return new practiceMainAdapter.ViewHolderThree(view);
        }
        else if(viewType == 4){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item4, parent, false);
            linearLayout = view.findViewById(R.id.mathmodel);
            return new practiceMainAdapter.ViewHolderFour(view);
        }
        else if(viewType == 5){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item5, parent, false);
            linearLayout = view.findViewById(R.id.robot);
            return new practiceMainAdapter.ViewHolderFive(view);
        }
        else if(viewType == 6){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item6, parent, false);
            linearLayout = view.findViewById(R.id.weibo);
            return new practiceMainAdapter.ViewHolderSix(view);
        }
        else if(viewType == 7){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item7, parent, false);
            linearLayout = view.findViewById(R.id.huaxue);
            return new practiceMainAdapter.ViewHolderSeven(view);
        }
        else if(viewType == 8){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item8, parent, false);
            linearLayout = view.findViewById(R.id.wuli);
            return new practiceMainAdapter.ViewHolderEight(view);
        }
        else if(viewType == 9){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item9, parent, false);
            linearLayout = view.findViewById(R.id.chuangke);
            return new practiceMainAdapter.ViewHolderNine(view);
        }
        else{
            View view = LayoutInflater.from(mContext).inflate(R.layout.item10, parent, false);
            linearLayout = view.findViewById(R.id.shengwu);
            return new practiceMainAdapter.ViewHolderTen(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int type = getItemViewType(position);
        practiceMainEntity practiceMainEntity = datas.get(position);
        if (type == 1) {
            practiceMainAdapter.ViewHolderOne vh = (practiceMainAdapter.ViewHolderOne) holder;
        } else if (type == 2) {
            practiceMainAdapter.ViewHolderTwo vh = (practiceMainAdapter.ViewHolderTwo) holder;
        } else if(type == 3){
            practiceMainAdapter.ViewHolderThree vh = (practiceMainAdapter.ViewHolderThree) holder;
        }
        else if(type == 4){
            practiceMainAdapter.ViewHolderFour vh = (practiceMainAdapter.ViewHolderFour) holder;
        }
        else if(type == 5){
            practiceMainAdapter.ViewHolderFive vh = (practiceMainAdapter.ViewHolderFive) holder;
        }
        else if(type == 6){
            practiceMainAdapter.ViewHolderSix vh = (practiceMainAdapter.ViewHolderSix) holder;
        }
        else if(type == 7){
            practiceMainAdapter.ViewHolderSeven vh = (practiceMainAdapter.ViewHolderSeven) holder;
        }
        else if(type == 8){
            practiceMainAdapter.ViewHolderEight vh = (practiceMainAdapter.ViewHolderEight) holder;
        }
        else if(type == 9){
            practiceMainAdapter.ViewHolderNine vh = (practiceMainAdapter.ViewHolderNine) holder;
        }
        else{
            practiceMainAdapter.ViewHolderTen vh = (practiceMainAdapter.ViewHolderTen) holder;
        }
    }

    @Override
    public int getItemViewType(int position) {
        int type = datas.get(position).getType();
        return type;
    }
    @Override
    public int getItemCount() {
        if(datas != null && datas.size() > 0)
        {
            return datas.size();
        }else {
            return 0;
        }
    }
    public class ViewHolderOne extends RecyclerView.ViewHolder
    {
        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, electronicHobbyistActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
    public class ViewHolderTwo extends RecyclerView.ViewHolder
    {
        public ViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, electronicPkActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
    public class ViewHolderThree extends RecyclerView.ViewHolder
    {
    public ViewHolderThree(@NonNull View itemView) {
        super(itemView);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, electronicIdeaActivity.class);
                mContext.startActivity(intent);
            }
        });
    }
    }
    public class ViewHolderFour extends RecyclerView.ViewHolder
    {
        public ViewHolderFour(@NonNull View itemView) {
            super(itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, mathModelActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
    public class ViewHolderFive extends RecyclerView.ViewHolder
    {
        public ViewHolderFive(@NonNull View itemView) {
            super(itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, robotActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
    public class ViewHolderSix extends RecyclerView.ViewHolder
    {
        public ViewHolderSix(@NonNull View itemView) {
            super(itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, weiBoActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
    public class ViewHolderSeven extends RecyclerView.ViewHolder
    {
        public ViewHolderSeven(@NonNull View itemView) {
            super(itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, huaXueActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
    public class ViewHolderEight extends RecyclerView.ViewHolder
    {
        public ViewHolderEight(@NonNull View itemView) {
            super(itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, wuLiActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
    public class ViewHolderNine extends RecyclerView.ViewHolder
    {
        public ViewHolderNine(@NonNull View itemView) {
            super(itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, chuangKeActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
    public class ViewHolderTen extends RecyclerView.ViewHolder
    {
        public ViewHolderTen(@NonNull View itemView) {
            super(itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, shengWuActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}