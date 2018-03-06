package com.yzyfdf.lifehelper.bean.live;

import java.util.List;

/**
 * Created by MLRC-iOS-CI on 2018/1/10.
 */

public class PhotoInfoBean {
    /**
     * id : 0011lrt000000mjc
     * pic_url : http://img.hhz1.cn/App-imageShow/sq_phone/079/183cd22732qw00000p287gb?iv=1&w=750&h=750&fmt=webp
     * new_pic_url : http://img.hhz1.cn/App-imageShow/o_nphone/079/183cd22732qw00000p287gb?iv=1&w=750&h=937.82929399368&fmt=webp
     * thumb_pic_url : http://img.hhz1.cn/App-imageShow/sq_thumb/079/183cd22732qw00000p287gb?iv=1&w=230&h=230&fmt=webp
     * ori_pic_url : http://img.hhz1.cn/App-imageShow/o_phbig/ae6/12d2622743b400000p287ga?iv=1&w=1080&h=1626.0674157303&fmt=webp
     * o_500_url : http://img.hhz1.cn/App-imageShow/o_500/079/183cd22732qw00000p287gb?iv=1&w=500&h=625.21952932912&fmt=webp
     * remark : #商业空间 #失物招领lostandfound
     * house_type : 0
     * admin_score : 0
     * is_liked : 0
     * is_relevance : 0
     * is_favorited : 0
     * is_join_article : 0
     * share_url : https://m.haohaozhu.com/tupian/0011lrt000000mjc.html
     * addtime : 1515396540
     * status : 0
     * has_goods : 0
     * is_origin : 1
     * tags : [{"center_local":{"x":0.56977775065104,"y":0.51385924251857,"arrow":0},"type":1,"activity":{"id":"000004q030000981","title":"家居店探店行动","join_num":3158,"desc_color":"#2DB7B5","desc":""}}]
     */

    private String id;
    private String pic_url;
    private String new_pic_url;
    private String thumb_pic_url;
    private String ori_pic_url;
    private String o_500_url;
    private String remark;
    private String house_type;
    private String admin_score;
    private int is_liked;
    private int is_relevance;
    private int is_favorited;
    private int is_join_article;
    private String share_url;
    private String addtime;
    private String status;
    private int has_goods;
    private String is_origin;
    private List<TagsBean> tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getNew_pic_url() {
        return new_pic_url;
    }

    public void setNew_pic_url(String new_pic_url) {
        this.new_pic_url = new_pic_url;
    }

    public String getThumb_pic_url() {
        return thumb_pic_url;
    }

    public void setThumb_pic_url(String thumb_pic_url) {
        this.thumb_pic_url = thumb_pic_url;
    }

    public String getOri_pic_url() {
        return ori_pic_url;
    }

    public void setOri_pic_url(String ori_pic_url) {
        this.ori_pic_url = ori_pic_url;
    }

    public String getO_500_url() {
        return o_500_url;
    }

    public void setO_500_url(String o_500_url) {
        this.o_500_url = o_500_url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHouse_type() {
        return house_type;
    }

    public void setHouse_type(String house_type) {
        this.house_type = house_type;
    }

    public String getAdmin_score() {
        return admin_score;
    }

    public void setAdmin_score(String admin_score) {
        this.admin_score = admin_score;
    }

    public int getIs_liked() {
        return is_liked;
    }

    public void setIs_liked(int is_liked) {
        this.is_liked = is_liked;
    }

    public int getIs_relevance() {
        return is_relevance;
    }

    public void setIs_relevance(int is_relevance) {
        this.is_relevance = is_relevance;
    }

    public int getIs_favorited() {
        return is_favorited;
    }

    public void setIs_favorited(int is_favorited) {
        this.is_favorited = is_favorited;
    }

    public int getIs_join_article() {
        return is_join_article;
    }

    public void setIs_join_article(int is_join_article) {
        this.is_join_article = is_join_article;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHas_goods() {
        return has_goods;
    }

    public void setHas_goods(int has_goods) {
        this.has_goods = has_goods;
    }

    public String getIs_origin() {
        return is_origin;
    }

    public void setIs_origin(String is_origin) {
        this.is_origin = is_origin;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class TagsBean {
        /**
         * center_local : {"x":0.56977775065104,"y":0.51385924251857,"arrow":0}
         * type : 1
         * activity : {"id":"000004q030000981","title":"家居店探店行动","join_num":3158,"desc_color":"#2DB7B5","desc":""}
         */

        private CenterLocalBean center_local;
        private int type;
        private ActivityBean activity;

        public CenterLocalBean getCenter_local() {
            return center_local;
        }

        public void setCenter_local(CenterLocalBean center_local) {
            this.center_local = center_local;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public ActivityBean getActivity() {
            return activity;
        }

        public void setActivity(ActivityBean activity) {
            this.activity = activity;
        }

        public static class CenterLocalBean {
            /**
             * x : 0.56977775065104
             * y : 0.51385924251857
             * arrow : 0
             */

            private double x;
            private double y;
            private int arrow;

            public double getX() {
                return x;
            }

            public void setX(double x) {
                this.x = x;
            }

            public double getY() {
                return y;
            }

            public void setY(double y) {
                this.y = y;
            }

            public int getArrow() {
                return arrow;
            }

            public void setArrow(int arrow) {
                this.arrow = arrow;
            }
        }


    }
}
