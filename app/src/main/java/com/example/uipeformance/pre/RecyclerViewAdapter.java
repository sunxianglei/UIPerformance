package com.example.uipeformance.pre;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.uipeformance.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunxianglei
 * @date 2019/4/9
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder> {

    private Context context;
    private List<List<String>> datas;

    public RecyclerViewAdapter(Context context, List<List<String>> datas){
        this.context = context;
        this.datas = datas;
        if(datas == null){
            this.datas = new ArrayList<>();
        }
    }

    public void setDatas(List<List<String>> datas){
        this.datas = datas;
        notifyDataSetChanged();
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("RecyclerViewAdapter", "创建view：");
        RecyclerView innerRV = new RecyclerView(parent.getContext());
        innerRV.setLayoutManager(new LinearLayoutManager(parent.getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        return new Holder(innerRV);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Log.d("RecyclerViewAdapter", "绑定view：" + position);
        holder.recyclerView.setAdapter(new RecyclerViewSubAdapter(context, datas.get(position)));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        private RecyclerView recyclerView;

        public Holder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView;

        }
    }
}
