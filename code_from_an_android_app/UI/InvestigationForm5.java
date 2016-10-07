package com.example.smanzi.rbc.UI;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


import com.example.tmutabazi.rbc.InvestigationClass.InvestigationClass;

import com.example.tmutabazi.rbc.R;



public class InvestigationForm5 extends ActionBarActivity {
    private Spinner one;
    private Spinner two;
    private Button next;
    private EditText numberOfHouses;
    private EditText numberOfInhabitants;

    private RadioGroup houseWithHoles;
    private RadioButton  houseWithHolesRadioButton;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investigation_form5);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("INVESTIGATION FORM    5 OUT OF 6");
        one = (Spinner)findViewById(R.id.spinner5);
        one.setAdapter(ArrayAdapter.createFromResource(this, R.array.TypeOfHabitat, R.layout.spinner4));
        two = (Spinner)findViewById(R.id.spinner6);
        two.setAdapter(ArrayAdapter.createFromResource(this, R.array.LocationOfHouse, R.layout.spinner5));
        next = (Button) findViewById(R.id.button5);
        numberOfHouses = (EditText) findViewById(R.id.numberOfHouses);
        numberOfInhabitants = (EditText) findViewById(R.id.numberOfInhabitants);
        houseWithHoles = (RadioGroup) findViewById(R.id.housesWithHoles);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InvestigationClass investigation = populateObject();
                Intent ip = new Intent(InvestigationForm5.this, InvestigationForm6.class);
                ip.putExtra("myObject", investigation);
                startActivity(ip);

            }
        });
    }
    public InvestigationClass populateObject ()
    {
        Intent intent = getIntent();
        InvestigationClass investigation = (InvestigationClass) intent.getSerializableExtra("myObject");
        String numberOfHouses1 = numberOfHouses.getText().toString();
        int numberOfHouses2 = Integer.parseInt(numberOfHouses1 );
        investigation.setTotalNumberOfHousesInVillage(numberOfHouses2);
        String numberOfInhabitants1 = numberOfInhabitants.getText().toString();
        int  numberOfInhabitants2 = Integer.parseInt( numberOfInhabitants1);
        investigation.setTotalNumberOfInhabitantsInVillage(numberOfInhabitants2);
        String typeOfHabitat = (one.getSelectedItem().toString());
        investigation.setTypeOfHabitat(typeOfHabitat);
        String houseLocation =  (two.getSelectedItem().toString());
        investigation.setHouseLocation(houseLocation);
        int selected_id = houseWithHoles.getCheckedRadioButtonId();
        houseWithHolesRadioButton = (RadioButton) findViewById( selected_id);
        String radioButtonText =  houseWithHolesRadioButton.getText().toString();
        investigation.setHousesWithHoles(radioButtonText);
        return investigation;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_investigation_form5, menu);
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
