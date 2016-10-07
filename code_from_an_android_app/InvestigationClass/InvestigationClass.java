package com.example.smanzi.rbc.InvestigationClass;

import java.io.Serializable;

/**
 * Created by smanzi on 6/1/2015.
 */
public class InvestigationClass implements Serializable{

    private int investigationCaseNumber;
    private String patientFirstName;
    private String patientSurName;
    private int indexCaseCodeNumber;
    private int investigationDistrictId;
    private int investigationHospitalId;
    private int investigationFacilityId;
    private String investigationDate;
    private int patientAge;
    private String isPregnant;
    private String headOfHousehold;
    private String typeOfCaseDetection;
    private String last_indoor;
    private int numberOfLLINS;
    private int totalNumberOfHousesInVillage;
    private int totalNumberOfInhabitantsInVillage;
    private String typeOfHabitat;
    private String houseLocation;
    private String housesWithHoles;
    private String completedDate;
    private String completedBy;
    private String verifiedDate;
    private String verifiedBy;
    private String completedDesignation;
    private String verifiedDesignation;
    private String idNumber;
    private String slideResult;
    private String parasiteDensity;
    private String rdtResult;

    public  InvestigationClass ()
    {

    }
    public void setIdNumber (String idNumber)
    {
        this.idNumber = idNumber;
    }
    public void setSlideResult (String slideResult)
    {
        this.slideResult = slideResult;
    }
    public void setParasiteDensity (String parasiteDensity)
    {
        this.parasiteDensity = parasiteDensity;
    }
    public void setRdtResult (String rdtResult)
    {
        this.rdtResult = rdtResult;
    }
    public void setInvestigationCaseNumber (int investigationCaseNumber)
    {
        this.investigationCaseNumber = investigationCaseNumber;
    }

    public void setPatientName (String patientFirstName, String patientSurName )
    {
        this.patientFirstName = patientFirstName;
        this.patientSurName = patientSurName;
    }
    public void setIndexCaseCodeNumber (int indexCaseCodeNumber)
    {
        this.indexCaseCodeNumber = indexCaseCodeNumber;
    }
    public void setInvestigationDistrictId (int investigationDistrictId)
    {
        this.investigationDistrictId = investigationDistrictId;

    }
    public void setInvestigationHospitalId (int investigationHospitalId)
    {
        this.investigationHospitalId = investigationHospitalId;
    }

   public void setInvestigationFacilityId (int investigationFacilityId)
   {
       this.investigationFacilityId = investigationFacilityId;
   }
   public void setInvestigationDate (String investigationDate)
   {
       this.investigationDate = investigationDate;
   }
   public void setPatientAge (int patientAge)
   {
       this.patientAge = patientAge;
   }
   public void setHeadOfHousehold (String headOfHousehold)
   {
       this.headOfHousehold = headOfHousehold;

   }
   public void setIsPregnant (String isPregnant)
   {
       this.isPregnant = isPregnant;
   }
   public void setTypeOfCaseDetection (String typeOfCaseDetection)
   {
       this.typeOfCaseDetection  = typeOfCaseDetection;
   }
   public void setLast_indoor (String last_indoor)
   {
       this.last_indoor = last_indoor;
   }
   public void setNumberOfLLINS (int numberOfLLINS1)
   {
       this.numberOfLLINS = numberOfLLINS;
   }
   public void setTotalNumberOfHousesInVillage (int numberOfHousesInVillage)
   {
       this.totalNumberOfHousesInVillage = numberOfHousesInVillage;
   }
   public void setTotalNumberOfInhabitantsInVillage (int totalNumberOfInhabitantsInVillage)
   {
       this.totalNumberOfInhabitantsInVillage = totalNumberOfInhabitantsInVillage;
   }
   public void setTypeOfHabitat (String typeOfHabitat)
   {
       this.typeOfHabitat = typeOfHabitat;
   }
   public void setHouseLocation (String houseLocation)
   {
       this.houseLocation = houseLocation;
   }
   public void setHousesWithHoles (String housesWithHoles)
   {
       this.housesWithHoles = housesWithHoles;

   }
   public void setCompletedDate (String completedDate)
   {
       this.completedDate = completedDate;
   }
   public void setCompletedBy (String completedBy)
   {
       this.completedBy = completedBy;
   }
   public void setVerifiedDate (String verifiedDate)
   {
       this.verifiedDate = verifiedDate;
   }
   public void setVerifiedBy (String verifiedBy)
   {
       this.verifiedBy = verifiedBy;
   }
   public void setCompletedDesignation (String completedDesignation)
   {
       this.completedDesignation = completedDesignation;
   }
   public void setVerifiedDesignation (String verifiedDesignation)
   {
       this.verifiedDesignation = verifiedDesignation;
   }
   public String getPatientName ()
   {
       return patientFirstName;
   }
   public int getInvestigationDistrictId ()
   {
       return investigationDistrictId;
   }
   public int getInvestigationHospitalId ()
   {
       return investigationHospitalId;
   }
    public int getInvestigationFacilityId ()
    {
        return investigationFacilityId;
    }
    public String getInvestigationDate ()
    {
        return investigationDate;
    }
    public String getIsPregnant ()
    {
        return isPregnant;
    }
    public String getPatientSurName ()
    {
        return patientSurName;
    }
    public String getHeadOfHousehold ()
    {
        return headOfHousehold;
    }
    public String getTypeOfCaseDetection ()
    {
        return typeOfCaseDetection;
    }
    public String getLast_indoor ()
    {
        return last_indoor;
    }
    public String getTypeOfHabitat ()
    {
        return typeOfHabitat;
    }
    public String getHouseLocation ()
    {
        return houseLocation;
    }
    public String getHousesWithHoles ()
    {
        return housesWithHoles;
    }
    public String getCompletedDate ()
    {
        return completedDate;
    }
    public String getCompletedBy ()
    {
        return completedBy;
    }
    public String getVerifiedDate ()
    {
        return completedBy;
    }
    public String getVerifiedBy ()
    {
        return verifiedBy;
    }
    public String getCompletedDesignation ()
    {
        return completedDesignation;
    }
    public String getVerifiedDesignation ()
    {
        return verifiedDesignation;
    }
    public int getInvestigationCaseNumber ()
    {
        return investigationCaseNumber;
    }
    public int getIndexCaseCodeNumber ()
    {
        return indexCaseCodeNumber;
    }
    public int getPatientAge ()
    {
        return patientAge;
    }
    public int getNumberOfLLINS ()
    {
        return numberOfLLINS;
    }
    public int getTotalNumberOfHousesInVillage ()
    {
        return totalNumberOfHousesInVillage;
    }
    public int getTotalNumberOfInhabitantsInVillage ()
    {
        return totalNumberOfInhabitantsInVillage;
    }
public String getIdNumber ()
{
    return idNumber;
}
public String getSlideResult ()
{
    return slideResult;
}
public String getParasiteDensity ()
{
    return parasiteDensity;
}
public String getRdtResult ()
{
    return rdtResult;
}
}
