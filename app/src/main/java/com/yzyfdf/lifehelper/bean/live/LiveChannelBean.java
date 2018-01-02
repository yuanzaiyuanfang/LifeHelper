package com.yzyfdf.lifehelper.bean.live;

import java.util.List;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class LiveChannelBean extends LiveBaseBean {

    /**
     * data : {"rows":["圣诞布置","收纳大法","配色方案","洗刷刷","家具灯具","实物测评","布艺搭配","DIY","绿植插花","家居地图","租客指南","剧里的家"]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<String> rows;

        public List<String> getRows() {
            return rows;
        }

        public void setRows(List<String> rows) {
            this.rows = rows;
        }
    }
}
