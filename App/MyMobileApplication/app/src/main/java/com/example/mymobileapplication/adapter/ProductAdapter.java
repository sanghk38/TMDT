package com.example.mymobileapplication.adapter;

import android.content.Context;
import android.icu.text.DecimalFormat;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;
import com.example.mymobileapplication.R;
import com.example.mymobileapplication.data.SanPham;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends BaseAdapter {
    Context context;
    ArrayList<SanPham> arraySanpham;
    List<SanPham> productList;
    private static int Timeout = 3000;
    public ProductAdapter(Context context, ArrayList<SanPham> arraySanpham) {
        this.context = context;
        this.arraySanpham = arraySanpham;
    }

    @Override
    public int getCount() {
        return arraySanpham.size();
    }

    @Override
    public Object getItem(int position) {
        return arraySanpham.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder{
        ImageView imghinhsanpham,heart;
        TextView txttensanpham,txtgiasanpham;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder viewHolder;
        if (view==null){
            viewHolder= new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.dong_sanphammoinhat,null);
            viewHolder.txttensanpham=(TextView) view.findViewById(R.id.tvTensanpham);
            viewHolder.txtgiasanpham=(TextView) view.findViewById(R.id.tvgiasanpham);
            viewHolder.imghinhsanpham=(ImageView) view.findViewById(R.id.imageviewsanpham);
            view.setTag(viewHolder);

        }else {
            viewHolder =(ViewHolder) view.getTag();
        }
        SanPham sanpham=(SanPham) getItem(position);
        Glide.with(viewHolder.imghinhsanpham.getContext()).load(sanpham.getHinhanhsanpham()).into(viewHolder.imghinhsanpham);
        viewHolder.txttensanpham.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        viewHolder.txtgiasanpham.setText("Giá:\t"+decimalFormat.format(sanpham.getGiasanpham())+"\tVNĐ");
        return view;
    }
}
