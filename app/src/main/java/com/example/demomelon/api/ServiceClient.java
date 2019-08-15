package com.example.demomelon.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceClient {
    public static final String BASE_URL="https://api.thetvdb.com/";
    public static final String BASE_URLDetalles="https://omdbapi.com/";

    public static IUserService createUserService(){
        return createRetrofit().create(IUserService.class);
    }

    public static ISerieService createSerieService(){
        return  createRetrofit().create(ISerieService.class);
    }

    public static ISerieDosService createSerieDosService(){
        return  CreateRetrofitSeriesDos().create(ISerieDosService.class);
    }



    private static Retrofit createRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }

    public static Retrofit CreateRetrofitSeriesDos(){
           Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URLDetalles)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }

}
