package com.example.mysoftware.controller.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mysoftware.R;

import com.example.mysoftware.controller.activity.community.sport.paiqiuActivity;
import com.example.mysoftware.controller.activity.community.sport.taiqiuActivity;
import com.example.mysoftware.controller.activity.community.sport.tiaoshengActivity;
import com.example.mysoftware.controller.activity.community.sport.yumaoqiuActivity;
import com.example.mysoftware.controller.activity.community.sport.zixingcheActivity;
import com.example.mysoftware.controller.activity.community.sport.zuqiuActivity;
import com.example.mysoftware.controller.entity.practiceMainEntity;

import java.util.List;

public class sportMainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private List<practiceMainEntity> datas;
    private LinearLayout linearLayout;

    public sportMainAdapter(Context context, List<practiceMainEntity> datas) {
        mContext = context;
        this.datas = datas;
    }

    public sportMainAdapter(List<practiceMainEntity> datas) {
        this.datas = datas;
    }

    public sportMainAdapter(Context context) {
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
            View view = LayoutInflater.from(mContext).inflate(R.layout.item17, parent, false);
            linearLayout = view.findViewById(R.id.taiqiu);
            return new sportMainAdapter.ViewHolderOne(view);
        } else if (viewType == 2) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item18, parent, false);
            linearLayout = view.findViewById(R.id.yumaoqiu);
            return new sportMainAdapter.ViewHolderTwo(view);
        } else if(viewType == 3){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item19, parent, false);
            linearLayout = view.findViewById(R.id.zixingche);
            return new sportMainAdapter.ViewHolderThree(view);
        }
        else if(viewType == 4){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item20, parent, false);
            linearLayout = view.findViewById(R.id.zuqiu);
            return new sportMainAdapter.ViewHolderFour(view);
        }
        else if(viewType == 5){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item21, parent, false);
            linearLayout = view.findViewById(R.id.paiqiu);
            return new sportMainAdapter.ViewHolderFive(view);
        }
        else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item22, parent, false);
            linearLayout = view.findViewById(R.id.tiaosheng);
            return new sportMainAdapter.ViewHolderSix(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        practiceMainEntity practiceMainEntity = datas.get(position);
        if (type == 1) {
            sportMainAdapter.ViewHolderOne vh = (sportMainAdapter.ViewHolderOne) holder;
        } else if (type == 2) {
            sportMainAdapter.ViewHolderTwo vh = (sportMainAdapter.ViewHolderTwo) holder;
        } else if(type == 3){
            sportMainAdapter.ViewHolderThree vh = (sportMainAdapter.ViewHolderThree) holder;
        }
        else if(type == 4){
            sportMainAdapter.ViewHolderFour vh = (sportMainAdapter.ViewHolderFour) holder;
        }
        else if(type == 5){
            sportMainAdapter.ViewHolderFive vh = (sportMainAdapter.ViewHolderFive) holder;
        }
        else{
            sportMainAdapter.ViewHolderSix vh = (sportMainAdapter.ViewHolderSix) holder;
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
                    Intent intent = new Intent(mContext, taiqiuActivity.class);
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
                    Intent intent = new Intent(mContext, yumaoqiuActivity.class);
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
                    Intent intent = new Intent(mContext, zixingcheActivity.class);
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
                    Intent intent = new Intent(mContext, zuqiuActivity.class);
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
                    Intent intent = new Intent(mContext, paiqiuActivity.class);
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
                    Intent intent = new Intent(mContext, tiaoshengActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
