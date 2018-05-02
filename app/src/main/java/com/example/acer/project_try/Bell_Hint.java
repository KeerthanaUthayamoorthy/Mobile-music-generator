package com.example.acer.project_try;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Bell_Hint extends AppCompatActivity {
    private Button bell_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bell_hint);
        bell_button = (Button) findViewById(R.id.playbell_btn);  // detect whether the play button is pressed or not
        bell_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBellplay();
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private void openBellplay() {
        Intent intent = new Intent(this, ShakerActivity.class);  // shaker activity will be opened
        startActivity(intent);
    }
}
