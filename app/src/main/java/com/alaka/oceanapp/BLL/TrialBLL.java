package com.alaka.oceanapp.BLL;

import com.alaka.oceanapp.API.APIEndpoints;
import com.alaka.oceanapp.API.Url;
import com.alaka.oceanapp.models.LoginResponse;
import com.alaka.oceanapp.models.TrialResponse;
import com.alaka.oceanapp.models.User;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class TrialBLL {

    private String tname;
    private String tphone;
    private String ttype;
    private String tdate;

    boolean isSuccess = false;

    public TrialBLL(String tname, String tphone, String ttype, String tdate) {
        this.tname = tname;
        this.tphone = tphone;
        this.ttype = ttype;
        this.tdate = tdate;

    }

    public boolean addTrial() {
        APIEndpoints apiEndpoints = Url.getEndPoints();
        Call<TrialResponse> trialResponseCall = apiEndpoints.trial(tname, tphone, ttype, tdate, Url.uid);

        try {
            Response<TrialResponse> response = trialResponseCall.execute();
            if (response.isSuccessful()) {
                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
