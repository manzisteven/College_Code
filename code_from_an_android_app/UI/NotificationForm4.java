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


public class NotificationForm4 extends ActionBarActivity implements View.OnClickListener{

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private EditText date;
    private RadioGroup TravelInRwanda;
    private RadioButton TravelInRwandaSelected;
    Notification notification;
    Button next4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifcation4);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("NOTIFICATION FORM   4 OUT 8");
        Intent i = getIntent();
        notification = (Notification) i.getSerializableExtra("object");

        spinner1 = (Spinner)findViewById(R.id.zeroToseven);
        spinner2 = (Spinner)findViewById(R.id.eightTofourteen);
        spinner3 = (Spinner)findViewById(R.id.fifteentwentyone);
        spinner4 = (Spinner)findViewById(R.id.twentyonefortytwo);
        spinner5 = (Spinner)findViewById(R.id.fortytwoabove);
        spinner1.setAdapter(ArrayAdapter.createFromResource(this, R.array.workHome, R.layout.spinner));
        spinner2.setAdapter(ArrayAdapter.createFromResource(this, R.array.workHome, R.layout.spinner));
        spinner3.setAdapter(ArrayAdapter.createFromResource(this, R.array.workHome, R.layout.spinner));
        spinner4.setAdapter(ArrayAdapter.createFromResource(this, R.array.workHome, R.layout.spinner));
        spinner5.setAdapter(ArrayAdapter.createFromResource(this, R.array.workHome, R.layout.spinner));
        date = (EditText) findViewById(R.id.returnInDate);


        next4 = (Button) findViewById(R.id.next4);
        TravelInRwanda = (RadioGroup) findViewById(R.id.radioIntravel);
        TravelInRwanda.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radioNotravel) {
                    date.setEnabled(false);

                } else if (checkedId == R.id.radioYestravel) {
                    date.setEnabled(true);
                    date.setOnClickListener(NotificationForm4.this);

                }


            }
        });

        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification = objectBuilding(notification);

                Intent ip = new Intent(NotificationForm4.this, NotificationForm5.class);
                ip.putExtra("object",  notification);
                startActivity(ip);



            }
        });
    }
    public Notification objectBuilding(Notification notification)
    {

        notification.setSleptBeforeIllness(spinner1.getSelectedItem().toString(),spinner2.getSelectedItem().toString(),spinner3.getSelectedItem().toString(),spinner4.getSelectedItem().toString(),spinner5.getSelectedItem().toString());

        TravelInRwandaSelected = (RadioButton) findViewById(TravelInRwanda.getCheckedRadioButtonId());
        notification.setTravelledWithInRwandaForteenDays(TravelInRwandaSelected.getText().toString());

        if(TravelInRwandaSelected.getText().toString().equals("Yes"))
        {
            notification.setDateOfInTravel(date.getText().toString());
        }


        return notification;
    }
    public void onClick(View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);




        DatePickerDialog datePicker=new DatePickerDialog(NotificationForm4.this, new DatePickerDialog.OnDateSetListener() {
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
        getMenuInflater().inflate(R.menu.menu_notifcation4, menu);
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
