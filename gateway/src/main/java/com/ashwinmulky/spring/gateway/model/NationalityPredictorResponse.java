package com.ashwinmulky.spring.gateway.model;

import java.util.ArrayList;
import java.util.List;

public class NationalityPredictorResponse {
    private String name;
    List<String> countries = new ArrayList<>();

    public String getName() {
        return name;
    }

    public NationalityPredictorResponse setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getCountries() {
        return countries;
    }

    public NationalityPredictorResponse setCountries(List<String> countries) {
        this.countries = countries;
        return this;
    }
}
