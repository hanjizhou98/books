package com.wzl.books.entity;

import java.sql.Date;

public class Book {
    private String id;
    private String name;
    private String author;
    private Date publishTime;
    private Date registerTime;
    private Integer num;
    private String type;

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishTime=" + publishTime +
                ", registerTime=" + registerTime +
                ", num=" + num +
                ", type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Book(String id, String name, String author, Date publishTime, Date registerTime, Integer num, String type) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishTime = publishTime;
        this.registerTime = registerTime;
        this.num = num;
        this.type = type;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Book() {
    }

    public Book(String id, String name, String author, Date publishTime, Date registerTime, Integer num) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishTime = publishTime;
        this.registerTime = registerTime;
        this.num = num;
    }
}
