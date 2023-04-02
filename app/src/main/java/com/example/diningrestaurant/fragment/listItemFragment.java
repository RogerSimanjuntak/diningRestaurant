package com.example.diningrestaurant.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diningrestaurant.modelXadapterItem.itemFood;
import com.example.diningrestaurant.modelXadapterItem.AdapterRecycleViewItem;
import com.example.diningrestaurant.R;
import com.example.diningrestaurant.modelXadapterItem.itemModel;

import java.util.ArrayList;

public class listItemFragment extends Fragment {
    RecyclerView recyclerView;
    AdapterRecycleViewItem adapterRecycleViewItem;
    RecyclerView.LayoutManager layoutManager;
    ArrayList <itemModel> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_list_item, container, false);
        recyclerView = view.findViewById(R.id.list_food);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        layoutManager = new  GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(layoutManager);
        data = new ArrayList<>();
        for (int i = 0; i < itemFood.judulItem.length; i++){
            data.add(new itemModel(
                 itemFood.judulItem[i],
                    itemFood.deskripsiItem[i],
                            itemFood.hargaItem[i],
                            itemFood.poster[i]
            ));
        }
        adapterRecycleViewItem = new AdapterRecycleViewItem(data);
        recyclerView.setAdapter(adapterRecycleViewItem);
        return view;
    }
}