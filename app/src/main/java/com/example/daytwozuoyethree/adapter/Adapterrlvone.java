package com.example.daytwozuoyethree.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
//import com.example.daytwozuoyethree.BaseApp;
import com.example.daytwozuoyethree.R;
//import com.example.daytwozuoyethree.SystemUtil;
import com.example.daytwozuoyethree.bean.Beanone;

import java.util.ArrayList;

public class Adapterrlvone extends RecyclerView.Adapter<Adapterrlvone.Holderone> {
    private ArrayList<Beanone.ResultsBean> list;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public Adapterrlvone(ArrayList<Beanone.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holderone onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_one, viewGroup, false);
        return new Holderone(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holderone holderone, final int i) {
        Beanone.ResultsBean bean = list.get(i);
        Glide.with(context).load(bean.getUrl()).into(holderone.iv_url);
        holderone.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnItemClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holderone extends RecyclerView.ViewHolder {

        public final ImageView iv_url;

        public Holderone(@NonNull View itemView) {
            super(itemView);
            iv_url = itemView.findViewById(R.id.iv_url);
        }
    }
    public interface OnItemClickListener{
        void OnItemClick(int i);
    }
}
