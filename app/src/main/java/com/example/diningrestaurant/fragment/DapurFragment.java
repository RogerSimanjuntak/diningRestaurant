package com.example.diningrestaurant.fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.diningrestaurant.R;
import com.example.diningrestaurant.modelXadapterDapur.adapterDapur;
import com.example.diningrestaurant.modelXadapterDapur.dapurModel;
import com.example.diningrestaurant.modelXadapterDapur.dapuritemModel;
import com.example.diningrestaurant.modelXadapterDapur.dapuritemPopup;
import com.example.diningrestaurant.modelXadapterItem.itemFood;
import com.example.diningrestaurant.modelXadapterKasir.KasiritemModel;
import com.example.diningrestaurant.modelXadapterKasir.adapterKasir;
import com.example.diningrestaurant.modelXadapterKasir.kasirModel;
import com.example.diningrestaurant.modelXadapterKasir.kasiritempopup;

import java.util.ArrayList;


public class DapurFragment extends Fragment {

    RecyclerView recyclerView;
    adapterDapur adapterRecycleViewItem;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<dapurModel> parentItemArrayList;
    ArrayList<dapuritemModel> childItemArrayList;
    ArrayList<dapuritemPopup> popupItemArraylist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dapur, container, false);
        recyclerView = view.findViewById(R.id.recdapurfrag);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(getActivity(),4);
        recyclerView.setLayoutManager(layoutManager);

        String[] itemdibeliroger = itemFood.judulItem;
        String[] hargaitemdibeliroger = itemFood.hargaItem;
        Integer[] nomormeja = {11, 22, 33, 44, 55, 66, 77, 88};

        parentItemArrayList = new ArrayList<>();
        childItemArrayList = new ArrayList<>();
        popupItemArraylist = new ArrayList<>();

        // deklarasi variabel indeks
        int indexItem = 0;
        int indexHarga = 0;
        int indexNomorMeja = 0;

// mengambil urutan data yang berbeda dengan jumlah yang berbeda
        while (indexNomorMeja < nomormeja.length) {
            dapurModel parentItem = new dapurModel(nomormeja[indexNomorMeja]);
            parentItemArrayList.add(parentItem);

            if (indexItem < itemdibeliroger.length && indexHarga < hargaitemdibeliroger.length) {
                dapuritemModel childItem = new dapuritemModel(itemdibeliroger[indexItem], hargaitemdibeliroger[indexHarga]);
                dapuritemPopup popupItem = new dapuritemPopup(itemdibeliroger[indexItem], hargaitemdibeliroger[indexHarga]);
                childItemArrayList.add(childItem);
                popupItemArraylist.add(popupItem);

                // increment variabel indeks sesuai kebutuhan
                indexItem += 2;
                indexHarga += 2;
            }

            // increment variabel indeks untuk nomor meja
            indexNomorMeja++;
        }

        adapterRecycleViewItem = new adapterDapur(parentItemArrayList, childItemArrayList, popupItemArraylist);
        recyclerView.setAdapter(adapterRecycleViewItem);
        return view;


    }

}