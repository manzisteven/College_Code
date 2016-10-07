package com.example.smanzi.ac_controller;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    ImageButton power;
    ImageButton positive;
    ImageButton negative;
    ImageButton logo;

    ImageButton auto;
    ImageButton cool;
    ImageButton dry;
    ImageButton fan;
    private boolean flag = false;
    StringBuffer b = new StringBuffer();
    private static final int freq = 38000;
    private static final int[] raw = {4400,4250,600,1550,600,500,600,1500,650,1500,650,450,600,450,650,1500,650,450,600,450,650,1500,650,450,600,500,600,1500,650,1500,650,500,550,1550,600,500,600,450,650,450,600,1550,600,1500,650,1500,650,1500,650,1500,650,1500,650,1500,650,1500,650,450,600,500,600,450,600,450,650,450,600,500,600,450,650,1500,650,1500,600,500,600,1550,600,450,650,450,600,1550,600,1550,600,450,650,450,600,1550,600,450,650,1500,650,1500,650,5050,4450,4200,650,1500,600,500,600,1550,600,1550,600,450,650,450,600,1550,600,500,600,450,600,1550,600,450,650,450,600,1550,600,1550,600,450,650,1500,650,450,600,500,600,450,600,1550,600,1550,600,1550,600,1550,600,1550,600,1550,600,1550,600,1550,600,450,650,450,600,500,600,450,600,450,650,450,600,450,650,1500,650,1500,650,450,600,1550,600,500,600,450,600,1550,600,1550,600,450,650,450,600,1550,600,500,600,1500,650,1500,650};
    TextView ambientTemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        power = (ImageButton) findViewById(R.id.power);
        ambientTemp = (TextView) findViewById(R.id.txt_ambient);
        power.setImageResource(R.drawable.power);

        positive = (ImageButton) findViewById(R.id.positive);
        positive.setImageResource(R.drawable.plus);

        negative = (ImageButton) findViewById(R.id.negative);
        negative.setImageResource(R.drawable.negative);

        auto = (ImageButton) findViewById(R.id.Auto);
        auto.setImageResource(R.drawable.auto);

        cool = (ImageButton) findViewById(R.id.cool);
        cool.setImageResource(R.drawable.cool);

        dry = (ImageButton) findViewById(R.id.dry);
        dry.setImageResource(R.drawable.dry);

        fan = (ImageButton) findViewById(R.id.fan);
        fan.setImageResource(R.drawable.fan);

        logo = (ImageButton) findViewById(R.id.logo);
        logo.setImageResource(R.drawable.logo);


        SensorManager mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        Sensor AmbientTemperatureSensor
                = mySensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if(AmbientTemperatureSensor != null){
            //textAMBIENT_TEMPERATURE_available.setText("Sensor.TYPE_AMBIENT_TEMPERATURE Available");
            mySensorManager.registerListener(
                    AmbientTemperatureSensorListener,
                    AmbientTemperatureSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else{
            ambientTemp.setText("NOT Available");
        }

    }


    private final SensorEventListener AmbientTemperatureSensorListener
            = new SensorEventListener(){

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){
                ambientTemp.setText(""+ String.format("%.2f",event.values[0])+"°C");
            }
        }

    };

    power.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           // Toast.makeText(getBaseContext(), "it works .", Toast.LENGTH_LONG).show();
            if (flag==false)
            {

            }
            else
            {

            }

        });

}
