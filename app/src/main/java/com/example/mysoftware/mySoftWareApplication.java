package com.example.mysoftware;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;


import com.baidu.mapapi.SDKInitializer;
import com.example.mysoftware.model.Model;
import com.facebook.stetho.Stetho;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.EaseUI;
import com.zhy.http.okhttp.OkHttpUtils;

import org.xutils.x;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import skin.support.SkinCompatManager;
import skin.support.app.SkinCardViewInflater;
import skin.support.constraint.app.SkinConstraintViewInflater;
import skin.support.design.app.SkinMaterialViewInflater;

public class IMApplication extends Application {
    private static Context mContext;
    public void onCreate() {

        super.onCreate();
        //初始化UI
        EMOptions options = new EMOptions();
        //需要同意后才能接受邀请
        options.setAcceptInvitationAlways(true);
        options.setAutoAcceptGroupInvitation(false);

        EaseUI.getInstance().init(this, options);
//        初始化数据模型层类
        Model.getInstance().init(this);
        mContext = this;

        Stetho.initializeWithDefaults(this);

        x.Ext.init(this);
        //x.Ext.setDebug(BuildConfig.DEBUG);
        x.Ext.setDebug(true);


        //*******************地图初始操作*****************
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        //SDKInitializer.setCoordType(CoordType.BD09LL);
        //*************************************

        //***************************
        SkinCompatManager.withoutActivity(this)                         // 基础控件换肤初始化
                .addInflater(new SkinMaterialViewInflater())            // material design 控件换肤初始化[可选]
                .addInflater(new SkinConstraintViewInflater())          // ConstraintLayout 控件换肤初始化[可选]
                .addInflater(new SkinCardViewInflater())                // CardView v7 控件换肤初始化[可选]
                .setSkinStatusBarColorEnable(false)                     // 关闭状态栏换肤，默认打开[可选]
                .setSkinWindowBackgroundEnable(false)                   // 关闭windowBackground换肤，默认打开[可选]
                .loadSkin();
        SharedPreferences sp = getSharedPreferences("sp_ttit", MODE_PRIVATE);
        String skin = sp.getString("skin", "");
        if (skin.equals("night")) {
            SkinCompatManager.getInstance().loadSkin("night", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN); // 后缀加载
        } else {
            SkinCompatManager.getInstance().restoreDefaultTheme();
        }


        //***************************
    }
    private void initOkhttpClient()
    {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);

    }

    //获取全局上下文对象
    public static Context getGlobalApplication()
    {
        return mContext;
    }
}