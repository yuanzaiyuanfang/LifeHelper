package com.yzyfdf.lifehelper.bean.cookbean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class MyStepBean implements Serializable{
    public MyStepBean(List<CookMainBean.ResultBean.ListBean.RBean.CookstepBean> list, int index) {
        this.list = list;
        this.index = index;
    }

    List<CookMainBean.ResultBean.ListBean.RBean.CookstepBean> list;
    int                                                       index;

    public List<CookMainBean.ResultBean.ListBean.RBean.CookstepBean> getList() {
        return list;
    }

    public void setList(List<CookMainBean.ResultBean.ListBean.RBean.CookstepBean> list) {
        this.list = list;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
