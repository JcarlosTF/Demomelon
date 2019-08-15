package com.example.demomelon.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.demomelon.api.ISerieDosService;
import com.example.demomelon.api.ISerieService;
import com.example.demomelon.api.ServiceClient;
import com.example.demomelon.interfaces.IDetalles;
import com.example.demomelon.model.entity.DetallesData;
import com.example.demomelon.model.entity.DetallesDos;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsInteractor implements IDetalles.DetallesModel{
    private static final String TAG="DetailsInteractor";
    private Context contexts;
    private SharedPreferences preferencia,preferences,preferencesDetalles;
    private IDetalles.DetallesPresenter presenter;

    public DetailsInteractor(IDetalles.DetallesPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getDetalles(Context context) {
        preferencia = context.getSharedPreferences("preferencia",Context.MODE_PRIVATE);
        preferences = context.getSharedPreferences("preferencia",Context.MODE_PRIVATE);
        preferencesDetalles = context.getSharedPreferences("preferencia",Context.MODE_PRIVATE);


        String tokenobtenido=getTokenIniciarPreferencia();
        String ID=getIdPreferencia();

        ISerieService serieService= ServiceClient.createSerieService();

        final Call<DetallesData> detalles=serieService.getDetailsReult("Bearer "+tokenobtenido,ID);
        detalles.enqueue(new Callback<DetallesData>() {
            @Override
            public void onResponse(Call<DetallesData> call, Response<DetallesData> response) {
                if(response.isSuccessful()){
                    //Log.e("LoginActivity", ""+response.body());
                    String getAirsDayOfWeek=response.body().getData().getAirsDayOfWeek();
                    String getAirsTime=response.body().getData().getAirsTime();
                    String getFirstAired=response.body().getData().getFirstAired();
                    String getOverview=response.body().getData().getOverview();
                    String getImdbId=response.body().getData().getImdbId();
                    Log.e("a ",getImdbId);
                    presenter.showDetalles(getAirsDayOfWeek,getAirsTime,getFirstAired,getOverview);

                    DetallesDos(getImdbId);
                }else {
                    Log.e(TAG,"no hay datos");
                }
            }

            @Override
            public void onFailure(Call<DetallesData> call, Throwable t) {
                Log.e("error ",""+t);
            }
        });
    }


    public  void DetallesDos(String ImdbId){
        ISerieDosService serieService=ServiceClient.createSerieDosService();
        final Call<DetallesDos> detalles=serieService.getDetailDos("?i="+ImdbId+"&apikey=2f1f55d7&plot=full");

        detalles.enqueue(new Callback<DetallesDos>() {
            @Override
            public void onResponse(Call<DetallesDos> call, Response<DetallesDos> response) {
                if(response.isSuccessful()){
                    Log.e("temporadas ",""+response.body().getTotalSeasons());
                    String getGenre=response.body().getGenre();
                    String getImdbRating=response.body().getImdbRating();
                    String getPoster=response.body().getPoster();
                    String getTotalSeasons=response.body().getTotalSeasons();

                    if(getTotalSeasons==null){
                        guardadTotalSeasons("0");
                    }else {
                        guardadTotalSeasons(getTotalSeasons);
                    }
                    presenter.showDetallesDos(getGenre,getImdbRating,getPoster,getTotalSeasons);


                }else{
                    //String datosa=response.body();
                    Log.e(TAG,"datos vacios");
                }

            }

            @Override
            public void onFailure(Call<DetallesDos> call, Throwable t) {
                Log.e("error ",""+t);
            }
        });
    }
    private String getTokenIniciarPreferencia(){
        return preferencia.getString("tokenIniciar","");
    }
    private String getIdPreferencia(){
        return preferences.getString("guardarid","");
    }

    private void guardadTotalSeasons(String id){
        SharedPreferences.Editor editor=preferencesDetalles.edit();
        editor.putString("guardarTotalSeasons",id);
        editor.apply();
    }



}
