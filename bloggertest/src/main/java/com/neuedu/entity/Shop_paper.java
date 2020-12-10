package com.neuedu.entity;

import java.util.Date;

public class Shop_paper {
    private Integer paperid;

    private String papername;

    private String paperlabel;

    private Integer questionnum;

    private Integer signlenum;

    private Integer judgenum;

    private Integer multiplenum;

    private Integer fillnum;

    private Integer shortanswernum;

    private Integer questionscore;

    private Integer signlescore;

    private Integer judgescore;

    private Integer multiplescore;

    private Integer fillscore;

    private Integer shortanswerscore;

    private Integer winder;
    private User user;


    private Integer price;

    private Date time;

    private Integer paynum;

    private Integer avgevaluate;

    private String c1;

    private String c2;

    private Integer checkflag;

    private Integer c4;

    public Integer getPaperid() {
        return paperid;
    }

    public void setPaperid(Integer paperid) {
        this.paperid = paperid;
    }

    public String getPapername() {
        return papername;
    }

    public void setPapername(String papername) {
        this.papername = papername == null ? null : papername.trim();
    }

    public String getPaperlabel() {
        return paperlabel;
    }

    public void setPaperlabel(String paperlabel) {
        this.paperlabel = paperlabel == null ? null : paperlabel.trim();
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

    public Integer getFillnum() {
        return fillnum;
    }

    public void setFillnum(Integer fillnum) {
        this.fillnum = fillnum;
    }

    public Integer getShortanswernum() {
        return shortanswernum;
    }

    public void setShortanswernum(Integer shortanswernum) {
        this.shortanswernum = shortanswernum;
    }

    public Integer getQuestionscore() {
        return questionscore;
    }

    public void setQuestionscore(Integer questionscore) {
        this.questionscore = questionscore;
    }

    public Integer getSignlescore() {
        return signlescore;
    }

    public void setSignlescore(Integer signlescore) {
        this.signlescore = signlescore;
    }

    public Integer getJudgescore() {
        return judgescore;
    }

    public void setJudgescore(Integer judgescore) {
        this.judgescore = judgescore;
    }

    public Integer getMultiplescore() {
        return multiplescore;
    }

    public void setMultiplescore(Integer multiplescore) {
        this.multiplescore = multiplescore;
    }

    public Integer getFillscore() {
        return fillscore;
    }

    public void setFillscore(Integer fillscore) {
        this.fillscore = fillscore;
    }

    public Integer getShortanswerscore() {
        return shortanswerscore;
    }

    public void setShortanswerscore(Integer shortanswerscore) {
        this.shortanswerscore = shortanswerscore;
    }

    public Integer getWinder() {
        return winder;
    }

    public void setWinder(Integer winder) {
        this.winder = winder;
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

    public Integer getCheckflag() {
        return checkflag;
    }

    public void setCheckflag(Integer checkflag) {
        this.checkflag = checkflag;
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