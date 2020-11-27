package com.example.mysoftware.controller.pager;


import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mysoftware.controller.activity.NewsActivity;
import com.example.mysoftware.controller.domain.NewsCenterPagerBean;
import com.example.mysoftware.controller.domain.NewsCenterPagerBean2;
import com.example.mysoftware.controller.fragment.LeftmenuFragment;
import com.example.mysoftware.controller.fragment.NewsContentFragment;
import com.example.mysoftware.controller.pager.menudatailpager.InteracMenuDetailPager;
import com.example.mysoftware.controller.pager.menudatailpager.NewsMenuDetailPager;
import com.example.mysoftware.controller.pager.menudatailpager.PhotosMenuDetailPager;
import com.example.mysoftware.controller.pager.menudatailpager.TopicMenuDetailPager;
import com.example.mysoftware.controller.pager.menudatailpager.VoteMenuDetailPage;
import com.example.mysoftware.utils.CacheUtils;
import com.example.mysoftware.utils.Constants;
import com.example.mysoftware.utils.LogUtil;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class NewsCenterPager extends BasePager {
    /**
     * 左侧菜单对应的数据集合
     */
    private List<NewsCenterPagerBean2.DetailPagerData> data;

    private TextView textView;

    /**
     * 详情页面的集合
     */
    private ArrayList<MenuDetaiBasePager> detaiBasePagers;

    /**
     * 左侧菜单对应的数据集合
     */
//    private List<NewsCenterPagerBean2.DetailPagerData> data;

    public NewsCenterPager(Context context) {
        super(context);
    }
    @Override
    public void initData() {
        super.initData();
        LogUtil.e("主页面数据被初始化了..");
        //1.设置标题
        mtv_title.setText("主页面");

        ib_menu.setVisibility(View.VISIBLE);
        //2.联网请求，得到数据，创建视图
        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        //3.把子视图添加到BasePager的FrameLayout中
        fl_content.addView(textView);
        //4.绑定数据
        textView.setText("新闻页面内容");

        //得到缓存数据
        String saveJson = CacheUtils.getString(context,Constants.NEWSCENTER_PAGER_URL);//""


        if(!TextUtils.isEmpty(saveJson)){
            processData(saveJson);
        }


        //联网请求数据
        getDataFromNet();

    }

    private void getDataFromNet() {
        RequestParams params = new RequestParams(Constants.NEWSCENTER_PAGER_URL);
        x.http().get(params, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                LogUtil.e("xUtils请求ok"+result);

                //缓存数据
                CacheUtils.putString(context,Constants.NEWSCENTER_PAGER_URL,result);

                processData(result);
            }



            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e("xUtils请求err"+ex);
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void processData(String json) {
        //NewsCenterPagerBean bean = parsedJson(json);
        NewsCenterPagerBean2 bean = parsedJson2(json);

//        String title = bean.getData().get(0).getChildren().get(1).getTitle();
//        LogUtil.e("使用Gson解析数据成功"+title);
        String title2 = bean.getData().get(0).getChildren().get(1).getTitle();
        //LogUtil.e("使用Gson解析数据成功 NewsCenterPagerBean2 bean2 = parsedJson2(json);"+title);

        data = bean.getData();
        NewsActivity newsActivity = (NewsActivity) context;
        LeftmenuFragment leftmenuFragment = newsActivity.getLeftmenuFragment();


        detaiBasePagers = new ArrayList<>();
        detaiBasePagers.add(new NewsMenuDetailPager(context,data.get(0)));//新闻详情页面
        detaiBasePagers.add(new TopicMenuDetailPager(context));
        //detaiBasePagers.add(new TopicMenuDetailPager(context, data.get(0)));//专题详情页面
        detaiBasePagers.add(new PhotosMenuDetailPager(context));//图组详情页面
        detaiBasePagers.add(new InteracMenuDetailPager(context));//互动详情页面
        //detaiBasePagers.add(new VoteMenuDetailPage(context));
        //把数据传递给左侧菜单
        leftmenuFragment.setData(data);

    }
    /**
     * 使用Android系统自带的API解析json数据
     *
     * @param json
     * @return
     */
    private NewsCenterPagerBean2 parsedJson2(String json) {
        NewsCenterPagerBean2 bean2 = new NewsCenterPagerBean2();
        try {
            JSONObject object = new JSONObject(json);


            int retcode = object.optInt("retcode");
            bean2.setRetcode(retcode);//retcode字段解析成功

            JSONArray data = object.optJSONArray("data");
            if (data != null && data.length() > 0) {

                List<NewsCenterPagerBean2.DetailPagerData> detailPagerDatas = new ArrayList<>();
                //设置列表数据
                bean2.setData(detailPagerDatas);
                //for循环，解析每条数据
                for (int i = 0; i < data.length(); i++) {

                    JSONObject jsonObject = (JSONObject) data.get(i);

                    NewsCenterPagerBean2.DetailPagerData detailPagerData = new NewsCenterPagerBean2.DetailPagerData();
                    //添加到集合中
                    detailPagerDatas.add(detailPagerData);

                    int id = jsonObject.optInt("id");
                    detailPagerData.setId(id);
                    int type = jsonObject.optInt("type");
                    detailPagerData.setType(type);
                    String title = jsonObject.optString("title");
                    detailPagerData.setTitle(title);
                    String url = jsonObject.optString("url");
                    detailPagerData.setUrl(url);
                    String url1 = jsonObject.optString("url1");
                    detailPagerData.setUrl1(url1);
                    String dayurl = jsonObject.optString("dayurl");
                    detailPagerData.setDayurl(dayurl);
                    String excurl = jsonObject.optString("excurl");
                    detailPagerData.setExcurl(excurl);
                    String weekurl = jsonObject.optString("weekurl");
                    detailPagerData.setWeekurl(weekurl);


                    JSONArray children = jsonObject.optJSONArray("children");
                    if (children != null && children.length() > 0) {

                        List<NewsCenterPagerBean2.DetailPagerData.ChildrenData> childrenDatas  = new ArrayList<>();

                        //设置集合-ChildrenData
                        detailPagerData.setChildren(childrenDatas);

                        for (int j = 0; j < children.length(); j++) {
                            JSONObject childrenitem = (JSONObject) children.get(j);

                            NewsCenterPagerBean2.DetailPagerData.ChildrenData childrenData = new NewsCenterPagerBean2.DetailPagerData.ChildrenData();
                            //添加到集合中
                            childrenDatas.add(childrenData);


                            int childId = childrenitem.optInt("id");
                            childrenData.setId(childId);
                            String childTitle = childrenitem.optString("title");
                            childrenData.setTitle(childTitle);
                            String childUrl = childrenitem.optString("url");
                            childrenData.setUrl(childUrl);
                            int childType = childrenitem.optInt("type");
                            childrenData.setType(childType);

                        }

                    }


                }


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return bean2;
    }


    /**
     * 根据位置切换详情页面
     *
     * @param position
     */
    public void swichPager(int position) {

            //1.设置标题
            mtv_title.setText(data.get(position).getTitle());
            //2.移除之前内容
            fl_content.removeAllViews();//移除之前的视图

            //3.添加新内容
            MenuDetaiBasePager detaiBasePager = detaiBasePagers.get(position);//
            View rootView = detaiBasePager.rootView;
            detaiBasePager.initData();//初始化数据


            fl_content.addView(rootView);


//            if(position ==2){
//                //图组详情页面
//                ib_swich_list_grid.setVisibility(View.VISIBLE);
//                //设置点击事件
//                ib_swich_list_grid.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //1.得到图组详情页面对象
//                        PhotosMenuDetailPager detailPager = (PhotosMenuDetailPager) detaiBasePagers.get(2);
//                        //2.调用图组对象的切换ListView和GridView的方法
//                       // detailPager.swichListAndGrid(ib_swich_list_grid);
//                    }
//                });
//            }else{
//                //其他页面
//                ib_swich_list_grid.setVisibility(View.GONE);
//            }
//
//        }else{
//            Toast.makeText(context, "该页面还没有启用", Toast.LENGTH_SHORT).show();
//        }


    }

    private NewsCenterPagerBean parsedJson(String json) {

//        Gson gson = new Gson();
//
//        NewsCenterPagerBean bean = gson.fromJson(json, NewsCenterPagerBean.class);

        return new Gson().fromJson(json, NewsCenterPagerBean.class);
    }


}
