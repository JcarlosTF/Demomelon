package com.example.demomelon.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demomelon.interfaces.ILogin;
import com.example.demomelon.presenter.LoginPresenter;
import com.example.demomelon.R;

public class LoginActivity extends AppCompatActivity implements ILogin.LoginView{
    private Button btnEntrar;
    private ProgressBar progressBar;
    private TextView textV;

    private ILogin.LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnEntrar=(Button)findViewById(R.id.button);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        textV=(TextView)findViewById(R.id.Token);

        presenter=new LoginPresenter(this);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.iniciarSesion("PPDZ39EGKOEHNR3R","JOEZYXMFGR0RDBXA","tavromero2yu",v.getContext());
            }
        });
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showToken(String token) {
        textV.setText(token);
    }

    @Override
    public void setError() {
        Toast.makeText(this,"A ocurrido un error",Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateToSearch() {
        startActivity(new Intent(LoginActivity.this,BuscarActivity.class));
    }
}
