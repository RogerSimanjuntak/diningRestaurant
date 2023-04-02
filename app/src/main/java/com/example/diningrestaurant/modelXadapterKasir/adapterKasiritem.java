package com.example.diningrestaurant.modelXadapterKasir;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diningrestaurant.R;

import java.util.ArrayList;

public class adapterKasiritem extends RecyclerView.Adapter<adapterKasiritem.ViewHolder> {

    ArrayList<KasiritemModel> childarrayList;

    public adapterKasiritem(ArrayList<KasiritemModel> childarrayList) {

        this.childarrayList = childarrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_kasiritem,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        KasiritemModel childItem = childarrayList.get(position);

        holder.itemdibeli.setText(childItem.itemdibeli);
        holder.hargaitemdibeli.setText(childItem.hargaitemdibeli);
    }

    @Override
    public int getItemCount() {

        return childarrayList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView itemdibeli, hargaitemdibeli;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemdibeli = itemView.findViewById(R.id.itemkasirdibeli);
            hargaitemdibeli = itemView.findViewById(R.id.hargaitemkasirdibeli);
        }
    }

}