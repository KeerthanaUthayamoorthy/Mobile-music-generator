package com.example.acer.project_try;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewOnBoardingScreen extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private LinearLayout mDotLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newonboardingscreen);
        mDotLayout=(LinearLayout) findViewById(R.id.dotsLayout);
        mSlideViewPager=(ViewPager) findViewById(R.id.slideViewPager);
        sliderAdapter =new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator();
    }
    public void addDotsIndicator(){
        mDots=new TextView[3];
        for(int i=0;i<mDots.length;i++){
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(10);
            mDots[i].setTextColor(getResources().getColor(R.color.white));
            mDotLayout.addView(mDots[i]);
        }
    }
}
