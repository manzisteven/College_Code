package com.example.smanzi.rbc.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.tmutabazi.rbc.CaseFollowupClass.CaseFollowUpClass;
import com.example.tmutabazi.rbc.InvestigationClass.InvestigationClass;

import com.example.tmutabazi.rbc.R;

import java.util.Calendar;
import java.util.TimeZone;


public class CaseFollowUp2 extends ActionBarActivity implements View.OnClickListener{
   private EditText date1;
   private EditText date2;
   private Button next;
   private EditText day3Date;
   private RadioGroup day3PresenceOfDangerSigns;
   private RadioButton day3PresenceOfDangerSignsRadioButton;
   private RadioGroup day14PresenceOfDangerSigns;
   private RadioButton day14PresenceOfDangerSignsRadioButton;
   private EditText day3Temperature;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_follow_up2);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("CASE FOLLOW UP FORM 2 OUT OF 7");
        next = (Button) findViewById(R.id.button8);
        date1 = (EditText) findViewById(R.id.day3Date);
        date2 = (EditText) findViewById(R.id.day14Date);
        date1.setOnClickListener(this);
        date2.setOnClickListener(this);
        day3PresenceOfDangerSigns = (RadioGroup) findViewById(R.id.day3PresenceOfDangerSigns);
        day14PresenceOfDangerSigns = (RadioGroup) findViewById(R.id.day14PresenceOfDangerSigns);


        day3Temperature = (EditText) findViewById(R.id.day3Temperature);
        day3Temperature.setInputType(InputType.TYPE_CLASS_NUMBER);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaseFollowUpClass caseFollowUp = populateObject();
                Intent ip = new Intent(CaseFollowUp2.this, CaseFollowUp3.class);
                ip.putExtra("myObject", caseFollowUp);
                startActivity(ip);

            }
        });
    }
    public CaseFollowUpClass populateObject ()
    {
        Intent intent = getIntent();
        CaseFollowUpClass caseFollowUp = (CaseFollowUpClass) intent.getSerializableExtra("myObject");
        int selected_id = day3PresenceOfDangerSigns.getCheckedRadioButtonId();
        day3PresenceOfDangerSignsRadioButton = (RadioButton) findViewById( selected_id);
        String day3PresenceOfDangerSignsResult = day3PresenceOfDangerSignsRadioButton.getText().toString();
        caseFollowUp.setPresenceOfDangerSigns(day3PresenceOfDangerSignsResult);
        int selected_id1 = day14PresenceOfDangerSigns.getCheckedRadioButtonId();
        day14PresenceOfDangerSignsRadioButton = (RadioButton) findViewById( selected_id1);
        String day14PresenceOfDangerSignsResult = day14PresenceOfDangerSignsRadioButton.getText().toString();
        caseFollowUp.setPresenceOfDangerSigns14( day14PresenceOfDangerSignsResult);
        String day3Date = date1.getText().toString();
        caseFollowUp.setDay3Date(day3Date);
        String day14Date = date2.getText().toString();
        caseFollowUp.setDay14Date(day14Date);
        String day3Temperature1 = day3Temperature.getText().toString();
        float day3Temperature2 = Float.parseFloat(day3Temperature1);
        caseFollowUp.setDay3Temperature(day3Temperature2);

        return caseFollowUp;
    }
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        switch (v.getId())
        {
            case R.id.day3Date :
                DatePickerDialog datePicker=new DatePickerDialog(CaseFollowUp2.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        date1.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);


                        //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day);
                datePicker.show();

                break;

            case R.id.day14Date:
                DatePickerDialog datePicker1=new DatePickerDialog(CaseFollowUp2.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        date2.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);


                        //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day);
                datePicker1.show();

                break;
        }









    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_case_follow_up2, menu);
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
