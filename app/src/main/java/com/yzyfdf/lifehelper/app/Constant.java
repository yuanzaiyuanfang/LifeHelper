package com.yzyfdf.lifehelper.app;

import com.yzyfdf.lifehelper.R;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class Constant {
    public static final boolean isDebug = true;
    /*常量*/
    public static final String PACKAGE_NAME = "lifehelper";
    public static final String[] mTitles = {"美食", "阅读", "远方", "港湾"};
    public static final int[] mMenuIds = {R.id.nav_cookbook, R.id.nav_read, R.id.nav_travel, R.id.nav_live};


    public static final int TYPE_ZHIHU = 1001;
    public static final int TYPE_DOUBAN = 1002;
    public static final int TYPE_GUOKE = 1003;


    /*参数*/
    public static final String PARAM = "data";//参数数组

    /*意图*/
    public static final String RBean = "rBean";
    public static final String MBean = "mBean";
    public static final String COOK_ID = "cook_id";
    public static final String MYSTEPBEAN = "myStepBean";
    public static final String KEY_WORD = "keyWord";

    public static final String READ_TYPE = "read_type";
    public static final String READ_ID = "read_id";
    public static final String READ_TITLE = "read_title";
    public static final String READ_MSG = "read_msg";
    public static final String READ_URL = "read_url";


    /*hawk*/
    public static final String favorites = "favorites";
    public static final String location = "location";
    public static final String nowpage = "nowpage";

    /*接口*/
    //cookbook
    public static final String cook_host = "http://api.douguo.net/";
    public static final String cook_home = cook_host + "recipe/home/";
    public static final String cook_list = cook_host + "menu/recipes/";
    public static final String cook_category = cook_host + "recipe/flatcatalogs";
    public static final String cook_search = cook_host + "recipe/s/";
    public static final String cook_detail = cook_host + "recipe/detail/";
    public static final String cook_share = "http://m.douguo.com/cookbook/share/cookid.html";
    //read
    // 知乎
    public static final String ZHIHU_NEWS = "http://news-at.zhihu.com/api/4/news/";
    // 果壳
    public static final String GUOKR_ARTICLE = "http://apis.guokr.com/handpick/v2/article.json?retrieve_type=by_offset&limit=20&ad=1&offset=";
    public static final String GUOKR_DETAIL = "http://jingxuan.guokr.com/pick/";
    // 豆瓣
    public static final String DOUBAN_MOMENT = "https://moment.douban.com/api/stream/date/";
    public static final String DOUBAN_DETAIL = "https://moment.douban.com/api/post/";

    //weather
    public static final String weather_host = "https://free-api.heweather.com/v5/";
    public static final String weather_key = "6532ab1d4d204af385d1616763dfdab2";
    public static final String weather_icon = "https://cdn.heweather.com/cond_icon/code.png";
    public static final String weather_now = weather_host + "now?key=" + weather_key + "&city=";
    public static final String weather_weather = weather_host + "weather?key=" + weather_key + "&city=";


    //远方
    public static final String travel_host = "https://api.chufaba.me/";
    public static final String travel_image = "http://img.chufaba.me/";
    public static final String travel_image_375 = "!375";

    public static final String travel_routes = travel_host + "v2/discovery/index.json?offset=";
    public static final String travel_route_details = travel_host;
    public static final String travel_impresss = travel_host + "v2/discovery/feed.json?before=";
    public static final String travel_found = travel_host + "v2/guides/hot";
    public static final String travel_hotsearch = travel_host + "v2/discovery/keywords";
    public static final String travel_suggestsearch = travel_host + "v2/search/suggest?keyword=";
    public static final String travel_guides_abroad = travel_host + "v2/guides/abroad";
    public static final String travel_guides_domestic = travel_host + "v2/guides/domestic";
    public static final String travel_destination = travel_host + "v2/guides/show?id=";


    //港湾
    public static final String live_host = "https://api.haohaozhu.com/index.php/";
    public static final String live_homeDynamic = live_host + "Home/Dynamic/index2_0";
    public static final String live_getChannel = live_host + "Home/Search/setNaviZone";
    public static final String live_jujia = live_host + "Home/Search/getChannelData";


    public static final String share_url = "http://yuanzaiyuanfang.applinzi.com/?p=92";

}
