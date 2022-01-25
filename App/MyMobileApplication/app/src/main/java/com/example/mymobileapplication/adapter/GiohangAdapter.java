package com.example.mymobileapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mymobileapplication.Giohangactivity;
import com.example.mymobileapplication.MainActivity;
import com.example.mymobileapplication.R;
import com.example.mymobileapplication.data.Giohang;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GiohangAdapter extends BaseAdapter {
    Context context;
    ArrayList<Giohang> giohangArrayList;

    public GiohangAdapter(Context context, ArrayList<Giohang> giohangArrayList) {
        this.context = context;
        this.giohangArrayList = giohangArrayList;
    }

    @Override
    public int getCount() {
        return giohangArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return giohangArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }
    public class ViewHodel{
        public TextView txttengiohang,txtgiagiohang,tvso;
        public ImageView imggiohang;
        public Button bnttru,bntgiatri,bntcong;
        public EditText editText;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHodel viewHodel = null;
        if(view == null){
            viewHodel = new ViewHodel();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_giohang,null);
            viewHodel.txttengiohang = (TextView) view.findViewById(R.id.tvtengiohang);
            viewHodel.txtgiagiohang = (TextView) view.findViewById(R.id.tvgiagiohang);
            viewHodel.imggiohang = (ImageView) view.findViewById(R.id.imggiohang);
            viewHodel.bnttru = (Button) view.findViewById(R.id.bnttru);
            viewHodel.bntgiatri = (Button) view.findViewById(R.id.bntthem);
            viewHodel.bntcong = (Button)view.findViewById(R.id.bntcong);
            view.setTag(viewHodel);
        }else {
            viewHodel = (ViewHodel) view.getTag();
        }
        Giohang giohang = (Giohang) getItem(i);
        viewHodel.txttengiohang.setText(giohang.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHodel.txtgiagiohang.setText("Giá:\t"+decimalFormat.format( giohang.getGiasp()) +"VND" );
        Picasso.get().load(giohang.getHinhanhsp())
                .placeholder(R.drawable.nomage)
                .error(R.drawable.error)
                .into(viewHodel.imggiohang);
        viewHodel.bntgiatri.setText(giohang.getSoluongsp() + "");
        int sl = Integer.parseInt(viewHodel.bntgiatri.getText().toString());
        if (sl >= 15){
            viewHodel.bntcong.setVisibility(View.INVISIBLE);
            viewHodel.bnttru.setVisibility(View.VISIBLE);
        }else if (sl <= 1){
            viewHodel.bnttru.setVisibility(View.INVISIBLE);
        }else if (sl >= 1){
            viewHodel.bnttru.setVisibility(View.VISIBLE);
            viewHodel.bntcong.setVisibility(View.VISIBLE);
        }
        final ViewHodel finalViewHolder = viewHodel;
        final ViewHodel finalViewHolder1 = viewHodel;
        viewHodel.bntcong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat = Integer.parseInt(finalViewHolder.bntgiatri.getText().toString()) + 1;
                int slhientai = MainActivity.manggiohang.get(i).getSoluongsp();
                long giaht = MainActivity.manggiohang.get(i).getGiasp();
                MainActivity.manggiohang.get(i).setSoluongsp(slmoinhat);
                long giamoinhat = (giaht * slmoinhat) / slhientai;
                MainActivity.manggiohang.get(i).setGiasp(giamoinhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolder.txtgiagiohang.setText(decimalFormat.format(giamoinhat)+ " VND");
                com.example.mymobileapplication.Giohangactivity.EvenUtil();
                if (slmoinhat > 14){
                    finalViewHolder1.bntcong.setVisibility(View.INVISIBLE);
                    finalViewHolder1.bnttru.setVisibility(View.VISIBLE);
                    finalViewHolder.bntgiatri.setText(String.valueOf(slmoinhat));
                }else {
                    finalViewHolder.bnttru. setVisibility(View.VISIBLE);
                    finalViewHolder.bntcong. setVisibility(View.VISIBLE);
                    finalViewHolder.bntgiatri.setText(String.valueOf(slmoinhat));
                }
            }
        });
        viewHodel.bnttru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat = Integer.parseInt(finalViewHolder.bntgiatri.getText().toString()) - 1;
                int slhientai = MainActivity.manggiohang.get(i).getSoluongsp();
                long giaht = MainActivity.manggiohang.get(i).getGiasp();
                MainActivity.manggiohang.get(i).setSoluongsp(slmoinhat);
                long giamoinhat = (giaht * slmoinhat) / slhientai;
                MainActivity.manggiohang.get(i).setGiasp(giamoinhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolder.txtgiagiohang.setText(decimalFormat.format(giamoinhat)+ " $");
                Giohangactivity.EvenUtil();
                if (slmoinhat < 2){
                    finalViewHolder.bnttru.setVisibility(View.INVISIBLE);
                    finalViewHolder.bntcong.setVisibility(View.VISIBLE);
                    finalViewHolder.bntgiatri.setText(String.valueOf(slmoinhat));
                }else {
                    finalViewHolder.bnttru. setVisibility(View.VISIBLE);
                    finalViewHolder.bntcong. setVisibility(View.VISIBLE);
                    finalViewHolder.bntgiatri.setText(String.valueOf(slmoinhat));
                }
            }
        });

        return view;
    }


}
