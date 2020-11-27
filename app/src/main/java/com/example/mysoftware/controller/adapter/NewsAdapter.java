package com.example.mysoftware.controller.adapter;

import android.content.Context;
import android.content.Entity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mysoftware.R;
import com.example.mysoftware.controller.activity.community.practice.electronicHobbyistActivity;
import com.example.mysoftware.controller.activity.newsdetail.a1Activity;
import com.example.mysoftware.controller.activity.newsdetail.a2Activity;
import com.example.mysoftware.controller.activity.newsdetail.a3Activity;
import com.example.mysoftware.controller.activity.newsdetail.a4Activity;
import com.example.mysoftware.controller.activity.newsdetail.a5Activity;
import com.example.mysoftware.controller.activity.newsdetail.a6Activity;
import com.example.mysoftware.controller.entity.NewsEntity;
import com.example.mysoftware.controller.view.CircleTransform;
import com.squareup.picasso.Picasso;


import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<ViewHolder>
{

    private Context mContext;
    private List<NewsEntity> datas;
    private LinearLayout linearLayout;

    public void setDatas(List<NewsEntity> datas)
    {
        this.datas = datas;
    }

    public NewsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public NewsAdapter(Context mContext, List<NewsEntity> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public int getItemViewType(int position) {
        int type = datas.get(position).getType();
        return type;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.news_item_one, parent, false);
            linearLayout = view.findViewById(R.id.a1);
            return new ViewHolderOne(view);
        } else if (viewType == 2) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.news_item_two, parent, false);
            linearLayout = view.findViewById(R.id.a2);
            return new ViewHolderTwo(view);
        }
        else if (viewType == 3) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.news_item_three, parent, false);
            linearLayout = view.findViewById(R.id.a3);
            return new ViewHolderThree(view);
        }
        else if (viewType == 4) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.news_item_four, parent, false);
            linearLayout = view.findViewById(R.id.a4);
            return new ViewHolderFour(view);
        }
        else if (viewType == 5) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.news_item_five, parent, false);
            linearLayout = view.findViewById(R.id.a5);
            return new ViewHolderFive(view);
        }else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.news_item_six, parent, false);
            linearLayout = view.findViewById(R.id.a6);
            return new ViewHolderSix(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int type = getItemViewType(position);
        NewsEntity newsEntity = datas.get(position);
        if (type == 1) {
            ViewHolderOne vh = (ViewHolderOne) holder;
        } else if (type == 2) {
            ViewHolderTwo vh = (ViewHolderTwo) holder;
        }
        else if (type == 3) {
            ViewHolderThree vh = (ViewHolderThree) holder;
        }
        else if (type == 4) {
            ViewHolderFour vh = (ViewHolderFour) holder;
        }
        else if (type == 5) {
            ViewHolderFive vh = (ViewHolderFive) holder;
        } else {
            ViewHolderSix vh = (ViewHolderSix) holder;
        }
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
                    Intent intent = new Intent(mContext, a1Activity.class);
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
                    Intent intent = new Intent(mContext, a2Activity.class);
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
                Intent intent = new Intent(mContext, a3Activity.class);
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
                    Intent intent = new Intent(mContext, a4Activity.class);
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
                    Intent intent = new Intent(mContext, a5Activity.class);
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
                    Intent intent = new Intent(mContext, a6Activity.class);
                    mContext.startActivity(intent);
                }
            });
        }
    }
    }




