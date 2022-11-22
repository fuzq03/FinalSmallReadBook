package com.example.smallredbook.adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.smallredbook.ui.fragment.FindViewPagerShoppingFragment;
import com.example.smallredbook.ui.fragment.FindViewPagerRecommandFragment;

public class FindViewPagerAdapter extends FragmentStateAdapter {

    public FindViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        Log.d("Here", "This is FindViewPagerAdapter constructor");
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Log.d("Here", "Now position is " + position);
        if(position == 0){
            Log.d("Here", "This is FindViewPagerAdapter CreateFragment");
            return FindViewPagerRecommandFragment.newInstance();
        }else if(position == 1){
            return FindViewPagerShoppingFragment.newInstance();
        }else{
            return FindViewPagerShoppingFragment.newInstance();
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
