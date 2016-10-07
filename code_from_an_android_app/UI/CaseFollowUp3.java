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

import com.example.tmutabazi.rbc.R;

import java.util.Calendar;
import java.util.TimeZone;


public class CaseFollowUp3 extends ActionBarActivity  implements View.OnClickListener{

    private Button next;
    private EditText date;
    private RadioGroup day28PresenceOfDangerSigns;
    private RadioButton day28PresenceOfDangerSignsRadioButton;
    private EditText day28Temperature;
    private EditText statusComments;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_follow_up3);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("CASE FOLLOW UP FORM  3 OUT OF 7");
        next = (Button) findViewById(R.id.button10);
        date = (EditText) findViewById(R.id.day28Date);
        date.setOnClickListener(this);
        day28PresenceOfDangerSigns = (RadioGroup) findViewById(R.id.day28PresenceOfDangerSigns);
        day28Temperature = (EditText) findViewById(R.id.day28Temperature);
        day28Temperature.setInputType(InputType.TYPE_CLASS_NUMBER);
        statusComments = (EditText) findViewById(R.id.statusComments);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaseFollowUpClass caseFollowUp = populateObject();
                Intent ip = new Intent(CaseFollowUp3.this, CaseFollowUp4.class);
                ip.putExtra("myObject", caseFollowUp);
                startActivity(ip);

            }
        });

    }
    public CaseFollowUpClass populateObject ()
    {
        Intent intent = getIntent();
        CaseFollowUpClass caseFollowUp = (CaseFollowUpClass) intent.getSerializableExtra("myObject");
        int selected_id = day28PresenceOfDangerSigns.getCheckedRadioButtonId();
        day28PresenceOfDangerSignsRadioButton = (RadioButton) findViewById( selected_id);
        String day28PresenceOfDangerSignsResult = day28PresenceOfDangerSignsRadioButton.getText().toString();
        caseFollowUp.setPresenceOfDangerSigns28(day28PresenceOfDangerSignsResult);
        String day28Date = date.getText().toString();
        caseFollowUp.setDay28Date(day28Date);
        String day28Temperature1 = day28Temperature.getText().toString();
        float day28Temperature2 = Float.parseFloat(day28Temperature1);
        caseFollowUp.setDay28Temperature(day28Temperature2);
        String statusComments1 = statusComments.getText().toString();
        caseFollowUp.setStatusComments(statusComments1);

        return caseFollowUp;
    }
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);




        DatePickerDialog datePicker=new DatePickerDialog(CaseFollowUp3.this, new DatePickerDialog.OnDateSetListener() {
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
        getMenuInflater().inflate(R.menu.menu_case_follow_up3, menu);
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
