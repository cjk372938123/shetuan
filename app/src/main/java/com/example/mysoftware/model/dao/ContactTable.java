package com.example.mysoftware.model.dao;

//联系人表建表语句(联系人信息表)
public class ContactTable {
    public static final String TAB_NAME = "tab_contact";

    public static final String COL_HXID = "hxid";
    public static final String COL_NAME = "name";
    public static final String COL_NICK = "nick";
    public static final String COL_PHOTO = "photo";

    public static final String COL_IS_CONTACT = "is_contact";  //是否是联系人

    public static final String CREATE_TAB = "create table "
            + TAB_NAME + " ("
            + COL_HXID + " text primary key,"
            + COL_NAME + " text,"
            + COL_NICK + " text,"
            + COL_PHOTO + " text,"
            + COL_IS_CONTACT + " integer);";//用0和1表示群里的人是否是自己的好友
}
