package com.example.mymobileapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymobileapplication.R;
import com.example.mymobileapplication.data.SanPham;

import java.util.ArrayList;

public class ManAdapter extends BaseAdapter {
    Context context;
    ArrayList<SanPham> arrayListthoitrangnam;

    public ManAdapter(Context context, ArrayList<SanPham> arrayListthoitrangnam) {
        this.context = context;
        this.arrayListthoitrangnam = arrayListthoitrangnam;
    }

    @Override
    public int getCount() {
        return arrayListthoitrangnam.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListthoitrangnam.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder {
        public TextView txttensp, txtgia, txtmota;
        public ImageView imgicon, imglike;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder =null;
        if (convertView == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lis_man, null);
            holder.imgicon = convertView.findViewById(R.id.imageviewsanpham);
            holder.txttensp = convertView.findViewById(R.id.tvTensanpham);
            holder.txtgia = convertView.findViewById(R.id.tvgiasanpham);

        }
        return null;
    }
}
