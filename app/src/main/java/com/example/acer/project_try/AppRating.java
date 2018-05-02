package com.example.acer.project_try;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class AppRating extends AppCompatActivity {
private static Button button_sbm;
private static TextView text_v;
private static RatingBar rating_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_rating);
        rating_b=(RatingBar)findViewById(R.id.ratingBar);
        text_v=(TextView)findViewById(R.id.text_v);

        rating_b.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
                text_v.setText(String.valueOf(rating));
            }
        });
    }
}
