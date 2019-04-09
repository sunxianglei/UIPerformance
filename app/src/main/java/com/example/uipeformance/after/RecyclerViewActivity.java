package com.example.uipeformance.after;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.uipeformance.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunxianglei
 * @date 2019/4/9
 */

public class RecyclerViewActivity extends AppCompatActivity {

    private SmartRefreshLayout smartRefreshLayout;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adaper;
    private Handler mHandler = new Handler();
    private List<List<String>> datas = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.after_activity_recycler);
        initRecycler();
        initRefreshLayout();
        requestRefresh();
    }

    private void initRecycler(){
        recyclerView = (RecyclerView)findViewById(R.id.view_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaper = new RecyclerViewAdapter(this, datas);
        recyclerView.setAdapter(adaper);
    }

    private void initRefreshLayout(){
        smartRefreshLayout = (SmartRefreshLayout)findViewById(R.id.layout_refresh);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        requestRefresh();
                        refreshLayout.finishRefresh();
                    }
                }, 1000);
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        requestLoadMore();
                        refreshLayout.finishLoadMore();
                    }
                }, 1000);

            }
        });
    }

    private void requestRefresh(){
        datas.clear();
        addDatas();
        adaper.setDatas(datas);
    }

    private void requestLoadMore(){
        addDatas();
        adaper.setDatas(datas);
    }

    private void addDatas(){
        for(int i=0;i<20;i++) {
            List<String> data = new ArrayList<>();
            for(int j=0;j<10;j++) {
                data.add("你好" +i+j);
            }
            datas.add(data);
        }
    }

}
