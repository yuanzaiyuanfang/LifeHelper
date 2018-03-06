package com.yzyfdf.lifehelper.bean.live;

import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class UserInfoBean {
    /**
     * uid : 12645
     * nick : ShinLee
     * gender : 1
     * area : 1,382
     * type : 2
     * avatar_version : 1
     * profile : 独立设计师。接受有趣的委托项目，随机回答一些室内设计问题（看空闲时间免费回答），加微信可以询问，普通的问题直接留言就可以了。

     做的设计比较建筑，过于软装和摆拍的不要问我，家是自己的，真正的生活方式属于个人。

     有趣的设计任务可以无视下面的的条件（例如度假民宿，airbnb，独栋建筑改造等）

     设计费200-300的区间：
     户型面积120以上200每平方（涵盖设计和软装）
     户型面积120以下300每平方（涵盖设计和软装）
     只出设计统一都是300（有趣的委托项目会特别对待）
     量房需要排队和支付定金（设计费的10%）

     咨询沟通不收取费用，微信加上就好ShinLee001

     * status : 1
     * phone : 18610490115
     * show_phone : 1
     * service_area : 北京 郑州
     * min_price : 250
     * max_price : 300
     * price_range : 250-300元/㎡
     * accept_discuss : 0
     * remark : 独立室内设计师
     * main_area : 1,1
     * other_area : [{"lid":"1","name":"北京"},{"lid":"186","name":"郑州"}]
     * decoration_status : 3
     * cover_img : 82b7e20ka0dj00000oyeywx
     * is_watermarking : 1
     * is_follow : 1
     * glory_data : {"glory":77,"glory_exceed_percent":65,"specification":"http://img.hhz1.cn/Op-imageShow/a01a730j906300000oy9m71?iv=1"}
     * avatar : http://img.hhz1.cn/Pic-imageShow/sq_big/000009r9?iv=1&v=1
     * big_avatar : http://img.hhz1.cn/Pic-imageShow/sq_640/000009r9?iv=1&v=1
     */

    private String uid;
    private String nick;
    private String gender;
    private String area;
    private String type;
    private String avatar_version;
    private String profile;
    private String status;
    private String phone;
    private String show_phone;
    private String service_area;
    private String min_price;
    private String max_price;
    private String price_range;
    private String accept_discuss;
    private String remark;
    private String main_area;
    private String decoration_status;
    private String cover_img;
    private String is_watermarking;
    private int is_follow;
    private GloryDataBean glory_data;
    private String avatar;
    private String big_avatar;
    private List<OtherAreaBean> other_area;
    private List<EmblemBean> emblem;
    private EmblemAdornBean emblem_adorn;

    public List<EmblemBean> getEmblem() {
        return emblem;
    }

    public void setEmblem(List<EmblemBean> emblem) {
        this.emblem = emblem;
    }

    public EmblemAdornBean getEmblem_adorn() {
        return emblem_adorn;
    }

    public void setEmblem_adorn(EmblemAdornBean emblem_adorn) {
        this.emblem_adorn = emblem_adorn;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShow_phone() {
        return show_phone;
    }

    public void setShow_phone(String show_phone) {
        this.show_phone = show_phone;
    }

    public String getService_area() {
        return service_area;
    }

    public void setService_area(String service_area) {
        this.service_area = service_area;
    }

    public String getMin_price() {
        return min_price;
    }

    public void setMin_price(String min_price) {
        this.min_price = min_price;
    }

    public String getMax_price() {
        return max_price;
    }

    public void setMax_price(String max_price) {
        this.max_price = max_price;
    }

    public String getPrice_range() {
        return price_range;
    }

    public void setPrice_range(String price_range) {
        this.price_range = price_range;
    }

    public String getAccept_discuss() {
        return accept_discuss;
    }

    public void setAccept_discuss(String accept_discuss) {
        this.accept_discuss = accept_discuss;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMain_area() {
        return main_area;
    }

    public void setMain_area(String main_area) {
        this.main_area = main_area;
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

    public int getIs_follow() {
        return is_follow;
    }

    public void setIs_follow(int is_follow) {
        this.is_follow = is_follow;
    }

    public GloryDataBean getGlory_data() {
        return glory_data;
    }

    public void setGlory_data(GloryDataBean glory_data) {
        this.glory_data = glory_data;
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

    public List<OtherAreaBean> getOther_area() {
        return other_area;
    }

    public void setOther_area(List<OtherAreaBean> other_area) {
        this.other_area = other_area;
    }

    public static class GloryDataBean {
        /**
         * glory : 77
         * glory_exceed_percent : 65
         * specification : http://img.hhz1.cn/Op-imageShow/a01a730j906300000oy9m71?iv=1
         */

        private int glory;
        private int glory_exceed_percent;
        private String specification;

        public int getGlory() {
            return glory;
        }

        public void setGlory(int glory) {
            this.glory = glory;
        }

        public int getGlory_exceed_percent() {
            return glory_exceed_percent;
        }

        public void setGlory_exceed_percent(int glory_exceed_percent) {
            this.glory_exceed_percent = glory_exceed_percent;
        }

        public String getSpecification() {
            return specification;
        }

        public void setSpecification(String specification) {
            this.specification = specification;
        }
    }

    public static class OtherAreaBean {
        /**
         * lid : 1
         * name : 北京
         */

        private String lid;
        private String name;

        public String getLid() {
            return lid;
        }

        public void setLid(String lid) {
            this.lid = lid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class EmblemAdornBean {
        /**
         * emblem_type : 1
         * name : 居住榜样
         * describe : 「居住榜样」是好好住授予住友的荣誉徽章，代表着好好住所倡导的居住理念：用心生活，热爱分享，以实用的家居灵感启发更多住友提升生活品质。
         * logo : http://img.hhz1.cn/Op-imageShow/ed10630dc0dc00000ozci0c?iv=1
         * round_logo : http://img.hhz1.cn/Op-imageShow/02e2b304604600000ozt2va?iv=1
         * link : http://m2.haohaozhu.com/static_page/about_insignia?type=1
         * status : 1
         * background : http://img.hhz1.cn/Op-imageShow/727f430m30a000000ozeebs?iv=1
         * logo_prefix : http://img.hhz1.cn/Op-imageShow/4ce49304601c00000p0zzc9?iv=1
         * id : 258
         * uid : 29208
         * get_time : 1511425660
         * s_id :
         * adm_status : 1
         */

        private int emblem_type;
        private String name;
        private String describe;
        private String logo;
        private String round_logo;
        private String link;
        private String status;
        private String background;
        private String logo_prefix;
        private String id;
        private String uid;
        private String get_time;
        private String s_id;
        private String adm_status;

        public int getEmblem_type() {
            return emblem_type;
        }

        public void setEmblem_type(int emblem_type) {
            this.emblem_type = emblem_type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getRound_logo() {
            return round_logo;
        }

        public void setRound_logo(String round_logo) {
            this.round_logo = round_logo;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getLogo_prefix() {
            return logo_prefix;
        }

        public void setLogo_prefix(String logo_prefix) {
            this.logo_prefix = logo_prefix;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getGet_time() {
            return get_time;
        }

        public void setGet_time(String get_time) {
            this.get_time = get_time;
        }

        public String getS_id() {
            return s_id;
        }

        public void setS_id(String s_id) {
            this.s_id = s_id;
        }

        public String getAdm_status() {
            return adm_status;
        }

        public void setAdm_status(String adm_status) {
            this.adm_status = adm_status;
        }
    }

    public static class EmblemBean {
        /**
         * emblem_type : 1
         * name : 居住榜样
         * describe : 「居住榜样」是好好住授予住友的荣誉徽章，代表着好好住所倡导的居住理念：用心生活，热爱分享，以实用的家居灵感启发更多住友提升生活品质。
         * logo : http://img.hhz1.cn/Op-imageShow/ed10630dc0dc00000ozci0c?iv=1
         * round_logo : http://img.hhz1.cn/Op-imageShow/02e2b304604600000ozt2va?iv=1
         * link : http://m2.haohaozhu.com/static_page/about_insignia?type=1
         * status : 1
         * background : http://img.hhz1.cn/Op-imageShow/727f430m30a000000ozeebs?iv=1
         * id : 258
         * uid : 29208
         * get_time : 1511425660
         * s_id :
         * adm_status : 1
         */

        private int emblem_type;
        private String name;
        private String describe;
        private String logo;
        private String round_logo;
        private String link;
        private String status;
        private String background;
        private String id;
        private String uid;
        private String get_time;
        private String s_id;
        private String adm_status;

        public int getEmblem_type() {
            return emblem_type;
        }

        public void setEmblem_type(int emblem_type) {
            this.emblem_type = emblem_type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getRound_logo() {
            return round_logo;
        }

        public void setRound_logo(String round_logo) {
            this.round_logo = round_logo;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getBackground() {
            return background;
        }

        public void setBackground(String background) {
            this.background = background;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getGet_time() {
            return get_time;
        }

        public void setGet_time(String get_time) {
            this.get_time = get_time;
        }

        public String getS_id() {
            return s_id;
        }

        public void setS_id(String s_id) {
            this.s_id = s_id;
        }

        public String getAdm_status() {
            return adm_status;
        }

        public void setAdm_status(String adm_status) {
            this.adm_status = adm_status;
        }
    }
}