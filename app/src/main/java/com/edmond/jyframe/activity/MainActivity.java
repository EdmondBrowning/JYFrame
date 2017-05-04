package com.edmond.jyframe.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.edmond.jyframe.R;
import com.edmond.jyframe.activity.base.BaseActivity;
import com.edmond.jyframe.adapter.TestAdapter;
import com.edmond.jyframe.classes.Banner;
import com.edmond.jyframe.module.banner.BannerViewInterface;
import com.edmond.jyframe.module.list.ListViewInterface;
import com.edmond.jyframe.module.banner.BannerModel;
import com.edmond.jyframe.module.list.ListModel;
import com.edmond.jyframe.presenter.MainPresenter;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<MainPresenter> implements BannerViewInterface,ListViewInterface{

    RecyclerView recyclerView ;
    TestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        adapter = new TestAdapter(this,new ArrayList<Integer>());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        getPresenter().getBanners();
//        getPresenter().getList();
    }

    @Override
    public Class[] initModelName() {
        Class[] classes = new Class[2];
        classes[0] = BannerModel.class;
        classes[1] = ListModel.class;
        return classes;
    }

    @Override
    public void getBanners() {

    }

    @Override
    public void returnBanners(Banner banner) {
        Log.d("TAG","returnBanners");
    }

    @Override
    public void getList() {

    }

    @Override
    public void returnList() {
        Log.d("TAG","returnList");
    }
}
