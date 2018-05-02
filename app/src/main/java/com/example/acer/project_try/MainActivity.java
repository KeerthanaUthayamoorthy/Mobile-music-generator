package com.example.acer.project_try;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextClock;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements SensorEventListener{
    private TextView xText,yText,zText,set;
    private Sensor mySensor;
    private SensorManager SM;

    MediaPlayer mdx1;
    MediaPlayer mdx2;
    MediaPlayer mdx3;
    MediaPlayer mdx4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create our sensor manager
        SM=(SensorManager)getSystemService(SENSOR_SERVICE);
        mySensor=SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);   // use of accelerometer sensor in detection of user interaction
        //register sensor listener
        SM.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);
        // assign text view
        xText=(TextView)findViewById(R.id.xText);
        yText=(TextView)findViewById(R.id.yText);
        zText=(TextView)findViewById(R.id.zText);
        set=(TextView)findViewById(R.id.set);

        mdx1 = MediaPlayer.create(MainActivity.this,R.raw.tabla);   // get the sound for each fom raw file
        mdx2 = MediaPlayer.create(MainActivity.this,R.raw.drums);
        mdx3 = MediaPlayer.create(MainActivity.this,R.raw.raja_rani);
//        mdx4 = MediaPlayer.create(MainActivity.this,R.raw.awesomemorning_alarm);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xText.setText("X: " +event.values[0]);   // displays the acceleration along each axis
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);

        if ( event.values[2]<1.5 ){
            //mdx1.stop();
            //mdx1.start();
           // mdx1 = MediaPlayer.create(MainActivity.this,R.raw.tabla);
        }
        else{
            //mdx1.stop();
            //mdx1.start();
           // mdx1 = MediaPlayer.create(MainActivity.this,R.raw.tabla);
        }

//        if ( event.values[1]<11.0 && event.values[1]>0.0 ){
//
//
//            //mdx1 = MediaPlayer.create(MainActivity.this,R.raw.roja_flute);
//            mdx1.start();
//            mdx4 = MediaPlayer.create(MainActivity.this,R.raw.awesomemorning_alarm);
//
//            set.setText("it's vertical ");
//
//        }
//         else if ( event.values[0]<11.0 && event.values[0]>0.0 ){
//
//           mdx1.stop();
//
//            // mdx1 = MediaPlayer.create(MainActivity.this,R.raw.roja_flute);
//           //mdx3.stop();
//         //  mdx2 = MediaPlayer.create(MainActivity.this,R.raw.drums);
//         // mdx2.start();
//
//        }
//          else if ( event.values[1]>-11.0 && event.values[1]<0.0 ){
//        // mdx1.stop();
////         mdx4.stop();
////              mdx3 = MediaPlayer.create(MainActivity.this,R.raw.raja_rani);
//          mdx3.start();
//            mdx1 = MediaPlayer.create(MainActivity.this,R.raw.roja_flute);
//
//             set.setText("it's another_vertical ");
//         }
//         else if ( event.values[0]>-11.0 && event.values[0]<-9.0 ){
//           mdx3.stop();
//          //  mdx1.stop();
//           // mdx4 = MediaPlayer.create(MainActivity.this,R.raw.awesomemorning_alarm);
//
//
////            mdx4.start();
//            set.setText("it's another_vertical ");
//        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
// not in use
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
