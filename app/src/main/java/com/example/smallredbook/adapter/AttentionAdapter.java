package com.example.smallredbook.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smallredbook.R;

public class AttentionAdapter extends RecyclerView.Adapter<AttentionAdapter.AttentionHolder> {

    @NonNull
    @Override
    public AttentionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_attention_item, parent, false);
        AttentionHolder holder = new AttentionHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AttentionHolder holder, int position) {


        if(position == 3){
            holder.ContentImageView.setImageResource(R.drawable.attention_item_image);
            holder.textContent.setText("“我想要吃好吃的”");
        }

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class AttentionHolder extends RecyclerView.ViewHolder{
        ImageView ContentImageView;
        TextView textContent;

        public AttentionHolder(@NonNull View itemView) {
            super(itemView);
            ContentImageView = (ImageView) itemView.findViewById(R.id.imageView2);
            textContent = itemView.findViewById(R.id.text_content);
        }
    }
}
