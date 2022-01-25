package com.example.mymobileapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymobileapplication.adapter.UserLocalStore;
import com.example.mymobileapplication.data.User;
import com.example.mymobileapplication.data.Uxer;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {
    private BottomNavigationView ahBotNavProfile;
    UserLocalStore userLocalStore;
    TextView txtNameUser,txtEmailUser,tvOder;
    LinearLayout logout;
    FacebookLoginActivity fb;
    ImageView imgOder, imgSetting, imgReview, imgPromocodes, imgPayment, imgShipping, imgUser;
    Intent intent;
    GraphRequest request;
    AccessToken token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        userLocalStore = new UserLocalStore(this);
        ActionBar ab = getSupportActionBar();
        getWindow().setStatusBarColor(ContextCompat.getColor(ProfileActivity.this, R.color.black));
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initItem();
        addEvents();
    }
    //ĐANG LÀM SETTING, Promocodes, REVIEW, PAYMENT, USER.

    private void initItem(){
        ahBotNavProfile = findViewById(R.id.ahbotnav_home);
        ahBotNavProfile.setSelectedItemId(R.id.profile);
        imgOder = (ImageView) findViewById(R.id.imgOder);
        txtNameUser = findViewById(R.id.tvUsername);
        txtEmailUser = findViewById(R.id.tvEmails);
        imgUser = findViewById(R.id.imgUser);
        tvOder = findViewById(R.id.tvMyOrder);
        tvOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(getApplicationContext(), OderUserActivity.class);
                startActivity(loginIntent);
            }
        });
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                SharedPreferences preferences = getSharedPreferences("checkBook", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "false");
                editor.apply();
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);
                Intent loginIntent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginIntent);
                Toast.makeText(ProfileActivity.this, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
            }
        });


        ahBotNavProfile.setOnNavigationItemSelectedListener(navgation);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navgation = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Intent i;
            switch (item.getItemId()) {
                case R.id.home:
                    i = new Intent(ProfileActivity.this,MainActivity.class);
                    startActivity(i);
                    break;
                case R.id.shop:
                    i = new Intent(ProfileActivity.this,ShopActivity.class);
                    startActivity(i);
                    break;
                case R.id.bag:
                    i = new Intent(ProfileActivity.this,BagActivity.class);
                    startActivity(i);
                    break;
                case R.id.favorite:
                    i = new Intent(ProfileActivity.this,FavoriteActivity.class);
                    startActivity(i);
                    break;

                case R.id.profile:
                    i = new Intent(ProfileActivity.this, ProfileActivity.class);
                    startActivity(i);
                    break;
            }
            return true;
        }

    };
    private void addEvents() {
        Profile profile = Profile.getCurrentProfile();
       if (profile !=null){
           String f_name = profile.getFirstName();
           String name = profile.getName();
           String imgfb = profile.getProfilePictureUri(300,300).toString();
           txtNameUser.setText(name);
           txtEmailUser.setText(f_name);
           Picasso.get().load(imgfb).into(imgUser);
           request =  GraphRequest.newMeRequest(token, new GraphRequest.GraphJSONObjectCallback() {
               @Override
               public void onCompleted(JSONObject object, GraphResponse response) {
                   try {
                       String email = object.getString("email");
                       String gender = object.getString("gender");
                       String profile_name = object.getString("name");
                       long fb_id = object.getLong("id");
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }

               }
           });
           request.executeAsync();

       }else{
           Uxer user = userLocalStore.getLoggedInUser();
           txtNameUser.setText(user.username);
           txtEmailUser.setText(user.email);
       }
    }
    @Override
    protected void onStart() {
        super.onStart();

    }
}