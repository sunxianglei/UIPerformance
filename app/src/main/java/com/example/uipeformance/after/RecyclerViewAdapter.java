package com.example.uipeformance.after;

import android.content.Context;
import android.support.v7.util.DiffUtil;
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
    RecyclerView.RecycledViewPool mSharedPool = new RecyclerView.RecycledViewPool();

    public RecyclerViewAdapter(Context context, List<List<String>> datas){
        this.context = context;
        if(this.datas == null){
            this.datas = new ArrayList<>();
        }
        this.datas.addAll(datas);
    }

    public void setDatas(List<List<String>> datas){
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffCallBack(this.datas, datas));
        result.dispatchUpdatesTo(this);
        this.datas.clear();
        this.datas.addAll(datas);
    }


    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("RecyclerViewAdapter", "创建view：");
        RecyclerView innerRV = new RecyclerView(parent.getContext());
        innerRV.setLayoutManager(new LinearLayoutManager(parent.getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        innerRV.setRecycledViewPool(mSharedPool);
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

    private class DiffCallBack extends DiffUtil.Callback {

        private List<List<String>> olds;
        private List<List<String>> news;

        public DiffCallBack(List<List<String>> olds, List<List<String>> news){
            this.olds = olds;
            this.news = news;
        }

        @Override
        public int getOldListSize() {
            return olds.size();
        }

        @Override
        public int getNewListSize() {
            return news.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return true;
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            int oldSize = olds.get(oldItemPosition).size();
            int newSize = news.get(newItemPosition).size();
            if(oldSize != newSize){
                return false;
            }
            int i = 0;
            for(i=0;i<oldSize;i++){
                if(!olds.get(oldItemPosition).get(i).equals(news.get(newItemPosition).get(i))){
                    break;
                }
            }
            if(i < oldSize){
                return false;
            }
            Log.d("RecyclerViewAdapter", "重复的item：" + newItemPosition);
            return true;
        }
    }
}

