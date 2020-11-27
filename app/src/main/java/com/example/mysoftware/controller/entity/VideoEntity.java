package com.example.mysoftware.controller.entity;

import java.io.Serializable;


public class VideoEntity implements Serializable{
    /*
    Serializable:序列化
     */
    private int id;
    private String title;
    private String name;
    private int dzCount;
    private int collectCount;
    private int commentCount;
    private VideoSocialEntity videoSocialEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public VideoSocialEntity getVideoSocialEntity() {
        return videoSocialEntity;
    }

    public void setVideoSocialEntity(VideoSocialEntity videoSocialEntity) {
        this.videoSocialEntity = videoSocialEntity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDzCount() {
        return dzCount;
    }

    public void setDzCount(int dzCount) {
        this.dzCount = dzCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(int collectCount) {
        this.collectCount = collectCount;
    }
    public static class VideoSocialEntity {

        private int commentnum;
        private int likenum;
        private int collectnum;
        private boolean flagLike;
        private boolean flagCollect;

        public int getCommentnum() {
            return commentnum;
        }

        public void setCommentnum(int commentnum) {
            this.commentnum = commentnum;
        }

        public int getLikenum() {
            return likenum;
        }

        public void setLikenum(int likenum) {
            this.likenum = likenum;
        }

        public int getCollectnum() {
            return collectnum;
        }

        public void setCollectnum(int collectnum) {
            this.collectnum = collectnum;
        }

        public boolean isFlagLike() {
            return flagLike;
        }

        public void setFlagLike(boolean flagLike) {
            this.flagLike = flagLike;
        }

        public boolean isFlagCollect() {
            return flagCollect;
        }

        public void setFlagCollect(boolean flagCollect) {
            this.flagCollect = flagCollect;
        }
    }
}
