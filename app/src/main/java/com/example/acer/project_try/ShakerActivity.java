package com.example.acer.project_try;

import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.squareup.seismic.ShakeDetector;

public class ShakerActivity extends AppCompatActivity implements ShakeDetector.Listener {
    MediaPlayer mdx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shaker);
        mdx = MediaPlayer.create(ShakerActivity.this,R.raw.bell); // bell ringing tone will be got

        SensorManager sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector shakeDetector=new ShakeDetector(this);
        shakeDetector.start(sensorManager);
    }


    @Override
    public void hearShake() {

        Toast.makeText(this,"Shake has been detected",Toast.LENGTH_SHORT).show(); // whilw shake was detected music starts
        mdx.start();

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
