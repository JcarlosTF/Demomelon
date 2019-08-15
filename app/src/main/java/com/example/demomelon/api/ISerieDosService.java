package com.example.demomelon.api;

import com.example.demomelon.model.entity.DetallesDos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ISerieDosService {
    @GET
    Call<DetallesDos> getDetailDos(@Url String url);
}
