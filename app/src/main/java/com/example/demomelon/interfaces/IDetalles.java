package com.example.demomelon.interfaces;

import android.content.Context;

public interface IDetalles {

    interface DetallesModel{
        void getDetalles(Context context);
    }
    interface DetallesPresenter{
       void getDetalles(Context context);
        void showDetalles(String getAirsDayOfWeek,String getAirsTime,String getFirstAired,String getOverview);
        void showDetallesDos(String getGenre,String getImdbRating,String getPoster,String getTotalSeasons);
    }
    interface DetallesView{
        void showProgress();
        void hideProgress();
        void showDetalles(String getAirsDayOfWeek,String getAirsTime,String getFirstAired,String getOverview);
        void showDetallesDos(String getGenre,String getImdbRating,String getPoster,String getTotalSeasons);
    }
}
