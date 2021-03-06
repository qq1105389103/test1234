package com.example.practice;

public class Province {
    private int id;
    private String name;
    private String jiancheng;
    private String shenghui;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJiancheng() {
        return jiancheng;
    }

    public void setJiancheng(String jiancheng) {
        this.jiancheng = jiancheng;
    }

    public String getShenghui() {
        return shenghui;
    }

    public void setShenghui(String shenghui) {
        this.shenghui = shenghui;
    }

    public Province() {
    }

    public Province(int id, String name, String jiancheng, String shenghui) {
        this.id = id;
        this.name = name;
        this.jiancheng = jiancheng;
        this.shenghui = shenghui;
    }


}
