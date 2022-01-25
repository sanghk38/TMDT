package com.example.mymobileapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mymobileapplication.adapter.ProductSearch;
import com.example.mymobileapplication.connect.APISERVISE;
import com.example.mymobileapplication.connect.ApiInterface;
import com.example.mymobileapplication.connect.Checkconnect;
import com.example.mymobileapplication.data.SanPham;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SanPhamYeuThichAdapter extends BaseAdapter {
    Context context;
    ArrayList<SanPham> arraySanpham;
    List<SanPham> productList;
    View v;

    public SanPhamYeuThichAdapter(Context context, ArrayList<SanPham> arraySanpham) {
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
        public TextView txtname,txtprice,txtdiscount;
        public ImageView imageViews,heart;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder viewHolder;
        if (convertView==null){
            viewHolder= new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_item_sanpham_yeuthich,null);
            viewHolder.txtname=(TextView) convertView.findViewById(R.id.tvtensanphamyeuthich);
            viewHolder.txtprice=(TextView) convertView.findViewById(R.id.tvgiasanphamyeuthich);
            viewHolder.imageViews=(ImageView) convertView.findViewById(R.id.imgsanphamyeuthich);
            viewHolder.heart = convertView.findViewById(R.id.imglike);
            if (Checkconnect.haveNetworkConnection(context)){
                viewHolder.heart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ApiInterface apiInterface = APISERVISE.getServise();
                        Call<String> stringCall = apiInterface.updatelike("1", String.valueOf(arraySanpham.get(position).getID()));
                        stringCall.enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {
                                String ketqua = response.body();
                                if (ketqua.equals("Success")) {
                                    Checkconnect.ShowToast_Short(context, "Yêu thích");
                                } else {
                                    Checkconnect.ShowToast_Short(context, "Lỗi");
                                }
                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {

                            }
                        });
                        viewHolder.heart.setEnabled(false);
                    }
                });

            }


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
}
