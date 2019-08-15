package com.example.demomelon.interfaces;

import android.content.Context;

import com.example.demomelon.model.entity.Series;

import java.util.List;

public interface IBuscarSeries {
    interface LoginModel{
        void BuscarSereis(Context context,String serieBuscar);
    }
    interface LoginPresenter{
        void showSeries(List<Series> seriesList);

        void searchSeries(Context context,String serieBuscar);

        void ErrorSerieBuscada(String Error);

        void EntradaVacio(String vacio);


    }
    interface LoginView{
        void showProgress();
        void hideProgress();

        void EntradaVacio(String vacio);

        void ErrorSerieBuscada(String Error);

        void showSeries(List<Series> seriesList);

    }
}
