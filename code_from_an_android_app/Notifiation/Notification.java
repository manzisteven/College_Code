package com.example.smanzi.rbc.Notifiation;

import java.io.Serializable;

/**
 * Created by smanzi on 6/2/2015.
 */
public class Notification implements Serializable{

    private int districtId;
    private int hospitalId;
    private int facilityId;
    private String typePatient;
    private String date;
    private String refered;
    private String firstName;
    private String secondName;
    private String gender;
    private String DOB;
    private String nationality;
    private String pregnant;
    private String patientOccupation;
    private String bloodTransfusionTest;
    private String bloodTransfusionDate;
    private String frequencyWorkAway;
    private String dateOnsetIllness;
    private String sevenDays;
    private String fourteenDays;
    private String twentyOneDays;
    private String fortyTwoDays;
    private String fortytwoAboveDays;
    private String inYesOrNo;
    private String outYesNo;
    private String inDateTravel;
    private String outDateTravel;
    private String preventableMeasures;
    private String fortyTwoTravelYesNo;
    private String fortyTwoDaysPlaceTravel;
    private String RDTDateTest;
    private String officerPerformedRDT;
    private String RDTresult;
    private String bloodSlideDatePerformed;
    private String bloodSlideDateExamined;
    private String bloodSlideDateResultReceived;
    private String bloodSlideResult;
    private String gametocytesPresent;
    private String PCRdateCollected;
    private String specimenCollected;
    private String dateDBSSent;
    private String vivaxSpecie;
    private String malarieSpecie;
    private String falciparumSpecie;
    private String notDeterminedSpecie;
    private String actionTaken;
    private String completedDesignation;
    private String completedDate;
    private String sameAddress;
    private String verifiedDate;
    private String verifiedDesignation;
    private String TravelInReturnDate;
    private String outTravelSector;
    private String outTravelDistrict;
    private int age;
    private int phoneNumber;
    private int caseNumber;
    private int patientDistrictID;
    private int patientSectorID;
    private int patientCellID;
    private int patientVillageID;
    private int patientPhysicalDistrictID;
    private int patientPhysicalSectorID;
    private int patientPhysicalCellID;
    private int patientPhysicalVillageID;
    private int occupationSectorID;

    private int slideNumber;
    private int bloodSlideExaminingFacilityID;
    private int examiningOfficerID;
    private int DBScard;
    private int completedByID;
    private String outTravelCountry;

    public Notification()
    {

    }
    public Notification(int district,int hospital,int facility)
    {
        this.districtId = district;
        this.hospitalId = hospital;
        this.facilityId = facility;
    }
    public void setStatusPatient(String patientStatus)
    {
        this.typePatient = patientStatus;

    }
   public void setPatientInformation(String firstName, String secondName, String gender, String nationality, int age, int phoneNumber, String DOB)
   {
       this.firstName = firstName;
       this.secondName = secondName;
       this.gender = gender;
       this.nationality = nationality;
       this.phoneNumber = phoneNumber;
       this.DOB = DOB;
   }
   public void setPregnancy(String pregnant)
   {
       this.pregnant = pregnant;
   }
   public void setAddress(int districtID, int sectorID, int villageID, int cellID )
   {
       this.patientDistrictID = districtID;
       this.patientSectorID = sectorID;
       this.patientCellID = cellID;
       this.patientVillageID = villageID;
   }
    public void setPhyisicalAddress(int physicalDistrictID, int physicalSectorID, int physicalVillageID, int physicalCellID )
    {
        this.patientPhysicalDistrictID =  physicalDistrictID;
        this.patientPhysicalSectorID =  physicalSectorID;
        this.patientPhysicalCellID =  physicalCellID;
        this.patientPhysicalVillageID =  physicalVillageID;
    }
    public void setOccupation(String Occupation, int sectorID)
    {
        this.patientOccupation = Occupation;
        this.occupationSectorID = sectorID;
    }
    public void setBloodTransfusion(String test)
    {
        this.bloodTransfusionTest = test;
    }
    public  void setBloodTransfusionDate(String date)
    {
        this.bloodTransfusionDate = date;
    }
    public void setFrequencyOfWorkAway(String frequency)
    {
        this.frequencyWorkAway = frequency;
    }
    public void setDateOnsetIllness(String date)
    {
        this.dateOnsetIllness = date;
    }

