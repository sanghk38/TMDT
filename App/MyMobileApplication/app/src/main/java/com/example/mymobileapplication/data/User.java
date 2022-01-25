package com.example.mymobileapplication.data;

import com.example.mymobileapplication.OderUserActivity;

public class User {
    public int ID;
    public String TenKh;
    public String Email;
    public  String Password;
    public String Phone;
    public  String diachi;

    public User(int ID, String tenKh, String email, String password, String phone, String diachi) {
        this.ID = ID;
        TenKh = tenKh;
        Email = email;
        Password = password;
        Phone = phone;
        this.diachi = diachi;
    }

    public User(String email, String user_name, String password, String phone, String address) {
    }

    public User(String email, String username, String password) {
    }

    public User() {
    }




    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTenKh() {
        return TenKh;
    }

    public void setTenKh(String tenKh) {
        TenKh = tenKh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
