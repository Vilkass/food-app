package com.vilkas.foodapp.model;

public class Ingredient {

    private String name;
    private String type;
    private boolean alergen;

    public Ingredient(String name, String type, boolean alergen) {
        this.name = name;
        this.type = type;
        this.alergen = alergen;
    }

    public Ingredient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAlergen() {
        return alergen;
    }

    public void setAlergen(boolean alergen) {
        this.alergen = alergen;
    }
}
