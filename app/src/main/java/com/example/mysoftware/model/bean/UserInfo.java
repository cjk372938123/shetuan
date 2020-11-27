package com.example.mysoftware.model.bean;

public class UserInfo {
    private String name;
    private String hxid;//环信id
    private String nick;//昵称
    private String photo;//头像

    public UserInfo()
    {

    }
    //方便后期操作, 用同一个name
    public UserInfo(String name) {
        this.name = name;
        this.hxid = name;
        this.nick = name;
    }

    public String getName() {
        return name;
    }

    public String getHxid() {
        return hxid;
    }

    public String getNick() {
        return nick;
    }

    public String getPhoto() {
        return photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHxid(String hxid) {
        this.hxid = hxid;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
