package com.yzyfdf.lifehelper.util;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class TravelUtil {
    public static String getimage(String s) {
        String[] strings = getimages(s);
        return strings[0];
    }

    public static String[] getimages(String s) {
        String replace = s.replace("\"", "").replace("[", "").replace("]", "");
        String[] split = replace.split(",");
        return split;
    }
}
