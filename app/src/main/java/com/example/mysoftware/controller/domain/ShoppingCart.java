package com.example.mysoftware.controller.domain;

import java.io.Serializable;

public class ShoppingCart extends SmartServicePagerBean.Wares implements Serializable{

    /**
     * 购买的数量
     */
    private int count = 1;

    /**
     * 是否勾选
     */
    private boolean isCheck = true;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setIsCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "count=" + count +
                ", isCheck=" + isCheck +
                '}';
    }
}
