package com.yzyfdf.lifehelper.bean.cookbean;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class MyFavoriteBean {
    String id;
    CookMainBean.ResultBean.ListBean.RBean rBean;
    boolean delete;

    @Override
    public String toString() {
        return "MyFavoriteBean{" +
                "id='" + id + '\'' +
                ", rBean=" + rBean +
                ", delete=" + delete +
                '}';
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public MyFavoriteBean(String id, CookMainBean.ResultBean.ListBean.RBean rBean) {
        this.id = id;
        this.rBean = rBean;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CookMainBean.ResultBean.ListBean.RBean getrBean() {
        return rBean;
    }

    public void setrBean(CookMainBean.ResultBean.ListBean.RBean rBean) {
        this.rBean = rBean;
    }

}
