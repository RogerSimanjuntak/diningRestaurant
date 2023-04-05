package com.example.diningrestaurant.modelXadapterDapur;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diningrestaurant.R;
import com.example.diningrestaurant.modelXadapterKasir.KasiritemModel;
import com.example.diningrestaurant.modelXadapterKasir.adapterKasiritem;

import java.util.ArrayList;

public class adapterDapuritem extends RecyclerView.Adapter<adapterDapuritem.ViewHolder> {

    ArrayList<dapuritemModel> childarrayList;

    public adapterDapuritem(ArrayList<dapuritemModel> childarrayList) {

        this.childarrayList = childarrayList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_dapuritem,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        dapuritemModel childItem = childarrayList.get(position);

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

            itemdibeli = itemView.findViewById(R.id.itemdapurdibeli);
            hargaitemdibeli = itemView.findViewById(R.id.hargaitemdapurdibeli);
        }
    }

}