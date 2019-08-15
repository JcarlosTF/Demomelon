package com.example.demomelon.api;

import com.example.demomelon.model.entity.TokenData;
import com.example.demomelon.model.entity.TokenIniciarSesion;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IUserService {
    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })
    //login
    @POST("login")
        // Call<TokenData> getToken(@Query("apikey") String apikey,@Query("userkey") String userkey,@Query("username") String username);
    Call<TokenData> login(@Body TokenIniciarSesion loginData);
}
