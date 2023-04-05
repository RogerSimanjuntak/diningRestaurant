package com.example.diningrestaurant.fragment;

import static com.example.diningrestaurant.modelXadapterItem.itemFood.judulItem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.diningrestaurant.R;

public class PemesenanFragment extends Fragment {


//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }


String[] nomormeja = {"11", "22", "33", "44", "55", "66", "77", "88"};
    Button addMenu;
    LinearLayout CardForm;
    AutoCompleteTextView autoCompleteTextViewItem;
    AutoCompleteTextView autoCompleteTextViewMeja;
    ArrayAdapter<String> adapterItems;
    ArrayAdapter<String> adapterMeja;
    int autoCompleteTextViewCount = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_pemesenan, container, false);


//        LIST MEJA
    autoCompleteTextViewMeja=view.findViewById(R.id.autoComplete_meja);
    adapterMeja =new ArrayAdapter<String>(view.getContext(),R.layout.list_item,nomormeja);
    autoCompleteTextViewMeja.setAdapter(adapterMeja);
    autoCompleteTextViewMeja.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String nomormeja = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(getContext(), "Kamu Memilih" + nomormeja, Toast.LENGTH_SHORT).show();
        }
    });
//        List Item PEMBUKA

//        autoCompleteTextViewItem = view.findViewById(R.id.autoComplete_item);
//        adapterItems = new ArrayAdapter<String>(view.getContext(), R.layout.list_item,judulItem);
//        autoCompleteTextViewItem.setAdapter(adapterItems);
//        autoCompleteTextViewItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String judulItem = adapterView.getItemAtPosition(i).toString();
//                Toast.makeText(getContext(), "Kamu Memilih" + judulItem, Toast.LENGTH_SHORT).show();
//            }
//        });

//        List Item PENUTUP
        addMenu = view.findViewById(R.id.buttonadd);
        CardForm = view.findViewById(R.id.cardForm);
        addMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAutoCompleteTextView();
            }
        });

        return view;
    }
    private void addAutoCompleteTextView(){
        AutoCompleteTextView autoCompleteTextView =new AutoCompleteTextView(getContext());
        autoCompleteTextView.setId(View.generateViewId());

        autoCompleteTextView.setHint("Masukkan Makanan Yang sesuai");
        adapterItems = new ArrayAdapter<>(getContext(), R.layout.list_item,judulItem);
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String judulItem = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getContext(), "Kamu Memilih Item " + judulItem, Toast.LENGTH_SHORT).show();
            }
        });
        CardForm.addView(autoCompleteTextView);
        autoCompleteTextViewCount++;
    }
}