package com.neuedu.entity;

import org.springframework.stereotype.Component;

@Component
public class Papermapping {
    private Integer userpaperid;

    private Integer paperid;

    private Integer examinee;

    private Integer type;

    private String c1;

    private Integer c2;

    public Integer getUserpaperid() {
        return userpaperid;
    }

    public void setUserpaperid(Integer userpaperid) {
        this.userpaperid = userpaperid;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public Integer getExaminee() {
        return examinee;
    }

    public void setExaminee(Integer examinee) {
        this.examinee = examinee;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1 == null ? null : c1.trim();
    }

    public Integer getC2() {
        return c2;
    }

    public void setC2(Integer c2) {
        this.c2 = c2;
    }
}