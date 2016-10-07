package com.example.tmutabazi.rbc.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tmutabazi.rbc.Database.Database;
import com.example.tmutabazi.rbc.R;

import java.util.ArrayList;


public class PermanentAddress extends ActionBarActivity {

    ArrayList<String> districtNames;
    ArrayList<String> sectorNames;
    ArrayList<String> cellNames;
    ArrayList<String> villageNames;
    Database db = new Database(this);
    Button next;
    String activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permanent_address);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("Permanent Address");
        Intent intent = getIntent();
        activity = intent.getStringExtra("Activity");
        districtNames = new ArrayList<String>();
        sectorNames = new ArrayList<String>();
        cellNames = new ArrayList<String>();
        villageNames = new ArrayList<String>();
        districtNames = db.getDistricts();
        districtNames.add(0,"Select District");
        final Spinner sp = (Spinner) findViewById(R.id.permanentDistrict);
        final Spinner sp1 = (Spinner) findViewById(R.id.permanentSector);
        final Spinner sp2 = (Spinner) findViewById(R.id.permanentCell);
        final Spinner sp3 = (Spinner) findViewById(R.id.permanenVillage);
        final ArrayAdapter<String> adp1=new ArrayAdapter<String>(this, R.layout.spinner,districtNames);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adp1);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0) {
                    sp1.setEnabled(false);
                    sp2.setEnabled(false);
                    sp3.setEnabled(false);
                    sp1.setAdapter(null);
                    sp2.setAdapter(null);
                    sp3.setAdapter(null);
                } else {
                    String itemSelectedSector = sp.getSelectedItem().toString();
                    // int districtNumber = db.getDistrictNumber(itemSelected);

                    if(sectorNames.isEmpty())
                    {
                        Toast.makeText(getBaseContext(), itemSelectedSector, Toast.LENGTH_SHORT).show();
                        sectorNames = db.getSectors(itemSelectedSector);
                        sectorNames.add(0, "Select One");
                        final ArrayAdapter<String> adp2 = setAdapterNow(sectorNames);
                        adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        sp1.setAdapter(adp2);
                        sp1.setEnabled(true);
                        sp2.setEnabled(false);
                        sp3.setEnabled(false);
                        sp2.setAdapter(null);
                        sp3.setAdapter(null);
                    }
                    else
                    {

                        sectorNames = new ArrayList<String>();
                        sectorNames = db.getSectors(itemSelectedSector);
                        sectorNames.add(0, "Select One");
                        final ArrayAdapter<String> adp2 = setAdapterNow(sectorNames);
                        adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        sp1.setAdapter(adp2);
                        sp2.setEnabled(false);
                        sp3.setEnabled(false);
                        sp2.setAdapter(null);
                        sp3.setAdapter(null);
                    }



                    sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            if (position == 0) {

                                sp2.setEnabled(false);
                                sp3.setEnabled(false);
                                sp2.setAdapter(null);
                                sp3.setAdapter(null);

                            } else {

                                String itemSelected = sp1.getSelectedItem().toString();
                                if(cellNames.isEmpty()) {
                                    cellNames = db.getCells(itemSelected);
                                    cellNames.add(0, "Select One");
                                    final ArrayAdapter<String> adp2 = setAdapterNow(cellNames);
                                    sp2.setAdapter(adp2);
                                    sp2.setEnabled(true);

                                }
                                else
                                {
                                    cellNames = new ArrayList<String>();
                                    cellNames = db.getCells(itemSelected);
                                    cellNames.add(0, "Select One");
                                    final ArrayAdapter<String> adp2 = setAdapterNow(cellNames);
                                    sp2.setAdapter(adp2);
                                }
                                sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                        if (position == 0) {


                                        } else {
                                            String itemSelected = sp2.getSelectedItem().toString();
                                            //int cellID = db.getCellNumber(itemSelected);
                                            if(villageNames.isEmpty()) {
                                                villageNames = db.getVillages(itemSelected);
                                                villageNames.add(0, "Select Village");
                                                final ArrayAdapter<String> adp3 = setAdapterNow(villageNames);
                                                sp3.setAdapter(adp3);
                                                sp3.setEnabled(true);
                                            }
                                            else
                                            {
                                                villageNames = new ArrayList<String>();
                                                villageNames = db.getVillages(itemSelected);
                                                villageNames.add(0, "Select Village");
                                                final ArrayAdapter<String> adp3 = setAdapterNow(villageNames);
                                                sp3.setAdapter(adp3);
                                            }
                                            sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    if (position == 0) {

                                                    } else {
                                                        String itemSelected = sp3.getSelectedItem().toString();

                                                    }
                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onNothingSelected(AdapterView<?> parent) {

                                    }
                                });


                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        next = (Button) findViewById(R.id.button3);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (activity.equals("notification2"))
                {
                    Intent ip = new Intent(PermanentAddress.this, NotificationForm3.class);
                    startActivity(ip);
                }
                else
                {
                    Intent ip = new Intent(PermanentAddress.this, addFOCI.class);
                    ip.putExtra("district", sp.getSelectedItem().toString());
                    startActivity(ip);
                }



            }
        });

    }

    public ArrayAdapter<String> setAdapterNow (ArrayList<String> arrayList)    {
        final ArrayAdapter<String> adp1=new ArrayAdapter<String>(this, R.layout.spinner,arrayList);

        return adp1;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_permanent_address, menu);
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