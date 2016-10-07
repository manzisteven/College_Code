package com.example.smanzi.rbc.CaseFollowupClass;

import java.io.Serializable;

/**
 * Created by smanzi on 6/4/2015.
 */
public class CaseFollowUpClass implements Serializable{
    private int caseCodeNumber;
    private String nationalIdNumber;
    private String caseDate;
    private String methodOfDiagnosis;
    private int districtId;
    private int hospitalId;
    private int facilityId;
    private String healthFacilityOfficer;
    private String day3Date;
    private String presenceOfDangerSigns;
    private float day3Temperature;
    private String day14Date;
    private String presenceOfDangerSigns14;
    private float day14Temperature;
    private String day28Date;
    private String presenceOfDangerSigns28;
    private float day28Temperature;
    private String statusComments;
    private String treatment;
    private String CompletedDose;
    private String notes;
    private String lossToFollowUp;
    private String lastContactDate;
    private String lossReasons;
    private String presenceOfGametocytes;
    private String OtherSpecies;
    private String isPcrtaken;
    private String pcrDate;
    private int day;
    private String speciesType;
    private String treatmentGiven;
    private String follow_UpDate;

    public CaseFollowUpClass ()
    {

    }


    public int getCaseCodeNumber() {
        return caseCodeNumber;
    }

    public void setCaseCodeNumber(int caseCodeNumber) {
        this.caseCodeNumber = caseCodeNumber;
    }

    public String getNationalIdNumber() {
        return nationalIdNumber;
    }

    public void setNationalIdNumber(String nationalIdNumber) {
        this.nationalIdNumber = nationalIdNumber;
    }

    public String getCaseDate() {
        return caseDate;
    }

    public void setCaseDate(String caseDate) {
        this.caseDate = caseDate;
    }

    public String getMethodOfDiagnosis() {
        return methodOfDiagnosis;
    }

    public void setMethodOfDiagnosis(String methodOfDiagnosis) {
        this.methodOfDiagnosis = methodOfDiagnosis;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getHealthFacilityOfficer() {
        return healthFacilityOfficer;
    }

    public void setHealthFacilityOfficer(String healthFacilityOfficer) {
        this.healthFacilityOfficer = healthFacilityOfficer;
    }

    public String getDay3Date() {
        return day3Date;
    }

    public void setDay3Date(String day3Date) {
        this.day3Date = day3Date;
    }

    public String getPresenceOfDangerSigns() {
        return presenceOfDangerSigns;
    }

    public void setPresenceOfDangerSigns(String presenceOfDangerSigns) {
        this.presenceOfDangerSigns = presenceOfDangerSigns;
    }

    public float getDay3Temperature() {
        return day3Temperature;
    }

    public void setDay3Temperature(float day3Temperature) {
        this.day3Temperature = day3Temperature;
    }

    public String getDay14Date() {
        return day14Date;
    }

    public void setDay14Date(String day14Date) {
        this.day14Date = day14Date;
    }

    public String getPresenceOfDangerSigns14() {
        return presenceOfDangerSigns14;
    }

    public void setPresenceOfDangerSigns14(String presenceOfDangerSigns14) {
        this.presenceOfDangerSigns14 = presenceOfDangerSigns14;
    }

    public float getDay14Temperature() {
        return day14Temperature;
    }

    public void setDay14Temperature(float day14Temperature) {
        this.day14Temperature = day14Temperature;
    }

    public String getDay28Date() {
        return day28Date;
    }

    public void setDay28Date(String day28Date) {
        this.day28Date = day28Date;
    }

    public String getPresenceOfDangerSigns28() {
        return presenceOfDangerSigns28;
    }

    public void setPresenceOfDangerSigns28(String presenceOfDangerSigns28) {
        this.presenceOfDangerSigns28 = presenceOfDangerSigns28;
    }

    public float getDay28Temperature() {
        return day28Temperature;
    }

    public void setDay28Temperature(float day28Temperature) {
        this.day28Temperature = day28Temperature;
    }

    public String getStatusComments() {
        return statusComments;
    }

    public void setStatusComments(String statusComments) {
        this.statusComments = statusComments;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getCompletedDose() {
        return CompletedDose;
    }

    public void setCompletedDose(String completedDose) {
        CompletedDose = completedDose;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getLossToFollowUp() {
        return lossToFollowUp;
    }

    public void setLossToFollowUp(String lossToFollowUp) {
        this.lossToFollowUp = lossToFollowUp;
    }

    public String getLastContactDate() {
        return lastContactDate;
    }

    public void setLastContactDate(String lastContactDate) {
        this.lastContactDate = lastContactDate;
    }

    public String getLossReasons() {
        return lossReasons;
    }

    public void setLossReasons(String lossReasons) {
        this.lossReasons = lossReasons;
    }

    public String getPresenceOfGametocytes() {
        return presenceOfGametocytes;
    }

    public void setPresenceOfGametocytes(String presenceOfGametocytes) {
        this.presenceOfGametocytes = presenceOfGametocytes;
    }

    public String getOtherSpecies() {
        return OtherSpecies;
    }

    public void setOtherSpecies(String otherSpecies) {
        OtherSpecies = otherSpecies;
    }

    public String getIsPcrtaken() {
        return isPcrtaken;
    }

    public void setIsPcrtaken(String isPcrtaken) {
        this.isPcrtaken = isPcrtaken;
    }

    public String getPcrDate() {
        return pcrDate;
    }

    public void setPcrDate(String pcrDate) {
        this.pcrDate = pcrDate;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getSpeciesType() {
        return speciesType;
    }

    public void setSpeciesType(String speciesType) {
        this.speciesType = speciesType;
    }

    public String getTreatmentGiven() {
        return treatmentGiven;
    }

    public void setTreatmentGiven(String treatmentGiven) {
        this.treatmentGiven = treatmentGiven;
    }

    public String getFollow_UpDate() {
        return follow_UpDate;
    }

    public void setFollow_UpDate(String follow_UpDate) {
        this.follow_UpDate = follow_UpDate;
    }
}
