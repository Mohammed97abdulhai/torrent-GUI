package com.example.ichigo.guitest001;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Debug;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.zip.Inflater;

public class Add_torrent extends AppCompatActivity implements  Detailsfragment.OnFragmentInteractionListener, Files.OnFragmentInteractionListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    static private String name;
    static boolean variable =false;
    EditText torrentname;
    Button b1;
    View fragview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_torrent);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Details"));
        tabLayout.addTab(tabLayout.newTab().setText("Files"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        viewPager = (ViewPager) findViewById(R.id.pager);
        CustomViewPager adapter = new CustomViewPager(getSupportFragmentManager(), tabLayout.getTabCount());
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

