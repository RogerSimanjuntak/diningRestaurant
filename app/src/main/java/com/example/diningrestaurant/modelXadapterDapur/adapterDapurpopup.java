package com.example.diningrestaurant.modelXadapterDapur;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diningrestaurant.R;
import com.example.diningrestaurant.modelXadapterKasir.adapterKasirpopup;
import com.example.diningrestaurant.modelXadapterKasir.kasiritempopup;

import java.util.ArrayList;

public class adapterDapurpopup extends RecyclerView.Adapter<adapterDapurpopup.ViewHolder> {


    ArrayList<dapuritemPopup> popupItemArraylist;

    public adapterDapurpopup(ArrayList<dapuritemPopup> popupItemArraylist) {

        this.popupItemArraylist = popupItemArraylist;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_dapuritempopup, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        dapuritemPopup popupItem = popupItemArraylist.get(position);
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
            itemdibelipopup = itemView.findViewById(R.id.itemdapurdibelipopup);
            hargaitemdibelipopup = itemView.findViewById(R.id.hargaitemdapurdibelipopup);
        }
    }
}
