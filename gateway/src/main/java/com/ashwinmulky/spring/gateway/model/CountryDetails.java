package com.ashwinmulky.spring.gateway.model;

import java.util.List;

public class CountryDetails {
    private String name;
    private String flag;
    private String nativeName;
    private String region;
    private String capital;

    public String getName() {
        return name;
    }

    public CountryDetails setName(String name) {
        this.name = name;
        return this;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
