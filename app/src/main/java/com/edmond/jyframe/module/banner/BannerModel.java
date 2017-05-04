package com.edmond.jyframe.module.banner;

import com.edmond.jyframe.classes.Banner;
import com.edmond.jyframe.module.BaseModel;

/**
 * Created by edmond on 17-3-21.
 * @author edmond
 */

public class BannerModel extends BaseModel<Banner> implements BannerModelInterface{
    @Override
    public void getBanners(BannerPresenterInterface presenter) {
        presenter.returnBanners(getData());
    }
}
