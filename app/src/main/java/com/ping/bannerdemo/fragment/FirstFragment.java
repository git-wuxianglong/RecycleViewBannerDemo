package com.ping.bannerdemo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jwenfeng.library.pulltorefresh.BaseRefreshListener;
import com.jwenfeng.library.pulltorefresh.PullToRefreshLayout;
import com.ping.bannerdemo.R;
import com.ping.bannerdemo.adpater.MyAdapter;
import com.ping.bannerdemo.global.App;
import com.ping.bannerdemo.loader.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;


/**
 * 显示页面
 * Created by wuxl_ on 2017/7/29.
 */
public class FirstFragment extends Fragment {

    private View root_view;

    private MyAdapter myAdapter;
    static final int REFRESH_COMPLETE = 0X1112;
    static final int LOADMORE_COMPLETE = 0X1113;

    Banner mBanner;

    RecyclerView mRecyclerView;

    PullToRefreshLayout mSwipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        root_view = inflater.inflate(R.layout.activity_main, null);
        initList();
        return root_view;
    }

    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case REFRESH_COMPLETE:
                    mSwipeRefreshLayout.finishRefresh();
                    break;
                case LOADMORE_COMPLETE:
                    mSwipeRefreshLayout.finishLoadMore();
                    break;
            }
        }
    };

    private void initList() {
        mRecyclerView = (RecyclerView) root_view.findViewById(R.id.recyclerView);
        mSwipeRefreshLayout = (PullToRefreshLayout) root_view.findViewById(R.id.black_tech_pull);

        View header = LayoutInflater.from(getContext()).inflate(R.layout.header, null);
        mBanner = (Banner) header.findViewById(R.id.banner);
        mBanner.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, App.H / 4));

        String[] data = getResources().getStringArray(R.array.demo_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        myAdapter = new MyAdapter(getContext(), data);
        myAdapter.setHeaderView(mBanner);
        mRecyclerView.setAdapter(myAdapter);

        initListener();

        mBanner.setImages(App.images)
                .setImageLoader(new GlideImageLoader())
                .start();
    }

    public static final FirstFragment newInstance(String title) {
        FirstFragment f = new FirstFragment();
        return f;
    }

    private void initListener() {
        //刷新和加载更多
        mSwipeRefreshLayout.setRefreshListener(new BaseRefreshListener() {
            @Override
            public void refresh() {
                mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);
            }

            @Override
            public void loadMore() {
                mHandler.sendEmptyMessageDelayed(LOADMORE_COMPLETE, 2000);
            }
        });

    }
}
