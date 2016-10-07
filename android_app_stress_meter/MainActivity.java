package mobilestressmeter.edu.cmu.stressmeter;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import mobilestressmeter.edu.cmu.services.SampleAlarmReceiver;


public class MainActivity extends Activity {

    ImageAdapter mImageAdapter;
    Button load;
    int grid=1;
    GridView gridview;
    private PendingIntent pendingIntent;
    private AlarmManager manager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
            return;
        }

        mImageAdapter =new ImageAdapter(this);
        gridview= (GridView) findViewById(R.id.gridview);

        load = (Button) findViewById(R.id.btnLoadMore);

        mImageAdapter.mThumbIds = mImageAdapter.getGrid(grid);
        gridview.setAdapter(mImageAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                int imageid = mImageAdapter.getGrid(grid)[position];

                Intent intent = new Intent(v.getContext(), ConfirmationActivity.class);
                intent.putExtra("id", imageid);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });

        // Retrieve a PendingIntent that will perform a broadcast
        Intent alarmIntent = new Intent(this, SampleAlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);
        
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if(grid==1)
                     grid=2;
                  else if(grid ==2)
                      grid=3;
                  else
                     grid=1;

                mImageAdapter.mThumbIds = mImageAdapter.getGrid(grid);
                gridview.setAdapter(mImageAdapter);
            }
        });
    }

    public void startAlarm(View view) {
        manager = (AlarmManager)getSystemService(view.getContext().ALARM_SERVICE);
        int interval = 10000;

        manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
        Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();
    }

    public void cancelAlarm(View view) {
        if (manager != null) {
            manager.cancel(pendingIntent);
            Toast.makeText(this, "Alarm Canceled", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
