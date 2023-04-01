package com.example.diningrestaurant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import java.util.ArrayList;

public class AdapterRecycleViewItem  extends RecyclerView.Adapter<AdapterRecycleViewItem.ViewHolder> {
    ArrayList<itemModel> dataItem;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView textFood;
    TextView textDeskripsi;
    TextView textHarga;
    ImageView posterFood;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            posterFood = itemView.findViewById(R.id.image_food);
            textFood = itemView.findViewById(R.id.name_food);
            textDeskripsi = itemView.findViewById(R.id.food_deskripsi);
            textHarga = itemView.findViewById(R.id.harga_food);
        }
    }
    public AdapterRecycleViewItem(ArrayList<itemModel> data){
    this.dataItem= data;

    }
    @NonNull
    @Override
    public AdapterRecycleViewItem.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycleViewItem.ViewHolder holder, int position) {
    TextView text_judul = holder.textFood;
    TextView text_deskripsi = holder.textDeskripsi;
    TextView text_harga = holder.textHarga;
    ImageView image_poster = holder.posterFood;
    text_judul.setText(dataItem.get(position).getName());
    text_deskripsi.setText(dataItem.get(position).getDeskripsi());
    text_harga.setText(dataItem.get(position).getPrice());
    image_poster.setImageResource(dataItem.get(position).getPoster());
    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

}
