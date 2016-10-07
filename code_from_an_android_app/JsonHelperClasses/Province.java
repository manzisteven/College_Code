package com.example.smanzi.rbc.JsonHelperClasses;

/**
 * Created by smanzi on 6/12/2015.
 */
public class Province {
    private String name;
    private int Id;
    private int countryId;
    private int provinceNumber;

    public Province ()
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

    public String toString() {
        return "province [id=" + Id + ", name =" + name + ", countryId=" + countryId + "]";
    }

    public int getProvinceNumber() {
        return provinceNumber;
    }

    public void setProvinceNumber(int provinceNumber) {
        this.provinceNumber = provinceNumber;
    }
}
