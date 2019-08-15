package com.example.demomelon.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.demomelon.api.ISerieService;
import com.example.demomelon.api.ServiceClient;
import com.example.demomelon.interfaces.IActores;
import com.example.demomelon.model.entity.Actores;
import com.example.demomelon.model.entity.ActoresData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActorsInteractor implements IActores.ActoresModel {
    final static String TAG="no hay datos";
    private IActores.ActoresPresenter presenter;
    private SharedPreferences preferencia,preferences;

    public ActorsInteractor(IActores.ActoresPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getActores(Context context) {
        preferencia = context.getSharedPreferences("preferencia", Context.MODE_PRIVATE);
        preferences = context.getSharedPreferences("preferencia", Context.MODE_PRIVATE);
        String tokenObetnido=getToken();
        String ID=getId();

        ISerieService serieService= ServiceClient.createSerieService();

        final Call<ActoresData> actores=serieService.getActors("Bearer "+tokenObetnido,ID);
        actores.enqueue(new Callback<ActoresData>() {
            @Override
            public void onResponse(Call<ActoresData> call, Response<ActoresData> response) {

                if(response.isSuccessful()){
                    List<Actores> actoresList=response.body().getData();
                    presenter.showActores(actoresList);
                }else{
                    Log.e(TAG,"error no se encontraron datos");
                }
            }
            @Override
            public void onFailure(Call<ActoresData> call, Throwable t) {
            }
        });
    }

    private String getId() {
        return preferencia.getString("guardarid", "");
    }
    private String getToken() {
        return preferences.getString("tokenIniciar", "");
    }
}