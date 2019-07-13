package com.alaka.oceanapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.alaka.oceanapp.MySharedPreference;
import com.alaka.oceanapp.R;
import com.alaka.oceanapp.fragments.BmiFragment;
import com.alaka.oceanapp.fragments.ContactFragment;
import com.alaka.oceanapp.fragments.HomeFragment;
import com.alaka.oceanapp.fragments.LoginFragment;
import com.alaka.oceanapp.fragments.RegisterFragment;
import com.alaka.oceanapp.fragments.ServiceFragment;
import com.alaka.oceanapp.fragments.TrainerFragment;
import com.alaka.oceanapp.fragments.TrialFragment;


public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout drawerLayout;
    private TextView tvtitle;
    private View navHome, navTrainer, navService, navContact, navRegister, navLogin, navTrial, navBmi, navLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        tvtitle = findViewById(R.id.tvtitle);
        drawerLayout = findViewById(R.id.drawerlayout);

        navTrainer = findViewById(R.id.navTrainer);
        navContact = findViewById(R.id.navContact);
        navRegister = findViewById(R.id.navRegister);
        navLogin = findViewById(R.id.navlogin);
        navBmi = findViewById(R.id.navBmi);
        navService = findViewById(R.id.navService);
        navTrial = findViewById(R.id.navTrial);
        navHome = findViewById(R.id.navHome);
        navLogout = findViewById(R.id.navLogout);

        if (MySharedPreference.getBoolean(this, "isLoggedIn")) {
            navLogin.setVisibility(View.GONE);
            navRegister.setVisibility(View.GONE);
            openFragment(new HomeFragment(), "Home");
        } else {
            navLogout.setVisibility(View.GONE);
            navTrial.setVisibility(View.GONE);
            navBmi.setVisibility(View.GONE);
            openFragment(new LoginFragment(), "Login");
        }

        navHome.setOnClickListener(this);
        navTrainer.setOnClickListener(this);
        navContact.setOnClickListener(this);
        navRegister.setOnClickListener(this);
        navLogin.setOnClickListener(this);
        navBmi.setOnClickListener(this);
        navTrial.setOnClickListener(this);
        navService.setOnClickListener(this);
        navHome.setOnClickListener(this);
        navLogout.setOnClickListener(this);
    }

    public void openFragment(Fragment fragment, String title) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        tvtitle.setText(title);
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    public void openDrawer(View view) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public void openRegisterActivity(View view) {


        //  ((DashboardActivity) getActivity()).openFragment(new HomeFragment(), "Home");

        // startActivity(new Intent(this, RegisterFragment.class));


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navHome:
                openFragment(new HomeFragment(), " Home");
                break;
            case R.id.navBmi:
                openFragment(new BmiFragment(), " Trainer");
                break;
            case R.id.navContact:
                openFragment(new ContactFragment(), " Contact");
                break;
            case R.id.navRegister:
                openFragment(new RegisterFragment(), " Register");
                break;
            case R.id.navService:
                openFragment(new ServiceFragment(), " Service Price");
                break;
            case R.id.navTrainer:
                openFragment(new TrainerFragment(), " Trainer");
                break;
            case R.id.navlogin:
                openFragment(new LoginFragment(), " Login");
                break;
            case R.id.navTrial:
                openFragment(new TrialFragment(), " Trial");
                break;


            case R.id.navLogout:
                finish();
                startActivity(new Intent(this, DashboardActivity.class));
                MySharedPreference.setBoolean(this, "isLoggedIn", false);
                break;
        }
    }
}
