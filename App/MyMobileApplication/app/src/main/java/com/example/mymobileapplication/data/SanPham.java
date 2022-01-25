package com.example.mymobileapplication.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SanPham implements Serializable {
    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("tensanpham")
    @Expose
    public String Tensanpham;
    @SerializedName("giasanpham")
    @Expose
    public long Giasanpham;
    @SerializedName("hinhanhsanpham")
    @Expose
    public String Hinhanhsanpham;
    @SerializedName("motasanpham")
    @Expose
    public  String Motasanpham;
    @SerializedName("idsanpham")
    @Expose
    public int idSanpham;
    @SerializedName("yeuthich")
    @Expose
    private int yeuthich;
    private Boolean isShortlisted = false;
    public SanPham(int id, String tensanpham, long giasanpham, String hinhanhsanpham, String motasanpham, int idSanpham,int yeuthich) {
        this.id = id;
        Tensanpham = tensanpham;
        Giasanpham = giasanpham;
        Hinhanhsanpham = hinhanhsanpham;
        Motasanpham = motasanpham;
        this.idSanpham = idSanpham;
        this.yeuthich = yeuthich;
    }

    public SanPham() {

    }


    public int getYeuthich() {
        return yeuthich;
    }

    public void setYeuthich(int yeuthich) {
        this.yeuthich = yeuthich;
    }

    public Boolean getShortlisted() {
        return isShortlisted;
    }

    public void setShortlisted(Boolean shortlisted) {
        isShortlisted = shortlisted;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getTensanpham() {
        return Tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        Tensanpham = tensanpham;
    }

    public long getGiasanpham() {
        return Giasanpham;
    }

    public void setGiasanpham(long giasanpham) {
        Giasanpham = giasanpham;
    }

    public String getHinhanhsanpham() {
        return Hinhanhsanpham;
    }

    public void setHinhanhsanpham(String hinhanhsanpham) {
        Hinhanhsanpham = hinhanhsanpham;
    }

    public String getMotasanpham() {
        return Motasanpham;
    }

    public void setMotasanpham(String motasanpham) {
        Motasanpham = motasanpham;
    }

    public int getIDSanpham() {
        return idSanpham;
    }

    public void setIDSanpham(int idSanpham) {
        this.idSanpham = idSanpham;
    }
}
