package com.wzl.books.entity;

public class Param {

    private String id;
    private String name;
    private Integer num;

    @Override
    public String toString() {
        return "Param{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Param() {
    }

    public Param(String id, String name, Integer num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }
}
