package com.example.smallredbook.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smallredbook.R;
import com.example.smallredbook.adapter.AttentionAdapter;
import com.example.smallredbook.adapter.NoteItem;
import com.example.smallredbook.adapter.noteItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class AttentionFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attention, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.attention_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        AttentionAdapter adapter = new AttentionAdapter();
        recyclerView.setAdapter(adapter);
        return view;
    }
}