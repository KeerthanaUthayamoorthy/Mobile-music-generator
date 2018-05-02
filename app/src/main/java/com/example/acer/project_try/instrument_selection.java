package com.example.acer.project_try;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class instrument_selection extends AppCompatActivity {

    private Button button;
    private Button bell_button;
    private Button tambourine_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument_selection);
        button=(Button) findViewById(R.id.Shaker_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainActivity();
            }
        });

        bell_button=(Button) findViewById(R.id.Bell_btn);
        bell_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBellHint();
            }
        }); // open hints to play bell

        tambourine_btn=(Button) findViewById(R.id.Tambourine_btn);
        tambourine_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTambourine();
            }
        });
    }
    public void openTambourine(){
        Intent intent=new Intent(this,TambourinePlayActivity.class);
        startActivity(intent);
    }

    private void openBellHint() {
        Intent intent=new Intent(this,Bell_Hint.class); // select to play bell
        startActivity(intent);
    }

    public void openMainActivity(){
            Intent intent=new Intent(this,MainActivity.class); // select to play
            startActivity(intent);

    }



}
