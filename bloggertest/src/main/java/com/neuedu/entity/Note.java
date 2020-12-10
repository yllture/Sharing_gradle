package com.neuedu.entity;

import java.util.Date;

public class Note {
    private Integer noteid;

    private Integer activeuserid;
    private User activeuser;
    
    private Integer passiveuserid;

    private Date notetime;
 
    private Integer paperid;

    private Integer type;

    private Integer c1;

    private Integer c2;

    private String c3;

    private String c4;

    public Integer getNoteid() {
        return noteid;
    }

    public void setNoteid(Integer noteid) {
        this.noteid = noteid;
    }

    public Integer getActiveuserid() {
        return activeuserid;
    }

    public void setActiveuserid(Integer activeuserid) {
        this.activeuserid = activeuserid;
    }

    public Integer getPassiveuserid() {
        return passiveuserid;
    }

    public void setPassiveuserid(Integer passiveuserid) {
        this.passiveuserid = passiveuserid;
    }

    public Date getNotetime() {
        return notetime;
    }

    public void setNotetime(Date notetime) {
        this.notetime = notetime;
    }

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getC1() {
        return c1;
    }

    public void setC1(Integer c1) {
        this.c1 = c1;
    }

    public Integer getC2() {
        return c2;
    }

    public void setC2(Integer c2) {
        this.c2 = c2;
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3 == null ? null : c3.trim();
    }

    public String getC4() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4 = c4 == null ? null : c4.trim();
    }

	public User getActiveuser() {
		return activeuser;
	}

	public void setActiveuser(User activeuser) {
		this.activeuser = activeuser;
	}

}