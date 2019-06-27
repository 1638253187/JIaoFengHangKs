package com.example.jiaofenghangks.api;

import com.example.jiaofenghangks.bean.AdBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface AdServer {
    String baseurl="https://www.wanandroid.com/";
    @GET()
    Observable<AdBean>getAd(@Url String url) ;
}
