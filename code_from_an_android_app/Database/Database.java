package com.example.smanzi.rbc.Database;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.tmutabazi.rbc.JsonHelperClasses.Cell;
import com.example.tmutabazi.rbc.JsonHelperClasses.Country;
import com.example.tmutabazi.rbc.JsonHelperClasses.District;
import com.example.tmutabazi.rbc.JsonHelperClasses.HealthCenter;
import com.example.tmutabazi.rbc.JsonHelperClasses.Hospital;
import com.example.tmutabazi.rbc.JsonHelperClasses.Province;
import com.example.tmutabazi.rbc.JsonHelperClasses.Sector;
import com.example.tmutabazi.rbc.JsonHelperClasses.StaticArrayLists;
import com.example.tmutabazi.rbc.JsonHelperClasses.Village;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by smanzi on 6/13/2015.
 */
public class Database extends SQLiteOpenHelper {
    private ArrayList<Country> countryObjects = new ArrayList<Country>();
    private ArrayList<Province> provinceObjects = new ArrayList<Province>();
    private ArrayList<District> districtObjects = new ArrayList<District>();
    private ArrayList<Sector> sectorObjects = new ArrayList<Sector>();
    private ArrayList<Cell> cellObjects = new ArrayList<Cell>();
    private ArrayList<Village> villageObjects = new ArrayList<Village>();
    private ArrayList<Hospital> hospitalObjects = new ArrayList<Hospital>();
    private ArrayList<HealthCenter> healthCenterObjects = new ArrayList<HealthCenter>();


    // Database name and version
    private  static final int DATABASE_VERSION = 1;
    private  static final String DATABASE_NAME = "locationDataDB.db";
    // Country table
    private static final String TABLE_NAME1 = "CountryTable";
    // Columns for country table
    private static final String KEY_ID1 = "id";
    private static final String countryName = "name";
    private static final String countryId1 = "countryId";
    private static final String countryNumber = "countryNumber";

    // Province table
    private static final String TABLE_NAME2 = "ProvinceTable";

    // Columns for province table
    private static final String KEY_ID2 = "id";
    private static final String provinceName = "name";
    private static final String provinceId1 = "provinceId";
    private static final String provinceNumber = "provinceNumber";
    private static final String countryId2 = "countryId";

    // District table
    private static final String TABLE_NAME3 = "DistrictTable";
    // Columns for district table
    private static final String KEY_ID3 = "id";
    private static final String districtName = "name";
    private static final String districtId1 = "districtId";
    private static final String districtNumber = "districtNumber";
    private static final String provinceId2 = "provinceId";
    private static final String countryId3 = "countryId";
    // Sector table
    private static final String TABLE_NAME4 = "SectorTable";
    // Columns for sector table
    private static final String KEY_ID4 = "id";
    private static final String sectorName = "name";
    private static final String sectorId1 = "sectorId";
    private static final String sectorNumber = "sectorNumber";
    private static final String districtId2 = "districtId";
    private static final String provinceId3 = "provinceId";
    private static final String countryId4 = "countryId";

    // Cell table
    private static final String TABLE_NAME5 = "CellTable";
    // Columns for cell table
    private static final String KEY_ID5 = "id";
    private static final String cellName = "name";
    private static final String cellId1 = "cellId";
    private static final String cellINumber = " cellINumber";
    private static final String sectorId2 = "sectorId";
    private static final String districtId3 = "districtId";
    private static final String provinceId4 = "provinceId";
    private static final String countryId5 = "countryId";
    // Village table
    private static final String TABLE_NAME6 = "VillageTable";
    // Columns for village table
    private static final String KEY_ID6 = "id";
    private static final String villageName = "name";
    private static final String villageId = "villageId";
    private static final String villageNumber = "villageNumber";
    private static final String cellId2 = "cellId";
    private static final String sectorId3 = "sectorId";
    private static final String districtId4 = "districtId";
    private static final String provinceId5 = "provinceId";
    private static final String countryId6 = "countryId";

    // Hospital table
    private static final String TABLE_NAME7 = "HospitalTable";
    // Columns for hospital table
    private static final String KEY_ID7 = "id";
    private static final String hospitalName = "name";
    private static final String hospitalId1 = "hospitalId";
    private static final String facilityId1 = "facilityId";
    private static final String districtId5 = "districtId";
    private static final String provinceId6 = "provinceId";
    private static final String countryId7 = "countryId";

