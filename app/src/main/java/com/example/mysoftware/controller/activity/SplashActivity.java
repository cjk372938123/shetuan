package com.example.mysoftware.controller.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;


import com.example.mysoftware.R;
import com.example.mysoftware.model.Model;
import com.example.mysoftware.model.bean.UserInfo;
import com.hyphenate.chat.EMClient;

public class SplashActivity extends Activity {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(isFinishing())
            {
                return;
            }
            toMainOrLogin();
        }
    };

    private void toMainOrLogin()
    {
//        new Thread(){
//            public void run(){
//        }.start();
    Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
        @Override
        public void run() {
                    if(EMClient.getInstance().isLoggedInBefore()){
                        //登陆过, 获取当前用户信息
                        UserInfo account = Model.getInstance().getUserAccountDao().getAccountByHxId(EMClient.getInstance().getCurrentUser());
                        if(account == null)
                        {//跳转到登录页面
                            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                        else
                        //跳转到主页面
                        {
                            Model.getInstance().loginSuccess(account);
                            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                    else{//没登陆过
                        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                    finish();
                }
    });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //发送3s延时消息
        handler.sendMessageDelayed(Message.obtain(), 3000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁消息
        handler.removeCallbacksAndMessages(null);
    }
}