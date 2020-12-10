package com.neuedu.entity;

import java.util.List;

public class Garbage_bankfolder {
    private Integer folderid;

    private String foldername;

    private Integer userid;

    private Integer banknum;

    private Integer foldermapping;

    private String c1;

    private String c2;

    private Integer c3;

    private Integer c4;

    private List<Bank> banklist;
    
    public Integer getFolderid() {
        return folderid;
    }

    public void setFolderid(Integer folderid) {
        this.folderid = folderid;
    }

    public String getFoldername() {
        return foldername;
    }

    public void setFoldername(String foldername) {
        this.foldername = foldername == null ? null : foldername.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBanknum() {
        return banknum;
    }

    public void setBanknum(Integer banknum) {
        this.banknum = banknum;
    }

    public Integer getFoldermapping() {
        return foldermapping;
    }

    public void setFoldermapping(Integer foldermapping) {
        this.foldermapping = foldermapping;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1 == null ? null : c1.trim();
    }

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2 == null ? null : c2.trim();
    }

    public Integer getC3() {
        return c3;
    }

    public void setC3(Integer c3) {
        this.c3 = c3;
    }

    public Integer getC4() {
        return c4;
    }

    public void setC4(Integer c4) {
        this.c4 = c4;
    }

	public List<Bank> getBanklist() {
		return banklist;
	}

	public void setBanklist(List<Bank> banklist) {
		this.banklist = banklist;
	}
}