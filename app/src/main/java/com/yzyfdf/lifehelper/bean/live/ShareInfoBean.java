package com.yzyfdf.lifehelper.bean.live;

/**
 * Created by MLRC-iOS-CI on 2018/1/10.
 */

public class ShareInfoBean {
    /**
     * wechat : {"title":"屋主「kenyaespresso」的图片 | 好好住 APP","desc":"#商业空间 #失物招领lostandfound ","cover_img":"http://img.hhz1.cn/App-imageShow/sq_thumb/079/183cd22732qw00000p287gb?iv=1&w=230&h=230&fmt=webp","url":"https://m.haohaozhu.com/tupian/0011lrt000000mjc.html"}
     * wechat_moments : {"title":"屋主「kenyaespresso」的图片 | 好好住 APP","cover_img":"http://img.hhz1.cn/App-imageShow/o_nphone/079/183cd22732qw00000p287gb?iv=1&w=750&h=937.82929399368&fmt=webp","url":"https://m.haohaozhu.com/tupian/0011lrt000000mjc.html"}
     * weibo : {"title":"屋主「kenyaespresso」的图片 @好好住APP ,快来看看吧！https://m.haohaozhu.com/tupian/0011lrt000000mjc.html","cover_img":"https://api.haohaozhu.com/index.php/Home/share/show?photo_id=0011lrt000000mjc","url":"https://m.haohaozhu.com/tupian/0011lrt000000mjc.html"}
     * qq : {"title":"屋主「kenyaespresso」的图片 | 好好住 APP","desc":"#商业空间 #失物招领lostandfound ","cover_img":"http://img.hhz1.cn/App-imageShow/sq_thumb/079/183cd22732qw00000p287gb?iv=1&w=230&h=230&fmt=webp","url":"https://m.haohaozhu.com/tupian/0011lrt000000mjc.html"}
     * cut_pic : {"url":"https://m.haohaozhu.com/cut_tupian/0011lrt000000mjc.html"}
     * im : {"session_title":"来自kenyaespresso的图片","title":"来自kenyaespresso的图片","desc":"#商业空间 #失物招领lostandfound ","cover_img":"http://img.hhz1.cn/App-imageShow/sq_thumb/079/183cd22732qw00000p287gb?iv=1&w=230&h=230&fmt=webp","link":"hhz://photo:0011lrt000000mjc"}
     */

    private WechatBean wechat;
    private WechatMomentsBean wechat_moments;
    private WeiboBean weibo;
    private QqBean qq;
    private CutPicBean cut_pic;
    private ImBean im;

    public WechatBean getWechat() {
        return wechat;
    }

    public void setWechat(WechatBean wechat) {
        this.wechat = wechat;
    }

    public WechatMomentsBean getWechat_moments() {
        return wechat_moments;
    }

    public void setWechat_moments(WechatMomentsBean wechat_moments) {
        this.wechat_moments = wechat_moments;
    }

    public WeiboBean getWeibo() {
        return weibo;
    }

    public void setWeibo(WeiboBean weibo) {
        this.weibo = weibo;
    }

    public QqBean getQq() {
        return qq;
    }

    public void setQq(QqBean qq) {
        this.qq = qq;
    }

    public CutPicBean getCut_pic() {
        return cut_pic;
    }

    public void setCut_pic(CutPicBean cut_pic) {
        this.cut_pic = cut_pic;
    }

    public ImBean getIm() {
        return im;
    }

    public void setIm(ImBean im) {
        this.im = im;
    }

    public static class WechatBean {
        /**
         * title : 屋主「kenyaespresso」的图片 | 好好住 APP
         * desc : #商业空间 #失物招领lostandfound
         * cover_img : http://img.hhz1.cn/App-imageShow/sq_thumb/079/183cd22732qw00000p287gb?iv=1&w=230&h=230&fmt=webp
         * url : https://m.haohaozhu.com/tupian/0011lrt000000mjc.html
         */

        private String title;
        private String desc;
        private String cover_img;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getCover_img() {
            return cover_img;
        }

        public void setCover_img(String cover_img) {
            this.cover_img = cover_img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class WechatMomentsBean {
        /**
         * title : 屋主「kenyaespresso」的图片 | 好好住 APP
         * cover_img : http://img.hhz1.cn/App-imageShow/o_nphone/079/183cd22732qw00000p287gb?iv=1&w=750&h=937.82929399368&fmt=webp
         * url : https://m.haohaozhu.com/tupian/0011lrt000000mjc.html
         */

        private String title;
        private String cover_img;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover_img() {
            return cover_img;
        }

        public void setCover_img(String cover_img) {
            this.cover_img = cover_img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class WeiboBean {
        /**
         * title : 屋主「kenyaespresso」的图片 @好好住APP ,快来看看吧！https://m.haohaozhu.com/tupian/0011lrt000000mjc.html
         * cover_img : https://api.haohaozhu.com/index.php/Home/share/show?photo_id=0011lrt000000mjc
         * url : https://m.haohaozhu.com/tupian/0011lrt000000mjc.html
         */

        private String title;
        private String cover_img;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover_img() {
            return cover_img;
        }

        public void setCover_img(String cover_img) {
            this.cover_img = cover_img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class QqBean {
        /**
         * title : 屋主「kenyaespresso」的图片 | 好好住 APP
         * desc : #商业空间 #失物招领lostandfound
         * cover_img : http://img.hhz1.cn/App-imageShow/sq_thumb/079/183cd22732qw00000p287gb?iv=1&w=230&h=230&fmt=webp
         * url : https://m.haohaozhu.com/tupian/0011lrt000000mjc.html
         */

        private String title;
        private String desc;
        private String cover_img;
        private String url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getCover_img() {
            return cover_img;
        }

        public void setCover_img(String cover_img) {
            this.cover_img = cover_img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class CutPicBean {
        /**
         * url : https://m.haohaozhu.com/cut_tupian/0011lrt000000mjc.html
         */

        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ImBean {
        /**
         * session_title : 来自kenyaespresso的图片
         * title : 来自kenyaespresso的图片
         * desc : #商业空间 #失物招领lostandfound
         * cover_img : http://img.hhz1.cn/App-imageShow/sq_thumb/079/183cd22732qw00000p287gb?iv=1&w=230&h=230&fmt=webp
         * link : hhz://photo:0011lrt000000mjc
         */

        private String session_title;
        private String title;
        private String desc;
        private String cover_img;
        private String link;

        public String getSession_title() {
            return session_title;
        }

        public void setSession_title(String session_title) {
            this.session_title = session_title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getCover_img() {
            return cover_img;
        }

        public void setCover_img(String cover_img) {
            this.cover_img = cover_img;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
