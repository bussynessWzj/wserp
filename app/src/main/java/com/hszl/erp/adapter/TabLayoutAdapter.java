package com.hszl.erp.adapter;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class TabLayoutAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;
    String[] title;

    public TabLayoutAdapter(FragmentManager fm, List<Fragment> list,String[] title) {
        super(fm);
        this.list = list;
        this.title=title;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
