package com.jc.bike.model;

import java.math.BigDecimal;

public class ShopCart {
    private Integer id;

    private Integer bno;

    private String bname;

    private String rentpoint;

    private BigDecimal bprice;

    private Integer count;

    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public String getRentpoint() {
        return rentpoint;
    }

    public void setRentpoint(String rentpoint) {
        this.rentpoint = rentpoint == null ? null : rentpoint.trim();
    }

    public BigDecimal getBprice() {
        return bprice;
    }

    public void setBprice(BigDecimal bprice) {
        this.bprice = bprice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}