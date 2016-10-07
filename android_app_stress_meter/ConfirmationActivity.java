package mobilestressmeter.edu.cmu.stressmeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;


public class ConfirmationActivity extends Activity {
    ImageView image;
    Button submit, cancel;
    int position,id;

    String FILENAME = "stress_timestamp.csv";
    File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);

    File file;

    int stressscores[] ={6,8,14,16,5,7,13,15,2,4,10,12,1,3,9,11};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        image = (ImageView)findViewById(R.id.imageView);
        submit = (Button)findViewById(R.id.btnSubmit);
        cancel = (Button)findViewById(R.id.btnCancel);
        id = getIntent().getIntExtra("id", 0);
        position = getIntent().getIntExtra("position",0);

        image.setImageResource(id);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createCSVFile(getCurrentTimeStamp(),stressscores[position]);

                Log.i("CSV File Updated","");
                Intent intent =new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_confirmation, menu);
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

    public void createCSVFile(String timestamp, int stress){
        StringBuilder csvString = new StringBuilder();
        csvString.append(timestamp);
        csvString.append(",");
        csvString.append(String.valueOf(stress));
        csvString.append("\n ");

        writeCSVFile(csvString.toString());

        Log.i("csv", csvString.toString());

    }

    public void writeCSVFile(String csv){
        try {
           // This is the file that should be
            // written to
            file = new File(path, FILENAME);
            OutputStream out = null;
            try {
                out = new BufferedOutputStream(new FileOutputStream(file,true));
                out.write(csv.getBytes());
            }
                finally {
                    if (out != null) {
                        out.close();
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
  }



    public static String getCurrentTimeStamp(){
        try {

            Long tsLong = System.currentTimeMillis()/1000;
            String ts = tsLong.toString();

            return ts;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
