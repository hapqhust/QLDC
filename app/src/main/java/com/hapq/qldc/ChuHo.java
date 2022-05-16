package com.hapq.qldc;

import java.io.Serializable;

public class ChuHo implements Serializable {
    private String namePerson;
    private String idHo;
    private String phone;

    public ChuHo(String namePerson, String idHoGD, String phone) {
        this.namePerson = namePerson;
        this.idHo = idHoGD;
        this.phone = phone;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getIdHoGD() {
        return idHo;
    }

    public void setIdHoGD(String idHoGD) {
        this.idHo = idHoGD;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
