package com.example.uipeformance.pre;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
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
 * @date 2019/4/10
 */
public class RecyclerViewSubAdapter extends RecyclerView.Adapter<RecyclerViewSubAdapter.Holder> {

    private Context context;
    private List<String> datas;

    public RecyclerViewSubAdapter(Context context, List<String> datas){
        this.context = context;
        if(this.datas == null){
            this.datas = new ArrayList<>();
        }
        this.datas.addAll(datas);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context).inflate(R.layout.item_recycler_view, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
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
