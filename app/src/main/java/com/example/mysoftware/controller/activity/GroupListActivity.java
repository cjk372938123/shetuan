package com.example.mysoftware.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;


import com.example.mysoftware.R;
import com.example.mysoftware.controller.adapter.GroupListAdapter;
import com.example.mysoftware.model.Model;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMGroup;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.exceptions.HyphenateException;

import java.util.List;

import static com.superrtc.mediamanager.EMediaManager.initData;

public class GroupListActivity extends Activity {

    private ListView lv_grouplist;
    private GroupListAdapter groupListAdapter;
    private LinearLayout ll_grouplist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);

        initView();

        initData();

        initListener();
    }

    private void initListener() {
        lv_grouplist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Log.e("TAG", "position:" + position);打印输出position, 0号位置被新建群组占了,所以下面-1

                if(position == 0)
                {
                    return;
                }

                Intent intent = new Intent(GroupListActivity.this, ChatActivity.class);

                //传递绘画类型
                intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_GROUP);

                EMGroup emGroup = EMClient.getInstance().groupManager().getAllGroups().get(position - 1);

                //群id
                intent.putExtra(EaseConstant.EXTRA_USER_ID, emGroup.getGroupId());

                startActivity(intent);
            }
        });

        ll_grouplist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GroupListActivity.this, NewGroupActivity.class);

                startActivity(intent);
            }
        });
    }

    private void getGroupsFromServer() {
        Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                try {
                    //从网络获取数据
                    final List<EMGroup> mGroups = EMClient.getInstance().groupManager().getJoinedGroupsFromServer();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(GroupListActivity.this, "加载群信息成功", Toast.LENGTH_SHORT);

                            //刷新
                            refresh();
                        }
                    });
                } catch (HyphenateException e) {
                    e.printStackTrace();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(GroupListActivity.this, "加载群信息失败", Toast.LENGTH_SHORT);
                        }
                    });

                }
            }

        });
    }

    private void initData() {
        groupListAdapter = new GroupListAdapter(this);

        lv_grouplist.setAdapter(groupListAdapter);

        //从环信服务器获取所有群的信息
        getGroupsFromServer();

    }

    private void refresh()
    {
        groupListAdapter.refresh(EMClient.getInstance().groupManager().getAllGroups());
    }


    private void initView() {
        lv_grouplist = findViewById(R.id.lv_grouplist);

        //添加头布局
        View headerView = View.inflate(this, R.layout.header_grouplist, null);
        lv_grouplist.addHeaderView(headerView);

        ll_grouplist = headerView.findViewById(R.id.ll_grouplist);

    }

    //如果创建群,需要再次刷新页面
    @Override
    protected void onResume() {
        super.onResume();
        //刷新页面
        refresh();
    }
}