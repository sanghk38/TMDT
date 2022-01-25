package com.example.mymobileapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mymobileapplication.adapter.SanphamAdapter;
import com.example.mymobileapplication.adapter.YeuThíchAdapter;
import com.example.mymobileapplication.adapter.favoriteAdapter;
import com.example.mymobileapplication.connect.APISERVISE;
import com.example.mymobileapplication.connect.ApiInterface;
import com.example.mymobileapplication.connect.Checkconnect;
import com.example.mymobileapplication.connect.Server;
import com.example.mymobileapplication.data.SanPham;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class FavoriteActivity extends AppCompatActivity  {
    private BottomNavigationView ahBotNavHome;
     RecyclerView rvsanphamyeuthich;
     YeuThíchAdapter yeuThichAdapter;
     SanPhamYeuThichAdapter sanPhamYeuThichAdapter;
    ArrayList<SanPham> mangsanpham;
    List<SanPham>sanPhamList;
    int ID=0;
    String Tensanpham="";
    Integer Giasanpham= 0;
    String Hinhanhsanpham="";
    String Hinhanhsanpham2="";
    String Motasanpham="";
    int IDsanpham=0;
    int yeuthich = 0;
    private SearchView searchView;
    SanphamAdapter sanphamAdapter;
    favoriteAdapter adapter;
    Context context;
    private static  final String Image_URL = "http://192.168.1.6/testadmin/upload/product/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_favorite);
        ahBotNavHome = findViewById(R.id.ahbotnav_home);
        rvsanphamyeuthich = findViewById(R.id.rvsanphamyeuthich);
        ahBotNavHome.setSelectedItemId(R.id.favorite);
        ahBotNavHome.setOnNavigationItemSelectedListener(navgation);
        mangsanpham = new ArrayList<>();
        GetDuLieuSPMoiNhat();
    }

//    public void getData(){
//        final ProgressDialog progressDialog = new ProgressDialog(FavoriteActivity.this);
//        progressDialog.setMessage("Loading...");
//        progressDialog.show();
//        if (Checkconnect.haveNetworkConnection(FavoriteActivity.this)) {
//            ApiInterface apiInterface = APISERVISE.getServise();
//            Call<List<SanPham>> listCall = apiInterface.GetDataProductLike();
//            listCall.enqueue(new Callback<List<SanPham>>() {
//                @Override
//                public void onResponse(Call<List<SanPham>> call, retrofit2.Response<List<SanPham>> response) {
//                    ArrayList<SanPham> mangsanphamyeuthich = (ArrayList<SanPham>) response.body();
//                   LinearLayoutManager layoutManager = new LinearLayoutManager(FavoriteActivity.this);
//                    rvsanphamyeuthich.setLayoutManager(layoutManager);
//                    rvsanphamyeuthich.setHasFixedSize(true);
//                    yeuThichAdapter = new YeuThíchAdapter(FavoriteActivity.this,mangsanphamyeuthich);
//                    rvsanphamyeuthich.setAdapter(yeuThichAdapter);
//                    progressDialog.dismiss();
//                }
//
//                @Override
//                public void onFailure(Call<List<SanPham>> call, Throwable t) {
//                    progressDialog.dismiss();
//                }
//            });
//
//        } else {
//            Checkconnect.ShowToast_Short(FavoriteActivity.this, "Lỗi mạng");
//            Checkconnect.ShowToast_Short(FavoriteActivity.this, "Vui lòng kiểm tra kết nối");
//            finish();
//        }
//    }
    public void GetDuLieuSPMoiNhat() {
        final RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Server.yeuthich,
                new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response!=null){

                            for (int i=0;i<response.length();i++){
                                try {
                                    JSONObject jsonObject=response.getJSONObject(i);
                                    ID = jsonObject.getInt("id");
                                    yeuthich = jsonObject.getInt("view");
                                    Tensanpham =jsonObject.getString("name");
                                    Giasanpham=jsonObject.getInt("price");
                                    Hinhanhsanpham= Image_URL+jsonObject.getString("image_link");
                                    Hinhanhsanpham2= jsonObject.getString("image_link");
                                    Motasanpham=jsonObject.getString("content");
//                                    IDsanpham=jsonObject.getInt("catatlog_id");
                                    LinearLayoutManager layoutManager = new LinearLayoutManager(FavoriteActivity.this);
                                 rvsanphamyeuthich.setLayoutManager(layoutManager);
                                 rvsanphamyeuthich.setHasFixedSize(true);
                                    mangsanpham.add(new SanPham(ID,Tensanpham,Giasanpham,Hinhanhsanpham,Motasanpham,IDsanpham,yeuthich));
                                    yeuThichAdapter = new YeuThíchAdapter(FavoriteActivity.this,mangsanpham);
                                    yeuThichAdapter.notifyDataSetChanged();
                                    rvsanphamyeuthich.setAdapter(yeuThichAdapter);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }


    //set case fargment
    private BottomNavigationView.OnNavigationItemSelectedListener navgation = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Intent i;
            switch (item.getItemId()) {
                case R.id.home:
                    i = new Intent(FavoriteActivity.this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.shop:
                    i = new Intent(FavoriteActivity.this,ShopActivity.class);
                    startActivity(i);
                    break;
                case R.id.bag:
                    i = new Intent(FavoriteActivity.this,Giohangactivity.class);
                    startActivity(i);
                    break;
                case R.id.favorite:
                    i = new Intent(FavoriteActivity.this,FavoriteActivity.class);
                    startActivity(i);
                    break;

                case R.id.profile:
                    i = new Intent(FavoriteActivity.this,ProfileActivity.class);
                    startActivity(i);
                    break;
            }
            return true;
        }

    };


}