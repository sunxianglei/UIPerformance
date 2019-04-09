package com.example.uipeformance.pre;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
    private List<String> datas;

    public RecyclerViewAdapter(Context context, List<String> datas){
        this.context = context;
        this.datas = datas;
        if(datas == null){
            this.datas = new ArrayList<>();
        }
    }

    public void setDatas(List<String> datas){
        this.datas = datas;
        notifyDataSetChanged();
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context).inflate(R.layout.item_recycler_view, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.textView.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        private TextView textView;

        public Holder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.tv_desc);
        }
    }
}
