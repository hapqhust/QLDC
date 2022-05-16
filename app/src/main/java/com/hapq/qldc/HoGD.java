package com.hapq.qldc;

import java.io.Serializable;

public class HoGD implements Serializable {
    private String diaChi;
    private String idHoGD;
    private String idChuHo;

    public HoGD(String diaChi, String idHoGD, String idChuHo) {
        this.diaChi = diaChi;
        this.idHoGD = idHoGD;
        this.idChuHo = idChuHo;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getIdHoGD() {
        return idHoGD;
    }

    public void setIdHoGD(String idHoGD) {
        this.idHoGD = idHoGD;
    }

    public String getIdChuHo() {
        return idChuHo;
    }

    public void setIdChuHo(String idChuHo) {
        this.idChuHo = idChuHo;
    }

}
