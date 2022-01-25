package com.example.mymobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.mymobileapplication.connect.Checkconnect;
import com.example.mymobileapplication.connect.Server;
import com.example.mymobileapplication.data.Giohang;
import com.example.mymobileapplication.data.SanPham;
import com.example.mymobileapplication.data.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThongTinKhachhang extends AppCompatActivity {
    TextView txttongtien,userids;
    EditText edtenkhachhang,edemail,edsodienthoai,eddiachi,edloinhan;
    Button bntxacnhan,bnttrove;
    public static ArrayList<Giohang> manggiohang;
    public  static List<Giohang> alaba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_khachhang);

        Anhxa();
        EvenUtil();
        bnttrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if(Checkconnect.haveNetworkConnection(getApplicationContext())){
            EventButton();
        }else {
            Checkconnect.ShowToast_Short(getApplicationContext(),"Please check your connection again");
        }
    }

    public void EvenUtil() {
        long tongtien = 0;
        for(int i = 0;i<MainActivity.manggiohang.size();i++){

            tongtien+=MainActivity.manggiohang.get(i).getGiasp();
        }


        DecimalFormat decimalFormat = new DecimalFormat("000.00");
         txttongtien.setText(decimalFormat.format(tongtien));
    }
    private void EventButton() {
        bntxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String ten = edtenkhachhang.getText().toString().trim();
                final  String sdt = edsodienthoai.getText().toString().trim();
                final String diachi = eddiachi.getText().toString().trim();
                final String loinhan = edloinhan.getText().toString().trim();
                final String email = edemail.getText().toString().trim();
                final String tongtienx = txttongtien.getText().toString().trim();
                if(ten.length() > 0 && sdt.length() > 0 && email.length() >0 && diachi.length() >0 && loinhan.length() >0){
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest request = new StringRequest(Request.Method.POST, Server.Duongdandonhang, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String madonhang) {
                         Log.d("id",madonhang);
                         if (Integer.parseInt(madonhang)>0){
                             RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                             StringRequest stringRequest = new StringRequest(Request.Method.POST, Server.Duongdanchitietdhonhang, new Response.Listener<String>() {
                                 @Override
                                 public void onResponse(String response) {
                                     MainActivity.manggiohang.clear();
                                     Checkconnect.ShowToast_Short(getApplicationContext(),
                                             "You have successfully added");
                                     Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                     Checkconnect.ShowToast_Short(getApplicationContext(),
                                             "Please continue to shop");
                                     startActivity(intent);
                                 }
                             }, new Response.ErrorListener() {
                                 @Override
                                 public void onErrorResponse(VolleyError error) {

                                 }
                             })
                                 //oder
                             {
                                 @Override
                                 protected Map<String, String> getParams() throws AuthFailureError {
                                     JSONArray jsonArray = new JSONArray();
                                     for(int i = 0; i<MainActivity.manggiohang.size();i++){
                                         JSONObject jsonObject = new JSONObject();
                                         try {
                                             jsonObject.put("transaction_id",madonhang);
                                             jsonObject.put("product_id",MainActivity.manggiohang.get(i).getIdsp());
                                             jsonObject.put("amount",MainActivity.manggiohang.get(i).getGiasp());
                                             jsonObject.put("qty",MainActivity.manggiohang.get(i).getSoluongsp());
                                             jsonObject.put("sizes",MainActivity.manggiohang.get(i).getSize());
                                         } catch (JSONException e) {
                                             e.printStackTrace();
                                         }
                                         jsonArray.put(jsonObject);
                                     }
                                     HashMap<String,String> hash = new HashMap<>();
                                     hash.put("json", jsonArray.toString());
                                     return hash;
                                 }
                             };
                             requestQueue.add(stringRequest);
                         }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            HashMap<String,String> hashMap = new HashMap<String,String>();
                            hashMap.put("user_name",ten);
                            hashMap.put("user_phone", sdt);
                            hashMap.put("user_address", diachi);
                            hashMap.put("message", loinhan);
                            hashMap.put("user_email",email);
                            hashMap.put("amount", tongtienx);
                            return hashMap;
                        }
                    };
                    queue.add(request);
                }else{
                    Checkconnect.ShowToast_Short(getApplicationContext(),
                            "Data has error");
                }
            }
        });
    }

    private void Anhxa() {
        edtenkhachhang = findViewById(R.id.edtenkhachhang);
        edemail = findViewById(R.id.edemailkhachhang);
        edsodienthoai = findViewById(R.id.edsdtkhachhang);
        eddiachi = findViewById(R.id.eddiachi);
        edloinhan = findViewById(R.id.edloinhan);
        bntxacnhan = (Button)findViewById(R.id.bntxacnhan);
        bnttrove = (Button)findViewById(R.id.bnttrove);
        txttongtien = findViewById(R.id.tvtong);

    }
}