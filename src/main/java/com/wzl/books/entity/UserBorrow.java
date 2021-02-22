package com.wzl.books.entity;

import java.sql.Date;

public class UserBorrow {
    private String id;
    private String uid;
    private String bid;
    private Integer isValid;
    private Date borrowTime;
    private Date returnTime;

    @Override
    public String toString() {
        return "UserBorrow{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", bid='" + bid + '\'' +
                ", isValid=" + isValid +
                ", borrowTime=" + borrowTime +
                ", returnTime=" + returnTime +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
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

    public UserBorrow() {
    }

    public UserBorrow(String id, String uid, String bid, Integer isValid, Date borrowTime, Date returnTime) {
        this.id = id;
        this.uid = uid;
        this.bid = bid;
        this.isValid = isValid;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
    }
}
