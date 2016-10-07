package com.example.smanzi.rbc.JsonHelperClasses;

/**
 * Created by smanzi on 6/12/2015.
 */
public class Sector {
    private String name;
    private int Id;
    private int countryId;
    private int provinceId;
    private int districtId;
    private int sectorNumber;

    public Sector ()
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

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String toString() {
        return "sector [id=" + Id + ", name=" + name + ", districtId=" + districtId + ", provinceId=" + provinceId + ", countryId=" + countryId
                +  "]";
    }

    public int getSectorNumber() {
        return sectorNumber;
    }

    public void setSectorNumber(int sectorNumber) {
        this.sectorNumber = sectorNumber;
    }
}
