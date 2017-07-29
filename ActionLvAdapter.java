package com.example.administrator.hlfrobot.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.hlfrobot.R;
import com.example.administrator.hlfrobot.model.ActionBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/28.
 */

public class ActionLvAdapter extends BaseExpandableListAdapter{

//    public List<String> body;
    private String[] body = new String[]{"头部","手部","行动","综合"};

    private Context mContext;
    public Map<String,List<ActionBean>> detailAction;
    private GridView mGridView;

    private List<ActionBean> list1;
    private List<ActionBean> list2;
    private List<ActionBean> list3;
    private List<ActionBean> list4;



    //    private String[][] detailAction = {}
    public ActionLvAdapter(Context context){
        mContext = context;
    }

    public void setBody( String[] body) {
        this.body = body;
        notifyDataSetChanged();
    }

    public void setDetailAction(Map<String, List<ActionBean>> detailAction) {
        this.detailAction = detailAction;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return body == null ? 0 :body.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        List<ActionBean> list = detailAction.get(body[groupPosition]);
        return list == null ? 0 : detailAction.get(body[groupPosition]).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return body == null ? null : body[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        List<ActionBean> list = detailAction.get(body[groupPosition]);
        return list.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
   //todo
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        BodyVH bodyVH = null;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_body,parent,false);
            bodyVH = new BodyVH(convertView);
            convertView.setTag(bodyVH);
        }else {
            bodyVH = (BodyVH) convertView.getTag();
        }
        if (!isExpanded){
            switch(groupPosition){
                case 0:
                    bodyVH.bodyIv.setImageResource(R.drawable.ic_robot_head);
                    break;
                case 1:
                    bodyVH.bodyIv.setImageResource(R.drawable.ic_robot_hand);
                    break;
                case 2:
                    bodyVH.bodyIv.setImageResource(R.drawable.ic_robot_motion);
                    break;
                case 3:
                    bodyVH.bodyIv.setImageResource(R.drawable.ic_robot_all);

                    break;
            }

        }else {
            bodyVH.bodyIv.setImageResource(R.drawable.ic_down_arrow);
        }

        bodyVH.bodyTv.setText(body[groupPosition]);
//        bodyVH.bodyTv.setText("adb");

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent){
        ActionVH actionVH = null;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_action,parent,false);
            actionVH = new ActionVH(convertView);
            convertView.setTag(actionVH);
        }else {
            actionVH = (ActionVH) convertView.getTag();
        }

        // 子
        int img1 = R.drawable.ic_robot_head;
        int img2 = R.drawable.ic_robot_hand;
        int img3 = R.drawable.ic_robot_motion;
        int img4 = R.drawable.ic_robot_all;
        list1 = new ArrayList<>();
        list1.add(new ActionBean("摇头",img1));
        list1.add(new ActionBean("动眼珠",img1));
        list1.add(new ActionBean("眨眼",img1));
        list1.add(new ActionBean("张嘴",img1));
        list1.add(new ActionBean("笑",img1));
        list1.add(new ActionBean("哭",img1));

        list1.add(new ActionBean("生气",img1));
        list1.add(new ActionBean("高兴",img1));
        list1.add(new ActionBean("惊讶",img1));
        list1.add(new ActionBean("打哈欠",img1));




        list2 = new ArrayList<>();
        list2.add(new ActionBean("挥手",img2));
        list2.add(new ActionBean("举手",img2));
        list2.add(new ActionBean("伸手",img2));
        list2.add(new ActionBean("握手",img2));
        list2.add(new ActionBean("抬手",img2));
        list2.add(new ActionBean("动手",img2));
        list2.add(new ActionBean("拍手",img2));
        list2.add(new ActionBean("摆手",img2));
        list2.add(new ActionBean("拱手",img2));
        list2.add(new ActionBean("抱抱",img2));
        list2.add(new ActionBean("比心",img2));
        list2.add(new ActionBean("手叉腰",img2));
        list2.add(new ActionBean("弯腰",img2));

        list3 = new ArrayList<>();


        list3.add(new ActionBean("转弯",img3));
        list3.add(new ActionBean("前进",img3));
        list3.add(new ActionBean("后退",img3));
        list3.add(new ActionBean("左转",img3));
        list3.add(new ActionBean("右转",img3));


        list4 = new ArrayList<>();
        list4.add(new ActionBean("跳舞",img4));

        detailAction.put(body[0],list1);
        detailAction.put(body[1],list2);
        detailAction.put(body[2],list3);
        detailAction.put(body[3],list4);

       switch(groupPosition){
           case 0:
              
               actionVH.actionTv.setText(list1.get(childPosition).getBodyAction());
               actionVH.actionIv.setImageResource(img1);
               break;
           case 1:
               actionVH.actionTv.setText(list2.get(childPosition).getBodyAction());
               actionVH.actionIv.setImageResource(img2);
               break;
           case 2:
               actionVH.actionTv.setText(list3.get(childPosition).getBodyAction());
               actionVH.actionIv.setImageResource(img3);
               break;
           case 3:
               actionVH.actionTv.setText(list4.get(childPosition).getBodyAction());
               actionVH.actionIv.setImageResource(img3);
               break;
       }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    // 父
    class BodyVH{
        TextView bodyTv;
        ImageView bodyIv;

        public BodyVH(View view){
            bodyTv = (TextView) view.findViewById(R.id.body_tv);
            bodyIv = (ImageView) view.findViewById(R.id.body_iv);
        }
    }

    // 子
    class ActionVH{
        TextView actionTv;
        ImageView actionIv;
        public ActionVH(View view){
            actionTv  = (TextView)view.findViewById(R.id.action_tv);
            actionIv = (ImageView)view.findViewById(R.id.action_iv);
        }
    }
}
