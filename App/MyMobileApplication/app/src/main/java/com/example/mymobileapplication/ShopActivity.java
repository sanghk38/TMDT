package com.example.mymobileapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.mymobileapplication.Fragment.KidsFragment;
import com.example.mymobileapplication.Fragment.ManFragment;
import com.example.mymobileapplication.Fragment.WomenFragment;
import com.example.mymobileapplication.adapter.vdAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class ShopActivity extends AppCompatActivity {
    Toolbar toolbar;
    private TabLayout tab;
    private ViewPager views;
    vdAdapter adapter;
    private BottomNavigationView ahBotNavHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Inititem();
    }
    public void Inititem(){
        ahBotNavHome = findViewById(R.id.ahbotnav_home);
        ahBotNavHome.setSelectedItemId(R.id.shop);
        ahBotNavHome.setOnNavigationItemSelectedListener(navgation);
        tab =  findViewById(R.id.tablayout);
        views = findViewById(R.id.views);
        toolbar = findViewById(R.id.toolbar2);
        tab.setupWithViewPager(views);
        adapter = new vdAdapter(ShopActivity.this.getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addfragment(new ManFragment(),"Men");
        adapter.addfragment(new WomenFragment(),"Women");
        adapter.addfragment(new KidsFragment(),"Kids");
        views.setAdapter(adapter);
    }
    //set case fargment
    private BottomNavigationView.OnNavigationItemSelectedListener navgation = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Intent i;
            switch (item.getItemId()) {
                case R.id.home:
                    i = new Intent(ShopActivity.this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.shop:
                    i = new Intent(ShopActivity.this,ShopActivity.class);
                    startActivity(i);
                    break;
                case R.id.bag:
                    i = new Intent(ShopActivity.this,Giohangactivity.class);
                    startActivity(i);
                    break;
                case R.id.favorite:
                    i = new Intent(ShopActivity.this,FavoriteActivity.class);
                    startActivity(i);
                    break;
                case R.id.profile:
                    i = new Intent(ShopActivity.this,ProfileActivity.class);
                    startActivity(i);
                    break;
            }
            return true;
        }

    };
}