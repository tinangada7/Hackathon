package com.example.tinanenshigada.charitableeducation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener()
    {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
        {
            switch (menuItem.getItemId())
            {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new FragmentHome()).commit();
                    break;


                case R.id.navigation_yourdeed:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new FragmentTake()).commit();
                    break;

                case R.id.navigation_donate:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new FragnmentGive()).commit();
                    break;

                case R.id.navigation_aboutus:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new FrangmentAbout()).commit();
                    break;
            }
            return true;
        }
    };

    public void goTotakeclass(View view)
    {
        Intent intent = new Intent(this, TakeClass.class);
        startActivity(intent);
    }

    public void goTotakeQuiz(View view)
{
    Intent intent = new Intent(this, TakeQuiz.class);
    startActivity(intent);
}

}
