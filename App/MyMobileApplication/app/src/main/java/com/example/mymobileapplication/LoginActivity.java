package com.example.mymobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mymobileapplication.adapter.UserLocalStore;
import com.example.mymobileapplication.connect.Server;
import com.example.mymobileapplication.data.Account;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import com.example.mymobileapplication.data.User;
import com.example.mymobileapplication.data.Uxer;
import com.example.mymobileapplication.helper.DatabaseHandler;
import com.example.mymobileapplication.helper.SessionManager;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();

    private static String KEY_UID = "uid";
    private static String KEY_NAME = "name";
    private static String KEY_EMAIL = "email";
    private static String KEY_CREATED_AT = "created_at";

    private Button btnLogin, btnLinkToRegister, btnForgotPass;
    private EditText inputEmail, inputPassword;
    private ImageView fb,google;
    private CheckBox checkBox;
    private SessionManager session;
    private DatabaseHandler db;
    private ProgressDialog pDialog;
    UserLocalStore userLocalStore;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userLocalStore = new UserLocalStore(this);
        inputEmail = findViewById(R.id.edit_email);
        inputPassword = findViewById(R.id.edit_password);
        btnLogin = findViewById(R.id.button_login);
        checkBox = findViewById(R.id.checkBox);
        fb = findViewById(R.id.fb);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,FacebookLoginActivity.class);
                startActivity(intent);
            }
        });
        google = findViewById(R.id.google);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,GoogleLoginActivity.class);
                startActivity(intent);
            }
        });
        btnLinkToRegister = findViewById(R.id.button_next_login);
        btnLinkToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,DKActivity.class);
                startActivity(intent);
            }
        });
        btnForgotPass = findViewById(R.id.button_reset);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Đang đăng nhập...");
        pDialog.setCanceledOnTouchOutside(false);
        Dangnhap();
        checker();
    }
    public void Dangnhap(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                    if(checkEditText(inputPassword)
                            && checkEditText(inputEmail)&& isValidEmail(username)){
                        pDialog.show();
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.signin, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("id",response);
                                String message = "";
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    if (jsonObject.getInt("success") == 1){
                                        Account account = new Account();
                                        account.setUserName(jsonObject.getString("user_name"));
                                        account.setEmail(jsonObject.getString("email"));
                                        message = jsonObject.getString("message");
                                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();

                                        //Save
                                        Uxer user = new Uxer(jsonObject.getString("email"),
                                                jsonObject.getString("user_name"),
                                                jsonObject.getString("password"));

                                        userLocalStore.storeUserData(user);
                                        userLocalStore.setUserLoggedIn(true);
                                        //End
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        intent.putExtra("login", account);
                                        startActivity(intent);
                                    } else {
                                        message = jsonObject.getString("message");
                                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                                    }
                                }catch (JSONException e){
                                    e.printStackTrace();
                                }
                               pDialog.dismiss();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(),error.toString().trim(),Toast.LENGTH_LONG).show();

                            }
                        }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String,String> data =new HashMap<>();
                                data.put("email",username );
                                data.put("password",password);
                                return data;

                            }
                        };
                        RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
                        requestQueue.add(stringRequest);
                    }
                }
        });

    }
    /**
     * Check Input
     */
    private boolean checkEditText(EditText editText) {
        if (editText.getText().toString().trim().length() > 0)
            return true;
        else {
            editText.setError("Vui lòng nhập dữ liệu!");
        }
        return false;
    }

    /**
     * Check Email
     */
    private boolean isValidEmail(String target) {
        if (target.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+"))
            return true;
        else {
            inputEmail.setError("Email sai định dạng!");
        }
        return false;
    }


    //Rember User
    public void checker(){
        SharedPreferences preferences = getSharedPreferences("checkBook", MODE_PRIVATE);
        String checkbox = preferences.getString("remember", "false");
        if (checkbox.equals("true")) {
            Toast.makeText(getApplicationContext(),"Checked Succes",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }else if (checkbox.equals("false")){
            Toast.makeText(getApplicationContext(),"Checked Failed",Toast.LENGTH_LONG).show();
        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkBook", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_LONG).show();
                }else {
                    SharedPreferences preferences = getSharedPreferences("checkBook", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                    Toast.makeText(getApplicationContext(),"UnChecked",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}