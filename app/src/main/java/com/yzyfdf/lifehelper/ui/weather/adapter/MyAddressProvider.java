package com.yzyfdf.lifehelper.ui.weather.adapter;

import android.text.TextUtils;

import com.yzyfdf.lifehelper.bean.weather.AddressBean;

import java.util.ArrayList;
import java.util.List;

import chihane.jdaddressselector.AddressProvider;
import chihane.jdaddressselector.model.City;
import chihane.jdaddressselector.model.County;
import chihane.jdaddressselector.model.Province;
import chihane.jdaddressselector.model.Street;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class MyAddressProvider implements AddressProvider {

    private List<AddressBean.ProvincesBean.CitiesBean> mCities;
    private AddressBean mBean;

    public MyAddressProvider(AddressBean bean) {
        mBean = bean;
    }

    @Override
    public void provideProvinces(AddressReceiver<Province> addressReceiver) {
        List<Province> provinces = getProvinces();
        addressReceiver.send(provinces);
    }

    @Override
    public void provideCitiesWith(int i, AddressReceiver<City> addressReceiver) {
        List<City> cities = getCities(i);
        addressReceiver.send(cities);
    }

    @Override
    public void provideCountiesWith(int i, AddressReceiver<County> addressReceiver) {
        ArrayList<County> counties = getCounties(i);
        addressReceiver.send(counties);
    }

    @Override
    public void provideStreetsWith(int i, AddressReceiver<Street> addressReceiver) {
        addressReceiver.send(null);
    }


    private ArrayList<County> getCounties(int i) {
        ArrayList<County> counties = new ArrayList<>();
        for (AddressBean.ProvincesBean.CitiesBean city : mCities) {
            if (TextUtils.equals(city.getAreaId(), String.valueOf(i))) {
                List<AddressBean.ProvincesBean.CitiesBean.CountiesBean> countiesBeen = city.getCounties();
                for (AddressBean.ProvincesBean.CitiesBean.CountiesBean bean : countiesBeen) {
                    County county = new County();
                    county.id = Integer.parseInt(bean.getAreaId());
                    county.name = bean.getAreaName();
                    counties.add(county);
                }
            }
        }
        return counties;
    }

    private List<City> getCities(int i) {
        ArrayList<City> citys = new ArrayList<>();
        for (AddressBean.ProvincesBean bean : mBean.getAddress()) {
            if (TextUtils.equals(bean.getAreaId(), String.valueOf(i))) {
                mCities = bean.getCities();
                for (AddressBean.ProvincesBean.CitiesBean city : mCities) {
                    City city1 = new City();
                    city1.id = Integer.parseInt(city.getAreaId());
                    city1.name = city.getAreaName();
                    citys.add(city1);
                }
            }
        }
        return citys;
    }

    private List<Province> getProvinces() {
        List<AddressBean.ProvincesBean> list = mBean.getAddress();
        List<Province> provinceList = new ArrayList<>();
        for (AddressBean.ProvincesBean cityListBean : list) {
            Province province = new Province();
            province.id = Integer.parseInt(cityListBean.getAreaId());
            province.name = cityListBean.getAreaName();
            provinceList.add(province);
        }

        return provinceList;
    }
}
