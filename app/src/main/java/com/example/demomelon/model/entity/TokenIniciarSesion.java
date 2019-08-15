package com.example.demomelon.model.entity;

public class TokenIniciarSesion {
    private String apikey;
    private String userkey;
    private String username;

    public TokenIniciarSesion() {
    }

    public TokenIniciarSesion(String apikey, String userkey, String username) {
        this.apikey = apikey;
        this.userkey = userkey;
        this.username = username;
    }
}
