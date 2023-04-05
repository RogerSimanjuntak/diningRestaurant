package com.example.diningrestaurant.modelXadapterDapur;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.diningrestaurant.R;
import com.example.diningrestaurant.modelXadapterKasir.KasiritemModel;
import com.example.diningrestaurant.modelXadapterKasir.adapterKasir;
import com.example.diningrestaurant.modelXadapterKasir.adapterKasiritem;
import com.example.diningrestaurant.modelXadapterKasir.adapterKasirpopup;
import com.example.diningrestaurant.modelXadapterKasir.kasirModel;
import com.example.diningrestaurant.modelXadapterKasir.kasiritempopup;
import java.util.ArrayList;

public class adapterDapur extends RecyclerView.Adapter<adapterDapur.ViewHolder> {

    Context context;

    private Activity activity;
    ArrayList<dapurModel> parentItemArrayList;
    ArrayList<dapuritemModel> childItemArrayList;
    ArrayList<dapuritemPopup> popupItemArraylist;
    Button cancelserved, doneserved;
    RecyclerView popup_rv;
    TextView nomermeja;



    public adapterDapur(ArrayList<dapurModel> parentItemArrayList, ArrayList<dapuritemModel> childItemArrayList, ArrayList<dapuritemPopup> popupItemArraylist) {
        this.activity = activity;
        this.parentItemArrayList = parentItemArrayList;
        this.childItemArrayList = childItemArrayList;
        this.popupItemArraylist = popupItemArraylist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_dapur,parent,false);

        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        dapurModel parentItem = parentItemArrayList.get(position);
        holder.nomormeja.setText(Integer.toString(parentItem.nomormeja));
        adapterDapuritem adapterMember = new adapterDapuritem(childItemArrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);

        holder.nested_rv.setLayoutManager(linearLayoutManager);
        holder.nested_rv.setAdapter(adapterMember);


        holder.cardView.setOnClickListener(e->{
            AlertDialog dialog;
            AlertDialog.Builder builder = new AlertDialog.Builder(e.getContext());
            View dialogView = LayoutInflater.from(e.getContext()).inflate(R.layout.popupdapur,null);

            adapterDapurpopup adapterMemberr = new adapterDapurpopup(popupItemArraylist);
            LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(activity);
            dapurModel parentItemm = parentItemArrayList.get(position);
            popup_rv = dialogView.findViewById(R.id.recviewitemdapurpopup);
            popup_rv.setLayoutManager(linearLayoutManager1);
            popup_rv.setAdapter(adapterMemberr);
            nomermeja = dialogView.findViewById(R.id.nomormejapopup);
            nomermeja.setText(Integer.toString(parentItemm.nomormeja));

            builder.setView(dialogView);
            dialog = builder.create();

            cancelserved = dialogView.findViewById(R.id.button);
            cancelserved.setOnClickListener(f->{
                dialog.dismiss();
            });

            doneserved = dialogView.findViewById(R.id.button2);
            doneserved.setOnClickListener(f->{
                Toast.makeText(dialog.getContext(), "pesanan telah disajikan", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });

            dialog.show();
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
            nomormeja = itemView.findViewById(R.id.nomormejagriddapur);
            nested_rv = itemView.findViewById(R.id.recviewitemdapur);
            cardView = itemView.findViewById(R.id.reccardviewdapur);
        }
    }

}
