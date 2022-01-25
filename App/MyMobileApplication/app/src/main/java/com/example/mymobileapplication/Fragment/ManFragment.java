package com.example.mymobileapplication.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymobileapplication.NewActivity;
import com.example.mymobileapplication.R;
import com.example.mymobileapplication.data.LoaiSp;

import java.util.ArrayList;


public class ManFragment extends Fragment {
    ListView listView;
    View view;
    ArrayList<LoaiSp> mangloaisp;
//    String mTitle[]={"New","Clothes","Shoes","Accesories"};
//    int[] images={R.drawable.image4,R.drawable.image5,
//            R.drawable.image3,R.drawable.image2};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_man, container, false);
        listView= view.findViewById(R.id.list_shop);


        return view;
    }

}