package com.example.smallredbook.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.smallredbook.ui.fragment.AttentionFragment;
import com.example.smallredbook.ui.fragment.FindFragment;
import com.example.smallredbook.ui.fragment.NearFragment;

public class HomePageViewPagerAdapter extends FragmentStateAdapter {
    public HomePageViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new AttentionFragment();
            case 1:
                return new FindFragment();
            case 2:
                return new NearFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
