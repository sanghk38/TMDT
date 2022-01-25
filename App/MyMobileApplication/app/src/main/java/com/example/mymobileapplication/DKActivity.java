package com.example.mymobileapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mymobileapplication.adapter.UserLocalStore;
import com.example.mymobileapplication.connect.Server;
import com.example.mymobileapplication.data.Account;
import com.example.mymobileapplication.data.User;
import com.example.mymobileapplication.data.Uxer;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DKActivity extends AppCompatActivity {
    private EditText inputName, inputEmail, inputPassword,inputPhone,inputAdress;
    Button btnRegister,btnLinkToLogin;
    private ProgressDialog pDialog;
    Account account;
    UserLocalStore userLocalStore;
    public static final String TAG = DKActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dkactivity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initItem();
        Dk();
    }
    public void initItem(){
        inputName = findViewById(R.id.edit_name1);
        inputEmail = findViewById(R.id.edit_email1);
        inputPassword = findViewById(R.id.edit_password1);
        inputPhone = findViewById(R.id.edit_phone1);
        inputAdress = findViewById(R.id.edit_diachi1);
        account = new Account();
        userLocalStore = new UserLocalStore(this);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Đang đăng ký...");
        pDialog.setCanceledOnTouchOutside(false);
        btnRegister = findViewById(R.id.button_register);
        btnLinkToLogin = findViewById(R.id.button_next_login);
        btnLinkToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DKActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    public void Dk(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ten = inputName.getText().toString().trim();
                final  String email = inputEmail.getText().toString().trim();
                final String mk = inputPassword.getText().toString().trim();
                final String phone = inputPhone.getText().toString().trim();
                final String diachi = inputAdress.getText().toString().trim();
                if(checkEditText(inputName) && checkEditText(inputPassword)&&checkEditText(inputPhone) &&checkEditText(inputAdress)
                        && checkEditText(inputEmail) && isValidEmail(email)){
                    pDialog.show();
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.signup, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("id",response);
                            if (response!=null) {
                                account.setUserName(ten);
                                account.setEmail(email);
                                account.setPassword(mk);
                                account.setPhone(phone);
                                account.setAddress(diachi);
                                //Save
                                User users = new User(ten,email,mk,phone,diachi);
                                userLocalStore.Data(users);
                                Toast.makeText(DKActivity.this,"Đăng kí thành công",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(DKActivity.this,LoginActivity.class);
                                startActivity(intent);
                            } else if (response.equals("failure")) {
                                Toast.makeText(DKActivity.this,"Không được để trống",Toast.LENGTH_LONG).show();
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
                            data.put("name",ten);
                            data.put("email",email);
                            data.put("password", mk);
                            data.put("phone", phone);
                            data.put("address", diachi);
                            return data;

                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
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
}