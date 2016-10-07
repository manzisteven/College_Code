package com.example.smanzi.rbc.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.tmutabazi.rbc.Notifiation.Notification;
import com.example.tmutabazi.rbc.R;

import java.util.Calendar;
import java.util.TimeZone;

//import com.example.tmutabazi.rbc.R;


public class NotificationForm6 extends ActionBarActivity implements View.OnClickListener {

    Button next6;
    private EditText date1;
    private EditText date2;
    private EditText date3;
    private EditText date4;
    Notification notification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification6);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("NOTIFICATION FORM   6 OUT 8");
        Intent i = getIntent();
        notification = (Notification) i.getSerializableExtra("object");

        next6 = (Button) findViewById(R.id.next6);
        date1 = (EditText) findViewById(R.id.editText9);
        date2 = (EditText) findViewById(R.id.bsDate);
        date3 = (EditText) findViewById(R.id.rdtDate);
        date4 = (EditText) findViewById(R.id.bsdatereceived);
        date1.setOnClickListener(this);
        date2.setOnClickListener(this);
        date3.setOnClickListener(this);
        date4.setOnClickListener(this);

        next6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification = objectBuilding(notification);
                Intent ip = new Intent(NotificationForm6.this, NotificationForm7.class);
                ip.putExtra("object",  notification);
                startActivity(ip);

            }
        });
    }

    public Notification objectBuilding(Notification notification)
    {


        return  notification;
    }


    public void onClick(final View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);




        DatePickerDialog datePicker=new DatePickerDialog(NotificationForm6.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                switch (v.getId()) {
                    case R.id.editText9:
                        date1.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                        break;
                    case R.id.bsDate:
                        date2.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                        break;
                    case R.id.rdtDate:
                        date3.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                        break;
                    case R.id.bsdatereceived:
                        date4.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                        break;

                }
                //Toast.makeText(ReminderActivity.this, year + "year " + (monthOfYear + 1) + "month " + dayOfMonth + "day", Toast.LENGTH_SHORT).show();
            }
        }, year, month, day);
        datePicker.show();




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notification6, menu);
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
