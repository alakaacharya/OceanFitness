package com.alaka.oceanapp;

import com.alaka.oceanapp.fragments.TrialFragment;
import com.android21buttons.fragmenttestrule.FragmentTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.click;

public class TrialEspresso {

    @Rule
    public FragmentTestRule<?, TrialFragment> fragmentTestRule =
            FragmentTestRule.create(TrialFragment.class);


    private String etname="lel";
    private String etphone="999";
    private String etdate="07-07-2019 08:08";
    @Test
    public void TestUi() throws Exception{
        onView(withId(R.id.etname)).perform(typeText(etname));
        closeSoftKeyboard();
        onView(withId(R.id.etphone)).perform(typeText(etphone));
        closeSoftKeyboard();

        onView(withId(R.id.etdate)).perform(typeText(etdate));
        closeSoftKeyboard();

        onView(withId(R.id.btnbook)).perform(click());

    }


}
