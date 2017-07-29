package com.example.administrator.hlfrobot.ui.connect.child;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.pm.ActivityInfoCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.administrator.hlfrobot.R;
import com.example.administrator.hlfrobot.adapter.ActionLvAdapter;
import com.example.administrator.hlfrobot.base.BaseActivity;
import com.example.administrator.hlfrobot.model.ActionBean;
import com.example.administrator.hlfrobot.utils.Urls;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ActionActivity extends BaseActivity {

    private ExpandableListView actionLv;
    private ActionLvAdapter mActionLvAdapter;

//    public String DEFAULT_URL = "http://localhost:8080/okhttp/postString";
    public String DEFAULT_URL = "http://192.168.1.85:8080/";

    private String[] body = new String[]{"头部", "手部", "行动","综合"};
    //    private List<String> body;
    private Map<String, List<ActionBean>> actionInfo;

    private List<ActionBean> bean1;
    private List<ActionBean> bean2;
    private List<ActionBean> bean3;
    private List<ActionBean> bean4;

    public static final MediaType JSON = MediaType.parse("text/plain;charset=utf-8");

    private Toolbar mToolbar;

    @Override
    protected int setLayout() {
        return R.layout.activity_action;
    }

    @Override
    protected void initViews() {
        actionLv = bindView(R.id.action_lv);
        mToolbar = bindView(R.id.back_toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        actionLv.setGroupIndicator(null);

        mActionLvAdapter = new ActionLvAdapter(this);
        actionLv.setAdapter(mActionLvAdapter);
        actionInfo = new HashMap<>();

        // 子

        int img1 = R.drawable.ic_robot_head;
        int img2 = R.drawable.ic_robot_hand;
        int img3 = R.drawable.ic_robot_motion;
        int img4 = R.drawable.ic_robot_all;
        bean1 = new ArrayList<>();
        bean1.add(new ActionBean("摇头", img1));
        bean1.add(new ActionBean("动眼珠", img1));
        bean1.add(new ActionBean("眨眼", img1));
        bean1.add(new ActionBean("张嘴", img1));
        bean1.add(new ActionBean("笑", img1));
        bean1.add(new ActionBean("哭", img1));


        bean1.add(new ActionBean("生气", img1));
        bean1.add(new ActionBean("高兴", img1));
        bean1.add(new ActionBean("惊讶", img1));
        bean1.add(new ActionBean("打哈欠", img1));

       


        bean2 = new ArrayList<>();
        bean2.add(new ActionBean("抱抱", img2));
        bean2.add(new ActionBean("比心", img2));
        bean2.add(new ActionBean("手叉腰", img2));
        bean2.add(new ActionBean("挥手", img2));
        bean2.add(new ActionBean("举手", img2));
        bean2.add(new ActionBean("伸手", img2));
        bean2.add(new ActionBean("握手", img2));
        bean2.add(new ActionBean("抬手", img2));
        bean2.add(new ActionBean("动手", img2));
        bean2.add(new ActionBean("拍手", img2));
        bean2.add(new ActionBean("摆手", img2));
        bean2.add(new ActionBean("拱手", img2));


        bean3 = new ArrayList<>();


        bean3.add(new ActionBean("转弯", img3));
        bean3.add(new ActionBean("前进", img3));
        bean3.add(new ActionBean("后退", img3));
        bean3.add(new ActionBean("左转", img3));
        bean3.add(new ActionBean("右转", img3));

        bean4 = new ArrayList<>();
        bean4.add(new ActionBean("跳舞", img4));
        // 父
        actionInfo.put(body[0], bean1);
        actionInfo.put(body[1], bean2);
        actionInfo.put(body[2], bean3);
        actionInfo.put(body[3], bean4);

        mActionLvAdapter.setBody(body);
        mActionLvAdapter.setDetailAction(actionInfo);

        actionLv.setAdapter(mActionLvAdapter);

        actionLv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long id) {
                String mode = "body";
                String action = "默认";

                switch (groupPosition) {


                    case 0:
                        switch (childPosition) {
                            case 0:
                                action = "摇头";
                                break;
                            case 1:
                                action = "动眼珠";
                                break;
                            case 2:
                                action = "眨眼";
                                break;
                            case 3:
                                action = "张嘴";
                                break;
                            case 4:
                                action = "笑";
                                break;
                            case 5:
                                action = "哭";
                                break;
                            case 6:
                                action = "生气";
                                break;
                            case 7:
                                action = "高兴";
                                break;
                            case 8:
                                action = "惊讶";
                                break;
                            case 9:
                                action = "打哈欠";

                            default:
                                break;
                        }
                        break;
                    case 1:
                        switch (childPosition) {

                            case 0:
                                action = "挥手";
                                break;
                            case 1:
                                action = "举手";
                                break;
                            case 2:
                                action = "伸手";
                                break;
                            case 3:
                                action = "握手";
                                break;
                            case 4:
                                action = "抬手";
                                break;
                            case 5:
                                action = "动手";
                                break;
                            case 6:
                                action = "拍手";
                                break;
                            case 7:
                                action = "摆手";
                                break;
                            case 8:
                                action = "拱手";
                                break;
                            case 9:
                                action = "抱抱";
                                break;
                            case 10:
                                action = "比心";
                                break;
                            case 11:
                                action = "手叉腰";
                                break;
                            case 12:
                                action = "弯腰";
                            default:
                                break;
                        }
                        break;
                    case 2:

                        switch (childPosition) {
                            case 0:
                                action = "转弯";
                                break;
                            case 1:
                                action = "前进";
                                break;
                            case 2:
                                action = "后退";
                                break;
                            case 3:
                                action = "左转";
                                break;
                            case 4:
                                action = "右转";
                                break;


                            default:
                                break;
                        }

                        break;
                    case 3:
                        action = "跳舞";
                        break;

                }
                final JSONObject actionJson = new JSONObject();
                try {
                    actionJson.put("mode", "body");
                    actionJson.put("bodyval", action);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                new Thread() {
                    @Override
                    public void run() {
                        postActionJson(actionJson.toString());
                        Log.d("4152637", actionJson.toString());

                    }
                }.start();

                return false;
            }
        });

        for (int i = 0; i < mActionLvAdapter.getGroupCount(); i++) {
            actionLv.expandGroup(i);
        }

//        actionLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//
//            }
//        });

        // postActionJson();


    }

    private void postActionJson(String json) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        RequestBody requestBody = RequestBody.create(JSON, json);


        Request request = null;

        try {
            request = new Request.Builder()
                    .url(DEFAULT_URL)
                    .removeHeader("User-Agent")
                    .addHeader("User-Agent", Urls.USER_AGENT) // "HLFROBOT"
                    .addHeader("Host", "localhost:8000")
                    .addHeader("Connection", "Keep-Alive")
                    .addHeader("Accept-Encoding", "gzip")
                    .addHeader("Content-Length", String.valueOf(requestBody.contentLength()))
                    .post(requestBody)
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //发送请求获取响应
        try {
            Response response = okHttpClient.newCall(request).execute();
            Log.d("getResponse", "response.code():" + response.code());
            //判断请求是否成功
            if (response.isSuccessful()) {
                //打印服务端返回结果
                Log.e("getResponse", response.code() + "postJson: 1");
                Log.d("postJson", response.body().string());
            } else {
                Log.e("get", "postJson: 2");
                Log.d("postJson", "response.code():" + response.code());
            }
        } catch (IOException e) {
            Log.e("get", "postJson: 3");
            e.printStackTrace();
        }

    }



}
