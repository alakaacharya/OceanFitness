package com.alaka.oceanapp.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> listFragment = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public int getCount() {
        return listFragment.size();
    }

    public void addFragment(Fragment fragment) {
        listFragment.add(fragment);
    }

    @Override
    public Fragment getItem(int i) {
        return listFragment.get(i);
    }

}
