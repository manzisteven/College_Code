package com.example.smanzi.rbc.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.tmutabazi.rbc.InvestigationClass.InvestigationClass;

import com.example.tmutabazi.rbc.R;

import java.util.Calendar;
import java.util.TimeZone;


public class InvestigationForm6 extends ActionBarActivity implements View.OnClickListener {

    private EditText date1;
    private EditText date2;
    private EditText date3;
    private EditText date4;
    private EditText  completedBy;
    private EditText completedDesignation;
    private EditText completedDate;
    private EditText verifiedBy;
    private EditText verifiedDesignation;
    private EditText verifiedDate;
    private Button submit;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investigation_form6);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("INVESTIGATION FORM    6 OUT OF 6");
        date1 = (EditText) findViewById(R.id.completedDate);
        date2 = (EditText) findViewById(R.id.verifiedDate);
        date3 = (EditText) findViewById(R.id.editText44);
        date4 = (EditText) findViewById(R.id.editText45);
        completedBy = (EditText) findViewById(R.id.completedBy);
        completedDesignation = (EditText) findViewById(R.id.completedDesignation);
        verifiedBy = (EditText) findViewById(R.id.verifiedBy);
        verifiedDesignation= (EditText) findViewById(R.id. VerifiedDesignation);
        submit = (Button) findViewById(R.id.submit);
        date1.setOnClickListener(this);
        date2.setOnClickListener(this);
        date3.setOnClickListener(this);
        date4.setOnClickListener(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                populateObject();
                Intent ip = new Intent(InvestigationForm6.this, Dispatcher.class);
                startActivity(ip);

            }
        });


    }

   public void populateObject ()
   {
       Intent intent = getIntent();
       InvestigationClass investigation = (InvestigationClass) intent.getSerializableExtra("myObject");

       String completedBy1 = completedBy.getText().toString();
       investigation.setCompletedBy(completedBy1);


       String completedDate = date1.getText().toString();
       investigation.setCompletedDate(completedDate );
       String completedDesignation1 = completedDesignation.getText().toString();
       investigation.setCompletedDesignation(completedDesignation1);
       String verifiedBy1 = verifiedBy.getText().toString();
       investigation.setVerifiedBy(verifiedBy1);
       String verifiedDate = date2.getText().toString();
       investigation.setVerifiedDate(verifiedDate);
       String verifiedDesignation1 = verifiedDesignation.getText().toString();
       investigation.setVerifiedDesignation(verifiedDesignation1);

   }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_investigation_form6, menu);
        return true;
    }
    public void onClick(final View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        switch (v.getId()) {
            case R.id.completedDate:
                DatePickerDialog datePicker=new DatePickerDialog(InvestigationForm6.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        date1.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);


                        //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day);
                datePicker.show();

                break;

            case R.id.verifiedDate:
                DatePickerDialog datePicker1=new DatePickerDialog(InvestigationForm6.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        date2.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);


                        //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day);
                datePicker1.show();

                break;
            case R.id.editText44 :
                DatePickerDialog datePicker2=new DatePickerDialog(InvestigationForm6.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        date3.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);


                        //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day);
                datePicker2.show();
                break;
            case R.id.editText45 :
                DatePickerDialog datePicker3=new DatePickerDialog(InvestigationForm6.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        date4.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);


                        //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day);
                datePicker3.show();

                break;


        }





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
