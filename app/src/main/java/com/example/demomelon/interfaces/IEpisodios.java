package com.example.demomelon.interfaces;

import android.content.Context;

import com.example.demomelon.model.entity.Episodios;

import java.util.List;

public interface IEpisodios {
        interface EpisodiosModel{
                void getEpisodios(Context context, String s);
        }
        interface EpisodiosPresenter{
                void showEpisodios(List<Episodios>episodiosList);
                void getEpisodios(Context context, String s);
        }
        interface EpisodiosView{
                void showEpisodios(List<Episodios>episodiosList);
        }
}
