package com.liuchuanzheng.lcz_guigumall.app;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2017/6/11 0011.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initOkHttpUtils();
    }

    /**
     * 初始化OkHttpUtils
     */
    private void initOkHttpUtils() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(1000L, TimeUnit.MILLISECONDS)
                .readTimeout(1000L,TimeUnit.MILLISECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }
}
