package com.lordprimustl.primaltutors.Models;

import com.orm.SugarRecord;

/**
 * Created by LordPrimusTL on 9/22/2017.
 */

public class topic extends SugarRecord {
    public topic()
    {

    }
    private String class_id;
    private String topic_id;
    private String subject_id;
    private String name;


    public topic(String class_id, String subject_id, String topic_id, String name) {
        this.class_id = class_id;
        this.topic_id = topic_id;
        this.subject_id = subject_id;
        this.name = name;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "topic{" +
                "class_id='" + class_id + '\'' +
                ", topic_id='" + topic_id + '\'' +
                ", subject_id='" + subject_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