    // Health center table
    private static final String TABLE_NAME8 = "HealthCenterTable";
    // Columns for health center table
    private static final String KEY_ID8 = "id";
    private static final String healthCenterId = "healthCenterId";
    private static final String healthCenterName = "name";
    private static final String hospitalId2 = "hospitalId";
    private static final String facilityId2 = "facilityId";
    private static final String districtId6 = "districtId";
    private static final String provinceId7 = "provinceId";
    private static final String countryId8 = "countryId";

    ArrayList<Sector> sectorObjectsFunction;
    ArrayList<Cell> cellObjectsFunction;
    ArrayList<Village> villageObjectsFunction;
    ArrayList<HealthCenter> healthCenterObjects1;
    ArrayList<Country> countryObjectsFunction;


    public Database (Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate (SQLiteDatabase db)
    {
        String countryTable = "CREATE TABLE CountryTable ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name text, "+ "countryId integer,"+"countryNumber integer )";


        db.execSQL(countryTable);

        String provinceTable = "CREATE TABLE ProvinceTable ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name text, "+ "provinceId integer, "+"provinceNumber integer, "+"countryId integer )";

        db.execSQL(provinceTable);

        String districtTable = "CREATE TABLE DistrictTable ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name text, "+ "districtId integer, "+ "districtNumber integer, "+"provinceId integer, "+"countryId integer )";

        db.execSQL(districtTable);

        String sectorTable = "CREATE TABLE SectorTable ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name text, "+ "sectorId integer, "+ "sectorNumber integer, "+"districtId integer, "+"provinceId integer, "+ "countryId integer )";

        db.execSQL(sectorTable);

        String cellTable = "CREATE TABLE CellTable ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name text, "+ "cellId integer, "+ " cellINumber integer, "+"sectorId integer, "+"districtId integer, "+ "provinceId integer, "+
                "countryId integer )";

        db.execSQL(cellTable);

        String villageTable = "CREATE TABLE VillageTable ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name text, "+ "villageId integer, "+ "villageNumber integer, "+"cellId integer, "+"sectorId integer, "+ "districtId integer, "+
                "provinceId integer,"+"countryId integer )";

        db.execSQL(villageTable);

        String hospitalTable = "CREATE TABLE HospitalTable ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name text, "+ "hospitalId integer, "+"facilityId integer, "+"districtId integer, "+ "provinceId integer, "+
                "countryId integer )";

        db.execSQL(hospitalTable);

        String healthCenterTable = "CREATE TABLE HealthCenterTable ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name text, "+ "healthCenterId integer, "+"hospitalId integer, "+"facilityId integer, "+ "districtId integer, "+
                "provinceId integer,"+"countryId integer )";

        db.execSQL(healthCenterTable);

    }

    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion)
    {

        db.execSQL("DROP TABLE IF EXISTS re");


        this.onCreate(db);
    }

    public void insertCountryObject ()
    {
        ArrayList<Country> country = StaticArrayLists.getCountryObjects();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (int i =0; i<country.size(); i++)
        {
            Country countryObject = country.get(i);
            Log.d("country", countryObject.toString());
            String name = countryObject.getName();
            values.put(countryName, name);
            int id = countryObject.getId();
            values.put(countryId1, id);
            int countryNumber1 = countryObject.getCountryNumber();
            values.put(countryNumber, countryNumber1);
            db.insert(TABLE_NAME1, null,values);
        }

        db.close();

    }

