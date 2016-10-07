package com.example.smanzi.rbc.JsonHelperClasses;

/**
 * Created by smanzi on 6/12/2015.
 */
public class Hospital {
    private String name;
    private int Id;
    private int facilityId;
    private int districtId;
    private int provinceId;
    private int countryId;

    public Hospital ()
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

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String toString() {
        return "hospital [id=" + Id + ", name=" + name + ", facilityId=" + facilityId + ", districtId=" + districtId + ", provinceId=" + provinceId
                + ", countryId=" + countryId
                + "]";
    }
}
