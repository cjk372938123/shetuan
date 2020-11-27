package com.example.mysoftware.controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mysoftware.R;
import com.example.mysoftware.controller.adapter.PickContactAdapter;
import com.example.mysoftware.model.Model;
import com.example.mysoftware.model.bean.PickContactInfo;
import com.example.mysoftware.model.bean.UserInfo;
import com.example.mysoftware.utils.Constant;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMGroup;

import java.util.ArrayList;
import java.util.List;

//选择联系人页面
public class PickContactActivity extends Activity {
    private TextView tv_pick_save;
    private ListView lv_pick;
    private PickContactAdapter pickContactAdapter;
    private List<PickContactInfo> mPicks;
    private List<String> mExistMembers = new ArrayList<>();//保存群中已经存在的成员集合


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_contact);

        //获取传传递过来的id
        getData();
        initView();

        initData();
        initListener();
    }
    public void getData(){
        String groupId = getIntent().getStringExtra(Constant.GROUP_ID);

        //判断是否从上一个页面传递过来的信息
        if(groupId != null ){
            EMGroup group = EMClient.getInstance().groupManager().getGroup(groupId);

            //获取群中已经存在的所有群成员
            mExistMembers = group.getMembers();
        }

        if(mExistMembers == null){
            mExistMembers = new ArrayList<>();
        }
    }
    public void initListener()
    {
        //listview条目点击事件
        lv_pick.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //view是布局,点击哪一个就是哪一个布局

                //CheckBox的切换
                CheckBox cb_pick = view.findViewById(R.id.cb_pick);
                cb_pick.setChecked(!cb_pick.isChecked());

                //修改数据
                PickContactInfo pickContactInfo= mPicks.get(position);
                pickContactInfo.setChecked(cb_pick.isChecked());

                //刷新页面
                pickContactAdapter.notifyDataSetChanged();
            }
        });

        tv_pick_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取到已经选择的联系人
                List<String> names = pickContactAdapter.getPickContacts();

                //给自动页面返回数据
                Intent intent = new Intent();

                intent.putExtra("members", names.toArray(new String[0]));

                //设置返回结果码
                setResult(RESULT_OK, intent);

                //结束当前页面
                finish();
            }
        });
    }
    private void initData() {
        //从本地数据库中获取所有的联系人信息
        List<UserInfo> contacts = Model.getInstance().getDBManager().getContactTableDao().getContacts();


        if(contacts != null && contacts.size() >= 0)
        {
            //替换
            for(UserInfo contact : contacts)
            {
                //默认都不没有被选中
                PickContactInfo pickContactInfo = new PickContactInfo(contact, false);

                mPicks = new ArrayList<>();

                mPicks.add(pickContactInfo);
            }
        }

        //初始化listview
        pickContactAdapter = new PickContactAdapter(this, mPicks, mExistMembers);

        lv_pick.setAdapter(pickContactAdapter);
    }

    private void initView()
    {
        tv_pick_save = findViewById(R.id.tv_pick_save);
        lv_pick = findViewById(R.id.lv_pick);
    }
}