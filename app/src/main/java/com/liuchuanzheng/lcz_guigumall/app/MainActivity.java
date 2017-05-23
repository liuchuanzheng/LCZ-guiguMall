package com.liuchuanzheng.lcz_guigumall.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.liuchuanzheng.lcz_guigumall.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.frameLayout)
    FrameLayout frameLayout;
    @Bind(R.id.rg_main)
    RadioGroup rgMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //将butterKnife与布局文件绑定
        ButterKnife.bind(this);
        //默认选中第一个按钮
        rgMain.check(R.id.rb_home);
    }
}
