package com.example.smallredbook.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smallredbook.MyListItemDecoration;
import com.example.smallredbook.R;
import com.example.smallredbook.adapter.RecyclerMeDrawerAdapter;

public class MeDrawerFragment extends Fragment {


    public MeDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_me_drawer, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.drawer_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerMeDrawerAdapter adapter1 = new RecyclerMeDrawerAdapter();
        recyclerView.setAdapter(adapter1);
        MyListItemDecoration decoration = new MyListItemDecoration();
        recyclerView.addItemDecoration(decoration);
        return view;
    }
}