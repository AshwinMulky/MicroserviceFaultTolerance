package com.ashwinmulky.spring.gateway.service.vm;

import com.ashwinmulky.spring.gateway.model.CountryDetails;

import java.util.ArrayList;
import java.util.List;

public class ResponseVM {
    private String name;
    private List<CountryDetails> countryDetails = new ArrayList<>();

    public String getName() {
        return name;
    }

    public ResponseVM setName(String name) {
        this.name = name;
        return this;
    }

    public List<CountryDetails> getCountryDetails() {
        return countryDetails;
    }

    public void setCountryDetails(List<CountryDetails> countryDetails) {
        this.countryDetails = countryDetails;
    }

    public void addCountryDetails(CountryDetails countryDetails) {
        this.countryDetails.add(countryDetails);
    }
}
