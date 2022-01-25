package com.example.mymobileapplication.data;

public class Favorite {
    public int ID;
    public String Tensanpham;
    public Integer Giasanpham;
    public String Hinhanhsanpham;
    public  int soluongsp;
    public Favorite(int ID, String tensanpham, Integer giasanpham, String hinhanhsanpham,int soluongsp) {
        this.ID = ID;
        this.Tensanpham = tensanpham;
        this.Giasanpham = giasanpham;
        this.Hinhanhsanpham = hinhanhsanpham;
        this.soluongsp = soluongsp;
    }

    public int getSoluongsp() {
        return soluongsp;
    }

    public void setSoluongsp(int soluongsp) {
        this.soluongsp = soluongsp;
    }

    public Favorite() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTensanpham() {
        return Tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        Tensanpham = tensanpham;
    }

    public Integer getGiasanpham() {
        return Giasanpham;
    }

    public void setGiasanpham(Integer giasanpham) {
        Giasanpham = giasanpham;
    }

    public String getHinhanhsanpham() {
        return Hinhanhsanpham;
    }

    public void setHinhanhsanpham(String hinhanhsanpham) {
        Hinhanhsanpham = hinhanhsanpham;
    }
}
