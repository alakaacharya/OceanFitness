package com.alaka.oceanapp.fragments;


import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.alaka.oceanapp.BLL.LoginBLL;
import com.alaka.oceanapp.MySharedPreference;
import com.alaka.oceanapp.R;
import com.alaka.oceanapp.StrictMod.StrictMod;
import com.alaka.oceanapp.activities.DashboardActivity;

import static android.content.Context.SENSOR_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    private Button btnlogin;
    private EditText etUsername, etPassword;
    SensorManager manager;
    Sensor sensor;
    SensorEventListener event;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_login, container, false);
        etUsername = v.findViewById(R.id.etusername);
        etPassword = v.findViewById(R.id.etpassword);
        btnlogin = v.findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(this);

        manager = (SensorManager) getActivity().getSystemService(SENSOR_SERVICE);
        sensor = manager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        event = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent.values[0] <= 1) {
                    MySharedPreference.setBoolean(getActivity(), "isLoggedIn", true);
                    ((DashboardActivity) getActivity()).openFragment(new RegisterFragment(), "Register");

//                startActivity(new Intent(getActivity(), DashboardActivity.class));

                    Toast.makeText(getActivity(), "Object is near.", Toast.LENGTH_SHORT).show();
                } else {
//                Toast.makeText(getActivity(), "Object is far.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

        return v;
    }


    @Override
    public void onClick(View v) {
        if (!validate()) return;
        final LoginBLL bll = new LoginBLL(etUsername.getText().toString(), etPassword.getText().toString());
        StrictMod.StrictMode();

        if (bll.checkUser()) {
            MySharedPreference.setBoolean(getActivity(), "isLoggedIn", true);
            getActivity().finishAffinity();
            getActivity().startActivity(new Intent(getActivity(), DashboardActivity.class));
        } else {
            Toast.makeText(getActivity(), "error, check credentials", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validate() {
        if (TextUtils.isEmpty(etUsername.getText().toString())) {
            etUsername.setError("Please enter username");
            etPassword.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(etUsername.getText().toString())) {
            etPassword.setError("Please enter password; ");
            etPassword.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
        manager.registerListener(event, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onStop() {
        super.onStop();
        manager.unregisterListener(event);
    }
}
