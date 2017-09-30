package com.lordprimustl.primaltutors.Models;

import com.orm.SugarRecord;

/**
 * Created by LordPrimusTL on 9/20/2017.
 */

public class question extends SugarRecord {
    private String Qid;
    private String question;

    public question(String question, String optionA, String optionB, String optionC, String optionD, String answer, String class_id, String subject_id, String topic_id) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
        this.class_id = class_id;
        this.subject_id = subject_id;
        this.topic_id = topic_id;
    }

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String answer;
    private String class_id;
    private String subject_id;
    private String topic_id;


    public String getQid() {
        return Qid;
    }

    public void setQid(String qid) {
        Qid = qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public question()
    {

    }

    @Override
    public String toString() {
        return "question{" +
                "Qid='" + Qid + '\'' +
                ", question='" + question + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", answer='" + answer + '\'' +
                ", class_id='" + class_id + '\'' +
                ", subject_id='" + subject_id + '\'' +
                ", topic_id='" + topic_id + '\'' +
                '}';
    }
}
