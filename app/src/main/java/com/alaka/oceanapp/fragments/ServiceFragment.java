package com.alaka.oceanapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alaka.oceanapp.R;
import com.alaka.oceanapp.adapters.ViewPagerAdapter;

public class ServiceFragment extends Fragment {

    private ViewPager pager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_service, container, false);
        pager = v.findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new PriceFragment());
        adapter.addFragment(new YogaFragment());
        pager.setAdapter(adapter);
        return v;
    }

}
