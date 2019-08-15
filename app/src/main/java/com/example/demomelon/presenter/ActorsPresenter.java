package com.example.demomelon.presenter;

import android.content.Context;

import com.example.demomelon.interfaces.IActores;
import com.example.demomelon.model.ActorsInteractor;
import com.example.demomelon.model.entity.Actores;

import java.util.List;

public class ActorsPresenter implements IActores.ActoresPresenter {
    private IActores.ActoresView view;
    private IActores.ActoresModel model;

    public ActorsPresenter(IActores.ActoresView view) {
        this.view = view;
        this.model = new ActorsInteractor(this);
    }

    @Override
    public void showActores(List<Actores> actoresList) {
        view.showActores(actoresList);
    }

    @Override
    public void getActores(Context context) {
        model.getActores(context);
    }
}
