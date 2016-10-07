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
import android.widget.RadioGroup;

import com.example.tmutabazi.rbc.CaseFollowupClass.CaseFollowUpClass;
import com.example.tmutabazi.rbc.R;

import java.util.Calendar;
import java.util.TimeZone;


public class CaseFollowUp7 extends ActionBarActivity  implements View.OnClickListener{

    private RadioGroup lossToFollowUp;
    private RadioButton lossToFollowUpRadioButton;
    private EditText lastContactDate;
    private EditText lossReasons;
    private Button submit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_follow_up8);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("CASE FOLLOW UP FORM  7 OUT OF 7");
        lastContactDate = (EditText) findViewById(R.id.lastContactDate);
        lastContactDate.setOnClickListener(this);
        lossReasons = (EditText) findViewById(R.id.lossReasons);
        lossToFollowUp = (RadioGroup) findViewById(R.id.lossTofollowUp);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               populateObject();
               Intent ip = new Intent(CaseFollowUp7.this, Dispatcher.class);
               startActivity(ip);

            }
        });

    }
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);




        DatePickerDialog datePicker=new DatePickerDialog(CaseFollowUp7.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                lastContactDate.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);

                //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
            }
        }, year, month, day);
        datePicker.show();




    }
  public void populateObject ()
  {
      Intent intent = getIntent();
      CaseFollowUpClass caseFollowUp = (CaseFollowUpClass) intent.getSerializableExtra("myObject");
      int selected_id = lossToFollowUp.getCheckedRadioButtonId();
      lossToFollowUpRadioButton = (RadioButton) findViewById( selected_id);
      String lossToFollowUp1 = lossToFollowUpRadioButton.getText().toString();
      caseFollowUp.setLossToFollowUp(lossToFollowUp1);
      String lastContactDate1 = lastContactDate.getText().toString();
      caseFollowUp.setLastContactDate(lastContactDate1);
      String lossReasons1 = lossReasons.getText().toString();
      caseFollowUp.setLossReasons(lossReasons1);
  }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_case_follow_up8, menu);
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
