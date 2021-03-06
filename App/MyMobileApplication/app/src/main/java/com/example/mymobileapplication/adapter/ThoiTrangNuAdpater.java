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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThoiTrangNuAdpater extends BaseAdapter {
    Context context;
    ArrayList<SanPham> arrayListthoitrangnu;

    public ThoiTrangNuAdpater(Context context, ArrayList<SanPham> arrayListthoitrangnu) {
        this.context = context;
        this.arrayListthoitrangnu = arrayListthoitrangnu;
    }

    @Override
    public int getCount() {
        return arrayListthoitrangnu.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListthoitrangnu.get(position);
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ThoiTrangNuAdpater.ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ThoiTrangNuAdpater.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_sanphamtapluyen, null);
            viewHolder.txttensp = convertView.findViewById(R.id.tvtensanpham);
            viewHolder.txtgia = convertView.findViewById(R.id.tvgiasanpham);
            viewHolder.txtmota = convertView.findViewById(R.id.tvmota);
            viewHolder.imgicon = convertView.findViewById(R.id.imgsanphamtapluyen);
            viewHolder.imglike = convertView.findViewById(R.id.imglike);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ThoiTrangNuAdpater.ViewHolder) convertView.getTag();
        }
        SanPham sp = (SanPham) getItem(position);
        viewHolder.txttensp.setText(sp.getTensanpham());
        viewHolder.txttensp.setMaxLines(2);
        viewHolder.txttensp.setEllipsize(TextUtils.TruncateAt.END);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgia.setText("Gi??: " + decimalFormat.format(sp.getGiasanpham()) + ". VN??");
        viewHolder.txtmota.setMaxLines(2);
        viewHolder.txtmota.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmota.setText(sp.getMotasanpham());
        Picasso.get().load(sp.getHinhanhsanpham())
                .placeholder(R.drawable.alo)
                .error(R.drawable.error)
                .into(viewHolder.imgicon);
        final ViewHolder finalViewHolder = viewHolder;
        final ViewHolder finalViewHolder1 = viewHolder;
//        viewHolder.imglike.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finalViewHolder.imglike.setImageResource(R.drawable.like);
//                ApiInterface apiInterface = APISERVISE.getServise();
//                Call<String> stringCall = apiInterface.updatelike("1", String.valueOf(arrayListthoitrangnu.get(position).getId()));
//                stringCall.enqueue(new Callback<String>() {
//                    @Override
//                    public void onResponse(Call<String> call, Response<String> response) {
//                        String ketqua = response.body();
//                        if (ketqua.equals("Success")) {
//                            CheckConnect.showToast_Short(context, "Y??u th??ch");
//                        } else {
//                            CheckConnect.showToast_Short(context, "L???i");
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

