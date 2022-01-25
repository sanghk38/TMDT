package com.example.mymobileapplication;

import static com.example.mymobileapplication.Giohangactivity.EvenUtil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mymobileapplication.adapter.ProductSearch;
import com.example.mymobileapplication.adapter.SanphamAdapter;
import com.example.mymobileapplication.adapter.favoriteAdapter;
import com.example.mymobileapplication.connect.Checkconnect;
import com.example.mymobileapplication.connect.Server;
import com.example.mymobileapplication.data.Favorite;
import com.example.mymobileapplication.data.Giohang;
import com.example.mymobileapplication.data.SanPham;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewActivity extends AppCompatActivity {
    ListView lvs;
    TextView back_new,tiTe;
    private List<SanPham> listCartProduct;
    ArrayList<SanPham> mangsanpham;
    public static ArrayList<Favorite>  mangyeuthich;
    TextView txtthongbao;
    int ID=0;
    String Tensanpham="";
    Integer Giasanpham= 0;
    String Hinhanhsanpham="";
    String Hinhanhsanpham2="";
    String Motasanpham="";
    int IDsanpham=0;
    int yeuthich = 0;
    private SearchView  searchView;
    SanphamAdapter sanphamAdapter;
    favoriteAdapter adapter;
    Context context;

    ProductSearch search;
    private static  final String Image_URL = "http://192.168.1.6/testadmin/upload/product/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        initItem();
        GetDuLieuSPMoiNhat();
    }
    //khởi tạo Item
    private void initItem(){
        Toolbar toolbar  = (Toolbar) findViewById(R.id.toolbar2);
        tiTe = (TextView)findViewById(R.id.tbtext);
        back_new = (TextView)findViewById(R.id.newback);
        back_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NewActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
        lvs = findViewById(R.id. lvs);
        LoadData();
        mangsanpham =new ArrayList<>();
        mangyeuthich = new ArrayList<>();
        search = new ProductSearch(this, mangsanpham);
        lvs.setAdapter(search);
        toolbar.setTitle("");
        tiTe.setText("News");
        setSupportActionBar(toolbar);

    }
    private  void LoadData(){
        lvs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(getApplicationContext(),ChiTietSanPhamActivity.class);
                intent.putExtra("thongtinsanpham",mangsanpham.get(i));
                startActivity(intent);
            }
        });
    }
    private void GetDuLieuSPMoiNhat() {
        final RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Server.BAS_URL1,
                new Response.Listener<JSONArray>() {
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
                                    mangsanpham.add(new SanPham(ID,Tensanpham,Giasanpham,Hinhanhsanpham,Motasanpham,IDsanpham,yeuthich));
                                    search.notifyDataSetChanged();
                                    Collections.shuffle(mangsanpham);
                                    search = new ProductSearch(NewActivity.this, mangsanpham);
                                    lvs.setAdapter(search);

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int position = 0;
        getMenuInflater().inflate(R.menu.search,menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(NewActivity.this,query,Toast.LENGTH_LONG).show();

//                search.Filter(query.trim());
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                search.Filter(newText.trim());
                searchView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(context, ChiTietSanPhamActivity.class);
                        intent.putExtra("thongtinsanpham",mangsanpham.get(position));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        Checkconnect.ShowToast_Short(context,mangsanpham.get(position).getTensanpham());
                        context.startActivity(intent);
                    }
                });
                return false;
            }
        });
        return true;
    }
}