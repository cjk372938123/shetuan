package com.example.mysoftware.controller.fragment;

//import android.app.Activity;
//import android.app.FragmentTransaction;
////import android.support.v4.app.Fragment;
//import android.content.Context;
//import android.content.Intent;
//import android.database.DataSetObserver;
//import android.graphics.Color;
//import android.os.Handler;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.view.PagerAdapter;
//import android.support.v4.view.ViewPager;
//import android.support.v4.widget.DrawerLayout;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.support.v7.widget.ContentFrameLayout;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.StaggeredGridLayoutManager;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.View;
//
//import android.view.ViewGroup;
//import android.view.ViewTreeObserver;
//import android.widget.Adapter;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.BaseAdapter;
//import android.widget.Button;
//import android.widget.GridView;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.bumptech.glide.load.resource.bitmap.CenterInside;
//import com.example.mysoftware.R;
//import com.example.mysoftware.controller.activity.FindActivity;
//import com.example.mysoftware.controller.activity.LoginActivity;
//import com.example.mysoftware.controller.activity.MainActivity;
//import com.example.mysoftware.controller.activity.MainPageActivity;
//import com.example.mysoftware.controller.activity.community.practice.practiceMainActivity;
//import com.example.mysoftware.controller.activity.emptyActivity;
//import com.example.mysoftware.controller.adapter.GridViewAdapter;
//import com.example.mysoftware.controller.adapter.MainPageFragmentAdapter;
//
//import com.example.mysoftware.controller.adapter.StaggerAdapter;
//import com.example.mysoftware.controller.entity.MainPageEntity;
//import com.example.mysoftware.controller.listener.OnItemClickListener;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//
//public class MainPageFragment extends BaseFragment {
//
//    private Integer[] mImageIds = {R.mipmap.collect_selected,R.mipmap.collect_selected,R.mipmap.collect_selected,
//            R.mipmap.collect_selected,R.mipmap.collect_selected,R.mipmap.collect_selected};
//    private String[] mTitles = {"科技类","文艺类", "体育类",
//            "学术类", "服务类", "其他"};
//
//    //private RecyclerView gv_sagger;
//    private RecyclerView main_recyclerview;
//    private ImageView ib_top;
//    private TextView tv_search_home;
//    //private MainPageFragmentAdapter adapter;
//    private ViewPager mLoopPager;
//    private MainPageFragmentAdapter mMainPageFragmentAdapter;
//    private static List<Integer> sPics = new ArrayList<>();
//    private GridView gv;
//
//    private List<MainPageEntity> datas = new ArrayList<>();
//
//
//    static {
//        sPics.add(R.drawable.source1);
//        sPics.add(R.drawable.source2);
//        sPics.add(R.drawable.source3);
//    }
//
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        //View view = View.inflate(getActivity(), R.layout.activity_main_page, null);
//
//        View view = inflater.inflate(R.layout.activity_main_page, null);
//
//        initView(view);
//        return view;
//    }
//
//
//    @Override
//    protected int initLayout() {
//        return R.layout.activity_main_page;
//    }
//
//    @Override
//    protected void initView() {
//
//    }


//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        initData();
//    }
    //   protected void initView(View view) {
    // View view = View.inflate(mContext, R.layout.activity_main_page, null);
    //gv_sagger = (RecyclerView) view.findViewById(R.id.gv_sagger);
        /*
        返回顶部按钮
         */
    //ib_top = (ImageView) view.findViewById(R.id.ib_top);
//        tv_search_home = (TextView) view.findViewById(R.id.tv_search_home);
//        main_recyclerview = view.findViewById(R.id.main_recyclerview);
    //gv = view.findViewById(R.id.gv);
    //*****************************
//        mLoopPager = view.findViewById(R.id.looper_pager);
//
//        mLoopPager.setAdapter(mMainPageFragmentAdapter);
//        mLoopPager.setCurrentItem(100);
    //*****************************
    //main_recyclerview.setAdapter(new GridViewAdapter(getActivity()));
//        mMainPageFragmentAdapter = new MainPageFragmentAdapter();
//        GridViewAdapter gridViewAdapter = new GridViewAdapter(getActivity());
//        main_recyclerview.setAdapter(gridViewAdapter);


