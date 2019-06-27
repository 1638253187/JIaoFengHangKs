package com.example.jiaofenghangks.view;

import com.example.jiaofenghangks.bean.AdBean;

import java.util.List;

public interface AdView {
    void onSuccess(List<AdBean.DataBean.DatasBean> adbean);
    void onFail(String error);
}
