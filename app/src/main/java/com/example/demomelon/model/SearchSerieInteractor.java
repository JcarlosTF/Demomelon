package com.example.demomelon.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.demomelon.api.ISerieService;
import com.example.demomelon.api.ServiceClient;
import com.example.demomelon.interfaces.IBuscarSeries;
import com.example.demomelon.model.entity.SeriesData;
import com.example.demomelon.model.entity.Series;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchSerieInteractor implements IBuscarSeries.LoginModel {
    private SharedPreferences preferencia;
    private IBuscarSeries.LoginPresenter presenter;

    public SearchSerieInteractor(IBuscarSeries.LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void BuscarSereis(Context context, final String serieBuscar) {
        preferencia = context.getSharedPreferences("preferencia",Context.MODE_PRIVATE);
        String tokenobtenido=getTokenIniciarPreferencia();

        ISerieService  serieService= ServiceClient.createSerieService();

        final Call<SeriesData> series=serieService.getSeriesSearch("Bearer "+tokenobtenido,"="+serieBuscar);
        series.enqueue(new Callback<SeriesData>() {
            @Override
            public void onResponse(Call<SeriesData> call, Response<SeriesData> response) {
                if(response.isSuccessful()){

                    List<Series> seriesList=response.body().getSeries();
                    presenter.showSeries(seriesList);

                    }else{
                        Log.e("error ","no hay datos");
                        presenter.ErrorSerieBuscada("Error no se econtro la serie: "+serieBuscar+" :(");
                    }
                }
                @Override
                public void onFailure(Call<SeriesData> call, Throwable t) {
                    Log.e("errror",t.toString());
                }
            });
    }



    private String getTokenIniciarPreferencia(){
        return preferencia.getString("tokenIniciar","");
    }

}
