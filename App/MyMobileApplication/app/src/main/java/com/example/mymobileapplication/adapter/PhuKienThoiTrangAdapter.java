package com.example.mymobileapplication.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymobileapplication.PhukienActivity;
import com.example.mymobileapplication.R;
import com.example.mymobileapplication.data.SanPham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhuKienThoiTrangAdapter extends BaseAdapter {
    PhukienActivity context;
    ArrayList<SanPham> arrayList;

    public PhuKienThoiTrangAdapter(PhukienActivity context, ArrayList<SanPham> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        public TextView txttensp, txtgia, txtmota;
        public ImageView imgphukien, imglike;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        PhuKienThoiTrangAdapter.ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new PhuKienThoiTrangAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_sanphamtapluyen, null);
            viewHolder.txttensp = convertView.findViewById(R.id.tvtensanpham);
            viewHolder.txtgia = convertView.findViewById(R.id.tvgiasanpham);
            viewHolder.txtmota = convertView.findViewById(R.id.tvmota);
            viewHolder.imgphukien = convertView.findViewById(R.id.imgsanphamtapluyen);
            viewHolder.imglike = convertView.findViewById(R.id.imglike);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (PhuKienThoiTrangAdapter.ViewHolder) convertView.getTag();
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
                .placeholder(R.drawable.alo)
                .error(R.drawable.error)
                .into(viewHolder.imgphukien);
        final ViewHolder finalViewHolder = viewHolder;
        final ViewHolder finalViewHolder1 = viewHolder;
//        viewHolder.imglike.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finalViewHolder.imglike.setImageResource(R.drawable.like);
//                ApiInterface apiInterface = APISERVISE.getServise();
//                Call<String> stringCall = apiInterface.updatelike("1", String.valueOf(arrayList.get(position).getId()));
//                stringCall.enqueue(new Callback<String>() {
//                    @Override
//                    public void onResponse(Call<String> call, Response<String> response) {
//                        String ketqua = response.body();
//                        if (ketqua.equals("Success")) {
//                            CheckConnect.showToast_Short(context, "Yêu thích");
//                            context.refresh();
//                        } else {
//                            CheckConnect.showToast_Short(context, "Lỗi");
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<String> call, Throwable t) {
//
//                    }
//                });
//                finalViewHolder1.imglike.setEnabled(false);
//            }
//        });
        return convertView;
    }
}
