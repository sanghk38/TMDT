package com.example.mymobileapplication.connect;

public class APISERVISE {
    //Truyền địa chỉ url
    public static final String base_url = "http://192.168.1.6/mobilephp/";

    public static ApiInterface getServise(){
        //khởi tạo
        return APIClient.getClient(base_url).create(ApiInterface.class);
    }
}
