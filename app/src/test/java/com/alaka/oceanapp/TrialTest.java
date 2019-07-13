package com.alaka.oceanapp;


import com.alaka.oceanapp.BLL.TrialBLL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrialTest {

    @Test
    public void testTrial(){
        TrialBLL trialBLL=new TrialBLL("he", "99", "zumba", "8");
        boolean result = trialBLL.addTrial();
        assertEquals(true, result);
    }

}
