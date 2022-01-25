package com.example.mymobileapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mymobileapplication.connect.Checkconnect;
import com.example.mymobileapplication.connect.Server;
import com.example.mymobileapplication.data.Cart;
import com.example.mymobileapplication.data.Favorite;
import com.example.mymobileapplication.data.Giohang;
import com.example.mymobileapplication.data.SanPham;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChiTietSanPhamActivity extends AppCompatActivity {
    Toolbar toolbarchitiet;
    ImageView imgchitiet;
    TextView txtten,txtgia,txtmota, txtluotthich;
    Spinner spinner,spinnerkichthuoc;
    Button bntdatmua,bntfavorite;
    int id =0;
    String Tenchitiet= "";
    int Giachitiet = 0;
    String Hinhanhchitiet = "";
    String Motachitiet = "";
    int Idsanpham = 0;
    int yeuthich = 0;
    public static ArrayList<Giohang> manggiohang;
    public static ArrayList<SanPham> mangsp;
    public static ArrayList<Favorite> mangfv;
    private List<SanPham> listCartProduct;

    public static ArrayList<Cart> carts;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        Anhxa();
        GetInformation();
        EventButton();
        CatchEventSpiner();
    }

    private void CatchEventSpiner() {
        Integer [] soluong =new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item,soluong);
        spinner.setAdapter(arrayAdapter);
        String[] kichthuoc = new String[]{"S", "M", "L"};
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, kichthuoc);
        spinnerkichthuoc.setAdapter(stringArrayAdapter);
    }

    private void EventButton() {
    bntdatmua.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(MainActivity.manggiohang.size() >0){
                int sl= Integer.parseInt(spinner.getSelectedItem().toString());
                String kt = spinnerkichthuoc.getSelectedItem().toString();
                boolean exite = false;
                for(int i =0 ;i<MainActivity.manggiohang.size();i++){
                    if(MainActivity.manggiohang.get(i).getIdsp() == id){
                        MainActivity.manggiohang.get(i).setSoluongsp(MainActivity.manggiohang.get(i).getSoluongsp() + sl);
                        if(MainActivity.manggiohang.get(i).getSoluongsp()>=10){
                            MainActivity.manggiohang.get(i).setSoluongsp(10);
                        }
                        MainActivity.manggiohang.get(i).setGiasp(Giachitiet * MainActivity.manggiohang.get(i).getSoluongsp());
                        exite = true;
                    }
                }
                if(exite == false){
                    int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                    long Giamoi = soluong * Giachitiet;
                    MainActivity.manggiohang.add(new Giohang(id,Tenchitiet,Giamoi,Hinhanhchitiet,soluong,kt));
                }
            }else {
                int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                String kt = spinnerkichthuoc.getSelectedItem().toString();
                long Giamoi = soluong * Giachitiet;
                MainActivity.manggiohang.add(new Giohang(id,Tenchitiet,Giamoi,Hinhanhchitiet,soluong,kt));
            }
            Intent intent = new Intent(getApplicationContext(), Giohangactivity.class);
            startActivity(intent);
        }
    });
//        bntfavorite.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("ResourceType")
//            @Override
//            public void onClick(View v) {
//                if(MainActivity.mangyeuthich.size() >0){
//                    int sl= Integer.parseInt(spinner.getSelectedItem().toString());
//                    boolean exite = false;
//                    for(int i =0 ;i<MainActivity.mangyeuthich.size();i++){
//                        if(MainActivity.mangyeuthich.get(i).getID() == id){
//                            MainActivity.mangyeuthich.get(i).setSoluongsp(MainActivity.mangyeuthich.get(i).getSoluongsp() + sl);
//                            if(MainActivity.mangyeuthich.get(i).getSoluongsp()>=10){
//                                MainActivity.mangyeuthich.get(i).setSoluongsp(10);
//                            }
//                            MainActivity.mangyeuthich.get(i).setGiasanpham(Giachitiet);
//                            exite = true;
//                        }
//                    }
//                    if(exite == false){
//                        int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
//                        long Giamoi = Giachitiet;
//
//                        MainActivity.mangyeuthich.add(new Favorite(id,Tenchitiet, (int) Giamoi,Hinhanhchitiet,soluong));
//                    }
//                }else {
//                    int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
//                    long Giamoi =  Giachitiet;
//                    MainActivity.mangyeuthich.add(new Favorite(id,Tenchitiet, (int) Giamoi,Hinhanhchitiet,soluong));
//                }
//                if (mangsp != null) {
//                    bntfavorite.setBackgroundResource(R.drawable.ic_heart_grey);
//                }
//                Toast.makeText(ChiTietSanPhamActivity.this,"Add Succes",Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(getApplicationContext(), FavoriteActivity.class);
//                startActivity(intent);
//            }
//        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void GetInformation() {

        SanPham sanpham = (SanPham) getIntent().getSerializableExtra("thongtinsanpham");
        id= sanpham.getID();
        Tenchitiet = sanpham.getTensanpham();
        Giachitiet = Math.toIntExact(sanpham.getGiasanpham());
        Hinhanhchitiet = sanpham.getHinhanhsanpham();
        Motachitiet = sanpham.getMotasanpham();
        Idsanpham = sanpham.getIDSanpham();
        yeuthich= sanpham.getYeuthich();
        txtten.setText(Tenchitiet);
//        txtgia.setText(Giachitiet);
//        txtmota.setText(Motachitiet);
        DecimalFormat decimalFormat= new DecimalFormat("###,###,###");
        txtgia.setText("Giá:\t"+decimalFormat.format(Giachitiet)+"\tVNĐ");
        txtmota.setText(Motachitiet);
        txtluotthich.setText(String.valueOf(yeuthich));
        Picasso.get().load(Hinhanhchitiet)
                .placeholder(R.drawable.nomage)
                .error(R.drawable.error)
                .into(imgchitiet);

    }
    private void Anhxa() {
        imgchitiet = findViewById(R.id.imgchitietsanpham);
        txtten = findViewById(R.id.tvtenchitietsanpham);
        txtgia = findViewById(R.id.tvgiachitietsanpham);
        txtmota = findViewById(R.id.tvmotachitietsanpham);
        txtluotthich = findViewById(R.id.txtluotthich);
        bntdatmua = findViewById(R.id.bntDatmua);
        spinnerkichthuoc = findViewById(R.id.spinnerkichthuoc);
        spinner  = findViewById(R.id.spinner);
        mangsp = new ArrayList<>();
        listCartProduct = new ArrayList<>();
    }
}