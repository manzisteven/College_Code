package com.example.smanzi.rbc.JsonHelperClasses;

import java.util.ArrayList;

/**
 * Created by smanzi on 6/15/2015.
 */
public class StaticLocationMethods {
    private static ArrayList<Country> countryObjects = new ArrayList<Country>();
    private static ArrayList<Province> provinceObjects = new ArrayList<Province>();
    private static ArrayList<District> districtObjects = new ArrayList<District>();
    private static ArrayList<Sector> sectorObjects = new ArrayList<Sector>();
    private static ArrayList<Cell> cellObjects = new ArrayList<Cell>();
    private static ArrayList<Village> villageObjects = new ArrayList<Village>();
    private static ArrayList<Hospital> hospitalObjects = new ArrayList<Hospital>();
    private static ArrayList<HealthCenter> healthCenterObjects = new ArrayList<HealthCenter>();

    public static ArrayList<Country> getCountryObjects() {
        return countryObjects;
    }

    public static void setCountryObjects(ArrayList<Country> countryObjects) {
        StaticArrayLists.countryObjects = countryObjects;
    }

    public static ArrayList<Province> getProvinceObjects() {
        return provinceObjects;
    }

    public static void setProvinceObjects(ArrayList<Province> provinceObjects) {
        StaticArrayLists.provinceObjects = provinceObjects;
    }

    public static ArrayList<District> getDistrictObjects() {
        return districtObjects;
    }

    public static void setDistrictObjects(ArrayList<District> districtObjects) {
        StaticArrayLists.districtObjects = districtObjects;
    }

    public static ArrayList<Sector> getSectorObjects() {
        return sectorObjects;
    }

    public static void setSectorObjects(ArrayList<Sector> sectorObjects) {
        StaticArrayLists.sectorObjects = sectorObjects;
    }

    public static ArrayList<Cell> getCellObjects() {
        return cellObjects;
    }

    public static void setCellObjects(ArrayList<Cell> cellObjects) {
        StaticArrayLists.cellObjects = cellObjects;
    }

    public static ArrayList<Village> getVillageObjects() {
        return villageObjects;
    }

    public static void setVillageObjects(ArrayList<Village> villageObjects) {
        StaticArrayLists.villageObjects = villageObjects;
    }

    public static ArrayList<Hospital> getHospitalObjects() {
        return hospitalObjects;
    }

    public static void setHospitalObjects(ArrayList<Hospital> hospitalObjects) {
        StaticArrayLists.hospitalObjects = hospitalObjects;
    }

    public static ArrayList<HealthCenter> getHealthCenterObjects() {
        return healthCenterObjects;
    }

    public static void setHealthCenterObjects(ArrayList<HealthCenter> healthCenterObjects) {
        StaticArrayLists.healthCenterObjects = healthCenterObjects;
    }

    public static ArrayList<String> getDistricts (ArrayList<District> districtObjects)
    {
        ArrayList<String> districts = new ArrayList<String>();

        return districts;
    }
    public static ArrayList<String> getCountries (ArrayList<Country> countryObjects)
    {
        ArrayList<String> countries = new ArrayList<String>();

        return countries;
    }


}
