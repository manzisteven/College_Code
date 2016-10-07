package com.example.smanzi.rbc.JsonHelperClasses;

/**
 * Created by smanzi on 6/12/2015.
 */
public class District {
    private String name;
    private int Id;
    private int countryId;
    private int provinceId;
    private int districtNumber;

    public District ()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String toString() {
        return "district [id=" + Id + ", name=" + name + ", provinceId=" + provinceId + ", countryId=" + countryId +  "]";
    }

    public int getDistrictNumber() {
        return districtNumber;
    }

    public void setDistrictNumber(int districtNumber) {
        this.districtNumber = districtNumber;
    }
}
