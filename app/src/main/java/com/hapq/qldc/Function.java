package com.hapq.qldc;

public class Function {
    private int hinh;
    private String chucNang;
    private String mota;

    public Function(int hinh, String chucNang, String mota) {
        this.hinh = hinh;
        this.chucNang = chucNang;
        this.mota = mota;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getChucNang() {
        return chucNang;
    }

    public void setChucNang(String chucNang) {
        this.chucNang = chucNang;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
