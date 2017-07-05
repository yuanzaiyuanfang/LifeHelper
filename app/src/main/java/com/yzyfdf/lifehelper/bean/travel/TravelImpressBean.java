package com.yzyfdf.lifehelper.bean.travel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class TravelImpressBean extends TravelBaseBean {

    private List<TopicsBean> topics;
    private List<DataBean> data;

    public List<TopicsBean> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicsBean> topics) {
        this.topics = topics;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class TopicsBean {
        /**
         * id : 210
         * name : 印象@杭州
         * desc : 杭州，城市与山水各分半壁江山，美丽不仅仅只是西湖那么简单。城市远郊各有盎然诗意，夏季赏荷冬看断桥残雪；河坊街、南宋御街的老街巷里市井依然；在江南菜系中，杭帮菜更是实力强劲。来过杭州，你来说说最喜欢哪？（顶图来自@童小喵 · 龙井村）
         * image : http://img.chufaba.me/topics/210.jpg
         * url : /topic/210
         * banner_type : 2
         * hasHot : true
         * default_index : 1
         * res_type : 8
         */

        private int id;
        private String  name;
        private String  desc;
        private String  image;
        private String  url;
        private int     banner_type;
        private boolean hasHot;
        private int     default_index;
        private int     res_type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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

        public boolean isHasHot() {
            return hasHot;
        }

        public void setHasHot(boolean hasHot) {
            this.hasHot = hasHot;
        }

        public int getDefault_index() {
            return default_index;
        }

        public void setDefault_index(int default_index) {
            this.default_index = default_index;
        }

        public int getRes_type() {
            return res_type;
        }

        public void setRes_type(int res_type) {
            this.res_type = res_type;
        }
    }

    public static class DataBean {
        /**
         * id : 7245
         * time : 1499079600000
         * type : 6
         * poi : {"id":114726,"name":"正佳广场","name_en":"","name_py":"zheng jia guangchang","country":"中国","country_en":"China","country_py":"Zhongguo","province":"广东","province_en":"Guangdong","province_py":"Guangdong","city":"广州","city_en":"Guangzhou","city_py":"Guangzhou","query":"中国 广州 正佳广场  zheng jia guangchang","query_ws":"中国 广州 正佳广场  zheng jia guangchang","category":"其它","address":"广东省广州市天河区天河路228号","transport":"地铁：\r\n乘坐1号线至「体育中心」 \r\n乘坐3号线至 「石牌桥」","opening":"","fee":"","duration":"","website":"www.zhengjia.com.cn/","baike":"http://baike.baidu.com/view/257300.htm","dianping":null,"rank":9990,"star":1,"status":1,"images":[],"location":{"lat":23.132098151611,"lon":113.327003479},"tips":"#人气商铺#\r\n1.购物：H&M、YOYNOT、NIKE、broadcast：播、Stradivarius、Calvin Klein Jeans等\r\n2.美食：佬湘楼、仙踪林、汉堡王、摩斯汉堡、伊太郎日本料理、泰满冠","intro":"以体验式主题购物乐园为设计定位的正佳广场，是当今中国最大的完全贯彻\u201c体验式消费\u201d模式、集零售、休闲、娱乐、餐饮、会展、康体、旅游及商务于一体的现代化购物中心之一。","img":null,"rating":0,"favs":3,"faved":false,"adds":107}
         * pc : [{"desc":"等我们喝完早茶.已是10点多了.便动身前往正佳广场.\n一到正佳广场.我姐便拉着我们去找那家Line熊的店.\n当时人不多.我们一下子就进去了.\n便在里面拍照.那一天的旅程已经不想再回忆起来了.\n毕竟有好也有不好.","extra_info":"{\"poi_comment_8ec9913a-cbf0-4d0b-8798-a749f192bdd5.JPG\":{\"w\":1504,\"h\":1000},\"poi_comment_e753014b-64ec-4c04-92d6-cad5b4540420.JPG\":{\"w\":1504,\"h\":1000},\"poi_comment_0bce734d-8b0f-4df6-8126-84c87ab2479a.JPG\":{\"w\":1504,\"h\":1000},\"poi_comment_9f112b85-2724-49e1-ab99-796954bbb255.jpg\":{\"w\":1504,\"h\":1000},\"poi_comment_99d06530-88da-46fb-b724-b419232bbfb8.jpg\":{\"w\":1504,\"h\":1000},\"poi_comment_e2cf76fe-0e37-4622-9a3e-165c5ff2ff66.jpg\":{\"w\":1504,\"h\":1000}}","id":84147,"images":"[\"poi_comment_8ec9913a-cbf0-4d0b-8798-a749f192bdd5.JPG\",\"poi_comment_e753014b-64ec-4c04-92d6-cad5b4540420.JPG\",\"poi_comment_0bce734d-8b0f-4df6-8126-84c87ab2479a.JPG\",\"poi_comment_9f112b85-2724-49e1-ab99-796954bbb255.jpg\",\"poi_comment_99d06530-88da-46fb-b724-b419232bbfb8.jpg\",\"poi_comment_e2cf76fe-0e37-4622-9a3e-165c5ff2ff66.jpg\"]","location_uuid":"66d1f547-4672-4682-be49-cc6d02d50877","pintu":false,"plan_uuid":"23814870-ccf7-40b4-9b70-c426c077080b","poi_category":"其它","poi_destination":"广州，中国","poi_id":114726,"poi_name":"正佳广场","rating":5,"revision":74,"topic":"印象@广州","travel_date":"2017.04","user_id":343785,"uuid":"5dcfa532-0b43-4185-8f46-e1e10a24e8ec","custom_poi_uuid":null,"username":"Lonely和谐","vip":false,"avatar":"http://img.chufaba.me/0ff975a8-2141-4d03-aa3c-1ae3d0791274.jpg","intro":"叫我和谐.高二党.爱旅游.港铁迷.蜜汁技术宅.","followed":false,"url":"/notes/Xc-lMgtDQYWPRuHhCiTo7A","created_at":"2017-07-01 19:52:22","updated_at":"2017-07-03 14:26:33","likes":5,"liked":false,"comments":0,"plan_name":"广州摄影之旅","journal":"/journals/12d3e83c8cea1","topics":"印象@广州","image_index":5}]
         */

        private int id;
        private String         time;
        private int          type;
        private PoiBean      poi;
        private List<PcBean> pc;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public PoiBean getPoi() {
            return poi;
        }

        public void setPoi(PoiBean poi) {
            this.poi = poi;
        }

        public List<PcBean> getPc() {
            return pc;
        }

        public void setPc(List<PcBean> pc) {
            this.pc = pc;
        }

        public static class PoiBean {
            /**
             * id : 114726
             * name : 正佳广场
             * name_en :
             * name_py : zheng jia guangchang
             * country : 中国
             * country_en : China
             * country_py : Zhongguo
             * province : 广东
             * province_en : Guangdong
             * province_py : Guangdong
             * city : 广州
             * city_en : Guangzhou
             * city_py : Guangzhou
             * query : 中国 广州 正佳广场  zheng jia guangchang
             * query_ws : 中国 广州 正佳广场  zheng jia guangchang
             * category : 其它
             * address : 广东省广州市天河区天河路228号
             * transport : 地铁：
             乘坐1号线至「体育中心」
             乘坐3号线至 「石牌桥」
             * opening :
             * fee :
             * duration :
             * website : www.zhengjia.com.cn/
             * baike : http://baike.baidu.com/view/257300.htm
             * dianping : null
             * rank : 9990
             * star : 1
             * status : 1
             * images : []
             * location : {"lat":23.132098151611,"lon":113.327003479}
             * tips : #人气商铺#
             1.购物：H&M、YOYNOT、NIKE、broadcast：播、Stradivarius、Calvin Klein Jeans等
             2.美食：佬湘楼、仙踪林、汉堡王、摩斯汉堡、伊太郎日本料理、泰满冠
             * intro : 以体验式主题购物乐园为设计定位的正佳广场，是当今中国最大的完全贯彻“体验式消费”模式、集零售、休闲、娱乐、餐饮、会展、康体、旅游及商务于一体的现代化购物中心之一。
             * img : null
             * rating : 0
             * favs : 3
             * faved : false
             * adds : 107
             */

            private int id;
            private String       name;
            private String       name_en;
            private String       name_py;
            private String       country;
            private String       country_en;
            private String       country_py;
            private String       province;
            private String       province_en;
            private String       province_py;
            private String       city;
            private String       city_en;
            private String       city_py;
            private String       query;
            private String       query_ws;
            private String       category;
            private String       address;
            private String       transport;
            private String       opening;
            private String       fee;
            private String       duration;
            private String       website;
            private String       baike;
            private Object       dianping;
            private int          rank;
            private int          star;
            @SerializedName("status")
            private int          statusX;
            private LocationBean location;
            private String       tips;
            private String       intro;
            private Object       img;
            private double          rating;
            private int          favs;
            private boolean      faved;
            private int          adds;
            private List<String>      images;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getName_en() {
                return name_en;
            }

            public void setName_en(String name_en) {
                this.name_en = name_en;
            }

            public String getName_py() {
                return name_py;
            }

            public void setName_py(String name_py) {
                this.name_py = name_py;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getCountry_en() {
                return country_en;
            }

            public void setCountry_en(String country_en) {
                this.country_en = country_en;
            }

            public String getCountry_py() {
                return country_py;
            }

            public void setCountry_py(String country_py) {
                this.country_py = country_py;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getProvince_en() {
                return province_en;
            }

            public void setProvince_en(String province_en) {
                this.province_en = province_en;
            }

            public String getProvince_py() {
                return province_py;
            }

            public void setProvince_py(String province_py) {
                this.province_py = province_py;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCity_en() {
                return city_en;
            }

            public void setCity_en(String city_en) {
                this.city_en = city_en;
            }

            public String getCity_py() {
                return city_py;
            }

            public void setCity_py(String city_py) {
                this.city_py = city_py;
            }

            public String getQuery() {
                return query;
            }

            public void setQuery(String query) {
                this.query = query;
            }

            public String getQuery_ws() {
                return query_ws;
            }

            public void setQuery_ws(String query_ws) {
                this.query_ws = query_ws;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getTransport() {
                return transport;
            }

            public void setTransport(String transport) {
                this.transport = transport;
            }

            public String getOpening() {
                return opening;
            }

            public void setOpening(String opening) {
                this.opening = opening;
            }

            public String getFee() {
                return fee;
            }

            public void setFee(String fee) {
                this.fee = fee;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getWebsite() {
                return website;
            }

            public void setWebsite(String website) {
                this.website = website;
            }

            public String getBaike() {
                return baike;
            }

            public void setBaike(String baike) {
                this.baike = baike;
            }

            public Object getDianping() {
                return dianping;
            }

            public void setDianping(Object dianping) {
                this.dianping = dianping;
            }

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public int getStar() {
                return star;
            }

            public void setStar(int star) {
                this.star = star;
            }

            public int getStatusX() {
                return statusX;
            }

            public void setStatusX(int statusX) {
                this.statusX = statusX;
            }

            public LocationBean getLocation() {
                return location;
            }

            public void setLocation(LocationBean location) {
                this.location = location;
            }

            public String getTips() {
                return tips;
            }

            public void setTips(String tips) {
                this.tips = tips;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public Object getImg() {
                return img;
            }

            public void setImg(Object img) {
                this.img = img;
            }

            public double getRating() {
                return rating;
            }

            public void setRating(double rating) {
                this.rating = rating;
            }

            public int getFavs() {
                return favs;
            }

            public void setFavs(int favs) {
                this.favs = favs;
            }

            public boolean isFaved() {
                return faved;
            }

            public void setFaved(boolean faved) {
                this.faved = faved;
            }

            public int getAdds() {
                return adds;
            }

            public void setAdds(int adds) {
                this.adds = adds;
            }

            public List<String> getImages() {
                return images;
            }

            public void setImages(List<String> images) {
                this.images = images;
            }

            public static class LocationBean {
                /**
                 * lat : 23.132098151611
                 * lon : 113.327003479
                 */

                private double lat;
                private double lon;

                public double getLat() {
                    return lat;
                }

                public void setLat(double lat) {
                    this.lat = lat;
                }

                public double getLon() {
                    return lon;
                }

                public void setLon(double lon) {
                    this.lon = lon;
                }
            }
        }

        public static class PcBean {
            /**
             * desc : 等我们喝完早茶.已是10点多了.便动身前往正佳广场.
             一到正佳广场.我姐便拉着我们去找那家Line熊的店.
             当时人不多.我们一下子就进去了.
             便在里面拍照.那一天的旅程已经不想再回忆起来了.
             毕竟有好也有不好.
             * extra_info : {"poi_comment_8ec9913a-cbf0-4d0b-8798-a749f192bdd5.JPG":{"w":1504,"h":1000},"poi_comment_e753014b-64ec-4c04-92d6-cad5b4540420.JPG":{"w":1504,"h":1000},"poi_comment_0bce734d-8b0f-4df6-8126-84c87ab2479a.JPG":{"w":1504,"h":1000},"poi_comment_9f112b85-2724-49e1-ab99-796954bbb255.jpg":{"w":1504,"h":1000},"poi_comment_99d06530-88da-46fb-b724-b419232bbfb8.jpg":{"w":1504,"h":1000},"poi_comment_e2cf76fe-0e37-4622-9a3e-165c5ff2ff66.jpg":{"w":1504,"h":1000}}
             * id : 84147
             * images : ["poi_comment_8ec9913a-cbf0-4d0b-8798-a749f192bdd5.JPG","poi_comment_e753014b-64ec-4c04-92d6-cad5b4540420.JPG","poi_comment_0bce734d-8b0f-4df6-8126-84c87ab2479a.JPG","poi_comment_9f112b85-2724-49e1-ab99-796954bbb255.jpg","poi_comment_99d06530-88da-46fb-b724-b419232bbfb8.jpg","poi_comment_e2cf76fe-0e37-4622-9a3e-165c5ff2ff66.jpg"]
             * location_uuid : 66d1f547-4672-4682-be49-cc6d02d50877
             * pintu : false
             * plan_uuid : 23814870-ccf7-40b4-9b70-c426c077080b
             * poi_category : 其它
             * poi_destination : 广州，中国
             * poi_id : 114726
             * poi_name : 正佳广场
             * rating : 5
             * revision : 74
             * topic : 印象@广州
             * travel_date : 2017.04
             * user_id : 343785
             * uuid : 5dcfa532-0b43-4185-8f46-e1e10a24e8ec
             * custom_poi_uuid : null
             * username : Lonely和谐
             * vip : false
             * avatar : http://img.chufaba.me/0ff975a8-2141-4d03-aa3c-1ae3d0791274.jpg
             * intro : 叫我和谐.高二党.爱旅游.港铁迷.蜜汁技术宅.
             * followed : false
             * url : /notes/Xc-lMgtDQYWPRuHhCiTo7A
             * created_at : 2017-07-01 19:52:22
             * updated_at : 2017-07-03 14:26:33
             * likes : 5
             * liked : false
             * comments : 0
             * plan_name : 广州摄影之旅
             * journal : /journals/12d3e83c8cea1
             * topics : 印象@广州
             * image_index : 5
             */

            private String desc;
            private String  extra_info;
            private int     id;
            private String  images;
            private String  location_uuid;
            private boolean pintu;
            private String  plan_uuid;
            private String  poi_category;
            private String  poi_destination;
            private int     poi_id;
            private String  poi_name;
            private float  rating;
            private int     revision;
            private String  topic;
            private String  travel_date;
            private int     user_id;
            private String  uuid;
            private Object  custom_poi_uuid;
            private String  username;
            private boolean vip;
            private String  avatar;
            private String  intro;
            private boolean followed;
            private String  url;
            private String  created_at;
            private String  updated_at;
            private int     likes;
            private boolean liked;
            private int     comments;
            private String  plan_name;
            private String  journal;
            private String  topics;
            private int     image_index;

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getExtra_info() {
                return extra_info;
            }

            public void setExtra_info(String extra_info) {
                this.extra_info = extra_info;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getLocation_uuid() {
                return location_uuid;
            }

            public void setLocation_uuid(String location_uuid) {
                this.location_uuid = location_uuid;
            }

            public boolean isPintu() {
                return pintu;
            }

            public void setPintu(boolean pintu) {
                this.pintu = pintu;
            }

            public String getPlan_uuid() {
                return plan_uuid;
            }

            public void setPlan_uuid(String plan_uuid) {
                this.plan_uuid = plan_uuid;
            }

            public String getPoi_category() {
                return poi_category;
            }

            public void setPoi_category(String poi_category) {
                this.poi_category = poi_category;
            }

            public String getPoi_destination() {
                return poi_destination;
            }

            public void setPoi_destination(String poi_destination) {
                this.poi_destination = poi_destination;
            }

            public int getPoi_id() {
                return poi_id;
            }

            public void setPoi_id(int poi_id) {
                this.poi_id = poi_id;
            }

            public String getPoi_name() {
                return poi_name;
            }

            public void setPoi_name(String poi_name) {
                this.poi_name = poi_name;
            }

            public float getRating() {
                return rating;
            }

            public void setRating(float rating) {
                this.rating = rating;
            }

            public int getRevision() {
                return revision;
            }

            public void setRevision(int revision) {
                this.revision = revision;
            }

            public String getTopic() {
                return topic;
            }

            public void setTopic(String topic) {
                this.topic = topic;
            }

            public String getTravel_date() {
                return travel_date;
            }

            public void setTravel_date(String travel_date) {
                this.travel_date = travel_date;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public Object getCustom_poi_uuid() {
                return custom_poi_uuid;
            }

            public void setCustom_poi_uuid(Object custom_poi_uuid) {
                this.custom_poi_uuid = custom_poi_uuid;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public boolean isVip() {
                return vip;
            }

            public void setVip(boolean vip) {
                this.vip = vip;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public int getLikes() {
                return likes;
            }

            public void setLikes(int likes) {
                this.likes = likes;
            }

            public boolean isLiked() {
                return liked;
            }

            public void setLiked(boolean liked) {
                this.liked = liked;
            }

            public int getComments() {
                return comments;
            }

            public void setComments(int comments) {
                this.comments = comments;
            }

            public String getPlan_name() {
                return plan_name;
            }

            public void setPlan_name(String plan_name) {
                this.plan_name = plan_name;
            }

            public String getJournal() {
                return journal;
            }

            public void setJournal(String journal) {
                this.journal = journal;
            }

            public String getTopics() {
                return topics;
            }

            public void setTopics(String topics) {
                this.topics = topics;
            }

            public int getImage_index() {
                return image_index;
            }

            public void setImage_index(int image_index) {
                this.image_index = image_index;
            }
        }
    }
}
