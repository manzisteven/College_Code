package com.example.smanzi.rbc.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.tmutabazi.rbc.Notifiation.Notification;
import com.example.tmutabazi.rbc.R;


public class NotificationForm7 extends ActionBarActivity {

    Button next7;
    CheckBox vivax,falci,malarie,ovale,notDetermined;
    Notification notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification7);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("NOTIFICATION FORM   7 OUT 8");
        Intent i = getIntent();
        notification = (Notification) i.getSerializableExtra("object");

        next7 = (Button) findViewById(R.id.next7);
        vivax = (CheckBox) findViewById(R.id.vivax);
        falci = (CheckBox) findViewById(R.id.falciprum);
        malarie = (CheckBox) findViewById(R.id.malarie);
        ovale = (CheckBox) findViewById(R.id.ovale);
        notDetermined = (CheckBox) findViewById(R.id.notDetermined);

        next7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notification = objectBuilding(notification);
                Intent ip = new Intent(NotificationForm7.this, NotificationForm8.class);
                ip.putExtra("object",  notification);
                startActivity(ip);

            }
        });
    }

    public Notification objectBuilding(Notification notification)
    {


        return notification;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notification7, menu);
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
