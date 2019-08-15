package com.example.demomelon.presenter;

import android.content.Context;

import com.example.demomelon.interfaces.IEpisodios;
import com.example.demomelon.model.EpisodesInteractor;
import com.example.demomelon.model.entity.Episodios;

import java.util.List;

public class EpisodesPresenter implements IEpisodios.EpisodiosPresenter {
    private IEpisodios.EpisodiosView view;
    private IEpisodios.EpisodiosModel model;

    public EpisodesPresenter(IEpisodios.EpisodiosView view) {
        this.view = view;
        this.model = new EpisodesInteractor(this);
    }
    @Override
    public void showEpisodios(List<Episodios> episodiosList) {
        view.showEpisodios(episodiosList);
    }

    @Override
    public void getEpisodios(Context context, String s) {
        model.getEpisodios(context,s);
    }

}
