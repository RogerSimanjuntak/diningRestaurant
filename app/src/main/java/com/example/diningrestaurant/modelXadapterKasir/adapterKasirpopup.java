package com.example.diningrestaurant.modelXadapterKasir;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diningrestaurant.R;

import java.util.ArrayList;

public class adapterKasirpopup extends RecyclerView.Adapter<adapterKasirpopup.ViewHolder> {


    ArrayList<kasiritempopup> popupItemArraylist;

    public adapterKasirpopup(ArrayList<kasiritempopup> popupItemArraylist) {

        this.popupItemArraylist = popupItemArraylist;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_kasiritempopup,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        kasiritempopup popupItem = popupItemArraylist.get(position);
        holder.itemdibelipopup.setText(popupItem.itemdibeli);
        holder.hargaitemdibelipopup.setText(popupItem.hargaitemdibeli);
    }

    @Override
    public int getItemCount() {

        return popupItemArraylist.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemdibelipopup, hargaitemdibelipopup, totalhargapopup;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemdibelipopup = itemView.findViewById(R.id.itemkasirdibelipopup);
            hargaitemdibelipopup = itemView.findViewById(R.id.hargaitemkasirdibelipopup);
        }
    }

}