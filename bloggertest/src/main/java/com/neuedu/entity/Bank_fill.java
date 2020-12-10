package com.neuedu.entity;

import java.util.List;

public class Bank_fill {
    private Integer qId;

    private String qTitle;

    private Integer bankid;

    private String qKnowledge;

    private String qAnalysis;

    private Integer qDifficulty;

    private String c1;

    private String c2;
    
    private List<Bank_fillchoice>  filllsit;

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

    public String getC2() {
        return c2;
    }

    public void setC2(String c2) {
        this.c2 = c2 == null ? null : c2.trim();
    }

	public List<Bank_fillchoice> getFilllsit() {
		return filllsit;
	}

	public void setFilllsit(List<Bank_fillchoice> filllsit) {
		this.filllsit = filllsit;
	}
}