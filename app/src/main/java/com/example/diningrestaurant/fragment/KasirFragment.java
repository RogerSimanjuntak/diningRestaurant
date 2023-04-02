package com.example.diningrestaurant.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diningrestaurant.AdapterRecycleViewItem;
import com.example.diningrestaurant.KasiritemModel;
import com.example.diningrestaurant.R;
import com.example.diningrestaurant.adapterKasir;
import com.example.diningrestaurant.itemModel;
import com.example.diningrestaurant.kasirModel;

import java.util.ArrayList;

public class KasirFragment extends Fragment {
    RecyclerView recyclerView;
    adapterKasir adapterRecycleViewItem;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<kasirModel> parentItemArrayList;
    ArrayList<KasiritemModel> childItemArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_kasir, container, false);
        recyclerView = view.findViewById(R.id.reckasirfrag);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getActivity(),4);
        recyclerView.setLayoutManager(layoutManager);

        Integer[] nomormeja = {11, 22, 33, 44, 55, 66, 77, 88};
        String[] itemdibeli = {"koka kolha", "ciken ayam goreng", "berger mekdi", "fat frais", "minuman"};
        String[] hargaitemdibeli = {"Rp. 12.000", "Rp. 12.000", "Rp. 12.000", "Rp. 12.000", "Rp. 12.000"};

        parentItemArrayList = new ArrayList<>();
        childItemArrayList = new ArrayList<>();

        for (int i=0 ; i<nomormeja.length; i++ ){

            kasirModel parentItem = new kasirModel(nomormeja[i]);
            parentItemArrayList.add(parentItem);

            if (i < itemdibeli.length) {
                KasiritemModel childItem = new KasiritemModel(itemdibeli[i], hargaitemdibeli[i]);
                childItemArrayList.add(childItem);
            }
        }

        adapterRecycleViewItem = new adapterKasir(parentItemArrayList, childItemArrayList);
        recyclerView.setAdapter(adapterRecycleViewItem);
        return view;
    }
}