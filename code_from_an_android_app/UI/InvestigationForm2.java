package com.example.smanzi.rbc.UI;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.tmutabazi.rbc.Database.Database;
import com.example.tmutabazi.rbc.InvestigationClass.InvestigationClass;

import com.example.tmutabazi.rbc.JsonHelperClasses.Village;
import com.example.tmutabazi.rbc.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;


public class InvestigationForm2 extends ActionBarActivity implements View.OnClickListener{
    private Button next;
    private RadioGroup isPregnant;
    private RadioButton isPregnantRadioButton;
    private EditText headHouseHold;
    private EditText idNumber;
    private EditText telephoneNumber;
    private Spinner residentialDistrict;
    private Spinner sector;
    private Spinner cell;
    private Spinner village;
    private Database database = new Database(this);
    private ArrayList<String> sectors;
    private EditText date;
    private int districtIdGlobal;
    private int sectorIdGlobal;
    private int cellIdGlobal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investigation_form2);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("INVESTIGATION FORM    2 OUT OF 6");
        next = (Button) findViewById(R.id.button2);
        isPregnant = (RadioGroup) findViewById(R.id.isPregnant);
        headHouseHold = (EditText) findViewById(R.id.headOfHouseholdName);
        idNumber = (EditText) findViewById(R.id.IDnumber);
        idNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        telephoneNumber = (EditText) findViewById(R.id.telephoneNumber);
        telephoneNumber.setInputType(InputType.TYPE_CLASS_NUMBER);

        date = (EditText) findViewById(R.id.dateOfbirth);
        date.setOnClickListener(this);
        residentialDistrict = (Spinner)findViewById(R.id.residentialDistrict);
        //residentialDistrict.setAdapter(ArrayAdapter.createFromResource(this, R.array.district, R.layout.fat_spinner_entry));
        sector = (Spinner)findViewById(R.id.sector);
        village = (Spinner)findViewById(R.id.villageSpinner);
        cell = (Spinner)findViewById(R.id.cell);

        ArrayList<String> districts = database.getDistricts();
        districts.add(0, "Select One");
        final ArrayAdapter<String> adp1=new ArrayAdapter<String>(this, R.layout.spinner,districts);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        residentialDistrict.setAdapter(adp1);
        residentialDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (position == 0) {
                    sector.setEnabled(false);
                    cell.setEnabled(false);
                    village.setEnabled(false);

                } else {




                    sector.setEnabled(true);
                    String selectedDistrict = residentialDistrict.getSelectedItem().toString();
                    int districtId = database.getDistrictId(selectedDistrict);
                    districtIdGlobal = districtId;
                    sectors = database.getSectors(selectedDistrict);
                    sectors.add(0, "Select One");
                    final ArrayAdapter<String> adp2 = getAdapter(sectors);
                    adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sector.setAdapter(adp2);
                    sector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            if(position == 0)
                            {

                            }
                            else
                            {
                                cell.setEnabled(true);
                                String selectedSector =  sector.getSelectedItem().toString();
                                int sectorId = database.getSectorId(selectedSector);
                                sectorIdGlobal = sectorId;
                                ArrayList<String> cells = database.getCells(selectedSector);
                                cells.add(0, "Select One");
                                final ArrayAdapter<String> adp3 = getAdapter(cells);
                                adp3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                cell.setAdapter(adp3);
                                cell.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                    @Override
                                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                        if (position == 0) {

                                        } else {
                                            village.setEnabled(true);
                                            String selectedCell = cell.getSelectedItem().toString();
                                            int cellId = database.getCellId(selectedCell);
                                            cellIdGlobal = cellId;
                                            ArrayList<String> villages = database.getVillages(selectedCell);
                                            villages.add(0, "Select One");
                                            final ArrayAdapter<String> adp4 = getAdapter(villages);
                                            adp4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                            village.setAdapter(adp4);
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
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InvestigationClass investigation = populateObject();
                Intent ip = new Intent(InvestigationForm2.this, InvestigationForm3.class);
                ip.putExtra("myObject", investigation);
                startActivity(ip);






            }
        });
    }

    public ArrayAdapter<String> getAdapter (ArrayList<String> sectors)
    {
        final ArrayAdapter<String> adp1=new ArrayAdapter<String>(this, R.layout.spinner,sectors);

        return adp1;
    }
    public InvestigationClass populateObject ()
    {
        Intent intent = getIntent();
        InvestigationClass investigation = (InvestigationClass) intent.getSerializableExtra("myObject");
        int selected_id = isPregnant.getCheckedRadioButtonId();
        isPregnantRadioButton = (RadioButton) findViewById( selected_id);
        String radioButtonText = isPregnantRadioButton.getText().toString();
        investigation.setIsPregnant(radioButtonText);
        String headHousehold1 = headHouseHold.getText().toString();
        investigation.setHeadOfHousehold(headHousehold1);
        String idNumber1 = idNumber.getText().toString();
        investigation.setIdNumber(idNumber1);
        return investigation;
    }
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);




        DatePickerDialog datePicker=new DatePickerDialog(InvestigationForm2.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                date.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
            }
        }, year, month, day);
        datePicker.show();




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_investigation_form2, menu);
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
