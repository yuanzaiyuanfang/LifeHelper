package com.yzyfdf.lifehelper.bean.travel;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class MyFoundBean {
    String title;
    TravelFoundBean.DataBean.GuidesBean mGuidesBean;

    public MyFoundBean(String title) {
        this.title = title;
    }

    public MyFoundBean(String title, TravelFoundBean.DataBean.GuidesBean guidesBean) {
        this.title = title;
        mGuidesBean = guidesBean;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TravelFoundBean.DataBean.GuidesBean getGuidesBean() {
        return mGuidesBean;
    }

    public void setGuidesBean(TravelFoundBean.DataBean.GuidesBean guidesBean) {
        mGuidesBean = guidesBean;
    }
}
