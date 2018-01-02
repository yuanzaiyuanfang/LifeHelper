package com.yzyfdf.lifehelper.app;

import com.jaydenxiao.common.commonutils.JsonUtils;
import com.lzy.okgo.convert.Converter;
import com.yzyfdf.lifehelper.bean.live.LiveBaseBean;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;

public class JsonConvertLive<T extends LiveBaseBean> implements Converter<T> {


    @Override
    public T convertSuccess(Response response) throws Exception {


        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Type type = params[0];

        T t;

        try {
            t = (T) JsonUtils.fromJson(response.body().string(), type);
            response.close();

            if (t.getCode() != 1){
                throw new IllegalStateException("返回数据:" + response.body().string());
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.close();
            if (e instanceof IllegalStateException) {
                throw new IllegalStateException("错误数据:" + e.getMessage());
            }
            throw new RuntimeException("JsonConvert返回数据");
        }
        return t;

    }
}