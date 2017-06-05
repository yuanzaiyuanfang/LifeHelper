package com.jaydenxiao.common.commonwidget.pickerutil;

import android.content.Context;

import com.google.gson.Gson;
import com.jaydenxiao.common.commonwidget.pickerutil.components.bean.Province;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Conan on 2016/11/23.
 */

public class PickerUtil {

    public static ArrayList<Province> getProvince(Context context) {

        ArrayList<Province> provinces = new ArrayList<>();
        try {
            InputStreamReader inputReader = new InputStreamReader(context.getResources().getAssets().open("address.txt"));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line = "";
            String Result = "";
            while ((line = bufReader.readLine()) != null)
                Result += line;
            JSONArray jsonList = new JSONArray(Result);
            Gson gson = new Gson();
            for (int i = 0; i < jsonList.length(); i++) {
                provinces.add(gson.fromJson(jsonList.getString(i), Province.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return provinces;
    }

    public static int getIndex(List<String> list,String item ) {
        int index;
        try {
            index = list.indexOf(item);
        }catch (Exception e){
            index = 0;
        }

        return index == -1?0:index;
    }
}
