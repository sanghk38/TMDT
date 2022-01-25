package com.example.mymobileapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mymobileapplication.adapter.GiohangAdapter;
import com.example.mymobileapplication.connect.Checkconnect;
import com.example.mymobileapplication.data.Cart;
import com.example.mymobileapplication.data.Giohang;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Giohangactivity extends AppCompatActivity {
    ListView lvgiohang;
    TextView txtthongbao;
    static TextView txttongtien;
    Button bntthanhtoan,bnttieptucmua;
    Toolbar tbgiohang;
    GiohangAdapter giohangAdapter;
    private BottomNavigationView ahBotNavHome;
    public static ArrayList<Cart> carts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohangactivity);
        Anhxa();
        ActionToolBar();
        CheckData();
        EvenUtil();
        CacthOnItemListView();
        EventButton();
        initItem();
    }

    private void EventButton() {
        bnttieptucmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        bntthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.manggiohang.size() >0){
                    Intent intent = new Intent(getApplicationContext(),ThongTinKhachhang.class);
                    startActivity(intent);

                }else {
                    Checkconnect.ShowToast_Short(getApplicationContext(),"Your shopping cart is empty");
                }
            }
        });
    }

    private void CacthOnItemListView() {
        lvgiohang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int posion, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Giohangactivity.this);
                builder.setTitle("Xác nhận xóa sản phẩm\n");
                builder.setMessage("Bạn có chắc chắn xóa sản phẩm này không\n");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(MainActivity.manggiohang.size() <=0){
                            txtthongbao.setVisibility(View.VISIBLE);

                        }else {
                            MainActivity.manggiohang.remove(posion);
                            giohangAdapter.notifyDataSetChanged();
                            EvenUtil();
                            if(MainActivity.manggiohang.size() <= 0){
                                txtthongbao.setVisibility(View.VISIBLE);
                            }else {
                                txtthongbao.setVisibility(View.INVISIBLE);
                                giohangAdapter.notifyDataSetChanged();
                                EvenUtil();
                            }
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        giohangAdapter.notifyDataSetChanged();
                        EvenUtil();
                    }
                });
                builder.show();
                return true;

            }
        });
    }

    public static void EvenUtil() {
        long tongtien = 0;
        for(int i = 0;i<MainActivity.manggiohang.size();i++){
            tongtien+=MainActivity.manggiohang.get(i).getGiasp();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txttongtien.setText(decimalFormat.format(tongtien)+"\t" + "\tVNĐ");
    }

    private void CheckData() {
        if(MainActivity.manggiohang.size() <=0){
            giohangAdapter.notifyDataSetChanged();
            txtthongbao.setVisibility(View.VISIBLE);
            lvgiohang.setVisibility(View.INVISIBLE);

        }else {
            giohangAdapter.notifyDataSetChanged();
            txtthongbao.setVisibility(View.INVISIBLE);
            lvgiohang.setVisibility(View.VISIBLE);
        }
    }

    private void ActionToolBar() {
        setSupportActionBar(tbgiohang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbgiohang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        lvgiohang = (ListView) findViewById(R.id.lvgiohang);
        txtthongbao =(TextView) findViewById(R.id.tvthongbao);
        txttongtien =(TextView)findViewById(R.id.tvtongtien);
        bntthanhtoan=(Button)findViewById(R.id.bntthanhtoan);
        bnttieptucmua = (Button)findViewById(R.id.bnttieptuc);
        tbgiohang = (Toolbar)findViewById(R.id.tbGiohang);
        giohangAdapter = new GiohangAdapter(Giohangactivity.this,MainActivity.manggiohang);
        lvgiohang.setAdapter(giohangAdapter);

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navgation = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Intent i;
            switch (item.getItemId()) {
                case R.id.home:
                    i = new Intent(Giohangactivity.this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.shop:
                    i = new Intent(Giohangactivity.this,MenActivity.class);
                    startActivity(i);
                    break;
                case R.id.bag:
                    i = new Intent(Giohangactivity.this,Giohangactivity.class);
                    startActivity(i);
                    break;
                case R.id.favorite:
                    i = new Intent(Giohangactivity.this,FavoriteActivity.class);
                    startActivity(i);
                    break;
                case R.id.profile:
                    i = new Intent(Giohangactivity.this,ProfileActivity.class);
                    startActivity(i);
                    break;
            }
            return true;
        }

    };
    private void initItem() {
        ahBotNavHome = findViewById(R.id.ahbotnav_home);
        ahBotNavHome.setSelectedItemId(R.id.bag);

        ahBotNavHome.setOnNavigationItemSelectedListener(navgation);

    }
}