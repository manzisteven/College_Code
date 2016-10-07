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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.tmutabazi.rbc.CaseFollowupClass.CaseFollowUpClass;
import com.example.tmutabazi.rbc.R;

import java.util.Calendar;
import java.util.TimeZone;


public class CaseFollowUp6 extends ActionBarActivity implements View.OnClickListener{
    private Spinner one;
    private Button next;
    private EditText date;
    private EditText notes;
    private RadioGroup isPcrtaken;
    private RadioButton isPcrtakenRadioButton;
    private RadioGroup completedDose;
    private RadioButton completedDoseRadioButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_follow_up7);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("CASE FOLLOW UP FORM  6 OUT OF 7");
        one = (Spinner)findViewById(R.id.spinner9);
        one.setAdapter(ArrayAdapter.createFromResource(this, R.array.TreatmentGiven, R.layout.spinner4));
        next = (Button) findViewById(R.id.button12);
        date = (EditText) findViewById(R.id.editText55);
        date.setOnClickListener(this);
        isPcrtaken = (RadioGroup) findViewById(R.id.isPcrtaken);
        completedDose = (RadioGroup) findViewById(R.id.completedDose);
        notes = (EditText) findViewById(R.id.notes);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CaseFollowUpClass caseFollowUp = populateObject();

                Intent ip = new Intent(CaseFollowUp6.this, CaseFollowUp7.class);
                ip.putExtra("myObject", caseFollowUp);
                startActivity(ip);

            }
});
        }

    public CaseFollowUpClass populateObject ()
    {
        Intent intent = getIntent();
        CaseFollowUpClass caseFollowUp = (CaseFollowUpClass) intent.getSerializableExtra("myObject");
        int selected_id = isPcrtaken.getCheckedRadioButtonId();
        isPcrtakenRadioButton = (RadioButton) findViewById( selected_id);
        String isPcrTaken1 = isPcrtakenRadioButton.getText().toString();
        caseFollowUp.setIsPcrtaken(isPcrTaken1);
        int selected_id1 = completedDose.getCheckedRadioButtonId();
        completedDoseRadioButton = (RadioButton) findViewById( selected_id);
        String completedDose1 = completedDoseRadioButton.getText().toString();
        caseFollowUp.setCompletedDose(completedDose1);
        String pcrDate = date.getText().toString();
        caseFollowUp.setPcrDate(pcrDate);
        String notes1 = notes.getText().toString();
        caseFollowUp.setNotes(notes1);
        String treatmentGiven1 =  (one.getSelectedItem().toString());
        caseFollowUp.setTreatmentGiven(treatmentGiven1);
        return caseFollowUp;
    }
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);




        DatePickerDialog datePicker=new DatePickerDialog(CaseFollowUp6.this, new DatePickerDialog.OnDateSetListener() {
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
        getMenuInflater().inflate(R.menu.menu_case_follow_up7, menu);
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
