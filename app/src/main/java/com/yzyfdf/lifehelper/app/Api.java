package com.yzyfdf.lifehelper.app;

import android.content.Context;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okgo.request.PostRequest;
import com.lzy.okrx.RxAdapter;
import com.yzyfdf.lifehelper.bean.cookbean.CookCategoryBean;
import com.yzyfdf.lifehelper.bean.cookbean.CookListBean;
import com.yzyfdf.lifehelper.bean.cookbean.CookMainBean;
import com.yzyfdf.lifehelper.bean.cookbean.CookSearchBean;
import com.yzyfdf.lifehelper.bean.read.DouBanDetailsBean;
import com.yzyfdf.lifehelper.bean.read.DouBanListBean;
import com.yzyfdf.lifehelper.bean.read.GuoKeListBean;
import com.yzyfdf.lifehelper.bean.read.ZhiHuDetailsBean;
import com.yzyfdf.lifehelper.bean.read.ZhiHuListBean;
import com.yzyfdf.lifehelper.bean.travel.TravelImpressBean;
import com.yzyfdf.lifehelper.bean.travel.TravelRoutesBean;
import com.yzyfdf.lifehelper.bean.weather.WeatherBean;

import java.util.HashMap;

import okhttp3.MediaType;
import rx.Observable;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class Api {
    public static volatile Api api;

    private Api() {
    }

    public static Api getInstance() {

        if (api == null) {
            api = new Api();
        }
        return api;
    }

    public HashMap<String, Object> addBaseParams(HashMap<String, Object> params) {
        return params;
    }


    private PostRequest getTravelRequest(Context context, String url, HashMap<String, Object> params) {
        return OkGo.getInstance()
                .post(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                ;
    }

    private GetRequest getReadRequest(Context context, String url, HashMap<String, Object> params) {
        return OkGo.getInstance()
                .get(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                ;
    }

    private PostRequest getCookRequest(Context context, String url, HashMap<String, Object> params) {
        HttpHeaders headers = new HttpHeaders();
        headers.put("version", "647.2");
        HashMap<String, Object> map = addBaseParams(new HashMap<String, Object>());
        map.put(Constant.PARAM, params);
        return OkGo.getInstance()
                .addCommonHeaders(headers)
                .post(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                .upJson(new Gson().toJson(map));
    }

    private PostRequest getCookRequest2(Context context, String url, String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.put("version", "647.2");
        return OkGo.getInstance()
                .addCommonHeaders(headers)
                .post(url)
                .tag(context)//以对应activity或fragment作为网络请求tag，以便即时取消网络请求
                .upString(json, MediaType.parse("application/x-www-form-urlencoded"));
    }

    //食谱主页
    public Observable<CookMainBean> queryCookHome(Context context, int num) {
        HashMap<String, Object> params = new HashMap<>();
        return getCookRequest(context, Constant.cook_home + num + "/30", params).getCall(new JsonConvert<CookMainBean>() {
        }, RxAdapter.<CookMainBean>create());
    }

    //食谱专辑
    public Observable<CookListBean> queryCookList(Context context, int id, int num) {
        HashMap<String, Object> params = new HashMap<>();
        return getCookRequest(context, Constant.cook_list + id + "/" + num, params).getCall(new JsonConvert<CookListBean>() {
        }, RxAdapter.<CookListBean>create());
    }

    //食谱分类
    public Observable<CookCategoryBean> qureyCatalogs(Context context) {
        HashMap<String, Object> params = new HashMap<>();
        return getCookRequest(context, Constant.cook_category, params).getCall(new JsonConvert<CookCategoryBean>() {
        }, RxAdapter.<CookCategoryBean>create());
    }

    //食谱搜索
    public Observable<CookSearchBean> search(Context context, String keyWord, int num) {
        return getCookRequest2(context, Constant.cook_search + num, "order=0&keyword=" + keyWord).getCall(new JsonConvert<CookSearchBean>() {
        }, RxAdapter.<CookSearchBean>create());
    }

    //天气
    public Observable<WeatherBean> queryWeather(Context context, String city) {
        HashMap<String, Object> params = new HashMap<>();
        return getReadRequest(context, Constant.weather_weather + city, params).getCall(new JsonConvertNews<WeatherBean>() {
        }, RxAdapter.create());
    }

    //知乎
    public Observable<ZhiHuListBean> queryDaily(Context context, String url) {
        HashMap<String, Object> params = new HashMap<>();
        return getReadRequest(context, Constant.ZHIHU_NEWS + url, params).getCall(new JsonConvertNews<ZhiHuListBean>() {
        }, RxAdapter.<ZhiHuListBean>create());
    }

    //知乎详情
    public Observable<ZhiHuDetailsBean> queryZhiHuDetails(Context context, int id) {
        HashMap<String, Object> params = new HashMap<>();
        return getReadRequest(context, Constant.ZHIHU_NEWS + id, params).getCall(new JsonConvertNews<ZhiHuDetailsBean>() {
        }, RxAdapter.<ZhiHuDetailsBean>create());
    }

    //豆瓣
    public Observable<DouBanListBean> queryMoment(Context context, String date) {
        HashMap<String, Object> params = new HashMap<>();
        return getReadRequest(context, Constant.DOUBAN_MOMENT + date, params).getCall(new JsonConvertNews<DouBanListBean>() {
        }, RxAdapter.<DouBanListBean>create());
    }

    //豆瓣详情
    public Observable<DouBanDetailsBean> queryDouBanDetails(Context context, int id) {
        HashMap<String, Object> params = new HashMap<>();
        return getReadRequest(context, Constant.DOUBAN_DETAIL + id, params).getCall(new JsonConvertNews<DouBanDetailsBean>() {
        }, RxAdapter.<DouBanDetailsBean>create());
    }

    //果壳
    public Observable<GuoKeListBean> queryArticle(Context context, int num) {
        HashMap<String, Object> params = new HashMap<>();
        return getReadRequest(context, Constant.GUOKR_ARTICLE + num, params).getCall(new JsonConvertNews<GuoKeListBean>() {
        }, RxAdapter.<GuoKeListBean>create());
    }

    //果壳详情
    public Observable<String> queryGuoKeDetails(Context context, int id) {
        HashMap<String, Object> params = new HashMap<>();
        return getReadRequest(context, Constant.GUOKR_DETAIL + id, params).getCall(new JsonConvertNews2<String>() {
        }, RxAdapter.<String>create());
    }


    public Observable<TravelRoutesBean> getRoutes(Context context, int num) {
        HashMap<String, Object> params = new HashMap<>();
        return getTravelRequest(context, Constant.travel_routes + num, params).getCall(new JsonConvertTravel<TravelRoutesBean>() {
        }, RxAdapter.<TravelRoutesBean>create());
    }

    public Observable<TravelImpressBean> getImpress(Context context, String time) {
        HashMap<String, Object> params = new HashMap<>();
        return getTravelRequest(context, Constant.travel_impresss + time, params).getCall(new JsonConvertTravel<TravelImpressBean>() {
        }, RxAdapter.<TravelImpressBean>create());
    }

}
