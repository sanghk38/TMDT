package com.example.mymobileapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mymobileapplication.adapter.ThoiTrangNamAdapter;
import com.example.mymobileapplication.connect.Checkconnect;
import com.example.mymobileapplication.connect.Server;
import com.example.mymobileapplication.data.SanPham;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MenActivity extends AppCompatActivity {

    ListView lvthoitrangnam;
    ImageView view;
    ThoiTrangNamAdapter thoiTrangNamAdapter;
    ArrayList<SanPham> mangthoitrangnam;
    private static  final String Image_URL = "http://192.168.1.6/testadmin/upload/product/";
    int idtthoitrangnam = 0;
    int page = 1;
    View footerview;
    boolean limitdata = false;
    boolean Loading = false;
    MenActivity.mHandler mHandler;
    TextView tiTe;
    private BottomNavigationView ahBotNavHome,sanpham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men);
        tiTe = (TextView)findViewById(R.id.tbtext);


        setControl();
        if (Checkconnect.haveNetworkConnection(getApplicationContext())) {
            GetIdloaisp();
            LoadMoreData();
            getData(page);
            back();
            initItem();
        } else {
            Checkconnect.ShowToast_Short(getApplicationContext(), "L???i m???ng");
            Checkconnect.ShowToast_Short(getApplicationContext(), "Vui l??ng ki???m tra k???t n???i");
            finish();
        }
        //toolBar();
    }

    private void back() {
        view = findViewById(R.id.newback);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }

//    private void toolBar() {
//        // Kh???i t???o tool bar v?? thay th??? action bar
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        // Lo???i b??? ti??u ????? tool bar
//        getSupportActionBar().setDisplayShowTitleEnabled(true);
//
//        // Hi???n th??? n??t back
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//    }


    private void getData(int page) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan3 = Server.spmen+page;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongdan3,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        int id = 0;
                        String tenthoitrangnam = "";
                        int giathoitrangnam = 0;
                        String hinhanhthoitrangnam = "";
                        String motathoitrangnam = "";
                        int idspthoitrangnam = 0;
                        int yeuthich = 0;
                        if (response != null && response.length() != 2) {
                            lvthoitrangnam.removeFooterView(footerview);
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    id = jsonObject.getInt("id");
                                    tenthoitrangnam = jsonObject.getString("tensanpham");
                                    giathoitrangnam = jsonObject.getInt("giasanpham");
                                    hinhanhthoitrangnam = Image_URL+jsonObject.getString("hinhanhsanpham");
                                    motathoitrangnam = jsonObject.getString("motasanpham");
                                    idspthoitrangnam = jsonObject.getInt("idsanpham");
                                    yeuthich = jsonObject.getInt("yeuthich");
                                    mangthoitrangnam.add(new SanPham(id, tenthoitrangnam, giathoitrangnam, hinhanhthoitrangnam, motathoitrangnam, idspthoitrangnam,yeuthich));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                progressDialog.dismiss();
                            }
                        } else {
                            limitdata = true;
                            lvthoitrangnam.removeFooterView(footerview);
                            Checkconnect.ShowToast_Short(getApplicationContext(), "\n" +
                                    "The data has run out");
                        }
                        thoiTrangNamAdapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("idsanpham", String.valueOf(idtthoitrangnam));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void LoadMoreData() {
        lvthoitrangnam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ChiTietSanPhamActivity.class);
                intent.putExtra("thongtinsanpham", mangthoitrangnam.get(position));
                startActivity(intent);
            }
        });
        lvthoitrangnam.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount != 0 && Loading == false && limitdata == false) {
                    Loading = true;
                    MenActivity.ThreadData threadData = new MenActivity.ThreadData();
                    threadData.start();
                }
            }
        });
    }

    private void GetIdloaisp() {
        idtthoitrangnam = getIntent().getIntExtra("idLoaisanpham", -1);
        Log.d("giatriloaisanpham", idtthoitrangnam + "");
    }

    private void setControl() {
        lvthoitrangnam = findViewById(R.id.listviewthoitrangnam);
        mangthoitrangnam = new ArrayList<>();
        thoiTrangNamAdapter = new ThoiTrangNamAdapter(getApplicationContext(), mangthoitrangnam);
        lvthoitrangnam.setAdapter(thoiTrangNamAdapter);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerview = inflater.inflate(R.layout.progressbar, null);
        mHandler = new MenActivity.mHandler();
    }

    public class mHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    lvthoitrangnam.addFooterView(footerview);
                    break;
                case 1:
                    getData(++page);
                    Loading = false;
                    break;
            }
            super.handleMessage(msg);
        }
    }

    public class ThreadData extends Thread {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = mHandler.obtainMessage(1);
            mHandler.sendMessage(message);
            super.run();
        }
    }


    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.shopcart, menu);
//        return true;
//    }
//
//    // B???t s??? ki??n tr??n tool bar
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        Intent intent;
//        switch (item.getItemId()) {
//            case android.R.id.home:
//
//                // H???y m??n h??nh
//                finish();
//                onBackPressed();
//                return true;
//            default:
//                break;
//
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
    private BottomNavigationView.OnNavigationItemSelectedListener navgation = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Intent i;
            switch (item.getItemId()) {
                case R.id.man:
                    i = new Intent(MenActivity.this,MenActivity.class);
                    startActivity(i);
                    break;
                case R.id.women:
                    i = new Intent(MenActivity.this,WomenActivity.class);
                    startActivity(i);
                    break;
                case R.id.phukien:
                    i = new Intent(MenActivity.this,PhukienActivity.class);
                    startActivity(i);
                    break;
                case R.id.thuonghieu:
                    i = new Intent(MenActivity.this,ThuonghieuActivity.class);
                    startActivity(i);
                    break;
            }
            return true;
        }

    };
//    //set case fargment
//    private BottomNavigationView.OnNavigationItemSelectedListener navgation1 = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//            Intent i;
//            switch (item.getItemId()) {
//                case R.id.home:
//                    i = new Intent(MenActivity.this,MainActivity.class);
//                    startActivity(i);
//                    break;
//                case R.id.shop:
//                    i = new Intent(MenActivity.this,ShopActivity.class);
//                    startActivity(i);
//                    break;
//                case R.id.bag:
//                    i = new Intent(MenActivity.this,Giohangactivity.class);
//                    startActivity(i);
//                    break;
//                case R.id.favorite:
//                    i = new Intent(MenActivity.this,FavoriteActivity.class);
//                    startActivity(i);
//                    break;
//                case R.id.profile:
//                    i = new Intent(MenActivity.this,HomeActivity.class);
//                    startActivity(i);
//                    break;
//            }
//            return true;
//        }

    //};
    private void initItem() {
//        ahBotNavHome = findViewById(R.id.ahbotnav_home);
//        sanpham.setSelectedItemId(R.id.shop);
//        ahBotNavHome.setOnNavigationItemSelectedListener(navgation1);

        sanpham = findViewById(R.id.sanpham);
        sanpham.setSelectedItemId(R.id.man);
        sanpham.setOnNavigationItemSelectedListener(navgation);

    }

}
