package com.example.mysoftware.controller.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mysoftware.R;
import com.example.mysoftware.controller.activity.GroupDetailActivity;
import com.example.mysoftware.model.bean.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class GroupDetailAdapter extends BaseAdapter {

    private Context mContext;
    private boolean mIsCanModify;//是否允许添加和删除群成员
    private List<UserInfo> mUsers = new ArrayList<>();
    private ImageView iv_group_detail_photo;
    private TextView tv_group_detail_name;
    private ImageView iv_group_detail_delete;
    private boolean mIsDeleteModel;//删除模式
    private OnGroupDetailListener mOnGroupDetailListener;

    public GroupDetailAdapter(Context context, boolean isCanModify, OnGroupDetailListener onGroupDetailListener)
    {
        mContext = context;
        mIsCanModify = isCanModify;
        mOnGroupDetailListener = onGroupDetailListener;
    }

    public void refresh(List<UserInfo> users)
    {
        if(users != null && users.size() >= 0)
        {
            mUsers.clear();
            initUsers();

            mUsers.addAll(0, users);
        }
        notifyDataSetChanged();
    }

    private void initUsers() {
        UserInfo add = new UserInfo("add");
        UserInfo delete = new UserInfo("delete");

        mUsers.add(delete);
        mUsers.add(0, add);
    }

    @Override
    public int getCount() {
        return mUsers == null ? 0 : mUsers.size();
    }

    @Override
    public Object getItem(int position) {
        return mUsers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //获取或者创建viewholder
        ViewHolder holder = null;
        if(convertView == null)
        {
            holder = new ViewHolder();

            convertView = View.inflate(mContext, R.layout.item_groupdetail, null);

            holder.photo = convertView.findViewById(R.id.iv_group_detail_photo);
            holder.name = convertView.findViewById(R.id.tv_group_detail_name);
            holder.delete = convertView.findViewById(R.id.iv_group_detail_delete);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //获取当前item数据
        UserInfo userInfo = mUsers.get(position);

        if(mIsCanModify)
        {//群主或开放了群权限
            if(position == getCount() - 1){//减号的处理
                //删除模式判断
                if(mIsDeleteModel){
                    convertView.setVisibility(View.INVISIBLE);
                }else{
                    convertView.setVisibility(View.VISIBLE);
                    holder.photo.setImageResource(R.drawable.em_smiley_minus_btn_pressed);
                    holder.delete.setVisibility(View.GONE);
                    holder.name.setVisibility(View.INVISIBLE);
                }
            }else if(position == getCount() - 2){//加号的处理
                if(mIsDeleteModel){
                    convertView.setVisibility(View.INVISIBLE);
                }else {
                    convertView.setVisibility(View.VISIBLE);
                    holder.photo.setImageResource(R.drawable.em_smiley_add_btn_pressed);
                    holder.delete.setVisibility(View.GONE);
                    holder.name.setVisibility(View.INVISIBLE);
                }
            }else {//群成员
                convertView.setVisibility(View.VISIBLE);
                holder.name.setVisibility(View.VISIBLE);

                holder.photo.setImageResource(R.drawable.em_default_avatar);
                holder.name.setText(userInfo.getName());

                if(mIsDeleteModel){
                    holder.delete.setVisibility(View.VISIBLE);
                }else{
                    holder.delete.setVisibility(View.GONE);
                }
            }

            //点击事件的处理
            if(position == getCount() - 1){//减号的位置
                holder.photo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!mIsDeleteModel){
                            mIsDeleteModel = true;
                            notifyDataSetChanged();
                        }
                    }
                });

            }else if(position == getCount() - 2){//加号的位置
                holder.photo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnGroupDetailListener.onAddMembers();
                    }
                });
            }else{
                holder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnGroupDetailListener.onDeleteMembers(userInfo);
                    }
                });
            }

        }else{
            if(position == getCount() - 1 || position == getCount() - 2){
                convertView.setVisibility(View.GONE);
            }else {
                convertView.setVisibility(View.VISIBLE);

                //名称
                holder.name.setText(userInfo.getName());

                //头像
                holder.photo.setImageResource(R.drawable.msg_1);

                //删除
                holder.delete.setVisibility(View.GONE);
            }
        }
        return convertView;
    }
    //获取当前的删除模式
    public boolean ismDeleteModel() {
        return mIsDeleteModel;
    }
    //设置当前的删除模式
    public void setmIsDeleteModel(boolean mIsDeleteModel)
    {
        this.mIsCanModify = mIsDeleteModel;
    }
    public class ViewHolder
    {
        private ImageView photo;
        private ImageView delete;
        private TextView name;
    }
    public interface OnGroupDetailListener{
        //添加群成员
        void onAddMembers();

        //删除群成员方法
        void onDeleteMembers(UserInfo user);
    }
}
