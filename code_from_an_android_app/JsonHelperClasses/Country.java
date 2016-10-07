package com.example.smanzi.rbc.JsonHelperClasses;

/**
 * Created by smanzi on 6/12/2015.
 */
public class Country {
    private String name;
    private int Id;
    private int countryNumber;

    public Country ()
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

    public String toString() {
        return "country [id=" + Id + ", name=" + name +  "]";
    }

    public int getCountryNumber() {
        return countryNumber;
    }

    public void setCountryNumber(int countryNumber) {
        this.countryNumber = countryNumber;
    }
}
