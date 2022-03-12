package com.vilkas.foodapp.model;

import java.time.LocalDate;

public class RegisteredUser {

    private String name;
    private String lastName;
    private String email;
    private String pass;
    private LocalDate registeredDate;
    private String desc;
    private String country;

    public RegisteredUser() {

    }

    public RegisteredUser(String name, String lastName, String email, String pass) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
    }

    public RegisteredUser(String name, String lastName, String email, String pass, LocalDate registeredDate, String desc, String country) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
        this.registeredDate = registeredDate;
        this.desc = desc;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
