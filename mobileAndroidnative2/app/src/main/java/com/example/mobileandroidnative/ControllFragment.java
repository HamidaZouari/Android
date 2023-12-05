package com.example.mobileandroidnative;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class ControllFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<ModelCard> list;
    Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initData();
        initRecyclerView();
        return inflater.inflate(R.layout.fragment_controll, container, false);
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new ModelCard( "cam"));
    }

    private void initRecyclerView() {
        recyclerView = getView().findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(list,getContext());
        recyclerView.setAdapter(adapter);
    }

}