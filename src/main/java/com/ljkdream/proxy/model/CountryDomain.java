package com.ljkdream.proxy.model;

public class CountryDomain {
    private Long id;

    private String countryDomain;

    private String countryRegionZh;

    private String countryRegionEn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryDomain() {
        return countryDomain;
    }

    public void setCountryDomain(String countryDomain) {
        this.countryDomain = countryDomain == null ? null : countryDomain.trim();
    }

    public String getCountryRegionZh() {
        return countryRegionZh;
    }

    public void setCountryRegionZh(String countryRegionZh) {
        this.countryRegionZh = countryRegionZh == null ? null : countryRegionZh.trim();
    }

    public String getCountryRegionEn() {
        return countryRegionEn;
    }

    public void setCountryRegionEn(String countryRegionEn) {
        this.countryRegionEn = countryRegionEn == null ? null : countryRegionEn.trim();
    }

    public CountryDomain(String countryDomain) {
        this.countryDomain = countryDomain;
    }
}