    public void insertProvinceObject ()
    {
        ArrayList<Province> province = StaticArrayLists.getProvinceObjects();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (int i =0; i<province.size(); i++)
        {
            Province provinceObject = province.get(i);
            Log.d("province", provinceObject.toString());
            String name = provinceObject.getName();
            values.put(provinceName, name);
            int id = provinceObject.getId();
            values.put(provinceId1, id);
            int provinceNumber1 = provinceObject.getProvinceNumber();
            values.put(provinceNumber, provinceNumber1);
            int countryId = provinceObject.getCountryId();
            values.put(countryId2, countryId);
            db.insert(TABLE_NAME2, null,values);
        }

        db.close();
    }
    public void insertDistrictObject ()
    {
        ArrayList<District> district = StaticArrayLists.getDistrictObjects();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (int i =0; i<district.size(); i++)
        {
            District districtObject = district.get(i);
            Log.d("district", districtObject.toString());
            String name = districtObject.getName();
            values.put( districtName, name);
            int id = districtObject.getId();
            values.put(districtId1, id);
            int districtNumber1 = districtObject.getDistrictNumber();
            values.put(districtNumber, districtNumber1);
            int provinceId = districtObject.getProvinceId();
            values.put( provinceId2, provinceId);
            int countryId = districtObject.getCountryId();
            values.put( countryId3, countryId);
            db.insert(TABLE_NAME3, null,values);

        }

        db.close();

    }
    public void insertSectorObjects ()
    {
        ArrayList<Sector> sector = StaticArrayLists.getSectorObjects();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (int i =0; i<sector.size(); i++)
        {
            Sector sectorObject = sector.get(i);
            Log.d("sector", sectorObject.toString());
            String name = sectorObject.getName();
            values.put(  sectorName, name);
            int id = sectorObject.getId();
            values.put(sectorId1, id);
            int sectorNumber1 = sectorObject.getSectorNumber();
            values.put(sectorNumber, sectorNumber1);
            int districtId = sectorObject.getDistrictId();
            values.put(districtId2, districtId);
            int provinceId = sectorObject.getProvinceId();
            values.put(provinceId3, provinceId);
            int countryId = sectorObject.getCountryId();
            values.put(countryId4, countryId);
            db.insert(TABLE_NAME4, null,values);
        }

        db.close();

    }
    public void insertCellObject ()
    {
        ArrayList<Cell> cell = StaticArrayLists.getCellObjects();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (int i =0; i<cell.size(); i++)
        {
            Cell cellObject = cell.get(i);
            Log.d("cell", cellObject.toString());
            String name = cellObject.getName();
            values.put(cellName, name);
            int id = cellObject.getId();
            values.put(cellId1, id);
            int cellNumber1 = cellObject.getCellNumber();
            values.put(cellINumber, cellNumber1);
            int sectorId = cellObject.getSectorId();
            values.put(sectorId2, sectorId);
            int districtId = cellObject.getDistrictId();
            values.put(districtId3, districtId);
            int provinceId = cellObject.getProvinceId();
            values.put(provinceId4, provinceId);
            int countryId = cellObject.getCountryId();
            values.put(countryId5, countryId);
            db.insert(TABLE_NAME5, null,values);
        }

        db.close();

    }

    public void insertVillageObject ()
    {
        ArrayList<Village> village = StaticArrayLists.getVillageObjects();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (int i =0; i<village.size(); i++)
        {
            Village villageObject = village.get(i);
            Log.d("village", villageObject.toString());
            String name = villageObject.getName();
            values.put(villageName, name);
            int id = villageObject.getId();
            values.put(villageId, id);
            int villageNumber1 = villageObject.getVillageNumber();
            values.put(villageNumber, villageNumber1);
            int cellId = villageObject.getCellId();
            values.put(cellId2, cellId);
            int sectorId = villageObject.getSectorId();
            values.put(sectorId3, sectorId);
            int districtId = villageObject.getDistrictId();
            values.put(districtId4, districtId);
            int provinceId = villageObject.getProvinceId();
            values.put(provinceId5, provinceId);
            int countryId = villageObject.getCountryId();
            values.put(countryId6, countryId);
            db.insert(TABLE_NAME6, null,values);
        }


        db.close();

    }

    public void insertHospitalObject ()
    {
        ArrayList<Hospital> hospital = StaticArrayLists.getHospitalObjects();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (int i =0; i<hospital.size(); i++)
        {
            Hospital hospitalObject = hospital.get(i);
            Log.d("hospital", hospitalObject.toString());
            String name = hospitalObject.getName();
            values.put(hospitalName, name);
            int id = hospitalObject.getId();
            values.put(hospitalId1, id);
            int facilityId = hospitalObject.getFacilityId();
            values.put(facilityId1,facilityId);
            int districtId = hospitalObject.getDistrictId();
            values.put(districtId5,districtId);
            int provinceId = hospitalObject.getProvinceId();
            values.put(provinceId6 ,provinceId);
            int countryId = hospitalObject.getCountryId();
            values.put(countryId7 ,countryId);
            db.insert(TABLE_NAME7, null,values);
        }

        db.close();

    }

