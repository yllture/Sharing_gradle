package com.neuedu.entity;

import java.util.Date;

public class Shop_bank {
    private Integer bankid;

    private String bankname;

    private String bankdescription;

    private String banklabel;

    private Integer userid;
    private User user;
    
    private Integer questionnum;

    private Integer signlenum;

    private Integer judgenum;

    private Integer multiplenum;

    private Integer shortanswernum;

    private Integer fillnum;

    private Integer price;

    private Date time;

    private Integer paynum;

    private Integer avgevaluate;

    private Integer checkflag;

    private String c1;

    private String c2;

    private Integer c3;

    private Integer c4;

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }

    public String getBankdescription() {
        return bankdescription;
    }

    public void setBankdescription(String bankdescription) {
        this.bankdescription = bankdescription == null ? null : bankdescription.trim();
    }

    public String getBanklabel() {
        return banklabel;
    }

    public void setBanklabel(String banklabel) {
        this.banklabel = banklabel == null ? null : banklabel.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getQuestionnum() {
        return questionnum;
    }

    public void setQuestionnum(Integer questionnum) {
        this.questionnum = questionnum;
    }

    public Integer getSignlenum() {
        return signlenum;
    }

    public void setSignlenum(Integer signlenum) {
        this.signlenum = signlenum;
    }

    public Integer getJudgenum() {
        return judgenum;
    }

    public void setJudgenum(Integer judgenum) {
        this.judgenum = judgenum;
    }

    public Integer getMultiplenum() {
        return multiplenum;
    }

    public void setMultiplenum(Integer multiplenum) {
        this.multiplenum = multiplenum;
    }

    public Integer getShortanswernum() {
        return shortanswernum;
    }

    public void setShortanswernum(Integer shortanswernum) {
        this.shortanswernum = shortanswernum;
    }

    public Integer getFillnum() {
        return fillnum;
    }

    public void setFillnum(Integer fillnum) {
        this.fillnum = fillnum;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getPaynum() {
        return paynum;
    }

    public void setPaynum(Integer paynum) {
        this.paynum = paynum;
    }

    public Integer getAvgevaluate() {
        return avgevaluate;
    }

    public void setAvgevaluate(Integer avgevaluate) {
        this.avgevaluate = avgevaluate;
    }

    public Integer getCheckflag() {
        return checkflag;
    }

    public void setCheckflag(Integer checkflag) {
        this.checkflag = checkflag;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}