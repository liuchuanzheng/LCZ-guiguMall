package com.liuchuanzheng.lcz_guigumall.home;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.liuchuanzheng.lcz_guigumall.R;
import com.liuchuanzheng.lcz_guigumall.base.BaseFragment;
import com.liuchuanzheng.lcz_guigumall.utils.Constants;
import com.liuchuanzheng.lcz_guigumall.utils.MyLogger;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Request;

/**
 * Created by 刘传政 on 2017/5/25 0025.
 * 主界面
 */

public class HomeFragment extends BaseFragment {
    private RecyclerView rvHome;
    private ImageView ib_top;
    private TextView tv_search_home;
    private TextView tv_message_home;

    @Override
    public View initView() {
        MyLogger.lczLog().i("主界面初始化了");
        View view = View.inflate(mContext, R.layout.fragment_home, null);
        rvHome = (RecyclerView) view.findViewById(R.id.rv_home);
        ib_top = (ImageView) view.findViewById(R.id.ib_top);
        tv_search_home = (TextView) view.findViewById(R.id.tv_search_home);
        tv_message_home = (TextView) view.findViewById(R.id.tv_message_home);
        // 设置点击事件
        initListener();
        return view;
    }

    @Override
    protected void initData() {
        //请求网络
        getDataFromNet();
    }
    public void getDataFromNet() {
        OkHttpUtils
                .get()
                .url(Constants.HOME_URL)
                .id(100)
                .build()
                .execute(new MyStringCallback());
    }
    public class MyStringCallback extends StringCallback {


        @Override
        public void onBefore(Request request, int id) {
        }

        @Override
        public void onAfter(int id) {
        }



        public void onError(Call call, Exception e, int id) {
            MyLogger.lczLog().i("联网失败" + e.getMessage());
        }

        @Override
        public void onResponse(String response, int id) {

           /* switch (id) {
                case 100:
                    if (response != null) {
                        processData(response);
                        adapter = new HomeRecycleAdapter(mContext, resultBean);
                        rvHome.setAdapter(adapter);

                        GridLayoutManager manager = new GridLayoutManager(getActivity(), 1);

                        //设置滑动到哪个位置了的监听
                        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                            @Override
                            public int getSpanSize(int position) {
                                if (position <= 3) {
                                    ib_top.setVisibility(View.GONE);
                                } else {
                                    ib_top.setVisibility(View.VISIBLE);
                                }
                                return 1;
                            }
                        });
                        //设置网格布局
                        rvHome.setLayoutManager(manager);

                        initListener();
                    }
                    break;
                case 101:
//                    Toast.makeText(mContext, "https", Toast.LENGTH_SHORT).show();
                    break;
            }*/
        }

    }
    private void initListener() {
        // 置顶的监听
        ib_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 回到顶部
                rvHome.scrollToPosition(0);
            }
        });
        // 搜素的监听
        tv_search_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, " 搜索",
                        Toast.LENGTH_SHORT).show();
            }
        });
        // 消息的监听
        tv_message_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, " 进入消息中心",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
