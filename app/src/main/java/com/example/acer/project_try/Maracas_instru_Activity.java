package com.example.acer.project_try;

import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Maracas_instru_Activity extends AppCompatActivity implements SensorEventListener {
    TextView value;
    SensorManager sensorManager;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maracas);

        value=(TextView)findViewById(R.id.light_val);
        sensorManager=(SensorManager)getSystemService(Service.SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(sensor.TYPE_LIGHT);

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType()==Sensor.TYPE_LIGHT){
            value.setText(" "+event.values[0]);  // detect the luminosity change in the proximity sensor


        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
