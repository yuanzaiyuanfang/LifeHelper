package com.yzyfdf.lifehelper.app;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class Constant {
    public static final boolean isDebug = true;
    /*常量*/
    public static final String PACKAGE_NAME = "lifehelper";

    /*参数*/
    public static final String PARAM = "data";//参数数组

    /*意图*/
    public static final String RBean      = "rBean";
    public static final String MBean      = "mBean";
    public static final String MYSTEPBEAN = "myStepBean";
    public static final String KEY_WORD   = "keyWord";

    /*hawk*/
    public static final String favorites = "favorites";

    /*接口*/
    //cookbook
    public static final String cook_host     = "http://api.douguo.net/";
    public static final String cook_home     = cook_host + "recipe/home/";
    public static final String cook_list     = cook_host + "menu/recipes/";
    public static final String cook_category = cook_host + "recipe/flatcatalogs";
    public static final String cook_search   = cook_host + "recipe/s/";
    public static final String cook_share   = "http://m.douguo.com/cookbook/share/cookid.html";
    //read
    // 知乎
    public static final String ZHIHU_NEWS = "http://news-at.zhihu.com/api/4/news/";
    // 果壳精选文章列表
    public static final String GUOKR_ARTICLE = "http://apis.guokr.com/handpick/v2/article.json?retrieve_type=by_offset&limit=20&ad=1&offset=";
    // 果壳文章具体信息
    public static final String GUOKR_DETAIL = "http://jingxuan.guokr.com/pick/";
    // 豆瓣一刻消息列表
    public static final String DOUBAN_MOMENT = "https://moment.douban.com/api/stream/date/";
    // 豆瓣文章具体内容
    public static final String DOUBAN_DETAIL = "https://moment.douban.com/api/post/";

    public static final String READ_TYPE = "read_type";
    public static final String READ_ID  = "read_id";
    public static final String READ_TITLE  = "read_title";
    public static final String READ_MSG  = "read_msg";
    public static final String READ_URL  = "read_url";
    public static final int TYPE_ZHIHU  = 1001;
    public static final int TYPE_DOUBAN = 1002;
    public static final int TYPE_GUOKE = 1003;
}
