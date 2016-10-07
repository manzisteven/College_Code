package com.example.smanzi.rbc.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;


import com.example.tmutabazi.rbc.InvestigationClass.InvestigationClass;

import com.example.tmutabazi.rbc.R;


import java.util.Calendar;
import java.util.TimeZone;


public class InvestigationForm4 extends ActionBarActivity implements View.OnClickListener{
    private Spinner one;
    private Spinner two;
    private Button next;

    private EditText numberOfLLins;
    private EditText date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investigation_form4);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("INVESTIGATION FORM    4 OUT OF 6");
        one = (Spinner)findViewById(R.id.spinner3);
        two = (Spinner)findViewById(R.id.spinner4);
        one.setAdapter(ArrayAdapter.createFromResource(this, R.array.RDTS, R.layout.spinner2));
        two.setAdapter(ArrayAdapter.createFromResource(this, R.array.TreatmentOptions, R.layout.spinner3));
        next = (Button) findViewById(R.id.button4);

        numberOfLLins = (EditText) findViewById(R.id.numberofLLINS);
        date = (EditText) findViewById(R.id.last_indoor);
        date.setOnClickListener(this);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InvestigationClass investigation = populateObject();
                Intent ip = new Intent(InvestigationForm4.this, InvestigationForm5.class);
                ip.putExtra("myObject", investigation);
                startActivity(ip);

            }
        });

    }
    public InvestigationClass populateObject ()
    {
        Intent intent = getIntent();
        InvestigationClass investigation = (InvestigationClass) intent.getSerializableExtra("myObject");
        String last_indoor = date.getText().toString();
        investigation.setLast_indoor(last_indoor);
        String numberOfLlins1 = numberOfLLins.getText().toString();
        int  numberOfLlins2 = Integer.parseInt(numberOfLlins1);
        investigation.setNumberOfLLINS(numberOfLlins2 );
        String rdtResult =  (one.getSelectedItem().toString());
        investigation.setRdtResult(rdtResult);
        return investigation;
    }
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);




        DatePickerDialog datePicker=new DatePickerDialog(InvestigationForm4.this, new DatePickerDialog.OnDateSetListener() {
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
        getMenuInflater().inflate(R.menu.menu_investigation_form4, menu);
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
