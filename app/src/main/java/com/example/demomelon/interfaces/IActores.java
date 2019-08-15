package com.example.demomelon.interfaces;

import android.content.Context;

import com.example.demomelon.model.entity.Actores;
import java.util.List;

public interface IActores {
    interface ActoresModel{
        void getActores(Context context);
    }
    interface ActoresPresenter{
        void showActores(List<Actores> episodiosList);
        void getActores(Context context);
    }
    interface ActoresView{
        void showActores(List<Actores>episodiosList);

    }
}
