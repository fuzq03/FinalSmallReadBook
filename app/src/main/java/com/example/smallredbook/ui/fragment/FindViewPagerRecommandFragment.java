package com.example.smallredbook.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.smallredbook.R;
import com.example.smallredbook.adapter.NoteItem;
import com.example.smallredbook.adapter.noteItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class FindViewPagerRecommandFragment extends Fragment {

    public static FindViewPagerRecommandFragment newInstance() {

        Log.d("Here", "RecommendFragment Instance");
        
        Bundle args = new Bundle();

        FindViewPagerRecommandFragment fragment = new FindViewPagerRecommandFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("Here", "CreateRecycler1111111");
        View view = inflater.inflate(R.layout.fragment_find_view_pager_recommand, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.find_view_pager_recommend_recycler);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        List<NoteItem> mList = new ArrayList<>();
        NoteItem item = new NoteItem("课间小碎片", R.drawable.note);
        mList.add(item);
        NoteItem item1 = new NoteItem("yeyeyyeyeyeyeyeyyeeyyyyeeeyeyeyyyeyyyeyyeyeyyeyyeyeeyyeyeye", R.drawable.picture);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        mList.add(item1);
        Log.d("Here", "CreateRecycler1111111");
        noteItemAdapter noteItemAdapter = new noteItemAdapter(mList);
        Log.d("Here", "CreateRecycler1111111");
        recyclerView.setAdapter(noteItemAdapter);
        return view;
    }
}