package com.example.jiaofenghangks.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jiaofenghangks.R;
import com.example.jiaofenghangks.adapter.RecyAdapter;
import com.example.jiaofenghangks.bean.AdBean;
import com.example.jiaofenghangks.bean.AdDbbean;
import com.example.jiaofenghangks.model.ImpModel;
import com.example.jiaofenghangks.presenter.ImpAdPresenter;
import com.example.jiaofenghangks.util.Dao;
import com.example.jiaofenghangks.view.AdView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment implements AdView {


    private View view;
    private RecyclerView mRecy;
    private ArrayList<AdBean.DataBean.DatasBean> list;
    private RecyAdapter adapter;
    public OneFragment() {
        // Required empty public constructor
    }
    //懒加载
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            initData();
        } else {
            if (list != null && list.size() > 0) {
                list.clear();
                adapter.notifyDataSetChanged();
            }
        }
    }

    private void initData() {
        ImpAdPresenter impAdPresenter = new ImpAdPresenter(new ImpModel(), this);
        impAdPresenter.getAd();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_one, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRecy = (RecyclerView) inflate.findViewById(R.id.recy);
        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new RecyAdapter(getActivity(), list);
        mRecy.setAdapter(adapter);
        //列表展示数据
        adapter.setOnItemCliclListener(new RecyAdapter.OnItemCliclListener() {
            @Override
            public void onItemClick(int position) {
                Dao dao = Dao.getDao();
                AdBean.DataBean.DatasBean datasBean = list.get(position);
                AdDbbean adDbbean = new AdDbbean();
                adDbbean.setId(Long.valueOf(position));
                adDbbean.setChapterName(datasBean.getChapterName());
                adDbbean.setDesc(datasBean.getDesc());
                adDbbean.setEnvelopePic(datasBean.getEnvelopePic());
                long insert = dao.insert(adDbbean);
                if (insert >= 0) {
                    Toast.makeText(getActivity(), "收藏 ", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "收藏失败或者您已收藏", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onSuccess(List<AdBean.DataBean.DatasBean> adbean) {
        list.addAll(adbean);
        adapter.notifyDataSetChanged();
        Log.e("tag", adbean + "");
    }
    @Override
    public void onFail(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }
}
