package com.vilkas.foodapp.model;

import java.time.LocalDate;

public class Review {

    private short value;
    private String comment;
    private LocalDate date;


    public Review(short value, String comment, LocalDate date) {
        this.value = value;
        this.comment = comment;
        this.date = date;
    }

    public Review() {
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
