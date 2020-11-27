package com.example.mysoftware.controller.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mysoftware.R;
import com.example.mysoftware.controller.api.Api;
import com.example.mysoftware.controller.api.ApiConfig;
import com.example.mysoftware.controller.api.TtitCallback;
import com.example.mysoftware.controller.entity.BaseResponse;
import com.example.mysoftware.controller.entity.VideoEntity;
import com.example.mysoftware.controller.view.CircleTransform;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<VideoEntity> datas;

    public void setDatas(List<VideoEntity> datas) {
        this.datas = datas;
    }

    public VideoAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public VideoAdapter(Context Context, List<VideoEntity> datas) {
        this.mContext = Context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_video_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        ViewHolder vh = (ViewHolder) holder;
        VideoEntity videoEntity = datas.get(position);
        vh.tvTitle.setText(videoEntity.getTitle());
        vh.tvAuthor.setText(videoEntity.getName());
//        vh.tvDz.setText(String.valueOf(videoEntity.getDzCount()));
//        vh.tvComment.setText(String.valueOf(videoEntity.getCommentCount()));
//        vh.tvCollect.setText(String.valueOf(videoEntity.getCollectCount()));
        if (videoEntity.getVideoSocialEntity() != null) {
            int likenum = videoEntity.getVideoSocialEntity().getLikenum();
            int commentnum = videoEntity.getVideoSocialEntity().getCommentnum();
            int collectnum = videoEntity.getVideoSocialEntity().getCollectnum();
            boolean flagLike = videoEntity.getVideoSocialEntity().isFlagLike();
            boolean flagCollect = videoEntity.getVideoSocialEntity().isFlagCollect();
            if (flagLike) {
                vh.tvDz.setTextColor(Color.parseColor("#E21918"));
                vh.imgDizan.setImageResource(R.mipmap.dianzan_select);
            }
            if (flagCollect) {
                vh.tvCollect.setTextColor(Color.parseColor("#E21918"));
                vh.imgCollect.setImageResource(R.mipmap.collect_select);
            }
            vh.tvDz.setText(String.valueOf(likenum));
            vh.tvComment.setText(String.valueOf(commentnum));
            vh.tvCollect.setText(String.valueOf(collectnum));
            vh.flagCollect = flagCollect;
            vh.flagLike = flagLike;

        }
        /*
        Picasso.get()
                .load(videoEntity.getHeadurl())
                .transform(new CircleTransform())
                .into(vh.imgHeader);

        Picasso.get()
                .load(videoEntity.getCoverurl())
                .into(vh.mThumb);
        vh.mPosition = position;
        */

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
    static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTitle;
        private TextView tvAuthor;
        private TextView tvDz;
        private TextView tvComment;
        private TextView tvCollect;
        private ImageView imgCollect;
        private ImageView imgDizan;
        private boolean flagCollect;
        private boolean flagLike;

        /*
        private TextView tvTitle;
        private TextView tvAuthor;
        private TextView tvDz;
        private TextView tvComment;
        private TextView tvCollect;
        private ImageView imgHeader;
        private ImageView imgCollect;
        private ImageView imgDizan;
        public ImageView mThumb;
        //public PrepareView mPrepareView;
        public FrameLayout mPlayerContainer;
        public int mPosition;
        private boolean flagCollect;
        private boolean flagLike;
        */
        public ViewHolder(@NonNull View view) {
            super(view);
            tvTitle = view.findViewById(R.id.title);
            tvAuthor = view.findViewById(R.id.author);
            tvDz = view.findViewById(R.id.dz);
            //tvComment = view.findViewById(R.id.comment);
            tvCollect = view.findViewById(R.id.collect);
            imgCollect = view.findViewById(R.id.img_collect);
            imgDizan = view.findViewById(R.id.img_like);
            /*
            super(view);
            tvTitle = view.findViewById(R.id.title);
            tvAuthor = view.findViewById(R.id.author);
            tvDz = view.findViewById(R.id.dz);
            tvComment = view.findViewById(R.id.comment);
            tvCollect = view.findViewById(R.id.collect);
            imgHeader = view.findViewById(R.id.img_header);
            imgCollect = view.findViewById(R.id.img_collect);
            imgDizan = view.findViewById(R.id.img_like);
            mPlayerContainer = view.findViewById(R.id.player_container);
        */

            imgCollect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int collectNum = Integer.parseInt(tvCollect.getText().toString());
                    if(flagCollect) {//已收藏
                        if(collectNum > 0)
                        {
                            tvCollect.setText(String.valueOf(--collectNum));
                            tvCollect.setTextColor(Color.parseColor("#161616"));
                            imgCollect.setImageResource(R.mipmap.collect);
                        }

                    }else {
                        tvCollect.setText(String.valueOf(++collectNum));
                        tvCollect.setTextColor(Color.parseColor("#E21918"));
                        imgCollect.setImageResource(R.mipmap.collect_select);
                    }
                    flagCollect = !flagCollect;
                }
            });
            imgDizan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int likeNum = Integer.parseInt(tvDz.getText().toString());
                    if(flagLike) {
                        if(likeNum > 0)
                        {
                            tvDz.setText(String.valueOf(--likeNum));
                            tvDz.setTextColor(Color.parseColor("#161616"));
                            imgDizan.setImageResource(R.mipmap.dianzan);
                        }
                    }else {
                        tvDz.setText(String.valueOf(++likeNum));
                        tvDz.setTextColor(Color.parseColor("#E21918"));
                        imgDizan.setImageResource(R.mipmap.dianzan_select);
                    }
                    flagLike = !flagLike;
                }
            });
            //通过tag将ViewHolder和itemView绑定
            view.setTag(this);
        }
    }
//    private void updateCount(int vid, int type, boolean flag) {
//        HashMap<String, Object> params = new HashMap<String, Object>();
//        params.put("vid", vid);
//        params.put("type", type);
//        params.put("flag", flag);
//        Api.config(ApiConfig.VIDEO_UPDATE_COUNT, params).postRequest(mContext, new TtitCallback() {
//            @Override
//            public void onSuccess(final String res) {
//                Log.e("onSuccess", res);
//                Gson gson = new Gson();
//                BaseResponse baseResponse = gson.fromJson(res, BaseResponse.class);
//                if (baseResponse.getCode() == 0) {
//
//                }
//            }

//            @Override
//            public void onFailure(Exception e) {
//
//            }
//        });
//    }
}


