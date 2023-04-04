package com.example.diningrestaurant.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.diningrestaurant.R;

public class DialogEdit extends AppCompatDialogFragment {
    private EditText editTextItem;
    private EditText editDeskripsiItem;
    private EditText editHargaItem;
    private Button buttonSubmit;
    private Button buttonCancel;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.popupedititem,null);
//            AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext());
//            View dialogView = LayoutInflater.from(view.getRootView().getContext()).inflate(R.layout.popupedititem,null);
//            builder.setView(dialogView);
//            builder.show();
        builder.setView(view).setTitle("Edit Item").setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        editTextItem = view.findViewById(R.id.TextItem);
        editHargaItem = view.findViewById(R.id.textHarga);
        editDeskripsiItem = view.findViewById(R.id.textDeskripsiItem);
        return builder.create();

    }
}
