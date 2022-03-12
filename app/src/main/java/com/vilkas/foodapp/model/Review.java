package com.vilkas.foodapp.model;

import java.time.LocalDate;

public class Review {

    private short value;
    private String comment;
    private LocalDate date;
    private RegisteredUser user;

    private String data;


    public Review(short value, String comment, String data, RegisteredUser user) {
        this.value = value;
        this.comment = comment;
        this.user = user;
        this.data = data;
    }

    public Review(short value, String comment, LocalDate date, RegisteredUser user) {
        this.value = value;
        this.comment = comment;
        this.date = date;
        this.user  = user;
    }

    public Review() {
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }

    public short getValue() {
        return value;
    }

    public void setValue(short value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
