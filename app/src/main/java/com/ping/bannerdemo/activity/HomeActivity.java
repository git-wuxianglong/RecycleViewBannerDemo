package com.ping.bannerdemo.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.flyco.tablayout.SlidingTabLayout;
import com.ping.bannerdemo.R;
import com.ping.bannerdemo.fragment.SecondFragment;
import com.ping.bannerdemo.fragment.FirstFragment;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    SlidingTabLayout tab_layout;
    ViewPager tab_pager;

    private ArrayList<Fragment> fragments = new ArrayList<>();
    //   private List<String> titles = new ArrayList<>();
    String[] titles = {"黑科技", "干货", "测评", "新品"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tab_layout = (SlidingTabLayout) findViewById(R.id.tab_layout);
        tab_pager = (ViewPager) findViewById(R.id.tab_pager);

        initView();
        setPage();
    }

    private void initView() {

        FirstFragment fragment1 = FirstFragment.newInstance("Home");
        SecondFragment fragment2 = SecondFragment.newInstance("第1个fragment");
        SecondFragment fragment3 = SecondFragment.newInstance("第3个fragment");
        SecondFragment fragment4 = SecondFragment.newInstance("第4个fragment");

        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);

    }

    private void setPage() {
        //一步关联tablayout和viewpage
        tab_layout.setViewPager(tab_pager, titles, this, fragments);

    }

}

