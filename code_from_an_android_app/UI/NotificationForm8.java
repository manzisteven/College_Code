package com.example.smanzi.rbc.UI;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmutabazi.rbc.Notifiation.Notification;
import com.example.tmutabazi.rbc.OfflineMode.OfflineDatabase;
import com.example.tmutabazi.rbc.R;

import java.util.Calendar;
import java.util.TimeZone;


public class NotificationForm8 extends ActionBarActivity implements LocationListener,View.OnClickListener {

    TextView latitude,longtitude;
    LocationManager mLocationManager;
    String provider;
    private RadioGroup ActionTaken;
    private RadioButton ActionSelected;
    private EditText completedDesignation,dateCompletion,dateVerified,varifiedDisgnation;
    Button submit;
    Notification notification;
    OfflineDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification8);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("NOTIFICATION FORM   8 OUT 8");

        Intent i = getIntent();
        notification = (Notification) i.getSerializableExtra("object");
        completedDesignation = (EditText) findViewById(R.id.completedDesignation);
        dateCompletion = (EditText) findViewById(R.id.dateofcompletion);
        dateCompletion.setOnClickListener(this);
        dateVerified = (EditText) findViewById(R.id.verifiedDate);
        dateVerified.setOnClickListener(this);
        varifiedDisgnation = (EditText) findViewById(R.id.verifiedDesignation);


        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        provider = mLocationManager.getBestProvider(criteria,false);
        if(provider!=null){
            // This right here provides the location from the provider
            final Location loc = mLocationManager.getLastKnownLocation(provider);
            // Requests the location update
            mLocationManager.requestLocationUpdates(provider, 100000, 1, this);

            if(loc!=null) {


                onLocationChanged(loc);
            }

            else
                Toast.makeText(getBaseContext(), "Location Error", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(getBaseContext(), "No Provider Found", Toast.LENGTH_SHORT).show();
        }

        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification = objectBuilding(notification);

                Intent ip = new Intent(NotificationForm8.this, Dispatcher.class);
                startActivity(ip);



            }
        });
    }





    public Notification objectBuilding(Notification notification)
    {
        ActionTaken = (RadioGroup) findViewById(R.id.radioActionTaken);
        ActionSelected = (RadioButton) findViewById(ActionTaken.getCheckedRadioButtonId());

        notification.setActionTaken(ActionSelected.getText().toString());
        notification.setCompletedBy(completedDesignation.getText().toString(),dateCompletion.getText().toString());
        notification.setVerifiedInformation(dateVerified.getText().toString(),varifiedDisgnation.getText().toString());

        return notification;
    }
    public void onClick(final View v) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT-4:00"));
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        DatePickerDialog datePicker = new DatePickerDialog(NotificationForm8.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                switch (v.getId()) {
                    case R.id.dateofcompletion:
                        dateCompletion.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                        break;
                    case R.id.verifiedDate:
                        dateVerified.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
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
        getMenuInflater().inflate(R.menu.menu_notification8, menu);
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

    @Override
    public void onLocationChanged(Location location) {

        latitude = (TextView) findViewById(R.id.latitude);
        longtitude= (TextView) findViewById(R.id.longtitude);
        latitude.setText(location.getLatitude()+".");
        longtitude.setText(location.getLongitude()+".");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
