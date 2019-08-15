package com.example.demomelon.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.demomelon.api.ISerieService;
import com.example.demomelon.api.ServiceClient;
import com.example.demomelon.interfaces.IEpisodios;
import com.example.demomelon.model.entity.Episodios;
import com.example.demomelon.model.entity.EpisodiosData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EpisodesInteractor implements IEpisodios.EpisodiosModel {
    private IEpisodios.EpisodiosPresenter presenter;
    private SharedPreferences preferencia,preferences,preferencesDetalles;
    private static  final String TAG="EpisodesInteractor";
    public EpisodesInteractor(IEpisodios.EpisodiosPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getEpisodios(Context context, String s) {
        preferencia = context.getSharedPreferences("preferencia", Context.MODE_PRIVATE);
        preferences = context.getSharedPreferences("preferencia", Context.MODE_PRIVATE);
        preferencesDetalles = context.getSharedPreferences("preferencia",Context.MODE_PRIVATE);

        String tokenobtenido=getTokenIniciarPreferencia();
        String ID=getIdPreferencia();
        String totalSeasons=getIdPreferenciaTotalseasons();

        Log.e("datos token ",tokenobtenido);
        Log.e("datos id ",ID);
        Log.e("datos seasons ",totalSeasons);

        ISerieService serieService= ServiceClient.createSerieService();
        final Call<EpisodiosData> detalles=serieService.getEpisode("Bearer "+tokenobtenido,ID,s);
        detalles.enqueue(new Callback<EpisodiosData>() {
            @Override
            public void onResponse(Call<EpisodiosData> call, Response<EpisodiosData> response) {
                if(response.isSuccessful()){
                    List<Episodios> episodiosList=response.body().getData();
                    presenter.showEpisodios(episodiosList);
                }else{
                    Log.e(TAG,"no hay datos");
                }
            }
            @Override
            public void onFailure(Call<EpisodiosData> call, Throwable t) {

            }
        });
    }

    private String getTokenIniciarPreferencia(){
        return preferencia.getString("tokenIniciar","");
    }
    private String getIdPreferencia(){
        return preferences.getString("guardarid","");
    }
    private String getIdPreferenciaTotalseasons(){
        return preferencesDetalles.getString("guardarTotalSeasons","");
    }

}
