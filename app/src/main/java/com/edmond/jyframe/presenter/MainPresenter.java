package com.edmond.jyframe.presenter;

import com.edmond.jyframe.activity.MainActivity;
import com.edmond.jyframe.classes.Banner;
import com.edmond.jyframe.module.banner.BannerPresenterInterface;
import com.edmond.jyframe.module.list.ListPresenterInterface;
import com.edmond.jyframe.module.banner.BannerModel;
import com.edmond.jyframe.module.list.ListModel;
import com.edmond.jyframe.presenter.base.BasePresenter;

/**
 * Created by edmond on 17-3-19.
 * @author edmond
 */

public class MainPresenter extends BasePresenter<MainActivity> implements BannerPresenterInterface,ListPresenterInterface {

    public MainPresenter(MainActivity view,Class... classes) {
        super(view,classes);
    }

    @Override
    public void getBanners() {
        ((BannerModel)getModel(BannerModel.class)).getBanners(this);
    }

    @Override
    public void returnBanners(Banner banner) {
        getView().returnBanners(banner);
    }

    @Override
    public void getList() {
        ((ListModel)getModel(ListModel.class)).getList(this);
    }

    @Override
    public void returnList() {
        getView().returnList();
    }
}
