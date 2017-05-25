package com.liuchuanzheng.lcz_guigumall.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.liuchuanzheng.lcz_guigumall.R;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //两秒后启动主界面
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //这是运行在主线程的,因为handler在主线程创建
                //开启主界面,并关闭自己
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                finish();
            }
        },2000);
    }
}
