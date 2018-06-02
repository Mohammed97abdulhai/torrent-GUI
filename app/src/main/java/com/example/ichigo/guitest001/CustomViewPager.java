package com.example.ichigo.guitest001;

/**
 * Created by ichigo on 6/2/2018.
 */


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Chirag on 30-Jul-17.
 */

public class CustomViewPager extends FragmentStatePagerAdapter {

    int tabscount;

    public CustomViewPager(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.tabscount = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                Detailsfragment tab1 = new Detailsfragment();
                return tab1;
            case 1:
                Files tab2 = new Files();
                return  tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabscount;
    }
}