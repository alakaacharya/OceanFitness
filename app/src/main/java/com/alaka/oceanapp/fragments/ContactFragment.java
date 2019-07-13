package com.alaka.oceanapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.alaka.oceanapp.R;
import com.alaka.oceanapp.activities.MapsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment implements View.OnClickListener {
    private Button btnMap;

    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_contact, container, false);

        btnMap = v.findViewById(R.id.btnMap);
        btnMap.setOnClickListener(this);

        return v;

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMap:
                Log.d("button click:", "first button");
                startActivity(new Intent(getActivity(), MapsActivity.class));
                break;


        }
    }
}