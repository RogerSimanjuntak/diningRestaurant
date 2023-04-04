package com.example.diningrestaurant.modelXadapterItem;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.GnssAntennaInfo;
import android.media.Image;
import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diningrestaurant.MainActivity;
import com.example.diningrestaurant.R;
import com.example.diningrestaurant.fragment.DialogEdit;
import com.example.diningrestaurant.fragment.KasirFragment;
import com.example.diningrestaurant.modelXadapterKasir.KasiritemModel;
import com.example.diningrestaurant.modelXadapterKasir.kasirModel;

import java.util.ArrayList;

public class AdapterRecycleViewItem  extends RecyclerView.Adapter<AdapterRecycleViewItem.ViewHolder> {
    ArrayList<itemModel> dataItem;

    public AdapterRecycleViewItem(KasirFragment kasirFragment, ArrayList<kasirModel> parentItemArrayList, ArrayList<KasiritemModel> childItemArrayList) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        Button editButton;
        Button deleteButton;
        Button saveButton;
        Button cancelButton;
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
            editButton = itemView.findViewById(R.id.editButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            cancelButton = itemView.findViewById(R.id.cancel_button);
            saveButton = itemView.findViewById(R.id.submitButton);

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

//        holder.cancelButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                cancelDialog(view);
//            }
//        });

    holder.editButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view ) {

            openDialog(view);

        }

    });


        }
    AlertDialog.Builder dialogBuilder;
    AlertDialog dialog;
    Button saveButton;
    Button cancelButton;
    ImageView imageEdit;
    public void openDialog(View view){
    dialogBuilder = new AlertDialog.Builder(view.getContext());
    View EditpopupView = LayoutInflater.from(view.getContext()).inflate(R.layout.popupedititem,null);
    dialogBuilder.setView(EditpopupView);
    dialog =dialogBuilder.create();
    dialog.show();

    saveButton = EditpopupView.findViewById(R.id.submitButton);
    cancelButton = EditpopupView.findViewById(R.id.cancel_button);
    cancelButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    });
    saveButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(dialog.getContext(), "Item Berhasil Diganti", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        }
    });
//    Dialog dialog =new Dialog(view.getContext());
//    View dialogView = LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.popupedititem,null);
//    dialog.setView(dialogView);
//     dialog.show();

//        AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
//        View dialogView = LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.popupedititem,null);
//        builder.setView(dialogView);
//        builder.create();
//        Button cancelButton =dialogView.findViewById(R.id.cancel_button);
//        cancelButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                builder.
//            }
//        });
//        builder.show();

    }
public void cancelDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

}

    @Override
    public int getItemCount() {
        return dataItem.size();
    }

}
