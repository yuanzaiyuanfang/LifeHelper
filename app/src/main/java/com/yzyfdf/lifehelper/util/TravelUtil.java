package com.yzyfdf.lifehelper.util;

import java.util.List;

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
        String replace = s.replace("\"", "").replace("[", "").replace("]", "").trim();
        String[] split = replace.split(",");
        return split;
    }

    public static String toStrImages(List<String> list) {
        StringBuffer sb = new StringBuffer("[");
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            sb.append("\"").append(s).append("\"");
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
