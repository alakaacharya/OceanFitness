package com.alaka.oceanapp.fragments;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.alaka.oceanapp.BLL.TrialBLL;
import com.alaka.oceanapp.R;
import com.alaka.oceanapp.StrictMod.StrictMod;
import com.alaka.oceanapp.activities.DashboardActivity;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrialFragment extends Fragment implements View.OnClickListener {

    private Button btnbook;
    private Spinner ettype;
    private EditText etname, etphone, etdate;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private String date;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_trial, container, false);


        etname = v.findViewById(R.id.etname);
        etphone = v.findViewById(R.id.etphone);
        ettype = v.findViewById(R.id.ettype);
        etdate = v.findViewById(R.id.etdate);
        btnbook = v.findViewById(R.id.btnbook);


        etdate.setOnClickListener(this);
        btnbook.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.etdate) {
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            date = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                            int hour = c.get(Calendar.HOUR);
                            int minute = c.get(Calendar.MINUTE);
                            new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                                @Override
                                public void onTimeSet(TimePicker view, int hourOfDay, int min) {
                                    date += " " + hourOfDay + ":" + min;
                                    etdate.setText(date);
                                }
                            }, hour, minute, false).show();
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        } else if (v.getId() == R.id.btnbook) {
            if (!validate()) return;
            final TrialBLL bll = new TrialBLL(etname.getText().toString(), etphone.getText().toString(), ettype.getSelectedItem().toString(), etdate.getText().toString());
            StrictMod.StrictMode();
            if (bll.addTrial()) {
                Toast.makeText(getActivity(), "Trial  booked!", Toast.LENGTH_SHORT).show();
                ((DashboardActivity) getActivity()).openFragment(new HomeFragment(), "Home");
            } else {
                Toast.makeText(getActivity(), "error, check credentials", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean validate() {
        if (TextUtils.isEmpty(etphone.getText().toString())) {
            etphone.setError("Please enter Phone");
            etname.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etname.getText().toString())) {
            etname.setError("Please enter name ");
            etname.requestFocus();
            return false;
        }
        return true;
    }


}



