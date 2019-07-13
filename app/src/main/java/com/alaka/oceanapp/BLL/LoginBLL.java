package com.alaka.oceanapp.BLL;



import com.alaka.oceanapp.API.Url;
import com.alaka.oceanapp.models.LoginResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBLL {
    private String username;
    private String password;
    boolean isSuccess = false;

    public LoginBLL(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public boolean checkUser() {
        Call<LoginResponse> loginResponseCall = Url.getEndPoints().login(username, password);
        try {
            Response<LoginResponse> loginResponseResponse = loginResponseCall.execute();
            if (loginResponseResponse.isSuccessful()) {
                Url.cookie = loginResponseResponse.headers().get("set-cookie");
                Url.uid = loginResponseResponse.body().get_uid();
                isSuccess = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}

