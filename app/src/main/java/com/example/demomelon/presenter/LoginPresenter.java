package com.example.demomelon.presenter;

import android.content.Context;

import com.example.demomelon.interfaces.ILogin;
import com.example.demomelon.model.LoginInteractor;

public class LoginPresenter implements ILogin.LoginPresenter {
    private ILogin.LoginView view;
    private ILogin.LoginModel model;

    public LoginPresenter(ILogin.LoginView view) {
        this.view = view;
        this.model = new LoginInteractor(this);
    }

    @Override
    public void iniciarSesion(String apikey, String userkey, String username,Context context) {
        if(view != null){
            view.showProgress();
        }
        model.validarSesion(apikey,userkey,username,context);
    }

    @Override
    public void showToken(String token) {
        view.showToken(token);
    }


    @Override
    public void setError() {
        if(view != null){
            view.hideProgress();
            view.setError();
        }
    }

    @Override
    public void exitoOperacion() {
        if(view != null){
            view.hideProgress();
            view.navigateToSearch();
        }
    }



}
