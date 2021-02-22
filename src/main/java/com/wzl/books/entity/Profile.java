package com.wzl.books.entity;

import java.sql.Date;

public class Profile {

//    id
//            NAME
//    author
//            publishTime
//    registerTime
//            num
//    TYPE
//            borrowTime
//    returnTime
//            isValid
    private String id;
    private String name;
    private String author;
    private Date publishTime;
    private Date registerTime;
    private Integer num;
    private String type;
    private Date borrowTime;
    private Date returnTime;
    private Integer isValid;

    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishTime=" + publishTime +
                ", registerTime=" + registerTime +
                ", num=" + num +
                ", type='" + type + '\'' +
                ", borrowTime=" + borrowTime +
                ", returnTime=" + returnTime +
                ", isValid=" + isValid +
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Profile() {
    }

    public Profile(String id, String name, String author, Date publishTime, Date registerTime, Integer num, String type, Date borrowTime, Date returnTime, Integer isValid) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publishTime = publishTime;
        this.registerTime = registerTime;
        this.num = num;
        this.type = type;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
        this.isValid = isValid;
    }
}
