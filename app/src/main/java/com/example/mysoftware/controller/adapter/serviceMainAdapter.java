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
import com.example.mysoftware.controller.activity.community.art.bookActivity;
import com.example.mysoftware.controller.activity.community.art.hanfuActivity;
import com.example.mysoftware.controller.activity.community.art.jitaActivity;
import com.example.mysoftware.controller.activity.community.art.muliActivity;
import com.example.mysoftware.controller.activity.community.art.shufaActivity;
import com.example.mysoftware.controller.activity.community.art.taociActivity;
import com.example.mysoftware.controller.activity.community.service.falvActivity;
import com.example.mysoftware.controller.activity.community.service.fazhanActivity;
import com.example.mysoftware.controller.activity.community.service.gongzuoActivity;
import com.example.mysoftware.controller.entity.practiceMainEntity;

import java.util.List;

public class serviceMainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private List<practiceMainEntity> datas;
    private LinearLayout linearLayout;

    public serviceMainAdapter(Context context, List<practiceMainEntity> datas) {
        mContext = context;
        this.datas = datas;
    }

    public serviceMainAdapter(List<practiceMainEntity> datas) {
        this.datas = datas;
    }

    public serviceMainAdapter(Context context) {
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
            View view = LayoutInflater.from(mContext).inflate(R.layout.item24, parent, false);
            linearLayout = view.findViewById(R.id.falv);
            return new serviceMainAdapter.ViewHolderOne(view);
        } else if (viewType == 2) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item25, parent, false);
            linearLayout = view.findViewById(R.id.fazhan);
            return new serviceMainAdapter.ViewHolderTwo(view);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item26, parent, false);
            linearLayout = view.findViewById(R.id.gongzuo);
            return new serviceMainAdapter.ViewHolderThree(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        practiceMainEntity practiceMainEntity = datas.get(position);
        if (type == 1) {
            serviceMainAdapter.ViewHolderOne vh = (serviceMainAdapter.ViewHolderOne) holder;
        } else if (type == 2) {
            serviceMainAdapter.ViewHolderTwo vh = (serviceMainAdapter.ViewHolderTwo) holder;
        } else {
            serviceMainAdapter.ViewHolderThree vh = (serviceMainAdapter.ViewHolderThree) holder;
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
                    Intent intent = new Intent(mContext, falvActivity.class);
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
                    Intent intent = new Intent(mContext, fazhanActivity.class);
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
                    Intent intent = new Intent(mContext, gongzuoActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }

}
