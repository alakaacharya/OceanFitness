package com.alaka.oceanapp;


import androidx.test.espresso.Espresso;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.alaka.oceanapp.activities.DashboardActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class LoginEspresso {

    @Rule

  public ActivityTestRule<DashboardActivity> testRule=new ActivityTestRule<>(DashboardActivity.class);
    private String mtext="lol";
    private String mtext1="lol";
    @Test
    public void TestUi() throws Exception{
        onView(withId(R.id.etusername)).perform(typeText(mtext));
       Espresso.closeSoftKeyboard();
        onView(withId(R.id.etpassword)).perform(typeText(mtext1));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.btnlogin)).perform(click());

    }
}