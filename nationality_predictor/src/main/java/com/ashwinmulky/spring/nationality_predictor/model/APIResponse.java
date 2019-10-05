package com.ashwinmulky.spring.nationality_predictor.model;

import java.util.List;

public class APIResponse {
    private String name;
    List<Country> country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }
}
