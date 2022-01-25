package com.example.mymobileapplication.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymobileapplication.R;
import com.example.mymobileapplication.data.SanPham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class NoelAdapter extends BaseAdapter {
    Context context;
    ArrayList<SanPham> saleAraay;

    public NoelAdapter(Context context, ArrayList<SanPham> saleAraay) {
        this.context = context;
        this.saleAraay = saleAraay;
    }
    public class ViewHolder {
        public TextView txttensp, txtgia, txtmota;
        public ImageView imgicon, imglike;
    }
    @Override
    public int getCount() {
        return saleAraay.size();
    }

    @Override
    public Object getItem(int position) {
        return saleAraay.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_noel, null);
            viewHolder.txttensp = convertView.findViewById(R.id.tvtensanpham);
            viewHolder.txtgia = convertView.findViewById(R.id.tvgiasanpham);
            viewHolder.txtmota = convertView.findViewById(R.id.tvmota);
            viewHolder.imgicon = convertView.findViewById(R.id.imgsanphamtapluyen);
            //viewHolder.imglike = convertView.findViewById(R.id.imglike);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        SanPham sp = (SanPham) getItem(position);
        viewHolder.txttensp.setText(sp.getTensanpham());
        viewHolder.txttensp.setMaxLines(2);
        viewHolder.txttensp.setEllipsize(TextUtils.TruncateAt.END);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgia.setText("Giá: " + decimalFormat.format(sp.getGiasanpham()) + ". VNĐ");
        viewHolder.txtmota.setMaxLines(2);
        viewHolder.txtmota.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmota.setText(sp.getMotasanpham());
        Picasso.get().load(sp.getHinhanhsanpham())
                .placeholder(R.drawable.home)
                .error(R.drawable.error)
                .into(viewHolder.imgicon);
        final ViewHolder finalViewHolder = viewHolder;
        final ViewHolder finalViewHolder1 = viewHolder;
//
        return convertView;
    }
}
