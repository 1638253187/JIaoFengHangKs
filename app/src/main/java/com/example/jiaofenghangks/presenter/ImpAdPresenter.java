package com.example.jiaofenghangks.presenter;

import com.example.jiaofenghangks.bean.AdBean;
import com.example.jiaofenghangks.callback.AdCallBack;
import com.example.jiaofenghangks.model.AdModel;
import com.example.jiaofenghangks.view.AdView;

import java.util.List;

public class ImpAdPresenter implements AdPresenter, AdCallBack {
    private AdModel adModel;
    private AdView adView;

    public ImpAdPresenter(AdModel adModel, AdView adView) {
        this.adModel = adModel;
        this.adView = adView;
    }

    @Override
    public void getAd() {
        if (adModel!=null){
            adModel.getAd(this);
        }
    }

    @Override
    public void onSuccess(List<AdBean.DataBean.DatasBean> adbean) {
        if (adView!=null){
            adView.onSuccess(adbean);
        }
    }

    @Override
    public void onFail(String error) {
        if (adView!=null){
            adView.onFail(error);
        }
    }
}
