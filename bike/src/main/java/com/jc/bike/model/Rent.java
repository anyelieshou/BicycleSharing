package com.jc.bike.model;

import java.util.List;

public class Rent {
    private Integer id;

    private String rentname;

    private String address;

    private Integer tel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRentname() {
        return rentname;
    }

    public void setRentname(String rentname) {
        this.rentname = rentname == null ? null : rentname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }
}