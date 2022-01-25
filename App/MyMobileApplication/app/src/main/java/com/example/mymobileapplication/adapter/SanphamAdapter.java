package com.example.mymobileapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymobileapplication.ChiTietSanPhamActivity;
import com.example.mymobileapplication.R;
import com.example.mymobileapplication.connect.Checkconnect;
import com.example.mymobileapplication.data.SanPham;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SanphamAdapter extends RecyclerView.Adapter<SanphamAdapter.ItemHolder> {
    Context context;
    ArrayList<SanPham> arraySanpham;
    List<SanPham> productList;

    private static int Timeout = 3000;
    public SanphamAdapter(Context context, ArrayList<SanPham> arraySanpham) {
        this.context = context;
        this.arraySanpham = arraySanpham;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_sanphammoinhat,null);
        ItemHolder itemHolder= new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        SanPham sanpham=arraySanpham.get(position);
        holder.txttensanpham.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
        holder.txtgiasanpham.setText("Giá:\t"+decimalFormat.format(sanpham.getGiasanpham())+" VNĐ");
        Picasso.get().load(sanpham.getHinhanhsanpham())
                .placeholder(R.drawable.nomage)
                .error(R.drawable.error)
                .into(holder.imghinhsanpham);
    }

    @Override
    public int getItemCount() {

        return arraySanpham.size()  ;
    }

    public class ItemHolder extends RecyclerView.ViewHolder{
        public ImageView imghinhsanpham,heart;
        public TextView txttensanpham,txtgiasanpham;

        public ItemHolder(View itemView) {
            super(itemView);

            imghinhsanpham=(ImageView) itemView.findViewById(R.id.imageviewsanpham);
            txtgiasanpham=itemView.findViewById(R.id.tvgiasanpham);
            txttensanpham=itemView.findViewById(R.id.tvTensanpham);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(context, ChiTietSanPhamActivity.class);
                    intent.putExtra("thongtinsanpham",arraySanpham.get(getPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    Checkconnect.ShowToast_Short(context,arraySanpham.get(getPosition()).getTensanpham());
                    context.startActivity(intent);

                }
            });
        }
    }

    public void Filter(String chartText){
        chartText = chartText.toLowerCase(Locale.getDefault());
        productList.clear();
        if (chartText.length()==0){
            productList.addAll(arraySanpham);
        }else{
            for (SanPham p :arraySanpham){
                if (p.getTensanpham().toLowerCase(Locale.getDefault()).contains(chartText)){
                    productList.add(p);
                }
            }
        }
        notifyDataSetChanged();
    }
}
