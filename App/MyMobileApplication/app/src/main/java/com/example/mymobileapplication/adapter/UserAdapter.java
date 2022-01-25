package com.example.mymobileapplication.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.example.mymobileapplication.R;
import com.example.mymobileapplication.connect.Checkconnect;
import com.example.mymobileapplication.data.SanPham;
import com.example.mymobileapplication.data.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends BaseAdapter {
    ArrayList<User> mangaccount;
    Context context;
    List<User> userList;

    public UserAdapter(ArrayList<User> mangaccount, Context context) {
        this.mangaccount = mangaccount;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mangaccount.size();
    }

    @Override
    public Object getItem(int position) {
        return mangaccount.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView tvemail, tvtenaccount;
        ImageView imgdelete;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item_account, null);
            viewHolder.tvemail = view.findViewById(R.id.tvemail);
            viewHolder.tvtenaccount = view.findViewById(R.id.tvten);
            viewHolder.imgdelete = view.findViewById(R.id.imgdelete);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final User account = (User) getItem(position);
        viewHolder.tvemail.setText(account.getEmail());
        viewHolder.tvtenaccount.setText(account.getTenKh());

        viewHolder.imgdelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Xác nhận");
                builder.setMessage("Bạn có muốn xóa sản phẩm này không?");
                builder.setCancelable(false);
                builder.setPositiveButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Checkconnect.ShowToast_Short(context, "Mời bạn tiếp tục chương trình");
                    }
                });
                builder.setNegativeButton("Đông ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        context.deleteAccount(account.getId());
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return view;
    }
}
