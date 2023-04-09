package com.example.diningrestaurant.fragment;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.diningrestaurant.modelXadapterKasir.KasiritemModel;
import com.example.diningrestaurant.R;
import com.example.diningrestaurant.modelXadapterKasir.adapterKasir;
import com.example.diningrestaurant.modelXadapterKasir.kasirModel;
import com.example.diningrestaurant.modelXadapterKasir.kasiritempopup;

import java.util.ArrayList;

public class KasirFragment extends Fragment {
    RecyclerView recyclerView;
    adapterKasir adapterRecycleViewItem;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<kasirModel> parentItemArrayList;
    ArrayList<KasiritemModel> childItemArrayList;
    ArrayList<kasiritempopup> popupItemArraylist;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_kasir, container, false);
        recyclerView = view.findViewById(R.id.reckasirfrag);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getActivity(),4);
        recyclerView.setLayoutManager(layoutManager);

        Integer[] nomormeja = {11, 22, 33, 44, 55, 66, 77, 88};
        String[] itemdibeli = {"Koka Kolha", "Ciken Ayam Goyeng", "Berger Mekdi", "Fat Frais", "Minuman"};
        String[] hargaitemdibeli = {"Rp. 12.000", "Rp. 12.000", "Rp. 12.000", "Rp. 12.000", "Rp. 12.000"};

        parentItemArrayList = new ArrayList<>();
        childItemArrayList = new ArrayList<>();
        popupItemArraylist = new ArrayList<>();

        for (int i=0 ; i<nomormeja.length; i++ ){

            kasirModel parentItem = new kasirModel(nomormeja[i]);
            parentItemArrayList.add(parentItem);

            if (i < itemdibeli.length) {
                KasiritemModel childItem = new KasiritemModel(itemdibeli[i], hargaitemdibeli[i]);
                kasiritempopup popupItem = new kasiritempopup(itemdibeli[i], hargaitemdibeli[i]);
                childItemArrayList.add(childItem);
                popupItemArraylist.add(popupItem);
            }

        }

        adapterRecycleViewItem = new adapterKasir(parentItemArrayList, childItemArrayList, popupItemArraylist);
        recyclerView.setAdapter(adapterRecycleViewItem);
        return view;


    }

}