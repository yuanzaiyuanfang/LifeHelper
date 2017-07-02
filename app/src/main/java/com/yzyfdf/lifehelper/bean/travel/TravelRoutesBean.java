package com.yzyfdf.lifehelper.bean.travel;

import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class TravelRoutesBean extends TravelBaseBean {

    private List<ItemsBean> items;
    private List<BannersBean> banners;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public List<BannersBean> getBanners() {
        return banners;
    }

    public void setBanners(List<BannersBean> banners) {
        this.banners = banners;
    }

    public static class ItemsBean {
        /**
         * res_type : 3
         * id : 767324
         * title : 成都慢慢慢
         * destinations : 九寨沟、成都、黄龙风景名胜区
         * background_image : http://img.chufaba.me/cover6.jpg!320
         * url : /journals/12b4545ae07ec
         * hot : null
         * user_id : 16455
         * vip : false
         * username : winnie_dad
         * avatar : http://tp3.sinaimg.cn/1416739802/180/5656769411/1
         * user : 无语
         */

        private int res_type;
        private int     id;
        private String  title;
        private String  destinations;
        private String  background_image;
        private String  url;
        private String  hot;
        private int     user_id;
        private boolean vip;
        private String  username;
        private String  avatar;
        private String  user;

        public int getRes_type() {
            return res_type;
        }

        public void setRes_type(int res_type) {
            this.res_type = res_type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDestinations() {
            return destinations;
        }

        public void setDestinations(String destinations) {
            this.destinations = destinations;
        }

        public String getBackground_image() {
            return background_image;
        }

        public void setBackground_image(String background_image) {
            this.background_image = background_image;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHot() {
            return hot;
        }

        public void setHot(String hot) {
            this.hot = hot;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public boolean isVip() {
            return vip;
        }

        public void setVip(boolean vip) {
            this.vip = vip;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }
    }

    public static class BannersBean {
        /**
         * action : false
         * action_name : null
         * action_type : 1
         * action_url : null
         * comments : false
         * id : 115
         * image1 : http://img.chufaba.me/events/e3d11e3218c1a9102a0848ff54ad4a17n.jpg
         * image2 : null
         * intro : null
         * name : 享受得起的定制旅行
         * share : true
         * share_image : http://img.chufaba.me/events/e3d11e3218c1a9102a0848ff54ad4a17.jpg!200x200
         * share_text : null
         * share_title : 享受得起的定制旅行
         * show_ext_panel : false
         * url : http://chufaba.me/activities/23
         * banner_type : 1
         * type : 2
         * event_url : /events/115
         * actionType : 1
         * actionUrl : null
         */

        private boolean action;
        private Object  action_name;
        private int     action_type;
        private Object  action_url;
        private boolean comments;
        private int     id;
        private String  image1;
        private Object  image2;
        private Object  intro;
        private String  name;
        private boolean share;
        private String  share_image;
        private Object  share_text;
        private String  share_title;
        private boolean show_ext_panel;
        private String  url;
        private int     banner_type;
        private int     type;
        private String  event_url;
        private int     actionType;
        private Object  actionUrl;

        public boolean isAction() {
            return action;
        }

        public void setAction(boolean action) {
            this.action = action;
        }

        public Object getAction_name() {
            return action_name;
        }

        public void setAction_name(Object action_name) {
            this.action_name = action_name;
        }

        public int getAction_type() {
            return action_type;
        }

        public void setAction_type(int action_type) {
            this.action_type = action_type;
        }

        public Object getAction_url() {
            return action_url;
        }

        public void setAction_url(Object action_url) {
            this.action_url = action_url;
        }

        public boolean isComments() {
            return comments;
        }

        public void setComments(boolean comments) {
            this.comments = comments;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage1() {
            return image1;
        }

        public void setImage1(String image1) {
            this.image1 = image1;
        }

        public Object getImage2() {
            return image2;
        }

        public void setImage2(Object image2) {
            this.image2 = image2;
        }

        public Object getIntro() {
            return intro;
        }

        public void setIntro(Object intro) {
            this.intro = intro;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isShare() {
            return share;
        }

        public void setShare(boolean share) {
            this.share = share;
        }

        public String getShare_image() {
            return share_image;
        }

        public void setShare_image(String share_image) {
            this.share_image = share_image;
        }

        public Object getShare_text() {
            return share_text;
        }

        public void setShare_text(Object share_text) {
            this.share_text = share_text;
        }

        public String getShare_title() {
            return share_title;
        }

        public void setShare_title(String share_title) {
            this.share_title = share_title;
        }

        public boolean isShow_ext_panel() {
            return show_ext_panel;
        }

        public void setShow_ext_panel(boolean show_ext_panel) {
            this.show_ext_panel = show_ext_panel;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getBanner_type() {
            return banner_type;
        }

        public void setBanner_type(int banner_type) {
            this.banner_type = banner_type;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getEvent_url() {
            return event_url;
        }

        public void setEvent_url(String event_url) {
            this.event_url = event_url;
        }

        public int getActionType() {
            return actionType;
        }

        public void setActionType(int actionType) {
            this.actionType = actionType;
        }

        public Object getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(Object actionUrl) {
            this.actionUrl = actionUrl;
        }
    }
}
