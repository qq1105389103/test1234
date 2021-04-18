package com.example.practice;

public class City {
    private int provinceid;
    private String name;
    private int id;

    @Override
    public String toString() {
        return "City{" +
                "provinceid=" + provinceid +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public int getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(int provinceid) {
        this.provinceid = provinceid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City() {
    }

    public City(int provinceid, String name, int id) {
        this.provinceid = provinceid;
        this.name = name;
        this.id = id;
    }


}
