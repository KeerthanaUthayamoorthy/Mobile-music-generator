package com.example.acer.project_try;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tabla extends AppCompatActivity {
    private Button tablaBtn1,tablaBtn2;
    MediaPlayer media_player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla);

        media_player = MediaPlayer.create(Tabla.this,R.raw.tabla);
        tablaBtn1=(Button) findViewById(R.id.tabla1);
        tablaBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playtabla();
            }
        });
        tablaBtn2=(Button) findViewById(R.id.tabla2);
        tablaBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playtabla();
            }
        });


    }

    private void playtabla() {
        media_player.start();
    }
}
