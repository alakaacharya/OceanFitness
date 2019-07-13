package com.alaka.oceanapp;


import androidx.test.espresso.Espresso;

import com.alaka.oceanapp.fragments.RegisterFragment;
import com.android21buttons.fragmenttestrule.FragmentTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;



public class RegisterEspresso {
    @Rule
    public FragmentTestRule<?, RegisterFragment> fragmentTestRule =  FragmentTestRule.create(RegisterFragment.class);

    private String etname="la";
    private String etusername="la";
    private String etemail="la@example.com";
    private String etpassword="la";

    @Test
    public void TestUi() throws Exception{
        onView(withId(R.id.etname)).perform(typeText(etname));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.etusername)).perform(typeText(etusername));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.etemail)).perform(typeText(etemail));
       Espresso.closeSoftKeyboard();
       onView(withId(R.id.etpassword)).perform(typeText(etpassword));
       Espresso.closeSoftKeyboard();

       onView(withId(R.id.btnsignup)).perform(click());

    }

}


