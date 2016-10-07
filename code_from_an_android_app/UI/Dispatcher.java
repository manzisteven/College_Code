package com.example.smanzi.rbc.UI;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tmutabazi.rbc.Database.Database;
import com.example.tmutabazi.rbc.Notifiation.Notification;
import com.example.tmutabazi.rbc.R;

import java.util.ArrayList;


public class Dispatcher extends ActionBarActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private RBCDrawerListAdapter adapter;
    private ArrayList<RBCDrawerItem> navDrawerItems;
    Button notification;
    Button investigation;
    Boolean answer;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatcher);

        answer = db.doesDatabaseExist(this,"locationDataDB.db");
        if(answer.equals(false))
        {
            Intent ip = new Intent(Dispatcher.this, ParseJsonFile.class);
            startActivity(ip);

        }
        else
        {
           // Toast.makeText(getBaseContext(), "Here Here", Toast.LENGTH_SHORT).show();
        }

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);
        if(mDrawerList == null) {
            Log.d(getPackageName(), mDrawerList != null ? "lvCountries is not null!" : "lvCountries is null!");
        }
        navDrawerItems = new ArrayList<RBCDrawerItem>();
        navDrawerItems.add(new RBCDrawerItem("HOME",R.drawable.rbclogo));
        navDrawerItems.add(new RBCDrawerItem("Notification Form",R.drawable.forms));
        navDrawerItems.add(new RBCDrawerItem("Investigation Form",R.drawable.forms));
        navDrawerItems.add(new RBCDrawerItem("Follow up Form",R.drawable.forms));
        navDrawerItems.add(new RBCDrawerItem("Add FOCI",R.drawable.forms));
        navDrawerItems.add(new RBCDrawerItem("Tables",R.drawable.table));
        // setting the nav drawer list adapter
        adapter = new RBCDrawerListAdapter(getApplicationContext(),
                navDrawerItems);
        mDrawerList.setAdapter(adapter);

        // enabling action bar app icon and behaving it as toggle button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,

                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility

        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle("RBC");
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle("RBC");
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);
        }

        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

        /*notification = (Button) findViewById(R.id.notification);
        investigation = (Button) findViewById(R.id.investigation);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip = new Intent(Dispatcher.this, Notification.class);
                startActivity(ip);
            }
        });
        investigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ip = new Intent(Dispatcher.this, InvestigationForm.class);
                startActivity(ip);
            }
        });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dispatcher, menu);
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

    private class SlideMenuClickListener implements
            AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }

    /**
     * Diplaying fragment view for selected nav drawer list item
     */
    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case 0:
                Bundle arg = new Bundle();
                fragment = new homeFragment();
                fragment.setArguments(arg);
                break;
            case 1:
                Intent ip = new Intent(Dispatcher.this, NotificationForm.class);
                startActivity(ip);

                break;
            case 2:
                Intent ip1 = new Intent(Dispatcher.this, InvestigationForm.class);
                startActivity(ip1);
                break;
            case 3:
                Intent case1 = new Intent(Dispatcher.this, CaseFollowUp1.class);
                startActivity(case1);
                break;
            case 4:
                Intent FOCI = new Intent(Dispatcher.this, PermanentAddress.class);
                FOCI.putExtra("Activity", "addFoci");
                startActivity(FOCI);
                break;

            default:
                break;
        }


    }
}
