package com.example.smallredbook.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smallredbook.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerListenAdapter extends RecyclerView.Adapter<RecyclerListenAdapter.RecyclerListenHolder> {

    List<ListenItem> listenItems;

    public RecyclerListenAdapter(List<ListenItem> list){
        listenItems = list;
    }
    @NonNull
    @Override
    public RecyclerListenHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_home_left_listen, parent, false);
        RecyclerListenHolder holder = new RecyclerListenHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerListenHolder holder, int position) {
        holder.textView.setText(listenItems.get(position).getText_content());
        holder.imageFilterView.setImageResource(listenItems.get(position).getImageFilterViewId());

    }

    @Override
    public int getItemCount() {
        return listenItems.size();
    }

    class RecyclerListenHolder extends RecyclerView.ViewHolder {
        ImageFilterView imageFilterView;
        ImageView imageView;
        TextView textView;

        public RecyclerListenHolder(@NonNull View itemView) {
            super(itemView);
            imageFilterView = itemView.findViewById(R.id.recycler_home_left_image_item_image_filter);
            imageView = itemView.findViewById(R.id.recycler_home_left_image_view);
            textView = itemView.findViewById(R.id.recycler_home_left_text_view);
        }

    }
}
