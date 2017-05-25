package com.liuchuanzheng.lcz_guigumall.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.liuchuanzheng.lcz_guigumall.R;
import com.liuchuanzheng.lcz_guigumall.base.BaseFragment;
import com.liuchuanzheng.lcz_guigumall.community.CommunityFragment;
import com.liuchuanzheng.lcz_guigumall.home.HomeFragment;
import com.liuchuanzheng.lcz_guigumall.shoppingcart.ShoppingFragment;
import com.liuchuanzheng.lcz_guigumall.type.TypeFragment;
import com.liuchuanzheng.lcz_guigumall.user.UserFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity {

    @Bind(R.id.frameLayout)
    FrameLayout frameLayout;
    @Bind(R.id.rg_main)
    RadioGroup rgMain;
    private Context context;
    private ArrayList<BaseFragment> fragments;
    private int position = 0;
    private BaseFragment tempFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        //将butterKnife与布局文件绑定
        ButterKnife.bind(this);
        initData();
        initListenter();

    }

    private void initListenter() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        position = 0;
                        break;
                    case R.id.rb_type:
                        position = 1;
                        break;
                    case R.id.rb_community:
                        position = 2;
                        break;
                    case R.id.rb_cart:
                        position = 3;
                        break;
                    case R.id.rb_user:
                        position = 4;
                        break;
                    default:
                        position = 0;
                        break;
                }
                BaseFragment toFragment = fragments.get(position);
                switchFragment(tempFragment,toFragment);
            }


        });
        //默认选中第一个按钮
        rgMain.check(R.id.rb_home);
    }

    private void switchFragment(BaseFragment fromFragment, BaseFragment toFragment) {
        if (fromFragment != toFragment){
            tempFragment = toFragment;
            FragmentTransaction  transaction = getSupportFragmentManager().beginTransaction();
            if (toFragment != null){
                if (!toFragment.isAdded()){
                    if (fromFragment != null){
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.frameLayout,toFragment).commit();
                }else{
                    if (fromFragment != null){
                        transaction.hide(fromFragment);
                    }
                    transaction.show(toFragment).commit();
                }
            }

        }
    }

    private BaseFragment getFragment(int position) {
        BaseFragment baseFragment;
        if (fragments != null && fragments.size() >= 0){
            baseFragment = fragments.get(position);
        }else{
            baseFragment = null;
        }
        return baseFragment;
    }


    private void initData() {
        initFragment();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new TypeFragment());
        fragments.add(new CommunityFragment());
        fragments.add(new ShoppingFragment());
        fragments.add(new UserFragment());
    }
}
