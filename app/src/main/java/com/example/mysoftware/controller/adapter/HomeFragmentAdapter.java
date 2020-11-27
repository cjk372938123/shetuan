package com.example.mysoftware.controller.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mysoftware.R;
import com.example.mysoftware.controller.activity.MainActivity;
import com.example.mysoftware.controller.activity.NewsActivity;
import com.example.mysoftware.controller.activity.community.academic.academicMainActivity;
import com.example.mysoftware.controller.activity.community.art.artMainActivity;
import com.example.mysoftware.controller.activity.community.other.otherMainActivity;
import com.example.mysoftware.controller.activity.community.practice.practiceMainActivity;
import com.example.mysoftware.controller.activity.community.service.serviceMainActivity;
import com.example.mysoftware.controller.activity.community.sport.sportMainActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmentAdapter extends RecyclerView.Adapter {
    /**
     * 广告条幅类型
     */
    public static final int BANNER = 0;

    /**
     * 频道类型
     */
    public static final int CHANNEL = 1;
    /**
     * 活动类型
     */
    public static final int RECOMMEND = 2;

    private LayoutInflater mLayoutInflater;
    private Context mContext;

    private int currentType = BANNER;




    public HomeFragmentAdapter(Context context) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == BANNER) {
            return new BannerViewHolder(mContext, mLayoutInflater.inflate(R.layout.banner_viewpager, null));
        } else if (viewType == CHANNEL) {
            return new ChannelViewHolder(mContext, mLayoutInflater.inflate(R.layout.channel_item, null));
        }else if(viewType == RECOMMEND ){
            return new RecommendViewHolder(mContext, mLayoutInflater.inflate(R.layout.recommend_item, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == BANNER) {
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            bannerViewHolder.setData();
        }else if (getItemViewType(position) == CHANNEL) {
            ChannelViewHolder channelViewHolder = (ChannelViewHolder) holder;
            channelViewHolder.setData();
        }else if(getItemViewType(position) == RECOMMEND){
            RecommendViewHolder recommendViewHolder = (RecommendViewHolder) holder;
            recommendViewHolder.setData();
        }
    }
    class BannerViewHolder extends RecyclerView.ViewHolder{

        private Context mContext;
        private Banner banner;

        public BannerViewHolder(Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            this.banner = (Banner) itemView.findViewById(R.id.banner);
        }


        public void setData() {
            //设置Banner的数据
            //得到图片集合地址
            List<Integer> images = new ArrayList<>();
            images.add(R.drawable.source1);
            images.add(R.drawable.source2);
            images.add(R.drawable.source3);
//            for (int i = 0; i < 3; i++) {
//                String imageUrl = "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png";
//                imagesUrl.add(imageUrl);
//
//            }

            banner.setImageLoader(new ImageLoader() {

                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).into(imageView);
                }
            });
            //设置循环指示点
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            //banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);

            //设置手风琴效果
            banner.setBannerAnimation(Transformer.Accordion);

            banner.setImages(images);


            banner.start();
            //设置item的点击事件
            banner.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(mContext, "position==" + position, Toast.LENGTH_SHORT).show();
//                    startGoodsInfoActivity(goodsBean);
                }
            });
        }
    }
    class ChannelViewHolder extends RecyclerView.ViewHolder {
        private Context mContext;
        private GridView gv_channel;
        private ChannelAdapter adapter;

        public ChannelViewHolder(final Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            gv_channel = (GridView) itemView.findViewById(R.id.gv_channel);

                }
        public void setData() {
            //得到数据了
            //设置GridView的适配器
            adapter = new ChannelAdapter(mContext);
            gv_channel.setAdapter(adapter);
            //设置item的点击事件
            gv_channel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            Intent intent1 = new Intent(mContext, practiceMainActivity.class);
                            mContext.startActivity(intent1);
                            break;
                        case 1:
                            Intent intent2 = new Intent(mContext, artMainActivity.class);
                            mContext.startActivity(intent2);
                            break;
                        case 2:
                            Intent intent3 = new Intent(mContext, sportMainActivity.class);
                            mContext.startActivity(intent3);
                            break;
                        case 3:
                            Intent intent4 = new Intent(mContext, academicMainActivity.class);
                            mContext.startActivity(intent4);
                            break;
                        case 4:
                            Intent intent5 = new Intent(mContext, serviceMainActivity.class);
                            mContext.startActivity(intent5);
                            break;
                        case 5:
                            Intent intent6 = new Intent(mContext, otherMainActivity.class);
                            mContext.startActivity(intent6);
                            break;
                    }
        }

    });
        }
    }
    class RecommendViewHolder extends RecyclerView.ViewHolder{

        private final Context mContext;
        private TextView tv_more_recommend;
        private GridView gv_recommend;
        private RecommendGridViewAdapter adapter;

        public RecommendViewHolder(final Context mContext, View itemView) {
            super(itemView);
            this.mContext = mContext;
            tv_more_recommend = (TextView) itemView.findViewById(R.id.tv_more_recommend);
            gv_recommend = (GridView) itemView.findViewById(R.id.gv_recommend);
        }

        public void setData() {
            //1.有数据了
            //2.设置适配器
            adapter = new RecommendGridViewAdapter(mContext);
            gv_recommend.setAdapter(adapter);

            tv_more_recommend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, NewsActivity.class);
                    mContext.startActivity(intent);
                }
            });
            gv_recommend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(mContext, "position=="+position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case BANNER:
                currentType = BANNER;
                break;
            case CHANNEL:
                currentType = CHANNEL;
                break;
            case RECOMMEND:
                currentType = RECOMMEND;
                break;
        }
        return currentType;
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}
