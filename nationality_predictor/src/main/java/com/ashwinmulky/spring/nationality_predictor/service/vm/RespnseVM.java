package com.ashwinmulky.spring.nationality_predictor.service.vm;

import java.util.ArrayList;
import java.util.List;

public class RespnseVM {
    private String name;
    List<String> countries = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public void addCountry(String country) {
        countries.add(country);
    }

}
