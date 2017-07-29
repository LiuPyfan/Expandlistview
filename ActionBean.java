package com.example.administrator.hlfrobot.model;

/**
 * Created by Administrator on 2017/7/28.
 */

public class ActionBean {
    private String bodyAction;
    private int bodyActionIv;
    public ActionBean() {
    }

    public ActionBean(String bodyAction) {
        this.bodyAction = bodyAction;
    }

    public ActionBean(String bodyAction, int bodyActionIv) {
        this.bodyAction = bodyAction;
        this.bodyActionIv = bodyActionIv;
    }

    public String getBodyAction() {
        return bodyAction;
    }

    public void setBodyAction(String bodyAction) {
        this.bodyAction = bodyAction;
    }

    public int getBodyActionIv() {
        return bodyActionIv;
    }

    public void setBodyActionIv(int bodyActionIv) {
        this.bodyActionIv = bodyActionIv;
    }
}
