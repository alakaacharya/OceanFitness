package com.alaka.oceanapp;

import com.alaka.oceanapp.BLL.LoginBLL;
import com.alaka.oceanapp.BLL.RegisterBLL;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegisterTest {

    @Test
    public void testRegister() {
        RegisterBLL registerBLL= new RegisterBLL("ew", "ew", "ew", "ew@ew.com");
        boolean result = registerBLL.addUser();
        assertEquals(true, result);

    }
}