   public void setSleptBeforeIllness(String sevenDays,String fourteenDays, String twentyOneDays, String fortyTwoDays, String fortytwoAboveDays)
   {
       this.sevenDays = sevenDays;
       this.fourteenDays = fourteenDays;
       this.twentyOneDays = twentyOneDays;
       this.fortyTwoDays = fortyTwoDays;
       this.fortytwoAboveDays = fortytwoAboveDays;
   }

   public void setTravelledWithInRwandaForteenDays(String answer)
   {
       this.inYesOrNo = answer;
   }
    public void setDateOfInTravel(String dateofTravel)
    {
        this.inDateTravel = dateofTravel;
    }
    public void setTravelledOutForteenDays(String answer)
    {
        this.outYesNo = answer;
    }
    public void setOutTravelOutformation(String dateofTravel, String country, String district)
    {
        this.outDateTravel = dateofTravel;
        this.outTravelCountry = country;
        this.outTravelDistrict = district;
    }
    public void setPreventableMeasures(String measures)
    {
        this.preventableMeasures = measures;
    }

    public void travelWithInFortyTwoDays(String answer)
    {
        this.fortyTwoTravelYesNo = answer;
    }
    public void setPlaceOfFortyTwoDaysTravel(String placeofTravel)
    {
        this.fortyTwoDaysPlaceTravel = placeofTravel;
    }


    public void setRDTDateTest(String RDTDateTest) {
        this.RDTDateTest = RDTDateTest;
    }

    public void setOfficerPerformedRDT(String officerPerformedRDT) {
        this.officerPerformedRDT = officerPerformedRDT;
    }

    public void setRDTresult(String RDTresult) {
        this.RDTresult = RDTresult;
    }
    public void setbloodSlideInformation(int slideNumber,String bloodSlideDatePerformed, String bloodSlideDateExamined,String bloodSlideDateResultReceived, String bloodSlideResult,int bloodSlideExaminingFacilityID)
    {
        this.slideNumber = slideNumber;
        this.bloodSlideDatePerformed = bloodSlideDatePerformed;
        this.bloodSlideDateExamined = bloodSlideDateExamined;
        this.bloodSlideDateResultReceived = bloodSlideDateResultReceived;
        this.bloodSlideResult = bloodSlideResult;
        this.bloodSlideExaminingFacilityID = bloodSlideExaminingFacilityID;

    }

    public void setGametocytesPresent(String gametocytesPresent) {
        this.gametocytesPresent = gametocytesPresent;
    }

    public void setExaminingOfficerID(int examiningOfficerID) {
        this.examiningOfficerID = examiningOfficerID;
    }

    public void setPCRdateCollected(String PCRdateCollected) {
        this.PCRdateCollected = PCRdateCollected;
    }

    public void setSpecimenCollected(String specimenCollected) {
        this.specimenCollected = specimenCollected;
    }

    public void setDateDBSSent(String dateDBSSent, int DBScard) {
        this.dateDBSSent = dateDBSSent;
        this.DBScard = DBScard;
    }

    public void setVivaxSpecie(String vivaxSpecie) {
        this.vivaxSpecie = vivaxSpecie;
    }

    public void setMalarieSpecie(String malarieSpecie) {
        this.malarieSpecie = malarieSpecie;
    }

    public void setFalciparumSpecie(String falciparumSpecie) {
        this.falciparumSpecie = falciparumSpecie;
    }

