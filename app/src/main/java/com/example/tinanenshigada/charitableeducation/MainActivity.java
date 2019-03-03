package com.example.tinanenshigada.charitableeducation;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private static SliderAdaptor S;
    private ViewPager mSlideViewpager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private Button N;
    int currentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewpager = (ViewPager) findViewById(R.id.viewpagerlayout);
        mDotLayout = (LinearLayout) findViewById(R.id.dotslayout);
        N = (Button) findViewById(R.id.button5);



        S = new SliderAdaptor(this);
        mSlideViewpager.setAdapter(S);

        addDotsIndicator(0);
        mSlideViewpager.addOnPageChangeListener(viewListener);
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {
            {

            }
        }


        @Override
        public void onPageSelected(int i)
        {
            addDotsIndicator(i);
            currentPage = i;

            if(i==mDots.length-1)
            {
                N.setEnabled(true);
                N.setVisibility(View.VISIBLE);
                N.setText("Get started");
                mDotLayout.setVisibility(View.INVISIBLE);
            }
            else {
                mDotLayout.setVisibility(View.VISIBLE);
                N.setEnabled(false);
                N.setVisibility(View.INVISIBLE);
                N.setText("");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    public void addDotsIndicator(int position)
    {
        mDots = new TextView[4];
        mDotLayout.removeAllViews();
        for(int i=0;i<mDots.length;i++)
        {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorPrimary));

            mDotLayout.addView(mDots[i]);
        }
        if(mDots.length >0)
        {
            mDots[position].setTextColor(getResources().getColor(R.color.colorButton));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button5:
                break;
        }
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void goToHome(View view)
    {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}