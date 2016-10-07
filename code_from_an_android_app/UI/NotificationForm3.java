package com.example.smanzi.rbc.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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

import com.example.tmutabazi.rbc.Notifiation.Notification;
import com.example.tmutabazi.rbc.R;

import java.util.Calendar;
import java.util.TimeZone;


public class NotificationForm3 extends ActionBarActivity implements View.OnClickListener{
    private EditText date;
    private EditText date1;
    private EditText occupation;
    private RadioGroup bloodTransfusion;
    private RadioButton bloodTransfusionSelected;
    private Spinner travelFrequency;
    Button next3;
    Notification notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification3);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("NOTIFICATION FORM   3 OUT 8");
        Intent i = getIntent();
        notification = (Notification) i.getSerializableExtra("object");

        date = (EditText) findViewById(R.id.illnessDate);
        date.setOnClickListener(this);
        date1 = (EditText) findViewById(R.id.dateOfTransfusion);
        travelFrequency = (Spinner)findViewById(R.id.spinner);
        travelFrequency.setAdapter(ArrayAdapter.createFromResource(this, R.array.frequency, R.layout.spinner));
        bloodTransfusion = (RadioGroup) findViewById(R.id.radioBlood);
        bloodTransfusion.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radioNoBlood) {
                    date1.setEnabled(false);

                } else if (checkedId == R.id.radioYesBlood) {
                    date1.setEnabled(true);
                    date1.setOnClickListener(NotificationForm3.this);

                }


            }
        });
        next3 = (Button) findViewById(R.id.next3);

        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification = objectBuilding(notification);
                notification.setBloodTransfusionDate(date1.getText().toString());
                notification.setDateOnsetIllness(date.getText().toString());
                Intent ip = new Intent(NotificationForm3.this, NotificationForm4.class);
                ip.putExtra("object",  notification);
                startActivity(ip);



            }
        });
    }

    public Notification objectBuilding(Notification notifaction)
    {
        occupation = (EditText) findViewById(R.id.occupation);

        bloodTransfusionSelected = (RadioButton) findViewById(bloodTransfusion.getCheckedRadioButtonId());
        notifaction.setBloodTransfusion(bloodTransfusionSelected.getText().toString());
        notifaction.setFrequencyOfWorkAway(travelFrequency.getSelectedItem().toString());

        return notifaction;
    }
    public void onClick(final View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        DatePickerDialog datePicker=new DatePickerDialog(NotificationForm3.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                switch (v.getId()) {
                    case R.id.illnessDate:
                        date.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                        break;
                    case R.id.dateOfTransfusion:
                        date1.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                        break;

                    //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
                }
            }
        }, year, month, day);
        datePicker.show();




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notification3, menu);
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
