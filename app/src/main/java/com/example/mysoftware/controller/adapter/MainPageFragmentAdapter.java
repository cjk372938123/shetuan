package com.example.mysoftware.controller.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mysoftware.R;
import com.example.mysoftware.controller.entity.MainPageEntity;
import com.example.mysoftware.controller.entity.practiceMainEntity;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import org.giavacms.banner.model.Banner;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

//
//public class MainPageFragmentAdapter extends PagerAdapter {
//    private List<Integer> mPics = null;
//    private List<MainPageEntity> datas;
//
//    @Override
//    public int getCount() {
//        if(mPics != null)
//        {
//            //return mPics.size();
//            //自定义轮播次数
//            return Integer.MAX_VALUE;
//        }
//        return 0;
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
//        return view == o;
//    }
//
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        int realPosition = position % mPics.size();
//
//        ImageView imageView = new ImageView(container.getContext());
//        imageView.setImageResource(mPics.get(realPosition));
//        container.addView(imageView);
//        return imageView;
//    }
//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        container.removeView((View) object);
//    }
//
//    public void setBannerData(List<Integer> pics) {
//        this.mPics = pics;
//    }
//    public void setStaggerData(List<MainPageEntity> datas)
//    {
//        this.datas = datas;
//    }
//    public void setGridviewData(List<MainPageEntity> datas)
//    {
//        this.datas = datas;
//    }
//    public  void setDatas(List<MainPageEntity> datas)
//    {
//        this.datas = datas;
//    }


//    private static final int BANNER = 0;
//
//    private static final int CHANNEL = 1;
//
//    private static final int ACT = 2;
//
//    private  final Context mContext;
//
//   // private  ResultBean resultBean;
//
//    //LayoutInflater mLayoutInflater;
//
//    private int currentType = BANNER;
//
//
//
//    public MainPageFragmentAdapter() {
//        //this.mContext = mContext;
//        //this.resultBean = resultBean;
//       // mLayoutInflater = LayoutInflater.from(mContext);
//    }
//
//
//    //创建ViewHolder
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        return null;
//    }
//
//    //相当于getview中的绑定数据模块
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
//
//    }
//
//
//    @Override
//    public int getItemViewType(int position) {
////        switch (position)
////        {
////            case BANNER:
////                currentType = BANNER;
////                break;
////            case CHANNEL:
////                currentType = CHANNEL;
////                break;
////            case ACT:
////                currentType = ACT;
////                break;
////        }
////        return currentType;
//        return 0;
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//}
//
//public class MainPageFragmentAdapter extends RecyclerView.Adapter {
//    /**
//     * 广告条幅类型
//     */
//    public static final int BANNER = 0;
//
//    /**
//     * 频道类型
//     */
//    public static final int CHANNEL = 1;
//    /**
//     * 活动类型
//     */
//    public static final int ACT = 2;
//
//    private int currentType = BANNER;
//
//    private LayoutInflater mLayoutInflater;
//
//    private Context mContext;
//
//    public MainPageFragmentAdapter(Context context) {
//        this.mContext = context;
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        if (viewType == BANNER) {
//            //return new BannerViewHolder(mContext, mLayoutInflater.inflate(R.layout.main_page_viewpager, null));
//        } else if (viewType == CHANNEL) {
//            //return new ChannelViewHolder(mContext, mLayoutInflater.inflate(R.layout.main_page_gridview, null));
//        } else if (viewType == ACT) {
//            //return new ActViewHolder(mContext, mLayoutInflater.inflate(R.layout.item_stagger, null));
//        }
//        return null;
//    }
//
//        @Override
//        public void onBindViewHolder (RecyclerView.ViewHolder holder,int position){
//            if (getItemViewType(position) == BANNER) {
////                BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
////                bannerViewHolder.setData();
//            } else if (getItemViewType(position) == CHANNEL) {
//                ChannelViewHolder channelViewHolder = (ChannelViewHolder) holder;
//                channelViewHolder.setData();
//            } else if (getItemViewType(position) == ACT) {
////                ActViewHolder actViewHolder = (ActViewHolder) holder;
////                actViewHolder.setData(resultBean.getAct_info());
//            }
//        }
//    class ChannelViewHolder extends RecyclerView.ViewHolder {
//        private Context mContext;
//        private GridView gv;
//        private channel_Adapter adapter;
//
//        public ChannelViewHolder(final Context mContext, View itemView) {
//            super(itemView);
//            this.mContext = mContext;
//            gv = (GridView) itemView.findViewById(R.id.gv);
//
//            //设置item的点击事件
//            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView parent, View view, int position, long id) {
//                    Toast.makeText(mContext, "position" + position, Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//
//        public void setData() {
//            //得到数据了
//            //设置GridView的适配器
//            adapter = new channel_Adapter(mContext);
//            gv.setAdapter(adapter);
//        }
//    }
//        class BannerViewHolder extends RecyclerView.ViewHolder {
//            private Context mContext;
//            //private Banner mBanner;
//            private ViewPager mViewPager;
//
//            public BannerViewHolder(Context mContext, View itemView) {
//                super(itemView);
//                this.mContext = mContext;
//                this.mViewPager = itemView.findViewById(R.id.looper_pager);
//            }
//
//
//            public void setData() {
//                RecyclerView.Adapter bannerAdapter = new BannerAdapter(mContext);
//                //mViewPager.setAdapter(bannerAdapter);
//
//
////                //设置item的点击事件
////                banner.setOnBannerClickListener(new OnBannerClickListener() {
////                    @Override
////                    public void OnBannerClick(int position) {
////                        Toast.makeText(mContext, "position==" + position, Toast.LENGTH_SHORT).show();
//////                    startGoodsInfoActivity(goodsBean);
////                    }
////                });
//            }
//        }
//
//        @Override
//        public int getItemCount ()
//        {
//            return 2;
//        }
//
//        @Override
//        public int getItemViewType ( int position){
//            switch (position) {
//                case BANNER:
//                    currentType = BANNER;
//                    break;
//                case CHANNEL:
//                    currentType = CHANNEL;
//                    break;
//                case ACT:
//                    currentType = ACT;
//                    break;
//            }
//            return currentType;
//        }
//    }


public class MainPageFragmentAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}