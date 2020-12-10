package com.neuedu.entity;

public class Bank_judge {
    private Integer qId;

    private String qTitle;

    private Integer bankid;

    private Integer isture;

    private String qKnowledge;

    private String qAnalysis;

    private Integer qDifficulty;

    private String c1;

    private Integer c2;

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }

    public String getqTitle() {
        return qTitle;
    }

    public void setqTitle(String qTitle) {
        this.qTitle = qTitle == null ? null : qTitle.trim();
    }

    public Integer getBankid() {
        return bankid;
    }

    public void setBankid(Integer bankid) {
        this.bankid = bankid;
    }

    public Integer getIsture() {
        return isture;
    }

    public void setIsture(Integer isture) {
        this.isture = isture;
    }

    public String getqKnowledge() {
        return qKnowledge;
    }

    public void setqKnowledge(String qKnowledge) {
        this.qKnowledge = qKnowledge == null ? null : qKnowledge.trim();
    }

    public String getqAnalysis() {
        return qAnalysis;
    }

    public void setqAnalysis(String qAnalysis) {
        this.qAnalysis = qAnalysis == null ? null : qAnalysis.trim();
    }

    public Integer getqDifficulty() {
        return qDifficulty;
    }

    public void setqDifficulty(Integer qDifficulty) {
        this.qDifficulty = qDifficulty;
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