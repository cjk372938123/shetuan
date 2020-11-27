package com.example.mysoftware.controller.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysoftware.R;
import com.example.mysoftware.controller.activity.AddContactActivity;
import com.example.mysoftware.controller.activity.ChatActivity;
import com.example.mysoftware.controller.activity.GroupListActivity;
import com.example.mysoftware.controller.activity.InviteActivity;
import com.example.mysoftware.model.Model;
import com.example.mysoftware.model.bean.UserInfo;
import com.example.mysoftware.utils.Constant;
import com.example.mysoftware.utils.SpUtils;
import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.ui.EaseContactListFragment;
import com.hyphenate.easeui.widget.EaseContactList;
import com.hyphenate.exceptions.HyphenateException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactListFragment extends EaseContactListFragment {
    private ImageView iv_contact_red;
    private LocalBroadcastManager mLBM;
    private LinearLayout ll_contact_invite;
    private String mHxid;
    private LinearLayout ll_add_allperson;

    private BroadcastReceiver ContactChangeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //刷新页面
            refreshContact();
        }
    };
    private BroadcastReceiver ContactInviteChangeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //更新红点显示
            iv_contact_red.setVisibility(View.VISIBLE);
            SpUtils.getInstance().save(SpUtils.IS_NEW_INVITE, true);
        }
    };
    private BroadcastReceiver GroupChangeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //显示红点
            iv_contact_red.setVisibility( View.VISIBLE );
            SpUtils.getInstance().save( SpUtils.IS_NEW_INVITE, true );
        }
    };

    //联系人列表页面
    @Override
    protected void initView()
    {
        super.initView();

        //布局显示加号
        titleBar.setRightImageResource(R.drawable.em_add);

        //添加头布局
        View headerView = View.inflate(getActivity(), R.layout.header_fragment_contact, null);

        listView.addHeaderView(headerView);


        ll_add_allperson = headerView.findViewById(R.id.ll_add_allperson);

        //获取红点对象
        iv_contact_red = headerView.findViewById(R.id.iv_contact_red);

        ll_contact_invite = headerView.findViewById(R.id.ll_contact_invite);

        ll_add_allperson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });

        //设置listview条目的点击事件

        setContactListItemClickListener(new EaseContactListItemClickListener() {
            @Override
            public void onListItemClicked(EaseUser user) {
                if(user == null)
                {
                    return;
                }
                Intent intent = new Intent(getActivity(), ChatActivity.class);

                //传递参数
                intent.putExtra(EaseConstant.EXTRA_USER_ID,user.getUsername());

                startActivity(intent);
            }
        });

        LinearLayout ll_contact_group = headerView.findViewById( R.id.ll_contact_group );
        ll_contact_group.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity(), GroupListActivity.class);
                startActivity( intent );
            }
        } );
    }
    private void add() {
        Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                //去环信服务器添加好友
                try{
                    EMClient.getInstance().contactManager().addContact("1", "添加好友");
                    EMClient.getInstance().contactManager().addContact("2", "添加好友");
                    EMClient.getInstance().contactManager().addContact("3", "添加好友");
                    EMClient.getInstance().contactManager().addContact("4", "添加好友");
                    EMClient.getInstance().contactManager().addContact("5", "添加好友");
                    EMClient.getInstance().contactManager().addContact("6", "添加好友");
                    EMClient.getInstance().contactManager().addContact("7", "添加好友");
                    EMClient.getInstance().contactManager().addContact("8", "添加好友");
                    EMClient.getInstance().contactManager().addContact("9", "添加好友");
                    EMClient.getInstance().contactManager().addContact("10", "添加好友");
                    EMClient.getInstance().contactManager().addContact("11", "添加好友");
                    EMClient.getInstance().contactManager().addContact("12", "添加好友");
                    EMClient.getInstance().contactManager().addContact("13", "添加好友");
                    EMClient.getInstance().contactManager().addContact("14", "添加好友");
                    EMClient.getInstance().contactManager().addContact("15", "添加好友");
                    EMClient.getInstance().contactManager().addContact("16", "添加好友");
                    EMClient.getInstance().contactManager().addContact("17", "添加好友");
                    EMClient.getInstance().contactManager().addContact("18", "添加好友");
                    EMClient.getInstance().contactManager().addContact("19", "添加好友");
                    EMClient.getInstance().contactManager().addContact("20", "添加好友");
                    EMClient.getInstance().contactManager().addContact("21", "添加好友");
                    EMClient.getInstance().contactManager().addContact("22", "添加好友");
                    EMClient.getInstance().contactManager().addContact("23", "添加好友");
                    EMClient.getInstance().contactManager().addContact("24", "添加好友");
                    EMClient.getInstance().contactManager().addContact("25", "添加好友");
                    EMClient.getInstance().contactManager().addContact("26", "添加好友");



//
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(AddContactActivity.this, "添加服务人员成功,当服务人员在线会自动显示在您的列表", Toast.LENGTH_SHORT).show();
//                        }
//                    });
                    //finish();
                }catch(final HyphenateException e)
                {
                    e.printStackTrace();
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(AddContactActivity.this, "发送添加好友邀请失败" + e.toString(),Toast.LENGTH_SHORT).show();
//                        }
//                    });
                }

            }
        });
    }
    @Override
    protected void setUpView()
    {
        super.setUpView();

        //添加按钮的点击事件处理
        titleBar.setRightLayoutClickListener(v -> {
            Intent intent = new Intent(getActivity(), AddContactActivity.class);
            startActivity(intent);
        });
        boolean isNewInvite = SpUtils.getInstance().getBoolean(SpUtils.IS_NEW_INVITE, false);
        iv_contact_red.setVisibility(isNewInvite ? View.VISIBLE : View.GONE);

        //邀请信息条目点击事件
        ll_contact_invite.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //红点处理(关闭红点)
                iv_contact_red.setVisibility(View.GONE);
                SpUtils.getInstance().save(SpUtils.IS_NEW_INVITE, false);
                //跳转到邀请信息列表页面
                Intent intent = new Intent(getActivity(), InviteActivity.class);

                startActivity(intent);
            }
        });

        //注册广播
        mLBM = LocalBroadcastManager.getInstance(getActivity());
        //注册联系人邀请的广播
        mLBM.registerReceiver(ContactInviteChangeReceiver, new IntentFilter(Constant.CONTACT_INVITE_CHANGED));
        //注册联系人变化的广播
        mLBM.registerReceiver(ContactChangeReceiver, new IntentFilter(Constant.CONTACT_CHANGED));
        //注册群邀请信息变化的广播
        mLBM.registerReceiver(GroupChangeReceiver, new IntentFilter(Constant.GROUP_INVITE_CHANGED));

        //从环信服务器获取所有联系人信息
        getContactFromHxServer();

        //绑定listview和contextmenu
        registerForContextMenu(listView);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //获取点击的对象(两个实现类AdapterContextMenuInfo可以获取位置)
        int position = ((AdapterView.AdapterContextMenuInfo)menuInfo).position;
        EaseUser easeUser = (EaseUser) listView.getItemAtPosition(position);
        mHxid = easeUser.getUsername();

        //添加布局
        getActivity().getMenuInflater().inflate(R.menu.delete, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //点击删除按钮之后做的事情
        if(item.getItemId() == R.id.contact_delete)
        {
            deleteContact();
        }
        return true;//把事件消费掉
    }

    private void deleteContact() {
        Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                //从环信服务器中删除联系人
                try{
                    EMClient.getInstance().contactManager().deleteContact(mHxid);

                    //本地数据库更新
                    Model.getInstance().getDBManager().getContactTableDao().deleteContactByHxId(mHxid);

                    if(getActivity() == null)
                    {
                        return;
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(), "删除"+mHxid+"成功", Toast.LENGTH_SHORT).show();
                            //刷新页面
                            refreshContact();
                        }
                    });
                    //刷新页面
                } catch (HyphenateException e) {
                    e.printStackTrace();

                    if(getActivity() == null)
                    {
                        return;
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(), "删除" + mHxid + "失败", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    //从环信服务器获取所有联系人信息
    private void getContactFromHxServer()
    {
        Model.getInstance().getGlobalThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                try{
                    //获取到所有的好友的环信id
                    List<String> hxids = EMClient.getInstance().contactManager().getAllContactsFromServer();

                    if(hxids != null && hxids.size() >= 0){
                        List<UserInfo> contacts = new ArrayList<UserInfo>();

                        //转换
                        for(String hxid : hxids)
                        {
                            UserInfo userInfo = new UserInfo(hxid);
                            contacts.add(userInfo);
                        }
                        //保存好友信息到本地数据库
                        Model.getInstance().getDBManager().getContactTableDao().saveContacts(contacts, true);
                        //刷新页面(getActivity在子线程调用要注意判断,不判断在切换页面过程中获取不到页面有可能会出现空指针异常)
                        if(getActivity() == null)
                        {
                            return;
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                refreshContact();
                            }
                        });
                    }
                } catch (HyphenateException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void refreshContact()
            /*
            因为继承了EaseContactListFragment, 不能随便刷新界面
             */
    {
        //获取数据
        List<UserInfo> contacts = Model.getInstance().getDBManager().getContactTableDao().getContacts();
        //校验
        if(contacts != null && contacts.size() >= 0)
        {
            //设置数据
            Map<String, EaseUser> contactsMap = new HashMap<>();

            //转换
            for(UserInfo contact:contacts)
            {
                EaseUser easeUser = new EaseUser(contact.getHxid());
                contactsMap.put(contact.getHxid(), easeUser);
            }
            setContactsMap(contactsMap);
            //刷新界面
            refresh();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //关闭广播
        mLBM.unregisterReceiver( ContactInviteChangeReceiver );
        //关闭广播
        mLBM.unregisterReceiver( ContactChangeReceiver );
        mLBM.unregisterReceiver( GroupChangeReceiver );
        mLBM.unregisterReceiver(GroupChangeReceiver);
    }
}
