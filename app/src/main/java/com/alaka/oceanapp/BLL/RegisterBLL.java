package com.alaka.oceanapp.BLL;

import com.alaka.oceanapp.API.APIEndpoints;
import com.alaka.oceanapp.API.Url;
import com.alaka.oceanapp.models.LoginResponse;
import com.alaka.oceanapp.models.User;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class RegisterBLL {

    private String username;
    private String password;
    private String uname;
    private String email;

    boolean isSuccess = false;

    public RegisterBLL(String username, String password, String uname, String email) {
        this.username = username;
        this.password = password;
        this.uname = uname;
        this.email = email;

    }

    public boolean addUser() {
        APIEndpoints apiEndpoints = Url.getEndPoints();
        User user = new User(username, password, uname, email);
        Call<LoginResponse> loginSignupResponseCall = apiEndpoints.signup(user);

        try {
            Response<LoginResponse> response = loginSignupResponseCall.execute();
            if (response.isSuccessful()) {
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
