package com.jc.bike.model;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Integer id;

    private Integer status;

    private Integer userid;

    private String name;

    private String tel;

    private BigDecimal totalrent;

    private BigDecimal totaldeposit;

    private Date gettime;

    private Date puttime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public BigDecimal getTotalrent() {
        return totalrent;
    }

    public void setTotalrent(BigDecimal totalrent) {
        this.totalrent = totalrent;
    }

    public BigDecimal getTotaldeposit() {
        return totaldeposit;
    }

    public void setTotaldeposit(BigDecimal totaldeposit) {
        this.totaldeposit = totaldeposit;
    }

    public Date getGettime() {
        return gettime;
    }

    public void setGettime(Date gettime) {
        this.gettime = gettime;
    }

    public Date getPuttime() {
        return puttime;
    }

    public void setPuttime(Date puttime) {
        this.puttime = puttime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}