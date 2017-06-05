package com.yzyfdf.lifehelper.bean.cookbean;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class MyCsBean {

    String name;
    String id;
    String ju;
    int type;

    public MyCsBean(String name, String id, String ju, int type) {
        this.name = name;
        this.id = id;
        this.ju = ju;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJu() {
        return ju;
    }

    public void setJu(String ju) {
        this.ju = ju;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
