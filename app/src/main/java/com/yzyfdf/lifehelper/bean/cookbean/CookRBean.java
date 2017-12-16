package com.yzyfdf.lifehelper.bean.cookbean;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class CookRBean implements Serializable {

    private int                id;
    private int                cook_id;
    private String             cookstory;
    private String             n;
    private String             img;
    private String             image;
    private int                stc;
    private int                sti;
    private int                dc;
    private int                fc;
    private String             an;
    private int                ecs;
    private int                hq;
    private ABean              a;
    private String             photo_path;
    private String             p;
    private String             cook_difficulty;
    private String             cook_time;
    private int                vc;
    private List<CookstepBean> cookstep;
    private List<MajorBean>    major;
    private List<MinorBean>    minor;
    private List<TagsBean>     tags;

    @Override
    public String toString() {
        return "CookRBean{" +
                "id=" + id +
                ", cookstory='" + cookstory + '\'' +
                ", n='" + n + '\'' +
                ", img='" + img + '\'' +
                ", stc=" + stc +
                ", sti=" + sti +
                ", dc=" + dc +
                ", fc=" + fc +
                ", an='" + an + '\'' +
                ", ecs=" + ecs +
                ", hq=" + hq +
                ", a=" + a +
                ", p='" + p + '\'' +
                ", cook_difficulty='" + cook_difficulty + '\'' +
                ", cook_time='" + cook_time + '\'' +
                ", vc=" + vc +
                ", cookstep=" + cookstep +
                ", major=" + major +
                ", minor=" + minor +
                ", tags=" + tags +
                '}';
    }

    public int getId() {
        return id == 0 ? cook_id : id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCook_id() {
        return cook_id;
    }

    public void setCook_id(int cook_id) {
        this.cook_id = cook_id;
    }

    public String getCookstory() {
        return cookstory;
    }

    public void setCookstory(String cookstory) {
        this.cookstory = cookstory;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImg() {
        return TextUtils.isEmpty(img) ? image : img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getStc() {
        return stc;
    }

    public void setStc(int stc) {
        this.stc = stc;
    }

    public int getSti() {
        return sti;
    }

    public void setSti(int sti) {
        this.sti = sti;
    }

    public int getDc() {
        return dc;
    }

    public void setDc(int dc) {
        this.dc = dc;
    }

    public int getFc() {
        return fc;
    }

    public void setFc(int fc) {
        this.fc = fc;
    }

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an;
    }

    public int getEcs() {
        return ecs;
    }

    public void setEcs(int ecs) {
        this.ecs = ecs;
    }

    public int getHq() {
        return hq;
    }

    public void setHq(int hq) {
        this.hq = hq;
    }

    public ABean getA() {
        return a;
    }

    public void setA(ABean a) {
        this.a = a;
    }

    public String getP() {
        return TextUtils.isEmpty(p) ? photo_path : p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public String getCook_difficulty() {
        return cook_difficulty;
    }

    public void setCook_difficulty(String cook_difficulty) {
        this.cook_difficulty = cook_difficulty;
    }

    public String getCook_time() {
        return cook_time;
    }

    public void setCook_time(String cook_time) {
        this.cook_time = cook_time;
    }

    public int getVc() {
        return vc;
    }

    public void setVc(int vc) {
        this.vc = vc;
    }

    public List<CookstepBean> getCookstep() {
        return cookstep;
    }

    public void setCookstep(List<CookstepBean> cookstep) {
        this.cookstep = cookstep;
    }

    public List<MajorBean> getMajor() {
        return major;
    }

    public void setMajor(List<MajorBean> major) {
        this.major = major;
    }

    public List<MinorBean> getMinor() {
        return minor;
    }

    public void setMinor(List<MinorBean> minor) {
        this.minor = minor;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class ABean implements Serializable {
        /**
         * id : 3084957
         * n : keletimes
         * v : 1
         * p : http://tx2.douguo.net/upload/photo/4/6/9/70_u75959639894837132612.jpg
         */

        private String id;
        private String n;
        private int    v;
        private String p;

        @Override
        public String toString() {
            return "ABean{" +
                    "id='" + id + '\'' +
                    ", n='" + n + '\'' +
                    ", v=" + v +
                    ", p='" + p + '\'' +
                    '}';
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getN() {
            return n;
        }

        public void setN(String n) {
            this.n = n;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public String getP() {
            return p;
        }

        public void setP(String p) {
            this.p = p;
        }
    }

    public static class CookstepBean implements Serializable {
        /**
         * position : 1
         * content : 牛腩入冷水锅烧开一分钟，焯水捞起，再放入高压锅加水、姜片、葱段、料酒和一个炖肉料包，压半小时左右关火
         * thumb : http://cp1.douguo.net/upload/caiku/5/e/a/140_5e83d3b09ea2f336a292621b92b7c1da.jpg
         * image : http://cp1.douguo.net/upload/caiku/5/e/a/600_5e83d3b09ea2f336a292621b92b7c1da.jpg
         */

        private String position;
        private String content;
        private String thumb;
        private String image;

        @Override
        public String toString() {
            return "CookstepBean{" +
                    "position='" + position + '\'' +
                    ", content='" + content + '\'' +
                    ", thumb='" + thumb + '\'' +
                    ", image='" + image + '\'' +
                    '}';
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class MajorBean implements Serializable {
        /**
         * title : 牛腩
         * note : 一斤
         */

        private String title;
        private String note;

        @Override
        public String toString() {
            return "MajorBean{" +
                    "title='" + title + '\'' +
                    ", note='" + note + '\'' +
                    '}';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }
    }

    public static class MinorBean implements Serializable {
        /**
         * title : 葱
         * note : 适量
         */

        private String title;
        private String note;

        @Override
        public String toString() {
            return "MinorBean{" +
                    "title='" + title + '\'' +
                    ", note='" + note + '\'' +
                    '}';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }
    }

    public static class TagsBean implements Serializable {
        /**
         * t : 家常菜
         */

        private String t;

        @Override
        public String toString() {
            return "TagsBean{" +
                    "t='" + t + '\'' +
                    '}';
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }
    }
}


