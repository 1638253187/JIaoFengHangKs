package com.example.jiaofenghangks.model;

import com.example.jiaofenghangks.api.AdServer;
import com.example.jiaofenghangks.bean.AdBean;
import com.example.jiaofenghangks.callback.AdCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpModel implements AdModel {
    @Override
    public void getAd(final AdCallBack adCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AdServer.baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        AdServer adServer = retrofit.create(AdServer.class);

        Observable<AdBean> observable = adServer.getAd("project/list/1/json?cid=294");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AdBean adBean) {
                    adCallBack.onSuccess(adBean.getData().getDatas());
                    }

                    @Override
                    public void onError(Throwable e) {
                    adCallBack.onFail("网络错误："+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
