package com.example.mymobileapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.SyncStateContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mymobileapplication.ChiTietSanPhamActivity;
import com.example.mymobileapplication.MainActivity;
import com.example.mymobileapplication.R;
import com.example.mymobileapplication.connect.Checkconnect;
import com.example.mymobileapplication.data.Favorite;
import com.example.mymobileapplication.data.SanPham;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class favoriteAdapter extends BaseAdapter {
    private Context context;
    private List<Favorite> productList;
    ArrayList<Favorite> mangsanpham;
    ArrayList<SanPham> arraySanpham;
    favoriteAdapter sadapter;

    public favoriteAdapter(Context context, ArrayList<Favorite> mangsanpham) {
        this.context = context;
        this.mangsanpham = mangsanpham;
    }

    @Override
    public int getCount() {
        return mangsanpham.size();
    }

    @Override
    public Object getItem(int position) {
        return mangsanpham.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        RelativeLayout itemLay;
        TextView title, price;
        ImageView remove,img;
    }
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        int position = 0;
        ViewHolder viewHodel = null;
        arraySanpham = new ArrayList<>();
        if(convertView == null){
            viewHodel = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.wishlist_item, null);
            viewHodel.img = convertView.findViewById(R.id.imggiohangs);
            viewHodel.title = convertView.findViewById(R.id.tvtengiohangs);
            viewHodel.price = convertView.findViewById(R.id.tvgiagiohangs);
            convertView.setTag(viewHodel);
        }else {
            viewHodel  = (ViewHolder) convertView.getTag();
        }
        Favorite sanpham=(Favorite) getItem(i);
        Glide.with(viewHodel.img.getContext()).load(sanpham.getHinhanhsanpham()).into(viewHodel.img);
        viewHodel.title.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHodel.price.setText("Giá:\t"+decimalFormat.format(sanpham.getGiasanpham())+"\tVNĐ");
//        viewHodel.remove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        return convertView;
    }


}
