package com.example.mysoftware.controller.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysoftware.R;
import com.example.mysoftware.controller.activity.FindActivity;
import com.example.mysoftware.controller.activity.LoginActivity;
import com.example.mysoftware.controller.activity.MyCollectActivity;
import com.example.mysoftware.controller.activity.NewsActivity;
import com.example.mysoftware.controller.listener.OnItemClickListener;
import com.example.mysoftware.model.Model;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

import com.example.mysoftware.controller.activity.BaseActivity;

import java.util.ArrayList;

import skin.support.SkinCompatManager;

import static android.R.layout.simple_list_item_1;

public class SettingFragment extends BaseFragment implements OnItemClickListener {
    private TextView bt_setting_out;
    private RelativeLayout rl_collect;
    private RelativeLayout rl_skin;
    private Button find_btn;
    private TextView nickname;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = View.inflate(getActivity(), R.layout.fragment_my, null);
        initView(view);
        return view;
    }


    @Override
    protected int initLayout() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    private void initView(View view) {
        bt_setting_out = view.findViewById(R.id.bt_setting_out);
        rl_collect = view.findViewById(R.id.rl_collect);
        rl_skin = view.findViewById(R.id.rl_skin);
        //find_btn = view.findViewById(R.id.find_btn);
        nickname = view.findViewById(R.id.nickname);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    public void initData() {
        //设置用户昵称
        nickname.setText(EMClient.getInstance().getCurrentUser());


        //在按钮上显示用户名字
        bt_setting_out.setText("退出登录(" + EMClient.getInstance().getCurrentUser() + ")");

        rl_collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NewsActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        rl_skin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String skin = findByKey("skin");
                if (skin.equals("night")) {
                    // 恢复应用默认皮肤
                    SkinCompatManager.getInstance().restoreDefaultTheme();
                    insertVal("skin", "default");
                } else {
                    SkinCompatManager.getInstance().loadSkin("night", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN); // 后缀加载
                    insertVal("skin", "night");
                }
            }
        });
//        find_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), FindActivity.class);
//                startActivity(intent);
//            }
//        });

        bt_setting_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
                    @Override
                    public void run() {
                        //登陆环信服务器退出登录
                        EMClient.getInstance().logout(false, new EMCallBack() {
                            @Override
                            public void onSuccess() {
                                //关闭DBHelper
                                Model.getInstance().getDBManager().close();
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        //回到登录页面
                                        Toast.makeText(getActivity(), "退出成功", Toast.LENGTH_SHORT).show();
                                        //更新ui显示(更新Toast)
                                        Intent intent = new Intent(getActivity(), LoginActivity.class);

                                        startActivity(intent);

                                        getActivity().finish();
                                    }
                                });
                            }
                            @Override
                            public void onError(int i, String s) {
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getActivity(), "退出失败"+s, Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            @Override
                            public void onProgress(int i, String s) {

                            }
                        });}
                    });
                }
            });
    }

    @Override
    public void onItemClick(int position) {

    }
}

