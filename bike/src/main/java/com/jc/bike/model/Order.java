package com.jc.bike.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Order {
    private Integer id;

    private String orderno;

    private Integer status;

    private Integer userid;

    private Integer shopcartid;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createtime;

    private Integer count;

    private ShopCart shopcart;

    public ShopCart getShopCart() {
        return shopcart;
    }

    public void setShopCart(ShopCart shopcart) {
        this.shopcart = shopcart;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getShopcartid() {
        return shopcartid;
    }

    public void setShopcartid(Integer shopcartid) {
        this.shopcartid = shopcartid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}