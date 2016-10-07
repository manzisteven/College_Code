package com.example.smanzi.rbc.UI;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.tmutabazi.rbc.InvestigationClass.InvestigationClass;

import com.example.tmutabazi.rbc.R;



public class InvestigationForm3 extends ActionBarActivity {
    private Button next;
    private Spinner one;
    private Spinner two;
    private EditText ifOther;
    private EditText parasiteDensity;
    private EditText latitude;
    private EditText longitude;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investigation_form3);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("INVESTIGATION FORM    3 OUT OF 6");
        one = (Spinner)findViewById(R.id.spinner);
        two = (Spinner)findViewById(R.id.spinner2);
        ifOther = (EditText) findViewById(R.id.ifOther);
        latitude = (EditText) findViewById(R.id.latitude);

        longitude = (EditText) findViewById(R.id.longitude);
        parasiteDensity = (EditText) findViewById(R.id.parasiteDensity);
        one.setAdapter(ArrayAdapter.createFromResource(this, R.array.caseDetection, R.layout.fat_spinner_entry));
        two.setAdapter(ArrayAdapter.createFromResource(this, R.array.SlideResults, R.layout.spinner1));
        next = (Button) findViewById(R.id.button3);
        LocationManager locator = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        LocationListener listener = new MyLocationListener();

        locator.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InvestigationClass investigation = populateObject();
                Intent ip = new Intent(InvestigationForm3.this, InvestigationForm4.class);
                ip.putExtra("myObject", investigation);
                startActivity(ip);

            }
        });
    }
    public class MyLocationListener implements LocationListener

    {

        @Override

        public void onLocationChanged(Location loc)

        {

            loc.getLatitude();

            loc.getLongitude();

            latitude.setText(""+loc.getLatitude());
            longitude.setText(""+loc.getLongitude());
        }
        public void onProviderDisabled(String provider)

        {

            Toast.makeText( getApplicationContext(),

                    "Gps Disabled",

                    Toast.LENGTH_SHORT ).show();

        }

        @Override

        public void onProviderEnabled(String provider)

        {

            Toast.makeText( getApplicationContext(),

                    "Gps Enabled",

                    Toast.LENGTH_SHORT).show();

        }

        @Override

        public void onStatusChanged(String provider, int status, Bundle extras)

        {

        }
    }
  public InvestigationClass populateObject ()
  {
      Intent intent = getIntent();
      InvestigationClass investigation = (InvestigationClass) intent.getSerializableExtra("myObject");
      String typeOfCaseDetection =  (one.getSelectedItem().toString());
      if (typeOfCaseDetection.equals("Other"))
      {
          String ifOther1 = ifOther.getText().toString();
          investigation.setTypeOfCaseDetection(ifOther1);
      }

      else
      {
          investigation.setTypeOfCaseDetection(typeOfCaseDetection);
      }
      String slideResult =  (two.getSelectedItem().toString());
      investigation.setSlideResult(slideResult);
      String parasiteDensity1 = parasiteDensity.getText().toString();
      investigation.setParasiteDensity(parasiteDensity1);
      return investigation;
  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_investigation_form3, menu);
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