    public void setNotDeterminedSpecie(String notDeterminedSpecie) {
        this.notDeterminedSpecie = notDeterminedSpecie;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public void setCompletedBy( String completedDesignation, String completedDate) {
        this.completedDesignation = completedDesignation;
        this.completedDate = completedDate;
    }

    public int getDistrictId() {
        return districtId;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public String getTypePatient() {
        return typePatient;
    }

    public String getRefered() {
        return refered;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getGender() {
        return gender;
    }

    public String getDOB() {
        return DOB;
    }

    public String getNationality() {
        return nationality;
    }

    public String getPregnant() {
        return pregnant;
    }

    public String getPatientOccupation() {
        return patientOccupation;
    }

    public String getBloodTransfusionTest() {
        return bloodTransfusionTest;
    }

    public String getBloodTransfusionDate() {
        return bloodTransfusionDate;
    }

    public String getFrequencyWorkAway() {
        return frequencyWorkAway;
    }

    public String getDateOnsetIllness() {
        return dateOnsetIllness;
    }

    public String getSevenDays() {
        return sevenDays;
    }

    public String getFourteenDays() {
        return fourteenDays;
    }

    public String getTwentyOneDays() {
        return twentyOneDays;
    }

    public String getFortyTwoDays() {
        return fortyTwoDays;
    }

    public String getFortytwoAboveDays() {
        return fortytwoAboveDays;
    }

    public String getInYesOrNo() {
        return inYesOrNo;
    }

    public String getOutYesNo() {
        return outYesNo;
    }

    public String getInDateTravel() {
        return inDateTravel;
    }

    public String getOutDateTravel() {
        return outDateTravel;
    }

    public String getPreventableMeasures() {
        return preventableMeasures;
    }

    public String getFortyTwoTravelYesNo() {
        return fortyTwoTravelYesNo;
    }

    public String getFortyTwoDaysPlaceTravel() {
        return fortyTwoDaysPlaceTravel;
    }

    public String getRDTDateTest() {
        return RDTDateTest;
    }

    public String getOfficerPerformedRDT() {
        return officerPerformedRDT;
    }

    public String getRDTresult() {
        return RDTresult;
    }

    public String getBloodSlideDatePerformed() {
        return bloodSlideDatePerformed;
    }

    public String getBloodSlideDateExamined() {
        return bloodSlideDateExamined;
    }

    public String getBloodSlideDateResultReceived() {
        return bloodSlideDateResultReceived;
    }

    public String getBloodSlideResult() {
        return bloodSlideResult;
    }

    public String getGametocytesPresent() {
        return gametocytesPresent;
    }

    public String getPCRdateCollected() {
        return PCRdateCollected;
    }

    public String getSpecimenCollected() {
        return specimenCollected;
    }

    public String getDateDBSSent() {
        return dateDBSSent;
    }

    public String getVivaxSpecie() {
        return vivaxSpecie;
    }

    public String getMalarieSpecie() {
        return malarieSpecie;
    }

    public String getFalciparumSpecie() {
        return falciparumSpecie;
    }

    public String getNotDeterminedSpecie() {
        return notDeterminedSpecie;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public String getCompletedDesignation() {
        return completedDesignation;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public int getAge() {
        return age;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getPatientDistrictID() {
        return patientDistrictID;
    }

    public int getPatientSectorID() {
        return patientSectorID;
    }

    public int getPatientCellID() {
        return patientCellID;
    }

    public int getPatientVillageID() {
        return patientVillageID;
    }

    public int getPatientPhysicalDistrictID() {
        return patientPhysicalDistrictID;
    }

    public int getPatientPhysicalSectorID() {
        return patientPhysicalSectorID;
    }

    public int getPatientPhysicalCellID() {
        return patientPhysicalCellID;
    }

    public int getPatientPhysicalVillageID() {
        return patientPhysicalVillageID;
    }

    public int getOccupationSectorID() {
        return occupationSectorID;
    }

    public String getOutTravelSectorID() {
        return outTravelSector;
    }

    public String getOutTravelDistrictID() {
        return outTravelDistrict;
    }

    public int getSlideNumber() {
        return slideNumber;
    }

    public int getBloodSlideExaminingFacilityID() {
        return bloodSlideExaminingFacilityID;
    }

    public int getExaminingOfficerID() {
        return examiningOfficerID;
    }

    public int getDBScard() {
        return DBScard;
    }

    public int getCompletedByID() {
        return completedByID;
    }

    public int getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(int caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSameAddress() {
        return sameAddress;
    }

    public void setSameAddress(String sameAddress) {
        this.sameAddress = sameAddress;
    }


    public String getVerifiedDate() {
        return verifiedDate;
    }

    public String getVerifiedDesignation() {
        return verifiedDesignation;
    }
    public void setVerifiedInformation(String verifiedDate,String verifiedDesignation)
    {
        this.verifiedDate = verifiedDate;
        this.verifiedDesignation = verifiedDesignation;
    }

    public void setRefered(String refered) {
        this.refered = refered;
    }
}
