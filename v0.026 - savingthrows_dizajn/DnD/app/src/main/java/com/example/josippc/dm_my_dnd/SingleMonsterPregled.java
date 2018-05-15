package com.example.josippc.dm_my_dnd;

import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

public class SingleMonsterPregled extends AppCompatActivity implements Tab1.OnFragmentInteractionListener,Tab2.OnFragmentInteractionListener, Tab3.OnFragmentInteractionListener, Tab4.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_monster_pregled);

        //Da sakrije LEGENDARY tab ako je blank
        Bundle b = getIntent().getExtras();
        final String monsterId = b.getString("monsterId");
        Cursor c = null;
        DatabaseHelper myDbHelper = new DatabaseHelper(SingleMonsterPregled.this);
        try {
            myDbHelper.createDataBase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        }
        try {
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            throw sqle;
        }
        String[] args = { monsterId };
        c = myDbHelper.myDataBase.query("monsters", null ,"_id=?", args,  null, null, "Name");

        // Još nemamo column za LEGENDARY pa je tu samo zakomentirano
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Overview"));
        tabLayout.addTab(tabLayout.newTab().setText("Attacks"));
        tabLayout.addTab(tabLayout.newTab().setText("Traits"));
        if (c.moveToFirst()) {
            do {
                if(c.getString(62).length()>0) {
                    tabLayout.addTab(tabLayout.newTab().setText("Legendary"));
                }
            } while (c.moveToNext());
        }


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager=(ViewPager)findViewById(R.id.pager);
        final PagerAdapter adapter=new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