//        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (position)
//                {
//                    case 0:
//                        Intent intent = new Intent(getActivity(), practiceMainActivity.class);
//                        startActivity(intent);
//                        break;
//                    case 1:
//                        Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
//                        break;
//                    case 2:
//                        Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
//                        break;
//                    case 3:
//                        Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
//                        break;
//                    case 4:
//                        Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
//                        break;
//                    case 5:
//                        Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
//                        break;
//
//                }
//            }
//        });
    //  }
//    private class MyAdapter extends BaseAdapter {
//        private Integer[] mImageIds = {R.mipmap.collect_selected,R.mipmap.collect_selected,R.mipmap.collect_selected,
//                R.mipmap.collect_selected,R.mipmap.collect_selected,R.mipmap.collect_selected};
//        private String[] mTitles = {"科技类","文艺类", "体育类",
//                "学术类", "服务类", "其他"};
//
//        @Override
//        public int getCount() {
//            return 0;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            View view = null;
//            if(convertView == null)
//            {
//                LayoutInflater inflater = LayoutInflater.from(getActivity());
//                view = inflater.inflate(R.layout.item, null);
//
//                ImageView ivIcon = view.findViewById(R.id.iv_icon);
//                TextView tvTitle = view.findViewById(R.id.tv_title);
//
//                ivIcon.setBackgroundResource(mImageIds[position]);
//                tvTitle.setText(mTitles[position]);
//                tvTitle.setTextColor(Color.BLACK);
//            }else{
//                view = convertView;
//            }
//            return view;
//        }
//
//    }
//    @Override
//    protected void initData() {
        /*
        轮播图添加颜色做测试
         */
//        Random random = new Random();
//        for (int i = 0; i < 6; i++) {
//            sPics.add(Color.argb(random.nextInt(255), random.nextInt(255), random.nextInt(255), random.nextInt(255)));
//        }
//        mMainPageFragmentAdapter.setBannerData(sPics);
//        mMainPageFragmentAdapter.notifyDataSetChanged();
//        //置顶的监听
//        ib_top.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                main_recyclerview.scrollToPosition(0);
//            }
//        });
//        //搜素的监听
//        tv_search_home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "搜索", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        for (int i = 1; i <= 6; i++) {
//            MainPageEntity mainPageEntity = new MainPageEntity();
//            mainPageEntity.setType(i);
//            datas.add(mainPageEntity);
//        }
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        //gv_sagger.setLayoutManager(staggeredGridLayoutManager);
//
////        StaggerAdapter staggerAdapter = new StaggerAdapter(getActivity());
////        staggerAdapter.setDatas(datas);
////        gv_sagger.setAdapter(staggerAdapter);
//        mMainPageFragmentAdapter.setStaggerData(datas);
//  }
//
//}

//        //消息的监听
//        tv_message_home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, MessageCenterActivity.class);
//                mContext.startActivity(intent);
//            }
//        });

    //   }
//    private DrawerLayout mDrawerLayout;
//    private ListView mDrawerList;
//    private ArrayList<String> menuLists;
//    private ArrayAdapter<String> adapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_page);
//        mDrawerLayout = findViewById(R.id.drawer_layout);
//        mDrawerList = findViewById(R.id.left_drawer);
//        menuLists = new ArrayList<String>();
//
//        for (int i = 0; i < 6; i++) {
//            menuLists.add("A" + i);
//        }
//        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menuLists);
//        mDrawerList.setAdapter(adapter);
//        mDrawerList.setOnItemClickListener((AdapterView.OnItemClickListener) this);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public void onItemClick(int position) {
//        Fragment fragment = new Fragment();
//        Bundle args = new Bundle();
//        args.putString("text", menuLists.get(position));
//        fragment.setArguments(args);
//
//        FragmentManager fm = getFragmentManager();
//        fm.beginTransaction().replace(R.id.content_frame,  fragment).commit();
//        mDrawerLayout.closeDrawer(mDrawerList);
//    }

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mysoftware.R;

public class MainPageFragment extends BaseFragment {
    private static final String TAG =
            MainPageFragment.class.getSimpleName();
    private RecyclerView rvHome;
    private ImageView ib_top;
    private TextView tv_search_home;
    private TextView tv_message_home;

    @Override
    protected int initLayout() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        Log.e(TAG, " 主页视图被初始化了");
        View view = View.inflate(mContext, R.layout.fragment_home,
                null);
        rvHome = (RecyclerView) view.findViewById(R.id.rv_home);
        ib_top = (ImageView) view.findViewById(R.id.ib_top);
    }
}