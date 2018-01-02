package com.yzyfdf.lifehelper.bean.live;

import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class LiveUserInfoBean {
    /**
     * uid : 11941
     * nick : 好好住
     * gender : 1
     * area : 1,382
     * type : 0
     * avatar_version : 4
     * profile : 好好住APP官方帐(导)号(游)
     * status : 1
     * emblem_adorn : {}
     * emblem : []
     * decoration_status : 4
     * cover_img :
     * is_watermarking : 0
     * avatar : http://img.hhz1.cn/Pic-imageShow/sq_big/0000097p?iv=1&v=4
     * big_avatar : http://img.hhz1.cn/Pic-imageShow/sq_640/0000097p?iv=1&v=4
     */

    private String          uid;
    private String          nick;
    private String          gender;
    private String          area;
    private String          type;
    private String          avatar_version;
    private String          profile;
    private String          status;
    private EmblemAdornBean emblem_adorn;
    private String          decoration_status;
    private String          cover_img;
    private String          is_watermarking;
    private String          avatar;
    private String          big_avatar;
    private List<?>         emblem;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvatar_version() {
        return avatar_version;
    }

    public void setAvatar_version(String avatar_version) {
        this.avatar_version = avatar_version;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmblemAdornBean getEmblem_adorn() {
        return emblem_adorn;
    }

    public void setEmblem_adorn(EmblemAdornBean emblem_adorn) {
        this.emblem_adorn = emblem_adorn;
    }

    public String getDecoration_status() {
        return decoration_status;
    }

    public void setDecoration_status(String decoration_status) {
        this.decoration_status = decoration_status;
    }

    public String getCover_img() {
        return cover_img;
    }

    public void setCover_img(String cover_img) {
        this.cover_img = cover_img;
    }

    public String getIs_watermarking() {
        return is_watermarking;
    }

    public void setIs_watermarking(String is_watermarking) {
        this.is_watermarking = is_watermarking;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBig_avatar() {
        return big_avatar;
    }

    public void setBig_avatar(String big_avatar) {
        this.big_avatar = big_avatar;
    }

    public List<?> getEmblem() {
        return emblem;
    }

    public void setEmblem(List<?> emblem) {
        this.emblem = emblem;
    }

    public static class EmblemAdornBean {
    }
}
