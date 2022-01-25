package com.example.mymobileapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mymobileapplication.ChiTietSanPhamActivity;
import com.example.mymobileapplication.MainActivity;
import com.example.mymobileapplication.R;
import com.example.mymobileapplication.connect.Checkconnect;
import com.example.mymobileapplication.data.SanPham;
import com.google.android.material.snackbar.Snackbar;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductSearch extends BaseAdapter {
    Context context;
    ArrayList<SanPham> ArayList;
    List<SanPham> productList;
    private MainActivity home;

    public ProductSearch() {
    }

    public ProductSearch(Context context, List<SanPham> productList) {
        this.context = context;
        this.productList = productList;
        this.ArayList = new ArrayList<SanPham>();
        this.ArayList.addAll(productList);
    }

    public class ViewHolder{
        public TextView txtname,txtprice,txtdiscount;
        public ImageView imageViews,heart;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder= new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.item_productlistview,null);
            viewHolder.txtname=(TextView) convertView.findViewById(R.id.tvTenSpx);
            viewHolder.txtprice=(TextView) convertView.findViewById(R.id.tvGiaBanx);
            viewHolder.imageViews=(ImageView) convertView.findViewById(R.id.ivSanPhamx);


            convertView.setTag(viewHolder);

        }else {
            viewHolder =(ViewHolder) convertView.getTag();
        }
        SanPham sanpham=(SanPham) getItem(position);
        Glide.with(viewHolder.imageViews.getContext()).load(sanpham.getHinhanhsanpham()).into(viewHolder.imageViews);
        viewHolder.txtname.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHolder.txtprice.setText("Giá:\t"+decimalFormat.format(sanpham.getGiasanpham())+"\tVNĐ");



        return convertView;
    }

    public void Filter(String chartText){
        chartText = chartText.toLowerCase(Locale.getDefault());
        productList.clear();
        if (chartText.length()==0){
            productList.addAll(ArayList);
        }else{
            for (SanPham p :ArayList){
                if (p.getTensanpham().toLowerCase(Locale.getDefault()).contains(chartText)){
                    productList.add(p);


                }
            }
        }
        notifyDataSetChanged();
    }
}
