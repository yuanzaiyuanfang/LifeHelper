package com.yzyfdf.lifehelper.util;

import android.text.TextUtils;

import com.orhanobut.hawk.Hawk;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.bean.cookbean.MyFavoriteBean;

import java.util.ArrayList;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class HawkUtil {
    public static boolean addFavorite(MyFavoriteBean bean) {
        try {
            ArrayList<MyFavoriteBean> list = Hawk.get(Constant.favorites, new ArrayList<MyFavoriteBean>());
            list.add(0,bean);
            Hawk.put(Constant.favorites, list);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean removeFavorite(MyFavoriteBean bean) {
        try {
            ArrayList<MyFavoriteBean> list = Hawk.get(Constant.favorites, new ArrayList<MyFavoriteBean>());
            for (int i = 0; i < list.size(); i++) {
                MyFavoriteBean myFavoriteBean = list.get(i);
                if (TextUtils.equals(bean.getId(), myFavoriteBean.getId())) {
                    list.remove(myFavoriteBean);
                    Hawk.put(Constant.favorites, list);
                    i--;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean removeFavorites(ArrayList<MyFavoriteBean> removeList) {
        try {
            ArrayList<MyFavoriteBean> list = Hawk.get(Constant.favorites, new ArrayList<MyFavoriteBean>());
            for (int i = 0; i < list.size(); i++) {
                MyFavoriteBean myFavoriteBean = list.get(i);
                for (MyFavoriteBean favoriteBean : removeList) {
                    if (TextUtils.equals(myFavoriteBean.getId(), favoriteBean.getId())) {
                        list.remove(myFavoriteBean);
                        i--;
                    }
                }
            }
            Hawk.put(Constant.favorites, list);
            return true;
        } catch (Exception e) {
            return false;
        }

    }


    public static boolean isFavorite(MyFavoriteBean bean) {
        ArrayList<MyFavoriteBean> list = Hawk.get(Constant.favorites, new ArrayList<MyFavoriteBean>());
        for (MyFavoriteBean myFavoriteBean : list) {
            if (TextUtils.equals(bean.getId(), myFavoriteBean.getId())) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<MyFavoriteBean> getFavorite() {
        return Hawk.get(Constant.favorites, new ArrayList<MyFavoriteBean>());

    }


}
