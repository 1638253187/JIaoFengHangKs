package com.example.jiaofenghangks.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jiaofenghangks.R;
import com.example.jiaofenghangks.bean.AdBean;
import com.example.jiaofenghangks.bean.AdDbbean;

import java.util.ArrayList;

public class RecyDbAdapter extends RecyclerView.Adapter<RecyDbAdapter.ViewHolder> {
    private Context context;
    private ArrayList<AdDbbean>list;
    private OnItemCliclListener onItemCliclListener;

    public void setOnItemCliclListener(OnItemCliclListener onItemCliclListener) {
        this.onItemCliclListener = onItemCliclListener;
    }

    public RecyDbAdapter(Context context, ArrayList<AdDbbean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        AdDbbean datasBean = list.get(i);
        viewHolder.tv_chapterName.setText(datasBean.getChapterName());
        viewHolder.tv_desc.setText(datasBean.getDesc());
        Glide.with(context).load(datasBean.getEnvelopePic()).into(viewHolder.iv_envelopePic);
        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemCliclListener!=null){
                    onItemCliclListener.onItemClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private ImageView iv_envelopePic;
        private TextView tv_chapterName,tv_desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
              iv_envelopePic = itemView.findViewById(R.id.iv_envelopePic);
            tv_desc = itemView.findViewById(R.id.tv_desc);
            tv_chapterName = itemView.findViewById(R.id.tv_chapterName);
            view=itemView;
        }
    }
    public interface OnItemCliclListener {
       void onItemClick(int position);
    }
}
