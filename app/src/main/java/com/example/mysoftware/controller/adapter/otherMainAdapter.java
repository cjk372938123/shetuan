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
import com.example.mysoftware.controller.activity.community.other.guanliActivity;
import com.example.mysoftware.controller.activity.community.other.haixiActivity;
import com.example.mysoftware.controller.activity.community.other.jianxiActivity;
import com.example.mysoftware.controller.activity.community.other.jingyingActivity;
import com.example.mysoftware.controller.activity.community.other.kabchuangyeActivity;
import com.example.mysoftware.controller.activity.community.other.pinpaiActivity;
import com.example.mysoftware.controller.entity.practiceMainEntity;

import java.util.List;

public class otherMainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<practiceMainEntity> datas;
    private LinearLayout linearLayout;

    public otherMainAdapter(Context context, List<practiceMainEntity> datas) {
        mContext = context;
        this.datas = datas;
    }

    public otherMainAdapter(List<practiceMainEntity> datas) {
        this.datas = datas;
    }

    public otherMainAdapter(Context context) {
        mContext = context;
    }

    public void setDatas(List<practiceMainEntity> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item27, parent, false);
            linearLayout = view.findViewById(R.id.guanli);
            return new otherMainAdapter.ViewHolderOne(view);
        } else if (viewType == 2) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item28, parent, false);
            linearLayout = view.findViewById(R.id.haixi);
            return new otherMainAdapter.ViewHolderTwo(view);
        } else if (viewType == 3) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item29, parent, false);
            linearLayout = view.findViewById(R.id.jianxi);
            return new otherMainAdapter.ViewHolderThree(view);
        } else if (viewType == 4) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item30, parent, false);
            linearLayout = view.findViewById(R.id.jingying);
            return new otherMainAdapter.ViewHolderFour(view);
        } else if (viewType == 5) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item31, parent, false);
            linearLayout = view.findViewById(R.id.chuangye);
            return new otherMainAdapter.ViewHolderFive(view);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item32, parent, false);
            linearLayout = view.findViewById(R.id.pinpai);
            return new otherMainAdapter.ViewHolderSix(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        practiceMainEntity practiceMainEntity = datas.get(position);
        if (type == 1) {
            otherMainAdapter.ViewHolderOne vh = (otherMainAdapter.ViewHolderOne) holder;
        } else if (type == 2) {
            otherMainAdapter.ViewHolderTwo vh = (otherMainAdapter.ViewHolderTwo) holder;
        } else if (type == 3) {
            otherMainAdapter.ViewHolderThree vh = (otherMainAdapter.ViewHolderThree) holder;
        } else if (type == 4) {
            otherMainAdapter.ViewHolderFour vh = (otherMainAdapter.ViewHolderFour) holder;
        } else if (type == 5) {
            otherMainAdapter.ViewHolderFive vh = (otherMainAdapter.ViewHolderFive) holder;
        } else {
            otherMainAdapter.ViewHolderSix vh = (otherMainAdapter.ViewHolderSix) holder;
        }

    }

    @Override
    public int getItemViewType(int position) {
        int type = datas.get(position).getType();
        return type;
    }

    @Override
    public int getItemCount() {
        if (datas != null && datas.size() > 0) {
            return datas.size();
        } else {
            return 0;
        }
    }

    public class ViewHolderOne extends RecyclerView.ViewHolder {
        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, guanliActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    public class ViewHolderTwo extends RecyclerView.ViewHolder {
        public ViewHolderTwo(@NonNull View itemView) {
            super(itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, haixiActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    public class ViewHolderThree extends RecyclerView.ViewHolder {
        public ViewHolderThree(@NonNull View itemView) {
            super(itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, jianxiActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    public class ViewHolderFour extends RecyclerView.ViewHolder {
        public ViewHolderFour(@NonNull View itemView) {
            super(itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, jingyingActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    public class ViewHolderFive extends RecyclerView.ViewHolder {
        public ViewHolderFive(@NonNull View itemView) {
            super(itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, kabchuangyeActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }

    public class ViewHolderSix extends RecyclerView.ViewHolder {
        public ViewHolderSix(@NonNull View itemView) {
            super(itemView);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, pinpaiActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}

