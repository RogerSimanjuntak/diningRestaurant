package com.example.diningrestaurant.modelXadapterKasir;

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
import java.util.ArrayList;

public class adapterKasir extends RecyclerView.Adapter<adapterKasir.ViewHolder> {

    Context context;

    private Activity activity;
    ArrayList<kasirModel> parentItemArrayList;
    ArrayList<KasiritemModel> childItemArrayList;
    ArrayList<kasiritempopup> popupItemArraylist;
    Button cancelpayment, donepayment;
    RecyclerView popup_rv;
    TextView nomermeja, totalpayment;



    public adapterKasir(ArrayList<kasirModel> parentItemArrayList, ArrayList<KasiritemModel> childItemArrayList, ArrayList<kasiritempopup> popupItemArraylist) {
        this.activity = activity;
        this.parentItemArrayList = parentItemArrayList;
        this.childItemArrayList = childItemArrayList;
        this.popupItemArraylist = popupItemArraylist;
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
            AlertDialog dialog;
            AlertDialog.Builder builder = new AlertDialog.Builder(e.getContext());
            View dialogView = LayoutInflater.from(e.getContext()).inflate(R.layout.popupkasir,null);

            adapterKasirpopup adapterMemberr = new adapterKasirpopup(popupItemArraylist);
            LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(activity);
            kasirModel parentItemm = parentItemArrayList.get(position);
            popup_rv = dialogView.findViewById(R.id.recviewitemkasirpopup);
            popup_rv.setLayoutManager(linearLayoutManager1);
            popup_rv.setAdapter(adapterMemberr);
            totalpayment = dialogView.findViewById(R.id.totalpaymentkasirpopup);
            totalpayment.setText("Total = Rp. 60.000,-");
            nomermeja = dialogView.findViewById(R.id.nomormejapopup);
            nomermeja.setText(Integer.toString(parentItemm.nomormeja));

            builder.setView(dialogView);
            dialog = builder.create();

            cancelpayment = dialogView.findViewById(R.id.button);
            cancelpayment.setOnClickListener(f->{
                dialog.dismiss();
            });

            donepayment = dialogView.findViewById(R.id.button2);
            donepayment.setOnClickListener(f->{
                Toast.makeText(dialog.getContext(), "pembayaran selesai dilakukan", Toast.LENGTH_SHORT).show();
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
            nomormeja = itemView.findViewById(R.id.nomormejagrid);
            nested_rv = itemView.findViewById(R.id.recviewitemkasir);
            cardView = itemView.findViewById(R.id.reccardviewkasirr);
        }
    }

}