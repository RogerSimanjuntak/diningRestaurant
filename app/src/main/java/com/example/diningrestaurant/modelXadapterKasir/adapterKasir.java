package com.example.diningrestaurant.modelXadapterKasir;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diningrestaurant.MainActivity;
import com.example.diningrestaurant.R;
import com.example.diningrestaurant.fragment.KasirFragment;
import com.example.diningrestaurant.pages;

import java.util.ArrayList;

public class adapterKasir extends RecyclerView.Adapter<adapterKasir.ViewHolder> {

    Context context;
    private Activity activity;
    ArrayList<kasirModel> parentItemArrayList;
    ArrayList<KasiritemModel> childItemArrayList;

    public adapterKasir(ArrayList<kasirModel> parentItemArrayList, ArrayList<KasiritemModel> childItemArrayList) {
        this.activity = activity;
        this.parentItemArrayList = parentItemArrayList;
        this.childItemArrayList = childItemArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_kasir,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        kasirModel parentItem = parentItemArrayList.get(position);

        holder.nomormeja.setText(Integer.toString(parentItem.nomormeja));

        adapterKasiritem adapterMember = new adapterKasiritem(childItemArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        holder.nested_rv.setLayoutManager(linearLayoutManager);
        holder.nested_rv.setAdapter(adapterMember);

        holder.cardView.setOnClickListener(e->{

        });
    }


    @Override
    public int getItemCount() {

        return parentItemArrayList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView nomormeja;
        RecyclerView nested_rv;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomormeja = itemView.findViewById(R.id.nomormejagrid);
            nested_rv = itemView.findViewById(R.id.recviewitemkasir);
            cardView = itemView.findViewById(R.id.reccardview);

        }
    }

}