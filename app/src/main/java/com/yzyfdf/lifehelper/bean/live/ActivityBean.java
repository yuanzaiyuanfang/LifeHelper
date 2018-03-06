package com.yzyfdf.lifehelper.bean.live;

/**
 * Created by MLRC-iOS-CI on 2018/1/10.
 */

public class ActivityBean {
    /**
     * activity_id : 000004q030000981
     * title : 家居店探店行动
     */

    private String activity_id;
    private String id;
    private String title;
    private int join_num;
    private String desc_color;
    private String desc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getJoin_num() {
        return join_num;
    }

    public void setJoin_num(int join_num) {
        this.join_num = join_num;
    }

    public String getDesc_color() {
        return desc_color;
    }

    public void setDesc_color(String desc_color) {
        this.desc_color = desc_color;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(String activity_id) {
        this.activity_id = activity_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
