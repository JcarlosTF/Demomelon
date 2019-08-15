package com.example.demomelon.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.demomelon.api.IUserService;
import com.example.demomelon.api.ServiceClient;
import com.example.demomelon.interfaces.ILogin;
import com.example.demomelon.model.entity.TokenData;
import com.example.demomelon.model.entity.TokenIniciarSesion;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractor implements ILogin.LoginModel{
    private SharedPreferences preferencia;
    private ILogin.LoginPresenter presenter;
    private static final String TAG="LoginIteractor";

    public LoginInteractor(ILogin.LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void validarSesion(String apikey, String userkey, String username, Context context) {
        preferencia = context.getSharedPreferences("preferencia", Context.MODE_PRIVATE);

        IUserService userService = ServiceClient.createUserService();

        Call<TokenData> tokens=userService.login(new TokenIniciarSesion(apikey,userkey,username));
        tokens.enqueue(new Callback<TokenData>() {
            @Override
            public void onResponse(Call<TokenData> call, Response<TokenData> response) {
               if (response.isSuccessful()){
                   TokenData token2=response.body();

                   presenter.exitoOperacion();
                   presenter.showToken(token2.getToken());
                   guardadPrefences(token2.getToken());

                   Log.e(TAG,"RESPUESTA DEL SERVIDOR "+token2.getToken());
                }else{
                   presenter.setError();
               }
            }
            @Override
            public void onFailure(Call<TokenData> call, Throwable t) {

            }
        });

    }

    private void guardadPrefences(String token){
        SharedPreferences.Editor editor=preferencia.edit();
        editor.putString("tokenIniciar",token);
        editor.apply();
    }

}
