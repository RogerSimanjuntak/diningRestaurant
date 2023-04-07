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
        layoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(layoutManager);

        Integer[] nomormeja = {11, 22, 33, 44, 55, 66, 77, 88};
        String[] itemdibeli = {"Koka Kolha", "Ciken Ayam Goyeng", "Berger Mekdi", "Fat Frais", "Minuman"};
        String[] hargaitemdibeli = {"Rp. 12.000", "Rp. 12.000", "Rp. 12.000", "Rp. 12.000", "Rp. 12.000"};

        parentItemArrayList = new ArrayList<>();
        childItemArrayList = new ArrayList<>();
        popupItemArraylist = new ArrayList<>();

        for (int i=0 ; i<nomormeja.length; i++ ){

            dapurModel parentItem = new dapurModel(nomormeja[i]);
            parentItemArrayList.add(parentItem);

            if (i < itemdibeli.length) {
                dapuritemModel childItem = new dapuritemModel(itemdibeli[i], hargaitemdibeli[i]);
                dapuritemPopup popupItem = new dapuritemPopup(itemdibeli[i], hargaitemdibeli[i]);
                childItemArrayList.add(childItem);
                popupItemArraylist.add(popupItem);
            }

        }

        adapterRecycleViewItem = new adapterDapur(parentItemArrayList, childItemArrayList, popupItemArraylist);
        recyclerView.setAdapter(adapterRecycleViewItem);
        return view;


    }

}