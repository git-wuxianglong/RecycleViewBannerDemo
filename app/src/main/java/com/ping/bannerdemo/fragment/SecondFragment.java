package com.ping.bannerdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ping.bannerdemo.R;


/**
 * Created by wuxl_ on 2017/7/29.
 */
public class SecondFragment extends Fragment {

    private View root_view;

    static final String TITLE = "TITLE";

    private String title = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        root_view = inflater.inflate(R.layout.first_fragment, null);
        return root_view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static final SecondFragment newInstance(String title) {
        SecondFragment f = new SecondFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(TITLE, title);
        f.setArguments(bdl);
        return f;
    }
}
