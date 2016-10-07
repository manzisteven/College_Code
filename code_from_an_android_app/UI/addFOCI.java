package com.example.tmutabazi.rbc.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tmutabazi.rbc.Database.Database;
import com.example.tmutabazi.rbc.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;


public class addFOCI extends ActionBarActivity implements View.OnClickListener {

    Button next;
    EditText dateFoci;
    EditText classificationDate;
    Spinner healthFacility;
    ArrayList<String> facilityNames;
    Database db = new Database(this);
    String district;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_foci);

        Intent ip = getIntent();
        district = ip.getStringExtra("district");

        dateFoci = (EditText) findViewById(R.id.report_date);
        classificationDate = (EditText) findViewById(R.id.dateOfClassification);
        healthFacility = (Spinner) findViewById(R.id.healthyfacilitynames);
        dateFoci.setOnClickListener(this);
        classificationDate.setOnClickListener(this);
        facilityNames = new ArrayList<String>();
        facilityNames = db.getHealthCenters(district);
        facilityNames.add(0, "Select One");
        final ArrayAdapter<String> adp1= setAdapterNow(facilityNames);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        healthFacility.setAdapter(adp1);
        healthFacility.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0)
                {

                }
                else
                {
                    String itemSelected =  healthFacility.getSelectedItem().toString();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        next=(Button)  findViewById(R.id.nextFoci);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                Intent ip = new Intent(addFOCI.this, Dispatcher.class);
                ip.putExtra("Activity", "addFoci");
                startActivity(ip);
            }
        });
    }


    public void onClick(final View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        DatePickerDialog datePicker=new DatePickerDialog(addFOCI.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                switch (v.getId()) {
                    case R.id.report_date:
                        dateFoci.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                        break;
                    case R.id.dateOfClassification:
                        classificationDate.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                        break;

                    //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                }
            }
        }, year, month, day);
        datePicker.show();




    }
    public ArrayAdapter<String> setAdapterNow (ArrayList<String> arrayList)    {
        final ArrayAdapter<String> adp1=new ArrayAdapter<String>(this, R.layout.spinner,arrayList);
        return adp1;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_foci, menu);
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