    public void insertHealthCenterObject ()
    {
        ArrayList<HealthCenter> healthCenter = StaticArrayLists.getHealthCenterObjects();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        for (int i =0; i<healthCenter.size(); i++)
        {
            HealthCenter healthCenterObject = healthCenter.get(i);
            Log.d("health canter", healthCenterObject.toString());
            String name = healthCenterObject.getName();
            values.put(healthCenterName, name);
            int id = healthCenterObject.getId();
            values.put(healthCenterId, id);
            int facilityId = healthCenterObject.getFacilityId();
            values.put(facilityId2, facilityId);
            int hospitalId = healthCenterObject.getHospitalId();
            values.put(hospitalId2, hospitalId);
            int districtId = healthCenterObject.getDistrictId();
            values.put(districtId6, districtId);
            int provinceId = healthCenterObject.getProvinceId();
            values.put(provinceId7, provinceId);
            int countryId = healthCenterObject.getCountryId();
            values.put(countryId8, countryId);
            db.insert(TABLE_NAME8, null,values);
        }


        db.close();

    }
    public ArrayList<Country> getCountryObject ()
    {
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                int id = cursor.getInt(2);
                int countryNumber = cursor.getInt(3);
                Country country = new Country();
                country.setName(name);
                country.setId(id);
                country.setCountryNumber(countryNumber);
                countryObjects.add(country);
            } while (cursor.moveToNext());
        }
        //db.close();
        return countryObjects;
    }

    public ArrayList<Province> getProvinceObject ()
    {
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME2;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                int id = cursor.getInt(2);
                int provinceNumber = cursor.getInt(3);
                int countryId = cursor.getInt(4);
                Province province = new Province();
                province.setName(name);
                province.setId(id);
                province.setProvinceNumber(provinceNumber);
                province.setCountryId(countryId);
                provinceObjects.add(province);

            } while (cursor.moveToNext());
        }
        //db.close();
        return provinceObjects;
    }

    public ArrayList<District> getDistrictObject ()
    {
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME3;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                int id = cursor.getInt(2);
                int districtNumber = cursor.getInt(3);
                int provinceId = cursor.getInt(4);
                int countryId = cursor.getInt(5);
                District district = new District ();
                district.setName(name);
                district.setId(id);
                district.setProvinceId(provinceId);
                district.setCountryId(countryId);
                district.setDistrictNumber(districtNumber);
                districtObjects.add(district);

            } while (cursor.moveToNext());
        }
        //db.close();
        return districtObjects;
    }
    public ArrayList<Sector> getSectorObject (int districtNumber)
    {
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME4;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                int districtId = cursor.getInt(4);
                if (districtId == districtNumber) {
                    String name = cursor.getString(1);
                    int id = cursor.getInt(2);
                    int sectorNumber = cursor.getInt(3);
                    int provinceId = cursor.getInt(5);
                    int countryId = cursor.getInt(6);
                    Sector sector = new Sector();
                    sector.setName(name);
                    sector.setId(id);
                    sector.setDistrictId(districtId);
                    sector.setProvinceId(provinceId);
                    sector.setCountryId(countryId);
                    sector.setSectorNumber(sectorNumber);
                    sectorObjects.add(sector);
                }


            } while (cursor.moveToNext());
        }
        //db.close();
        return sectorObjects;
    }

    public ArrayList<Cell> getCellObject (int sectorNumber)
    {
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME5;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                int sectorId = cursor.getInt(4);
                if (sectorId == sectorNumber) {
                    String name = cursor.getString(1);
                    int id = cursor.getInt(2);
                    int cellNumber = cursor.getInt(3);
                    int districtId = cursor.getInt(5);
                    int provinceId = cursor.getInt(6);
                    int countryId = cursor.getInt(7);
                    Cell cell = new Cell();
                    cell.setName(name);
                    cell.setId(id);
                    cell.setSectorId(sectorId);
                    cell.setDistrictId(districtId);
                    cell.setProvinceId(provinceId);
                    cell.setCountryId(countryId);
                    cell.setCellNumber(cellNumber);
                    cellObjects.add(cell);
                }


            } while (cursor.moveToNext());
        }
        //db.close();
        return cellObjects;
    }
    public ArrayList<Village> getVillageObject (int cellNumber)
    {
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME6;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int cellId = cursor.getInt(4);
                if(cellId == cellNumber) {
                    String name = cursor.getString(1);
                    int id = cursor.getInt(2);
                    int villageNumber = cursor.getInt(3);
                    int sectorId = cursor.getInt(5);
                    int districtId = cursor.getInt(6);
                    int provinceId = cursor.getInt(7);
                    int countryId = cursor.getInt(8);
                    Village village = new Village();
                    village.setName(name);
                    village.setId(id);
                    village.setVillageNumber(villageNumber);
                    village.setCellId(cellId);
                    village.setSectorId(sectorId);
                    village.setDistrictId(districtId);
                    village.setProvinceId(provinceId);
                    village.setCountryId(countryId);
                    villageObjects.add(village);
                }

            } while (cursor.moveToNext());
        }
        //db.close();
        return villageObjects;
    }
    public ArrayList<Hospital> getHospitalObject ()
    {
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME7;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                String name = cursor.getString(1);
                int id = cursor.getInt(2);
                int facilityId = cursor.getInt(3);
                int districtId = cursor.getInt(4);
                int provinceId = cursor.getInt(5);
                int countryId = cursor.getInt(6);
                Hospital hospital = new Hospital();
                hospital.setName(name);
                hospital.setId(id);
                hospital.setFacilityId(facilityId);
                hospital.setDistrictId(districtId);
                hospital.setProvinceId(provinceId);
                hospital.setCountryId(countryId);
                hospitalObjects.add(hospital);



            } while (cursor.moveToNext());
        }
        //db.close();
        return hospitalObjects;
    }
    public ArrayList<HealthCenter> getHealthCenterObject (int districtNumber)
    {
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME8;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                int districtId = cursor.getInt(5);
                if(districtId == districtNumber) {

                    String name = cursor.getString(1);
                    int id = cursor.getInt(2);
                    int hospitalId = cursor.getInt(3);
                    int facilityId = cursor.getInt(4);
                    int provinceId = cursor.getInt(6);
                    int countryId = cursor.getInt(7);
                    HealthCenter healthCenter = new HealthCenter();
                    healthCenter.setName(name);
                    healthCenter.setId(id);
                    healthCenter.setFacilityId(facilityId);
                    healthCenter.setHospitalId(hospitalId);
                    healthCenter.setDistrictId(districtId);
                    healthCenter.setProvinceId(provinceId);
                    healthCenter.setCountryId(countryId);
                    healthCenterObjects.add(healthCenter);
                }
            } while (cursor.moveToNext());
        }
        //db.close();
        return healthCenterObjects;
    }
    public int  getDistrictNumber (String districtName)
    {
        int selectedId = 0;
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME3;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                if (name.trim().equals(districtName))
                {
                    int districtNumber = cursor.getInt(3);
                    selectedId = districtNumber;
                    break;
                }


            } while (cursor.moveToNext());
        }
        //db.close();
        return selectedId;
    }
    public int getSectorNumber (String sectorName)
    {
        int selectedNumber = 0;
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME4;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                String name = cursor.getString(1);
                if(name.trim().equals(sectorName))
                {
                    int sectorNumber = cursor.getInt(3);
                    selectedNumber  = sectorNumber;
                    break;
                }




            } while (cursor.moveToNext());
        }
        //db.close();
        return selectedNumber;
    }
    public int getCellNumber (String cellName)
    {
        int selectedNumber = 0;
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME5;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                if (name.trim().equals(cellName))
                {
                    int cellNumber = cursor.getInt(3);
                    selectedNumber = cellNumber;
                    break;
                }





            } while (cursor.moveToNext());
        }
        //db.close();
        return selectedNumber;
    }

    public  ArrayList<String> getDistricts ()
    {
        ArrayList<District> districtObjects = getDistrictObject();
        ArrayList<String> districts = new ArrayList<String>();
        for (int i =0; i<districtObjects.size(); i++)
        {
            District districtObject = districtObjects.get(i);
            districts.add(districtObject.getName());
        }

        return districts;
    }
    public  ArrayList<String> getSectors (String districtName)
    {
        int districtNumber = getDistrictNumber(districtName);
        if(sectorObjectsFunction != null)
        {
            sectorObjectsFunction.clear();
        }
        sectorObjectsFunction = getSectorObject(districtNumber);
        ArrayList<String> sectors = new ArrayList<String>();

        for (int i =0; i<sectorObjectsFunction.size(); i++)
        {
            Sector sectorObject = sectorObjectsFunction.get(i);
            sectors.add(sectorObject.getName().toString());
            Log.d("Sector Name", sectorObject.getName().toString());
        }

        return sectors;
    }
    public  ArrayList<String> getCountries ()
    {
        if(countryObjectsFunction != null)
        {
            countryObjectsFunction.clear();
        }
        countryObjectsFunction = getCountryObject();
        ArrayList<String> countries = new ArrayList<String>();
        for (int i =0; i<countryObjectsFunction.size(); i++)
        {
            Country countryObject = countryObjectsFunction.get(i);
            countries.add(countryObject.getName());
        }


        return countries;
    }
    public  ArrayList<String> getCells (String sectorName)
    {
        int sectorNumber = getSectorNumber(sectorName);

        if(cellObjectsFunction != null)
        {
            cellObjectsFunction.clear();
        }
        cellObjectsFunction = getCellObject(sectorNumber);
        ArrayList<String> cells = new ArrayList<String>();
        for (int i =0; i<cellObjectsFunction.size(); i++)
        {
            Cell cellObject = cellObjectsFunction.get(i);
            cells.add(cellObject.getName());
        }

        return cells;
    }
    public  ArrayList<String> getVillages (String cellName)
    {
        int cellNumber = getCellNumber(cellName);
        if(villageObjectsFunction != null)
        {
            villageObjectsFunction.clear();
        }
        villageObjectsFunction= getVillageObject(cellNumber);

        ArrayList<String> villages = new ArrayList<String>();
        for (int i =0; i<villageObjectsFunction.size(); i++)
        {
            Village villageObject = villageObjectsFunction.get(i);
            villages.add(villageObject.getName());
            Log.d("Village Name", villageObject.getName().toString());
        }

        return villages;
    }
    public  ArrayList<String> getHospitals ()
    {
        ArrayList<Hospital> hospitalObjects = getHospitalObject();
        ArrayList<String> hospitals = new ArrayList<String>();
        for (int i =0; i<hospitalObjects.size(); i++)
        {
            Hospital hospitalObject = hospitalObjects.get(i);
            hospitals.add(hospitalObject.getName());
        }

        return hospitals;
    }
    public  ArrayList<String> getHealthCenters (String districtName)
    {
        int districtNumber = getDistrictNumber(districtName);
        if (healthCenterObjects1!=null)
        {
            healthCenterObjects1.clear();
        }
        healthCenterObjects1 = getHealthCenterObject(districtNumber);
        ArrayList<String> healthCenters = new ArrayList<String>();

        for (int i =0; i<healthCenterObjects1.size(); i++)
        {
            HealthCenter healthCenterObject = healthCenterObjects1.get(i);
            healthCenters.add(healthCenterObject.getName());
        }

        return healthCenters;
    }
    public static boolean doesDatabaseExist(ContextWrapper context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }

    public int getCountryId (String countryName)
    {
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int selectedId = 0;
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                if (name.trim().equals(countryName))
                {
                    int id = cursor.getInt(2);
                    selectedId = id;
                    break;
                }


            } while (cursor.moveToNext());
        }
        //db.close();
        return selectedId;
    }
    public int getDistrictId (String districtName)
    {
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME3;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int selectedId = 0;

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                if (name.trim().equals(districtName))
                {
                    int id = cursor.getInt(2);
                    selectedId = id;
                    break;
                }



            } while (cursor.moveToNext());
        }
        //db.close();
        return selectedId;
    }

    public int getSectorId (String sectorName)
    {
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME4;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int selectedId = 0;
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                if(name.trim().equals(sectorName))
                {
                    int id = cursor.getInt(2);
                    selectedId = id;
                    break;
                }






            } while (cursor.moveToNext());
        }
        //db.close();
        return selectedId;
    }
    public int getCellId (String cellName)
    {
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME5;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int selectedId = 0;

        if (cursor.moveToFirst()) {
            do {

                String name = cursor.getString(1);
                if (name.trim().equals(cellName))
                {
                    int id = cursor.getInt(2);
                    selectedId = id;
                    break;
                }






            } while (cursor.moveToNext());
        }
        //db.close();
        return selectedId;
    }
    public int getVillageId (String villageName)
    {
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME6;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int selectedId = 0;

        if (cursor.moveToFirst()) {
            do {

                String name = cursor.getString(1);
                if (name.trim().equals(villageName))
                {
                    int id = cursor.getInt(2);
                    selectedId = id;
                    break;
                }



            } while (cursor.moveToNext());
        }
        //db.close();
        return selectedId;
    }
    public int getHospitalId (String hospitalName)
    {
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME7;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int selectedId = 0;

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                if (name.trim().equals(hospitalName))
                {
                    int id = cursor.getInt(2);
                    selectedId = id;
                    break;
                }






            } while (cursor.moveToNext());
        }
        //db.close();
        return selectedId;
    }

    public int getHealthCenterId (String healthCenterName)
    {
        String selectQuery = "SELECT  * FROM " +  TABLE_NAME8;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        int selectedId = 0;

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                if (name.trim().equals(healthCenterName))
                {
                    int id = cursor.getInt(2);
                    selectedId = id;
                    break;
                }


            } while (cursor.moveToNext());
        }
        //db.close();
              return selectedId;
        }
        }
