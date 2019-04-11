package com.hyc.onlineBookManagement.bean;

import java.sql.Date;

public class Borrow {
    private String uuid;
    private String status;
    private String user_uuid;
    private String book_uuid;
    private Date borrow_date;
    private Date back_date;
    private String borrow_day;
    private String overdue;
    private User user;
    private Book book;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser_uuid() {
        return user_uuid;
    }

    public void setUser_uuid(String user_uuid) {
        this.user_uuid = user_uuid;
    }

    public String getBook_uuid() {
        return book_uuid;
    }

    public void setBook_uuid(String book_uuid) {
        this.book_uuid = book_uuid;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Date getBack_date() {
        return back_date;
    }

    public void setBack_date(Date back_date) {
        this.back_date = back_date;
    }

    public String getBorrow_day() {
        return borrow_day;
    }

    public void setBorrow_day(String borrow_day) {
        this.borrow_day = borrow_day;
    }

    public String getOverdue() {
        return overdue;
    }

    public void setOverdue(String overdue) {
        this.overdue = overdue;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
