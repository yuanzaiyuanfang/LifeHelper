package com.yzyfdf.lifehelper.bean.travel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class MyImpressBean implements Serializable{
    String       desc;
    String       location;
    String       writeTime;
    String       from;
    List<String> imageList;

    String userIcon;
    String userName;
    String url;
    float rating;

    public MyImpressBean(String desc, String location, String writeTime, String from, List<String> imageList, String userIcon, String userName, String url, float rating) {
        this.desc = desc;
        this.location = location;
        this.writeTime = writeTime;
        this.from = from;
        this.imageList = imageList;
        this.userIcon = userIcon;
        this.userName = userName;
        this.url = url;
        this.rating = rating;
    }

    public MyImpressBean(String desc, String location, String writeTime, String from, List<String> imageList, String userIcon, String userName, float rating) {
        this.desc = desc;
        this.location = location;
        this.writeTime = writeTime;
        this.from = from;
        this.imageList = imageList;
        this.userIcon = userIcon;
        this.userName = userName;
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(String writeTime) {
        this.writeTime = writeTime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
