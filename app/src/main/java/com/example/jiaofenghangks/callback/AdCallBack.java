package com.example.jiaofenghangks.callback;

import com.example.jiaofenghangks.bean.AdBean;

import java.util.List;

public interface AdCallBack {
    void onSuccess(List<AdBean.DataBean.DatasBean> adbean);
    void onFail(String error);
}
