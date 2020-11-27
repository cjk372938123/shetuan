package com.example.mysoftware.controller.entity;

import java.io.Serializable;

public class MainPageEntity implements Serializable {
    private int img;
    private int Id;
    private String Title;
    private int type;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
