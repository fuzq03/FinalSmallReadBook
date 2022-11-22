package com.example.smallredbook.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.smallredbook.R;
import com.example.smallredbook.adapter.HomePageViewPagerAdapter;
import com.example.smallredbook.ui.activity.HomeLeftActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomePageFragment extends Fragment {



    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ViewPager2 viewPager2 = getView().findViewById(R.id.home_page_viewpager);
        HomePageViewPagerAdapter homePageViewPagerAdapter = new HomePageViewPagerAdapter(requireActivity());
        viewPager2.setAdapter(homePageViewPagerAdapter);
        viewPager2.requestDisallowInterceptTouchEvent(true);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if(position == 1){
                    viewPager2.requestDisallowInterceptTouchEvent(false);
                }
//                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        TabLayout tabLayout = getView().findViewById(R.id.home_page_tab_layout);
        new TabLayoutMediator(tabLayout, viewPager2, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0){
                    tab.setText("关注");
                }else if(position == 1){
                    tab.setText("发现");
                }else if(position == 2){
                    tab.setText("附近");
                }
            }
        }).attach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        ImageButton button_left = view.findViewById(R.id.fragment_home_left_button);
        button_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeLeftActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}