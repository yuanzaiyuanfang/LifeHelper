package com.yzyfdf.lifehelper.bean.cookbean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class MyStepBean implements Serializable{
    public MyStepBean(List<CookRBean.CookstepBean> list, int index) {
        this.list = list;
        this.index = index;
    }

    List<CookRBean.CookstepBean> list;
    int                                                       index;

    public List<CookRBean.CookstepBean> getList() {
        return list;
    }

    public void setList(List<CookRBean.CookstepBean> list) {
        this.list = list;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
