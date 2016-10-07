package com.example.smanzi.rbc.UI;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmutabazi.rbc.Database.Database;
import com.example.tmutabazi.rbc.JsonHelperClasses.Cell;
import com.example.tmutabazi.rbc.JsonHelperClasses.Country;
import com.example.tmutabazi.rbc.JsonHelperClasses.District;
import com.example.tmutabazi.rbc.JsonHelperClasses.HealthCenter;
import com.example.tmutabazi.rbc.JsonHelperClasses.Hospital;
import com.example.tmutabazi.rbc.JsonHelperClasses.Province;
import com.example.tmutabazi.rbc.JsonHelperClasses.Sector;
import com.example.tmutabazi.rbc.JsonHelperClasses.StaticArrayLists;
import com.example.tmutabazi.rbc.JsonHelperClasses.Village;
import com.example.tmutabazi.rbc.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ParseJsonFile extends ActionBarActivity {

    private TextView countryText;
    private InputStream input1;
    private String result = null;
    private ArrayList<Country> countryObjects = new ArrayList<Country>();
    private ArrayList<Province> provinceObjects = new ArrayList<Province>();
    private ArrayList<District> districtObjects = new ArrayList<District>();
    private ArrayList<Sector> sectorObjects = new ArrayList<Sector>();
    private ArrayList<Cell> cellObjects = new ArrayList<Cell>();
    private ArrayList<Village> villageObjects = new ArrayList<Village>();
    private ArrayList<Hospital> hospitalObjects = new ArrayList<Hospital>();
    private ArrayList<HealthCenter> healthCenterObjects = new ArrayList<HealthCenter>();
    Database database = new Database(this);
    ProgressDialog progressDialog;
    Boolean answer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_json_file);
        countryText= (TextView) findViewById(R.id.textView13);

        answer = database.doesDatabaseExist(this,"locationDataDB.db");

        if(answer.equals(false))
        {
            new RetrieveDataFromDB().execute();
        }

        //ArrayList <HealthCenter> country= database.getHealthCenterObject();
        //displayHealthCenterObject(country);
        // int districtNumber = database.getDistrictNumber("Nyarugenge");


        // ArrayList<HealthCenter> sector = database.getHealthCenterObject(districtNumber);
        // displayHealthCenterObject(sector);


    }




    public void displaySectorObject (ArrayList<Sector> sector)
    {
        String text ="";
        for (int i =0; i<sector.size(); i++)
        {
            Sector sectorObject = sector.get(i);
            String name = sectorObject.getName();
            text+= name;
            text+= " ";
            int id = sectorObject.getId();
            text+= ""+id;
            text+= " ";
            text+= " ";
            text+= " ";
            int sectorNumber = sectorObject.getSectorNumber();
            text+= ""+sectorNumber;
            text+= " ";
            text+= " ";
            text+= " ";
            int districtId = sectorObject.getDistrictId();
            text+= ""+districtId;
            text+= " ";
            text+= " ";
            text+= " ";
            int provinceId = sectorObject.getProvinceId();
            text+= ""+provinceId;
            text+= " ";
            text+= " ";
            text+= " ";
            int countryId = sectorObject.getCountryId();
            text+= ""+countryId;

            text+= "\n";

        }

        countryText.setText(text);
    }


    public void displayDistrictObject (ArrayList<District> district)
    {
        String text ="";
        for (int i =0; i<district.size(); i++)
        {
            District districtObject = district.get(i);
            String name = districtObject.getName();
            text+= name;
            text+= " ";
            int id = districtObject.getId();
            text+= ""+id;
            text+= " ";
            text+= " ";
            text+= " ";
            /**
             int sectorId = cellObject.getSectorId();
             text+= ""+sectorId;
             text+= " ";
             text+= " ";
             text+= " ";
             int districtId = cellObject.getDistrictId();
             text+= ""+districtId;
             text+= " ";
             text+= " ";
             text+= " ";**/
            int districtNumber = districtObject.getDistrictNumber();
            text+= ""+districtNumber;
            text+= " ";
            text+= " ";
            text+= " ";
            int provinceId = districtObject.getProvinceId();
            text+= ""+provinceId;
            text+= " ";
            text+= " ";
            text+= " ";
            int countryId = districtObject.getCountryId();
            text+= ""+countryId;

            text+= "\n";

        }

        countryText.setText(text);
    }
    public void displayCountryObject (ArrayList<Country> country)
    {
        String text ="";
        for (int i =0; i<country.size(); i++)
        {
            Country countryObject = country.get(i);
            String name = countryObject.getName();
            text+= name;
            text+= " ";
            int id = countryObject.getId();
            text+= ""+id;
            text+= " ";
            text+= " ";
            text+= " ";
            /**
             int sectorId = cellObject.getSectorId();
             text+= ""+sectorId;
             text+= " ";
             text+= " ";
             text+= " ";
             int districtId = cellObject.getDistrictId();
             text+= ""+districtId;
             text+= " ";
             text+= " ";
             text+= " ";**/
            int countryNumber = countryObject.getCountryNumber();
            text+= ""+countryNumber;


            text+= "\n";

        }

        countryText.setText(text);
    }
    public void displayProvinceObject (ArrayList<Province> province)
    {
        String text ="";
        for (int i =0; i<province.size(); i++)
        {
            Province provinceObject = province.get(i);
            String name = provinceObject.getName();
            text+= name;
            text+= " ";
            int id = provinceObject.getId();
            text+= ""+id;
            text+= " ";
            text+= " ";
            text+= " ";
            /**
             int sectorId = cellObject.getSectorId();
             text+= ""+sectorId;
             text+= " ";
             text+= " ";
             text+= " ";
             int districtId = cellObject.getDistrictId();
             text+= ""+districtId;
             text+= " ";
             text+= " ";
             text+= " ";**/
            int provinceNumber = provinceObject.getProvinceNumber();
            text+= ""+provinceNumber;
            text+= " ";
            text+= " ";
            text+= " ";
            int countryId = provinceObject.getCountryId();
            text+= ""+countryId;
            text+= "\n";

        }

        countryText.setText(text);
    }
    public void displayCellObject (ArrayList<Cell> cell)
    {
        String text ="";
        for (int i =0; i<cell.size(); i++)
        {
            Cell cellObject = cell.get(i);
            String name = cellObject.getName();
            text+= name;
            text+= " ";
            int id =  cellObject.getId();
            text+= ""+id;
            text+= " ";
            text+= " ";
            text+= " ";
            int cellNumber = cellObject.getCellNumber();
            text+= ""+cellNumber;
            text+= " ";
            text+= " ";
            text+= " ";
            int sectorId = cellObject.getSectorId();
            text+= ""+sectorId;
            text+= " ";
            text+= " ";
            text+= " ";
            int districtId = cellObject.getDistrictId();
            text+= ""+districtId;
            text+= " ";
            text+= " ";
            text+= " ";
            int provinceId = cellObject.getProvinceId();
            text+= ""+provinceId;
            text+= " ";
            text+= " ";
            text+= " ";
            int countryId = cellObject.getCountryId();
            text+= ""+countryId;

            text+= "\n";

        }

        countryText.setText(text);
    }
    public void displayVillageObject (ArrayList<Village> village)
    {
        String text ="";
        for (int i =0; i<village.size(); i++)
        {
            Village villageObject = village.get(i);
            String name = villageObject.getName();
            text+= name;
            text+= " ";
            int id =  villageObject.getId();
            text+= ""+id;
            text+= " ";
            text+= " ";
            text+= " ";
            int villageNumber = villageObject.getVillageNumber();
            text+= ""+villageNumber;
            text+= " ";
            text+= " ";
            text+= " ";
            int cellId = villageObject.getCellId();
            text+= ""+cellId;
            text+= " ";
            text+= " ";
            text+= " ";
            int sectorId = villageObject.getSectorId();
            text+= ""+sectorId;
            text+= " ";
            text+= " ";
            text+= " ";
            int districtId = villageObject.getDistrictId();
            text+= ""+districtId;
            text+= " ";
            text+= " ";
            text+= " ";
            int provinceId = villageObject.getProvinceId();
            text+= ""+provinceId;
            text+= " ";
            text+= " ";
            text+= " ";
            int countryId = villageObject.getCountryId();
            text+= ""+countryId;

            text+= "\n";

        }

        countryText.setText(text);
    }
    public void displayHospitalObject (ArrayList<Hospital> hospital)
    {
        String text ="";
        for (int i =0; i<hospital.size(); i++)
        {
            Hospital hospitalObject = hospital.get(i);
            String name = hospitalObject.getName();
            text+= name;
            text+= " ";
            int id = hospitalObject.getId();
            text+= ""+id;
            text+= " ";
            text+= " ";
            text+= " ";
            int facilityId = hospitalObject.getFacilityId();
            text+= ""+facilityId;
            text+= " ";
            text+= " ";
            text+= " ";
            int districtId = hospitalObject.getDistrictId();
            text+= ""+districtId;
            text+= " ";
            text+= " ";
            text+= " ";
            int provinceId = hospitalObject.getProvinceId();
            text+= ""+provinceId;
            text+= " ";
            text+= " ";
            text+= " ";
            int countryId = hospitalObject.getCountryId();
            text+= ""+countryId;

            text+= "\n";

        }

        countryText.setText(text);
    }

    public void displayHealthCenterObject (ArrayList<HealthCenter> healthCenter)
    {
        String text ="";
        for (int i =0; i<healthCenter.size(); i++)
        {
            HealthCenter healthCenterObject = healthCenter.get(i);
            String name = healthCenterObject.getName();
            text+= name;
            text+= " ";
            int id = healthCenterObject.getId();
            text+= ""+id;
            text+= " ";
            text+= " ";
            text+= " ";
            int facilityId = healthCenterObject.getFacilityId();
            text+= ""+facilityId;
            text+= " ";
            text+= " ";
            text+= " ";
            int hospitalId = healthCenterObject.getHospitalId();
            text+= ""+hospitalId;
            text+= " ";
            text+= " ";
            text+= " ";
            int districtId = healthCenterObject.getDistrictId();
            text+= ""+districtId;
            text+= " ";
            text+= " ";
            text+= " ";
            int provinceId = healthCenterObject.getProvinceId();
            text+= ""+provinceId;
            text+= " ";
            text+= " ";
            text+= " ";
            int countryId = healthCenterObject.getCountryId();
            text+= ""+countryId;

            text+= "\n";

        }

        countryText.setText(text);
    }
    public void displayId (int id)
    {
        countryText.setText(""+id);
    }

    class RetrieveDataFromDB extends AsyncTask<Void, Void, Void>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(ParseJsonFile.this, "Installing", "Downloading...");
        }

        protected Void doInBackground(Void... params) {





            String url_to_use = "http://www.rwanda.byethost12.com/Json.txt";
            HttpClient clientVariable = new DefaultHttpClient();
            HttpPost postVariable = new HttpPost(url_to_use);
            List<NameValuePair> valuePair = new ArrayList<NameValuePair>();
            try
            {
                postVariable.setEntity(new UrlEncodedFormEntity(valuePair));
                HttpResponse resp = clientVariable.execute(postVariable);
                HttpEntity entity = resp.getEntity();
                input1 = entity.getContent();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            try
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(input1));
                StringBuilder buffer = new StringBuilder();
                String line;
                while ((line =br.readLine())!= null)
                {
                    buffer.append(line);
                    buffer.append("\n");
                }
                input1.close();
                result = buffer.toString();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {




            //displayDistrictObject(district);



            //String testing = null;
            try {
                JSONArray array = new JSONArray(result);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    String type = jsonObject.getString("type");

                    if (type.trim().equals("Country")) {
                        Country country = new Country();
                        String name = jsonObject.getString("name");
                        country.setName(name);
                        String Id = jsonObject.getString("id");
                        int id = Integer.parseInt(Id);
                        country.setId(id);
                        String countryNumber = jsonObject.getString("country");
                        int countryNumber1 = Integer.parseInt(countryNumber);
                        country.setCountryNumber(countryNumber1);
                        countryObjects.add(country);

                    } else if (type.trim().equals("Province")) {
                        Province province = new Province();
                        String name = jsonObject.getString("name");
                        province.setName(name);
                        String Id = jsonObject.getString("id");
                        int id = Integer.parseInt(Id);
                        province.setId(id);
                        String provinceNumber = jsonObject.getString("province");
                        int provinceNumber1= Integer.parseInt(provinceNumber);
                        province.setProvinceNumber(provinceNumber1);
                        String countryId = jsonObject.getString("country");
                        int countryId1 = Integer.parseInt(countryId);
                        province.setCountryId(countryId1);
                        provinceObjects.add(province);


                    } else if (type.trim().equals("District")) {
                        District district = new District();
                        String name = jsonObject.getString("name");
                        district.setName(name);
                        String Id = jsonObject.getString("id");
                        int id = Integer.parseInt(Id);
                        district.setId(id);
                        String districtNumber = jsonObject.getString("district");
                        int districtNumber1 = Integer.parseInt(districtNumber);
                        district.setDistrictNumber(districtNumber1);

                        String provinceId = jsonObject.getString("province");
                        int provinceId1 = Integer.parseInt(provinceId);
                        district.setProvinceId(provinceId1);
                        String countryId = jsonObject.getString("country");
                        int countryId1 = Integer.parseInt(countryId);
                        district.setCountryId(countryId1);
                        districtObjects.add(district);


                    } else if (type.trim().equals("Sector")) {
                        Sector sector = new Sector();
                        String name = jsonObject.getString("name");
                        sector.setName(name);
                        String Id = jsonObject.getString("id");
                        int id = Integer.parseInt(Id);
                        sector.setId(id);
                        String sectorNumber = jsonObject.getString("sector");
                        int sectorNumber1 = Integer.parseInt(sectorNumber );
                        sector.setSectorNumber(sectorNumber1);
                        String districtId = jsonObject.getString("district");
                        int districtId1 = Integer.parseInt(districtId);
                        sector.setDistrictId(districtId1);
                        String provinceId = jsonObject.getString("province");
                        int provinceId1 = Integer.parseInt(provinceId);
                        sector.setProvinceId(provinceId1);
                        String countryId = jsonObject.getString("country");
                        int countryId1 = Integer.parseInt(countryId);
                        sector.setCountryId(countryId1);
                        sectorObjects.add(sector);

                    } else if (type.trim().equals("Cell")) {
                        Cell cell = new Cell();
                        String name = jsonObject.getString("name");
                        cell.setName(name);
                        String Id = jsonObject.getString("id");
                        int id = Integer.parseInt(Id);
                        cell.setId(id);
                        String cellNumber = jsonObject.getString("cell");
                        int cellNumber1 = Integer.parseInt(cellNumber);
                        cell.setCellNumber(cellNumber1);
                        String sectorId = jsonObject.getString("sector");
                        int sectorId1 = Integer.parseInt(sectorId);
                        cell.setSectorId(sectorId1);
                        String districtId = jsonObject.getString("district");
                        int districtId1 = Integer.parseInt(districtId);
                        cell.setDistrictId(districtId1);
                        String provinceId = jsonObject.getString("province");
                        int provinceId1 = Integer.parseInt(provinceId);
                        cell.setProvinceId(provinceId1);
                        String countryId = jsonObject.getString("country");
                        int countryId1 = Integer.parseInt(countryId);
                        cell.setCountryId(countryId1);
                        cellObjects.add(cell);


                    } else if (type.trim().equals("Village")) {
                        Village village = new Village();
                        String name = jsonObject.getString("name");
                        village.setName(name);
                        String Id = jsonObject.getString("id");
                        int id = Integer.parseInt(Id);
                        village.setId(id);
                        String villageNumber = jsonObject.getString("village");
                        int villageNumber1 = Integer.parseInt(villageNumber);
                        village.setVillageNumber(villageNumber1);
                        String cellId = jsonObject.getString("cell");
                        int cellId1 = Integer.parseInt(cellId);
                        village.setCellId(cellId1);
                        String sectorId = jsonObject.getString("sector");
                        int sectorId1 = Integer.parseInt(sectorId);
                        village.setSectorId(sectorId1);
                        String districtId = jsonObject.getString("district");
                        int districtId1 = Integer.parseInt(districtId);
                        village.setDistrictId(districtId1);
                        String provinceId = jsonObject.getString("province");
                        int provinceId1 = Integer.parseInt(provinceId);
                        village.setProvinceId(provinceId1);
                        String countryId = jsonObject.getString("country");
                        int countryId1 = Integer.parseInt(countryId);
                        village.setCountryId(countryId1);
                        villageObjects.add(village);

                    } else if (type.trim().equals("Hospital")) {
                        Hospital hospital = new Hospital();
                        String name = jsonObject.getString("name");
                        hospital.setName(name);
                        String Id = jsonObject.getString("id");
                        int id = Integer.parseInt(Id);
                        hospital.setId(id);
                        String facilityId = jsonObject.getString("facility");
                        int facilityId1 = Integer.parseInt(facilityId);
                        hospital.setFacilityId(facilityId1);
                        String districtId = jsonObject.getString("district");
                        int districtId1 = Integer.parseInt(districtId);
                        hospital.setDistrictId(districtId1);
                        String provinceId = jsonObject.getString("province");
                        int provinceId1 = Integer.parseInt(provinceId);
                        hospital.setProvinceId(provinceId1);
                        String countryId = jsonObject.getString("country");
                        int countryId2 = Integer.parseInt(countryId);
                        hospital.setCountryId(countryId2);
                        hospitalObjects.add(hospital);


                    } else if (type.trim().equals("HealthCenter")) {
                        HealthCenter healthCenter = new HealthCenter();
                        String name = jsonObject.getString("name");
                        healthCenter.setName(name);
                        String Id = jsonObject.getString("id");
                        int id = Integer.parseInt(Id);
                        healthCenter.setId(id);
                        String hospitalId = jsonObject.getString("hospital");

                        if (hospitalId != "null") {
                            int hospitalId1 = Integer.parseInt(hospitalId);
                            healthCenter.setHospitalId(hospitalId1);
                        }


                        String districtId = jsonObject.getString("district");
                        int districtId1 = Integer.parseInt(districtId);
                        healthCenter.setDistrictId(districtId1);
                        String provinceId = jsonObject.getString("province");
                        int provinceId1 = Integer.parseInt(provinceId);
                        healthCenter.setProvinceId(provinceId1);
                        String countryId = jsonObject.getString("country");
                        int countryId2 = Integer.parseInt(countryId);
                        healthCenter.setCountryId(countryId2);
                        healthCenterObjects.add(healthCenter);

                    }
                }



                // set arrayLists
                StaticArrayLists.setCountryObjects(countryObjects);
                StaticArrayLists.setDistrictObjects(districtObjects);
                StaticArrayLists.setProvinceObjects(provinceObjects);
                StaticArrayLists.setSectorObjects(sectorObjects);
                StaticArrayLists.setCellObjects(cellObjects);
                StaticArrayLists.setVillageObjects(villageObjects);
                StaticArrayLists.setHospitalObjects(hospitalObjects);
                StaticArrayLists.setHealthCenterObjects(healthCenterObjects);
                // call database functions
                database.insertCountryObject();
                database.insertProvinceObject();
                database.insertDistrictObject();
                database.insertSectorObjects();
                database.insertCellObject();
                database.insertVillageObject();
                database.insertHospitalObject();
                database.insertHealthCenterObject();


                String message = "Excellent";
                Toast.makeText(getApplicationContext(),

                        message,

                        Toast.LENGTH_SHORT).show();

                Intent ip = new Intent(ParseJsonFile.this, Dispatcher.class);
                startActivity(ip);
                finish();
            }
            catch (JSONException e) {
                e.printStackTrace();
                String message = "Something went wrong";
                Toast.makeText(getApplicationContext(),

                        message,

                        Toast.LENGTH_SHORT).show();

            }


        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_parse_json_file, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
