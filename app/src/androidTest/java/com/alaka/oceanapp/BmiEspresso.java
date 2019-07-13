package com.alaka.oceanapp;

import androidx.test.espresso.Espresso;

import com.alaka.oceanapp.fragments.BmiFragment;
import com.android21buttons.fragmenttestrule.FragmentTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;



public class BmiEspresso {

    @Rule
    public FragmentTestRule<?, BmiFragment> fragmentTestRule =  FragmentTestRule.create(BmiFragment.class);

    private String etheight="50";
    private String etweight="10";


    @Test
    public void TestUi() throws Exception{
        onView(withId(R.id.etheight)).perform(typeText(etheight));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.etweight)).perform(typeText(etweight));
        Espresso.closeSoftKeyboard();


        onView(withId(R.id.btnbmi)).perform(click());

    }


}
