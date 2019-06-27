package com.example.jiaofenghangks.fragment;


import android.os.Bundle;
import android.os.Environment;
import android.os.health.TimerStat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.jiaofenghangks.R;
import com.example.jiaofenghangks.adapter.RecyAdapter;
import com.example.jiaofenghangks.adapter.RecyDbAdapter;
import com.example.jiaofenghangks.bean.AdDbbean;
import com.example.jiaofenghangks.util.Dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {


    private RecyclerView mRecy;
    private ProgressBar mPb;
    private ArrayList<AdDbbean> list;
    private RecyDbAdapter adapter;

    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_two, container, false);
        initView(inflate);
        initPb();
        return inflate;
    }

    private void initPb() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        Request request = new Request.Builder()
                .get()
                .url("http://cdn.banmi.com/banmiapp/apk/banmi_330.apk")
                .build();
        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("tag",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                InputStream inputStream = body.byteStream();
                long length = body.contentLength();
                saveFile(inputStream,length, Environment.getExternalStorageDirectory()+"/凤航.apk");
            }
        });

    }

    private void saveFile(InputStream inputStream, final long length, String path) {
        try {
            FileOutputStream outputStream = new FileOutputStream(new File(path));
            int len =0;
            int count=0;

            byte[] bytes = new byte[1024 * 20];
            while ((len=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
                count+=len;
                Log.e("tag","下载进度："+count+"总长度："+length);
                final int finalCount1 = count;
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mPb.setMax((int) length);
                        mPb.setProgress(finalCount1);
                        int progress = mPb.getProgress();
                        if (progress==length){
                            mPb.setVisibility(View.GONE);
                        }
                    }
                });
            }

            inputStream.close();
            outputStream.close();
            Log.e("tag","下载完成");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()){
            initData();
        }else {
            if (list!=null&&list.size()>0){
                list.clear();
                adapter.notifyDataSetChanged();
            }
        }
    }

    private void initData() {
        List<AdDbbean> query = Dao.getDao().query();
        list.addAll(query);
        adapter.notifyDataSetChanged();
    }

    private void initView(View inflate) {
        mRecy = (RecyclerView) inflate.findViewById(R.id.recy);
        mPb = (ProgressBar) inflate.findViewById(R.id.pb);
        mRecy.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new RecyDbAdapter(getActivity(), list);
        mRecy.setAdapter(adapter);
    }


}
