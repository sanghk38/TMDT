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
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mymobileapplication.adapter.PhuKienThoiTrangAdapter;
import com.example.mymobileapplication.adapter.ThoiTrangNuAdpater;
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

public class PhukienActivity extends AppCompatActivity {
    ListView lvphukien;
    PhuKienThoiTrangAdapter phuKienThoiTrangAdapter;
    ArrayList<SanPham> mangphukien;
    int idphukien = 0;
    int page = 1;
    View footerview;
    boolean limitdata = false;
    boolean Loading = false;
    static PhukienActivity.mHandler mHandler;
    private static  final String Image_URL = "http://192.168.1.6/testadmin/upload/product/";
    ImageView view;
    private BottomNavigationView ahBotNavHome,sanpham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phukien);
        setControl();
        if (Checkconnect.haveNetworkConnection(getApplicationContext())) {
            GetIdloaisp();
            LoadMoreData();
            getData(page);
            back();
            initItem();
        } else {
            Checkconnect.ShowToast_Short(getApplicationContext(), "Lỗi mạng");
            Checkconnect.ShowToast_Short(getApplicationContext(), "Vui lòng kiểm tra kết nối");
            finish();
        }

    }

    private void initItem() {
        sanpham = findViewById(R.id.sanpham);
        sanpham.setSelectedItemId(R.id.phukien);
        sanpham.setOnNavigationItemSelectedListener(navgation);
    }

    private void back() {
        view = findViewById(R.id.newback);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhukienActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }

    private void getData(int page) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan2 = Server.pktt + page;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongdan2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id = 0;
                String tensp = "";
                int giasp = 0;
                String hinhanhsp = "";
                String motasp = "";
                int idsp = 0;
                int yeuthich = 0;
                if (response != null && response.length() != 2) {
                    lvphukien.removeFooterView(footerview);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tensp = jsonObject.getString("tensanpham");
                            giasp = jsonObject.getInt("giasanpham");
                            hinhanhsp = Image_URL+jsonObject.getString("hinhanhsanpham");
                            motasp = jsonObject.getString("motasanpham");
                            idsp = jsonObject.getInt("idsanpham");
                            yeuthich = jsonObject.getInt("yeuthich");
                            mangphukien.add(new SanPham(id, tensp, giasp, hinhanhsp, motasp, idsp, yeuthich));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                } else {
                    limitdata = true;
                    lvphukien.removeFooterView(footerview);
                    Checkconnect.ShowToast_Short(getApplicationContext(), "\n" +
                            "The data has run out");
                }
                phuKienThoiTrangAdapter.notifyDataSetChanged();
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
                param.put("idsanpham", String.valueOf(idphukien));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void LoadMoreData() {
        lvphukien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ChiTietSanPhamActivity.class);
                intent.putExtra("thongtinsanpham", mangphukien.get(position));
                startActivity(intent);
            }
        });
        // sự kiện vuốt của listview
        lvphukien.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount != 0 && Loading == false && limitdata == false) {
                    Loading = true;
                    PhukienActivity.ThreadData threadData = new PhukienActivity.ThreadData();
                    threadData.start();
                }
            }
        });
    }

    private void GetIdloaisp() {
        idphukien = getIntent().getIntExtra("idLoaisanpham", -1);
        Log.d("giatriloaisanpham", idphukien + "");
    }

    private void setControl() {
        lvphukien = findViewById(R.id.lvphukien);
        mangphukien = new ArrayList<>();
        phuKienThoiTrangAdapter = new PhuKienThoiTrangAdapter(PhukienActivity.this, mangphukien);
        lvphukien.setAdapter(phuKienThoiTrangAdapter);
        //Gợi phương thức gán layout
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        // truyền thanh progressbar
        footerview = inflater.inflate(R.layout.progressbar, null);
        mHandler = new mHandler();
    }

    public class mHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    lvphukien.addFooterView(footerview);
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
    private BottomNavigationView.OnNavigationItemSelectedListener navgation = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Intent i;
            switch (item.getItemId()) {
                case R.id.man:
                    i = new Intent(PhukienActivity.this,MenActivity.class);
                    startActivity(i);
                    break;
                case R.id.women:
                    i = new Intent(PhukienActivity.this,WomenActivity.class);
                    startActivity(i);
                    break;
                case R.id.phukien:
                    i = new Intent(PhukienActivity.this,PhukienActivity.class);
                    startActivity(i);
                    break;
                case R.id.thuonghieu:
                    i = new Intent(PhukienActivity.this,ThuonghieuActivity.class);
                    startActivity(i);
                    break;
            }
            return true;
        }

    };
}