package com.example.acer.project_try;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Piano extends AppCompatActivity {
    private Button B1,B2,B3,B4,B5,B6,B7,B8,b1,b2,b3,b4;
    private SoundPool soundPool;
    private int sound_a,sound_b,sound_c,sound_d,sound_e,sound_f,sound_g,sound_h,sound_i,sound_j,sound_k,sound_l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);
        B1=(Button)findViewById(R.id.B1);
        B2=(Button)findViewById(R.id.B2);
        B3=(Button)findViewById(R.id.B3);
        B4=(Button)findViewById(R.id.B4);
        B5=(Button)findViewById(R.id.B5);
        B6=(Button)findViewById(R.id.B6);
        B7=(Button)findViewById(R.id.B7);
        B8=(Button)findViewById(R.id.B8);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            soundPool=new SoundPool.Builder().setMaxStreams(5).build();
        }else{
            soundPool=new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        }

        sound_a=soundPool.load(this,R.raw.a1,1);
        sound_b=soundPool.load(this,R.raw.b1,1);
        sound_c=soundPool.load(this,R.raw.c1,1);
        sound_d=soundPool.load(this,R.raw.c2,1);
        sound_e=soundPool.load(this,R.raw.d1,1);
        sound_f=soundPool.load(this,R.raw.e1,1);
        sound_g=soundPool.load(this,R.raw.f1,1);
        sound_h=soundPool.load(this,R.raw.g1,1);
        sound_i=soundPool.load(this,R.raw.a1s,1);
        sound_j=soundPool.load(this,R.raw.c1s,1);
        sound_k=soundPool.load(this,R.raw.d1s,1);
        sound_l=soundPool.load(this,R.raw.f1s,1);


        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_a,1,1,0,0,1);

            }
        });
        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_b,1,1,0,0,1);
            }
        });
        B3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_c,1,1,0,0,1);
            }
        });
        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_d,1,1,0,0,1);
            }
        });
        B5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_e,1,1,0,0,1);
            }
        });
        B6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_f,1,1,0,0,1);

            }
        });
        B7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_g,1,1,0,0,1);
            }
        });
        B8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_h,1,1,0,0,1);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_i,1,1,0,0,1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_j,1,1,0,0,1);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_k,1,1,0,0,1);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPool.play(sound_l,1,1,0,0,1);
            }
        });
    }
}
