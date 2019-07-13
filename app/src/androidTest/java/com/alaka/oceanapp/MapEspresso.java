package com.alaka.oceanapp;



import com.alaka.oceanapp.fragments.ContactFragment;
import com.android21buttons.fragmenttestrule.FragmentTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MapEspresso {

    @Rule
    public FragmentTestRule<?, ContactFragment> fragmentTestRule =  FragmentTestRule.create(ContactFragment.class);



    @Test
    public void TestUi() throws Exception{

        onView(withId(R.id.btnsignup)).perform(click());

    }

}
