package com.example.demomelon.presenter;

import android.content.Context;

import com.example.demomelon.interfaces.IDetalles;
import com.example.demomelon.model.DetailsInteractor;

public class DetatailsPresenter implements IDetalles.DetallesPresenter{

private IDetalles.DetallesView view;
private IDetalles.DetallesModel model;

    public DetatailsPresenter(IDetalles.DetallesView view) {
        this.view = view;
        this.model = new DetailsInteractor(this);
    }

    @Override
    public void getDetalles(Context context) {
        view.showProgress();
        model.getDetalles(context);
    }

    @Override
    public void showDetalles(String getAirsDayOfWeek, String getAirsTime, String getFirstAired, String getOverview) {
        view.hideProgress();
        view.showDetalles(getAirsDayOfWeek,getAirsTime,getFirstAired,getOverview);
    }

    @Override
    public void showDetallesDos(String getGenre, String getImdbRating, String getPoster, String getTotalSeasons) {
        view.hideProgress();
        view.showDetallesDos(getGenre, getImdbRating, getPoster, getTotalSeasons);
    }
}
