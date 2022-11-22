package com.example.smallredbook.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.smallredbook.ui.fragment.FindFragment;
import com.example.smallredbook.ui.fragment.FindViewPagerShoppingFragment;

public class MeViewPagerAdapter extends FragmentStateAdapter {
    public MeViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return FindViewPagerShoppingFragment.newInstance();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
