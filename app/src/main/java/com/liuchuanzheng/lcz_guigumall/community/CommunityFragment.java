package com.liuchuanzheng.lcz_guigumall.community;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.liuchuanzheng.lcz_guigumall.base.BaseFragment;

/**
 * Created by 刘传政 on 2017/5/25 0025.
 * 发现界面
 *
 */

public class CommunityFragment extends BaseFragment {
    private TextView textView;
    @Override
    public View initView() {
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    protected void initData() {
        textView.setText("我是发现界面");
    }
}
