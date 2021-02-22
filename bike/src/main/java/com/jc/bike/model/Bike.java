package com.jc.bike.model;

import java.math.BigDecimal;

public class Bike {
    private Integer id;

    private Integer bno;

    private String bname;

    private String bface;

    private Integer bcount;

    private BigDecimal bprice;

    private String desc;

    private Rent rent;

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

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

    public String getBface() {
        return bface;
    }

    public void setBface(String bface) {
        this.bface = bface == null ? null : bface.trim();
    }

    public Integer getBcount() {
        return bcount;
    }

    public void setBcount(Integer bcount) {
        this.bcount = bcount;
    }

    public BigDecimal getBprice() {
        return bprice;
    }

    public void setBprice(BigDecimal bprice) {
        this.bprice = bprice;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }
}