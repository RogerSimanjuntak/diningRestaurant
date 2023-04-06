package com.example.diningrestaurant.fragment;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.diningrestaurant.modelXadapterItem.itemFood;
import com.example.diningrestaurant.modelXadapterItem.AdapterRecycleViewItem;
import com.example.diningrestaurant.R;
import com.example.diningrestaurant.modelXadapterItem.itemModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class listItemFragment extends Fragment {
    RecyclerView recyclerView;
    AdapterRecycleViewItem adapterRecycleViewItem;
    RecyclerView.LayoutManager layoutManager;
    ArrayList <itemModel> data;
    FloatingActionButton fab;
    AlertDialog dialog;
    AlertDialog.Builder dialogBuilder;
Button saveButton;
Button cancelButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_list_item, container, false);
        recyclerView = view.findViewById(R.id.list_food);
        recyclerView.setHasFixedSize(true);


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


//    Section Button
        fab = view.findViewById(R.id.floating_action_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder = new AlertDialog.Builder(view.getContext());
                View AddpopupView = LayoutInflater.from(view.getContext()).inflate(R.layout.popupedititem,null);
                dialogBuilder.setView(AddpopupView);
                dialog = dialogBuilder.create();
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.textfieldradius);
                saveButton =AddpopupView.findViewById(R.id.submitButton);
                cancelButton = AddpopupView.findViewById(R.id.cancel_button);

                saveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getContext(), "Item Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        return view;
    }
}