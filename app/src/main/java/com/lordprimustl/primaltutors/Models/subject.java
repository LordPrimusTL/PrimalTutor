package com.lordprimustl.primaltutors.Models;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by LordPrimusTL on 9/20/2017.
 */

public class subject extends SugarRecord {
    public subject()
    {

    }

    private String sub_id;
    private String name;

    public subject(String sub_id, String name) {
        this.sub_id = sub_id;
        this.name = name;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public long save() {
        return super.save();
    }

    @Override
    public String toString() {
        return "subject{" +
                "sub_id='" + sub_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
