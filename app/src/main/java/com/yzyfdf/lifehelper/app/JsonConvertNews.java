package com.yzyfdf.lifehelper.app;

import com.lzy.okgo.convert.Converter;

import okhttp3.Response;

public class JsonConvertNews<T> implements Converter<T> {

    @Override
    public T convertSuccess(Response response) throws Exception {

        try {
            return (T) response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
            response.close();
            if (e instanceof IllegalStateException) {
                throw new IllegalStateException("错误数据:" + e.getMessage());
            }
            throw new RuntimeException("JsonConvert返回数据");
        }

    }
}