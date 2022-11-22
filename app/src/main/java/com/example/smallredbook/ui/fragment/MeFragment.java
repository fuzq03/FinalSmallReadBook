package com.example.smallredbook.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smallredbook.R;
import com.example.smallredbook.adapter.MeViewPagerAdapter;
import com.example.smallredbook.adapter.RecyclerMeDrawerAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MeFragment extends Fragment {


    public MeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_me, container, false);
        ImageView imageView = view.findViewById(R.id.fragment_me_image);
        //imageView.getBackground().setAlpha(100);

        ViewPager2 viewPager2 = view.findViewById(R.id.me_fragment_viewpager2);
        MeViewPagerAdapter adapter = new MeViewPagerAdapter(getActivity());
        viewPager2.setAdapter(adapter);

        TabLayout tabLayout = view.findViewById(R.id.me_fragment_tab_layout);
        new TabLayoutMediator(tabLayout, viewPager2, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0){
                    tab.setText("笔记");
                }else if(position == 1){
                    tab.setText("收藏");
                }else if(position == 2){
                    tab.setText("赞过");
                }
            }
        }).attach();


        //选中的item字体变大
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view1 = tab.getCustomView();
                if(null != view1 && view1 instanceof TextView) {
                    ((TextView) view1).setTextSize(40);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        AppBarLayout appBarLayout = view.findViewById(R.id.app_bar_layout);
        //NestedScrollView scrollView = view.findViewById(R.id.me_fragment_scroll_view);
//        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(@NonNull NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                Log.d("tablayout", "scroll");
//                if (scrollY > appBarLayout.getHeight()) {
//                    //显示
//                    Log.d("tablayout", "show");
//                    view.findViewById(R.id.me_fragment_tab_layout_hide).setVisibility(View.VISIBLE);
//                } else {
//                    //隐藏
//                    Log.d("tablayout", "hide");
//                    view.findViewById(R.id.me_fragment_tab_layout_hide).setVisibility(View.GONE);
//                }
//            }
//        });

        DrawerLayout drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout_main);
        Button navButton = (Button) view.findViewById(R.id.nav_button);

        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        return view;
    }
}