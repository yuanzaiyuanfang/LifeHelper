package com.yzyfdf.lifehelper.bean.travel;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class MyItineraryBean {
    private MyItineraryTitle myItineraryTitle;
    private RouteDetailsBean.ItineraryBean.LocationsBean locationsBean;

    public  MyItineraryBean(MyItineraryTitle myItineraryTitle, RouteDetailsBean.ItineraryBean.LocationsBean locationsBean) {
        this.myItineraryTitle = myItineraryTitle;
        this.locationsBean = locationsBean;
    }

    public MyItineraryTitle getMyItineraryTitle() {
        return myItineraryTitle;
    }

    public void setMyItineraryTitle(MyItineraryTitle myItineraryTitle) {
        this.myItineraryTitle = myItineraryTitle;
    }

    public RouteDetailsBean.ItineraryBean.LocationsBean getLocationsBean() {
        return locationsBean;
    }

    public void setLocationsBean(RouteDetailsBean.ItineraryBean.LocationsBean locationsBean) {
        this.locationsBean = locationsBean;
    }

    public static class MyItineraryTitle {
        private String day;
        private String time;
        private String week;
        private String city;
        private String desc;

        public  MyItineraryTitle(String day, String time, String week, String city, String desc) {
            this.day = day;
            this.time = time;
            this.week = week;
            this.city = city;
            this.desc = desc;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
