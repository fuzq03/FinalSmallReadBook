package com.example.smallredbook.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smallredbook.R;

public class
RecyclerMeDrawerAdapter extends RecyclerView.Adapter<RecyclerMeDrawerAdapter.DrawerItemHolder>{
    @NonNull
    @Override
    public DrawerItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_me_drawer_item, parent, false);
        DrawerItemHolder holder = new DrawerItemHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull DrawerItemHolder holder, int position) {

        if(position == 0){
            holder.drawerTextView.setText("发现好友");
            holder.drawerImageView.setImageResource(R.drawable.me_drawer_find_friend);
        } else if( position == 1){
            holder.drawerTextView.setText("薯小虎");
        } else if( position == 2){
            holder.drawerTextView.setText("我的草稿");
            holder.drawerImageView.setImageResource(R.drawable.me_drawer_draft);
        } else if( position == 3){
            holder.drawerTextView.setText("创作中心");
            holder.drawerImageView.setImageResource(R.drawable.me_drawer_create);
        } else if( position == 4){
            holder.drawerTextView.setText("浏览记录");
            holder.drawerImageView.setImageResource(R.drawable.me_drawer_browsing_history);
        } else if( position == 5){
            holder.drawerTextView.setText("钱包");
            holder.drawerImageView.setImageResource(R.drawable.me_drawer_wallet);
        } else if( position == 6){
            holder.drawerTextView.setText("免流量");
            holder.drawerImageView.setImageResource(R.drawable.me_drawer_free_internet);
        } else if( position == 7){
            holder.drawerTextView.setText("好物体验");
            holder.drawerImageView.setImageResource(R.drawable.me_drawer_good_experience);
        } else if( position == 8){
            holder.drawerTextView.setText("订单");
            holder.drawerImageView.setImageResource(R.drawable.me_drawer_order);
        } else if( position == 9){
            holder.drawerTextView.setText("购物车");
            holder.drawerImageView.setImageResource(R.drawable.me_drawer_shop);
        } else if( position == 10){
            holder.drawerTextView.setText("卡券");
        } else if( position == 11){
            holder.drawerTextView.setText("心愿单");
            holder.drawerImageView.setImageResource(R.drawable.me_drawer_wish);
        } else if( position == 12){
            holder.drawerTextView.setText("小红书会员");
        } else if( position == 13){
            holder.drawerTextView.setText("社区公约");
            holder.drawerImageView.setImageResource(R.drawable.me_drawer_community_convention);
        }


    }

    @Override
    public int getItemCount() {
        return 14;
    }

    class DrawerItemHolder extends RecyclerView.ViewHolder {
        ImageView drawerImageView;
        TextView drawerTextView;

        public DrawerItemHolder(@NonNull View itemView) {
            super(itemView);
            drawerImageView = (ImageView) itemView.findViewById(R.id.drawer_item_imageview);
            drawerTextView = (TextView) itemView.findViewById(R.id.drawer_item_textview);
        }
    }
}
