package com.example.demomelon.interfaces;

import android.content.Context;

public interface ILogin {
    interface LoginModel{
        void validarSesion(String apikey,String userkey,String username, Context context);
    }
    interface LoginPresenter{
        void iniciarSesion(String apikey, String userkey, String username, Context context);

        void setError();

        void showToken(String token);
        void exitoOperacion();
    }
    interface LoginView{
        void showProgress();
        void hideProgress();

        void showToken(String token);

        void setError();

        void navigateToSearch();



    }

}
