package com.alaka.oceanapp.API;

import com.alaka.oceanapp.models.LoginResponse;
import com.alaka.oceanapp.models.PriceResponse;
import com.alaka.oceanapp.models.TrainResponse;
import com.alaka.oceanapp.models.TrialResponse;
import com.alaka.oceanapp.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIEndpoints {
    @FormUrlEncoded
    @POST("users/login")
    Call<LoginResponse> login(@Field("username") String username, @Field("password") String password);

    @POST("users/signup")
    Call<LoginResponse> signup(@Body User user);

    @FormUrlEncoded
    @POST("/trials")
    Call<TrialResponse> trial(@Field("tname") String name, @Field("tphone") String phone, @Field("ttype") String type, @Field("tdate") String date, @Field("userid")String userid);

    @GET("/teachers")
    Call<List<TrainResponse>> getTrainer(@Header("cookie") String cookie);


    @GET("/details")
    Call<List<PriceResponse>> getPrice(@Header("cookie") String cookie);


}
