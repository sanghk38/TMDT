package com.example.mymobileapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.mymobileapplication.MainActivity;
import com.example.mymobileapplication.data.SanPham;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends BaseAdapter {
    Context context;
    ArrayList<SanPham> ArayList;
    List<SanPham> productList;
    private MainActivity home;

    public OrderAdapter() {
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
