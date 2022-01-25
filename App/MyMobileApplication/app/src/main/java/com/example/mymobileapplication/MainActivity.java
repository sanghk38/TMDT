package com.example.mymobileapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mymobileapplication.adapter.SanphamAdapter;
import com.example.mymobileapplication.adapter.SlidePhotoAdapter;
import com.example.mymobileapplication.connect.Checkconnect;
import com.example.mymobileapplication.connect.Server;
import com.example.mymobileapplication.data.Cart;
import com.example.mymobileapplication.data.Favorite;
import com.example.mymobileapplication.data.Giohang;
import com.example.mymobileapplication.data.SanPham;
import com.example.mymobileapplication.data.User;
import com.example.mymobileapplication.data.slidePhoto;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView ahBotNavHome;
    private List<SanPham> listCartProduct;
    private int countProduct;
    ViewPager viewPager;
    RecyclerView rcv_new;
    private Timer mTimer;
    private List<slidePhoto> listSlidePhoto;
    private SlidePhotoAdapter slidePhotoAdapter;
    public static ArrayList<SanPham> mangsanpham;
    public static ArrayList<User> users;
    public static ArrayList<Favorite>  mangyeuthich;
    TextView back_new,tiTe;
    TextView all;
    SanphamAdapter sanphamAdapter;
    ImageView sale;
    public static ArrayList<Giohang>  manggiohang;
    public static ArrayList<Cart>  carts;
    boolean limitdata = false;
    View footerview;
    private static  final String Image_URL = "http://192.168.1.6/testadmin/upload/product/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar ab = getSupportActionBar();
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.black));
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        Anhxa();
        initItem();
        setDataSlidePhotoAdapter();

    }

    private void Anhxa() {
        if(mangyeuthich!=null){

        }else{
            mangyeuthich = new ArrayList<>();
        }
        if(manggiohang!=null){
        }else {
            manggiohang = new ArrayList<>();
            mangsanpham = new ArrayList<>();
           carts = new ArrayList<>();
        }
    }

    private void initItem() {
        ahBotNavHome = findViewById(R.id.ahbotnav_home);
        ahBotNavHome.setSelectedItemId(R.id.home);
        viewPager  =findViewById(R.id.imageSlider);
        rcv_new = findViewById(R.id.rcv_new);
        sale = findViewById(R.id.imgsale);
        sale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SaleActivity.class);
                startActivity(i);
            }
        });
        mangsanpham =new ArrayList<>();
        users = new ArrayList<>();
        ahBotNavHome.setOnNavigationItemSelectedListener(navgation);
        sanphamAdapter=new SanphamAdapter(getApplicationContext(),mangsanpham);
        rcv_new.setHasFixedSize(true);
        rcv_new.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        rcv_new.setAdapter(sanphamAdapter);
        GetDuLieuSPMoiNhat1();
        all = findViewById(R.id.all);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {

                Intent i = new Intent(MainActivity.this, NewActivity.class);
                startActivity(i);
            }
        });
        listSlidePhoto = getListSlidePhoto();

        if(listCartProduct == null){
            listCartProduct = new ArrayList<>();
        }
    }




    private void GetDuLieuSPMoiNhat1() {
        final RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Server.BASE_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response!=null){
                            int ID=0;
                            String Tensanpham="";
                            Integer Giasanpham=0;
                            String Hinhanhsanpham="";
                            String Motasanpham="";
                            int IDsanpham=0;
                            int yeuthich = 0;
                            for (int i=0;i<response.length();i++){
                                try {
                                    JSONObject jsonObject=response.getJSONObject(i);
                                    ID = jsonObject.getInt("id");
                                    yeuthich = jsonObject.getInt("view");
                                    Tensanpham =jsonObject.getString("name");
                                    Giasanpham=jsonObject.getInt("price");
                                    Hinhanhsanpham=Image_URL+jsonObject.getString("image_link");
                                    Motasanpham=jsonObject.getString("content");
//                                    IDsanpham=jsonObject.getInt("catatlog_id");
                                    mangsanpham.add(new SanPham(ID,Tensanpham,Giasanpham,Hinhanhsanpham,Motasanpham,IDsanpham,yeuthich));
                                    sanphamAdapter.notifyDataSetChanged();
                                    Collections.shuffle(mangsanpham);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }else {
                            limitdata = true;
                            Checkconnect.ShowToast_Short(getApplicationContext(), "\n" +
                                    "The data has run out");
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    // Set Adapter cho viewPagerSlidePhoto
    private void setDataSlidePhotoAdapter(){
        slidePhotoAdapter = new SlidePhotoAdapter(listSlidePhoto, MainActivity.this);
        viewPager.setAdapter(slidePhotoAdapter);

        // Auto chuyển các slide photo
        autoSildeImage();

    }
    private List<slidePhoto> getListSlidePhoto(){
        List<slidePhoto> listSlidePhoto = new ArrayList<>();
        listSlidePhoto.add(new slidePhoto(R.drawable.slide1));
        listSlidePhoto.add(new slidePhoto(R.drawable.slide7));
        listSlidePhoto.add(new slidePhoto(R.drawable.slide8));
        listSlidePhoto.add(new slidePhoto(R.drawable.slide9));
        listSlidePhoto.add(new slidePhoto(R.drawable.slide6));
        return listSlidePhoto;
    }


    // Auto chuyển các slide photo
    private void autoSildeImage(){
        if(listSlidePhoto == null || listSlidePhoto.isEmpty() || viewPager == null){
            return;
        }
        if (mTimer == null){
            mTimer = new Timer();
        }
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem = viewPager.getCurrentItem();
                        int totalItem = listSlidePhoto.size() - 1;

                        // Nếu item hiện tại chưa phải cuối cùng
                        if(currentItem < totalItem){
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        }else {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }

            // xử lý thêm để set time
        },500,3000 );
    }

    //set case fargment
    private BottomNavigationView.OnNavigationItemSelectedListener navgation = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Intent i;
            switch (item.getItemId()) {
                case R.id.home:
                   i = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.shop:
                    i = new Intent(MainActivity.this,MenActivity.class);
                    startActivity(i);
                    break;
                case R.id.bag:
                    i = new Intent(MainActivity.this,Giohangactivity.class);
                    startActivity(i);
                    break;
                case R.id.favorite:
                    i = new Intent(MainActivity.this,FavoriteActivity.class);
                    startActivity(i);
                    break;

                case R.id.profile:
                    i = new Intent(MainActivity.this,ProfileActivity.class);
                    startActivity(i);
                    break;
            }
            return true;
        }

    };
}