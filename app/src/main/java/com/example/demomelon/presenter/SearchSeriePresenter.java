package com.example.demomelon.presenter;

import android.content.Context;

import com.example.demomelon.interfaces.IBuscarSeries;
import com.example.demomelon.model.SearchSerieInteractor;
import com.example.demomelon.model.entity.Series;

import java.util.List;

public class SearchSeriePresenter implements IBuscarSeries.LoginPresenter {
    private IBuscarSeries.LoginView view;
    private IBuscarSeries.LoginModel model;

    public SearchSeriePresenter(IBuscarSeries.LoginView view) {
        this.view = view;
        this.model = new SearchSerieInteractor(this);
    }

    @Override
    public void showSeries(List<Series> seriesList) {
        view.hideProgress();
        view.showSeries(seriesList);
    }

    @Override
    public void searchSeries(Context context,String serieBuscar) {
        view.showProgress();
        model.BuscarSereis(context,serieBuscar);
    }

    @Override
    public void ErrorSerieBuscada(String Error) {
        view.hideProgress();
        view.ErrorSerieBuscada(Error);
    }

    @Override
    public void EntradaVacio(String vacio) {
        view.EntradaVacio(vacio);
    }

}
