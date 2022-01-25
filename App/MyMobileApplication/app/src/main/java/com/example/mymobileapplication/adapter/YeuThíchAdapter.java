package com.example.mymobileapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymobileapplication.ChiTietSanPhamActivity;
import com.example.mymobileapplication.FavoriteActivity;
import com.example.mymobileapplication.R;
import com.example.mymobileapplication.connect.APISERVISE;
import com.example.mymobileapplication.connect.ApiInterface;
import com.example.mymobileapplication.connect.Checkconnect;
import com.example.mymobileapplication.data.SanPham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YeuThíchAdapter extends RecyclerView.Adapter<YeuThíchAdapter.ItemHolder>  {
    Context context;
    ArrayList<SanPham> arraySanpham;
    List<SanPham> productList;
    View v;

    public YeuThíchAdapter(Context context, ArrayList<SanPham> arraySanpham) {
        this.context = context;
        this.arraySanpham = arraySanpham;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sanpham_yeuthich,null);
       ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
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
        return arraySanpham.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        public ImageView imghinhsanpham,heart;
        public TextView txttensanpham,txtgiasanpham;

        public ItemHolder(View itemView) {
            super(itemView);

            imghinhsanpham=(ImageView) itemView.findViewById(R.id.imgsanphamyeuthich);
            txtgiasanpham=itemView.findViewById(R.id.tvgiasanphamyeuthich);
            txttensanpham=itemView.findViewById(R.id.tvtensanphamyeuthich);
            heart = itemView.findViewById(R.id.imglike);
            heart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ApiInterface apiInterface = APISERVISE.getServise();
                    Call<String> stringCall = apiInterface.updatelike("1", String.valueOf(arraySanpham.get(getPosition()).getID()));
                    stringCall.enqueue(new Callback<String>() {
                        @SuppressLint("NotifyDataSetChanged")
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketqua = response.body();
                            if (ketqua.equals("Success")) {
                                Checkconnect.ShowToast_Short(context, "Yêu thích");
                                notifyDataSetChanged();
                            } else {
                                Checkconnect.ShowToast_Short(context, "Lỗi");
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    heart.setEnabled(false);
                }
            });
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
}
