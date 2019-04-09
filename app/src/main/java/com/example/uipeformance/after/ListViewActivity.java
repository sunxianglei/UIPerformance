package com.example.uipeformance.after;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.uipeformance.R;

/**
 * @author sunxianglei
 * @date 2019/4/9
 */

public class ListViewActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.after_activity_listview);
    }

}
