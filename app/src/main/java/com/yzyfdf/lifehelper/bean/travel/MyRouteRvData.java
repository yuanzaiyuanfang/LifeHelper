package com.yzyfdf.lifehelper.bean.travel;

import java.util.ArrayList;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class MyRouteRvData {
    private ArrayList<MyItineraryBean> list;
    private ArrayList<String>          menuList;

    public MyRouteRvData() {
    }

    public MyRouteRvData(ArrayList<MyItineraryBean> list, ArrayList<String> menuList) {
        this.list = list;
        this.menuList = menuList;
    }

    public ArrayList<MyItineraryBean> getList() {
        return list;
    }

    public void setList(ArrayList<MyItineraryBean> list) {
        this.list = list;
    }

    public ArrayList<String> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<String> menuList) {
        this.menuList = menuList;
    }
}
