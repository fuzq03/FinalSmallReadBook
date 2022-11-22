package com.example.smallredbook.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.smallredbook.R;
import com.example.smallredbook.adapter.ListenItem;
import com.example.smallredbook.adapter.RecyclerListenAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeLeftActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_home_left);

        Button button = findViewById(R.id.back_to_home_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeLeftActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout noHide = findViewById(R.id.home_left_no_hide);
        ConstraintLayout Hide = findViewById(R.id.home_left_hide);
        Hide.setVisibility(View.GONE);

        NestedScrollView scrollView = findViewById(R.id.home_left_scroll);
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(@NonNull NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if(scrollY > noHide.getHeight() - Hide.getHeight()) {
                    //显示hide控件并隐藏no_hide控件
                    Hide.setVisibility(View.VISIBLE);
                } else {
                    Hide.setVisibility(View.GONE);
                }
            }
        });

        List<ListenItem> list = initList();


        RecyclerView recyclerView = findViewById(R.id.home_left_listen_recycler);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setOrientation(layoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerListenAdapter adapter = new RecyclerListenAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    private List<ListenItem> initList(){
        List<ListenItem> list = new ArrayList<>();
        ListenItem listenItem1 = new ListenItem("初雪   >   ", R.drawable.main_head_profile);
        list.add(listenItem1);
        ListenItem listenItem2 = new ListenItem("别谈恋爱了   >   ", R.drawable.main_head_profile);
        list.add(listenItem2);
        ListenItem listenItem3 = new ListenItem("男人不值得   >   ", R.drawable.main_head_profile);
        list.add(listenItem3);
        ListenItem listenItem4 = new ListenItem("不要错过这条语音   >   ", R.drawable.main_head_profile);
        list.add(listenItem4);
        ListenItem listenItem5 = new ListenItem("我太牛了   >   ", R.drawable.main_head_profile);
        list.add(listenItem5);
        ListenItem listenItem6 = new ListenItem("简单的一天就过去了   >   ", R.drawable.main_head_profile);
        list.add(listenItem6);
        ListenItem listenItem7 = new ListenItem("哥们今天喝了八瓶   >   ", R.drawable.main_head_profile);
        list.add(listenItem7);
        ListenItem listenItem8 = new ListenItem("散我心中意难平   >   ", R.drawable.main_head_profile);
        list.add(listenItem8);
        ListenItem listenItem9 = new ListenItem("烤地瓜之路   >   ", R.drawable.main_head_profile);
        list.add(listenItem9);
        ListenItem listenItem10 = new ListenItem("可能是月亮不会眨眼   >   ", R.drawable.main_head_profile);
        list.add(listenItem10);
        ListenItem listenItem11 = new ListenItem("二号开启   >   ", R.drawable.main_head_profile);
        list.add(listenItem11);
        ListenItem listenItem12 = new ListenItem("这是哪里   >   ", R.drawable.main_head_profile);
        list.add(listenItem12);
        ListenItem listenItem13 = new ListenItem("你将无人可代替   >   ", R.drawable.main_head_profile);
        list.add(listenItem13);
        ListenItem listenItem14 = new ListenItem("玫瑰少年   >   ", R.drawable.main_head_profile);
        list.add(listenItem14);
        ListenItem listenItem15 = new ListenItem("一缕光   >   ", R.drawable.main_head_profile);
        list.add(listenItem15);
        return list;


    }
}