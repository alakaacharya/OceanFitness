package com.alaka.oceanapp;

import com.alaka.oceanapp.BLL.LoginBLL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    @Test
    public void testLogin() {
        LoginBLL loginBLL = new LoginBLL("lol", "lol");
        boolean result = loginBLL.checkUser();
        assertEquals(true, result);

    }
}
