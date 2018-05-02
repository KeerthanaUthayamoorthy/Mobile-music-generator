package com.example.acer.project_try;

import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.IOException;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;


public class TambourinePlayActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorMgr;
    Sensor sensor;
    TextView textView;
    MediaPlayer player;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambourine_play);
        textView = (TextView)findViewById(R.id.textView2);
        sensorMgr = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorMgr.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        player = MediaPlayer.create(getApplicationContext(), R.raw.maraca);
        try {
            player.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorMgr.registerListener(this, sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorMgr.unregisterListener(this);
        player.stop();
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == sensor.TYPE_PROXIMITY) {
            if (event.values[0] == sensor.getMaximumRange()) {
                if (flag == true) {
                    player.start();
                    textView.setText("Now Playing..!");

                    flag = false;
                } else {
                    player.start();
                    textView.setText("Pause");

                    flag = true;
                }
            }
        }
    }

}
