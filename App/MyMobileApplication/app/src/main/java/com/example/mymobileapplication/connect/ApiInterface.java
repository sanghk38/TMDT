package com.example.mymobileapplication.connect;

import com.example.mymobileapplication.data.SanPham;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    // getdataproductlike
    @GET("yeuthich.php")
    Call<List<SanPham>> GetDataProductLike();
    @FormUrlEncoded
    @POST("updatelike.php")
    Call<String> updatelike(@Field("view") String luotthich, @Field("id") String idsanphamyeuthich);
}
