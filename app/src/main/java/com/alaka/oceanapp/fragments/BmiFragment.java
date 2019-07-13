package com.alaka.oceanapp.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.alaka.oceanapp.R;

public class BmiFragment extends Fragment {

    private EditText etheight, etweight;
    private TextView tvbmi;
    private Button btnbmi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bmi, container, false);
        etheight = v.findViewById(R.id.etheight);
        etweight = v.findViewById(R.id.etweight);
        tvbmi = v.findViewById(R.id.tvbmi);
        btnbmi = v.findViewById(R.id.btnbmi);

        btnbmi.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                calcBMI();
                hideKeyboard(getActivity());
            }
        });
        return v;
    }

    public void calcBMI() {
        float weight, height, bmi;
        weight = Float.parseFloat(etweight.getText().toString().trim());
        height = Float.parseFloat(etheight.getText().toString().trim());

        bmi = weight / (height * height);

        tvbmi.setText(String.valueOf(bmi));

        if (bmi < 18.5) {
            Toast.makeText(getActivity(), "UNDERWEIGHT", Toast.LENGTH_SHORT).show();
        } else if (bmi > 18.5 && bmi < 25) {
            Toast.makeText(getActivity(), "NORMAL WEIGHT", Toast.LENGTH_SHORT).show();
        } else if (bmi > 24.9 && bmi < 30) {
            Toast.makeText(getActivity(), "OVERWEIGHT", Toast.LENGTH_SHORT).show();
        } else if (bmi >= 30) {
            Toast.makeText(getActivity(), "OBESITY", Toast.LENGTH_SHORT).show();
        }
    }

    //static method to hide keyboard
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);

        View view = activity.getCurrentFocus();

        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}


