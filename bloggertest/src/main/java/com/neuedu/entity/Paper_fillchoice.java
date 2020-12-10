package com.neuedu.entity;

public class Paper_fillchoice {
    private Integer choiceid;

    private String content;

    private Integer qId;

    private Integer sequence;

    private String answer;

    private String c1;

    private String c2;

    private Integer c3;



	public Integer getChoiceid() {
        return choiceid;
    }

    public void setChoiceid(Integer choiceid) {
        this.choiceid = choiceid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getqId() {
        return qId;
    }

    public void setqId(Integer qId) {
        this.qId = qId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
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
    
    @Override
	public String toString() {
		return "Paper_fillchoice [choiceid=" + choiceid + ", content=" + content + ", qId=" + qId + ", sequence="
				+ sequence + ", answer=" + answer + ", c1=" + c1 + ", c2=" + c2 + ", c3=" + c3 + "]";
	}
}