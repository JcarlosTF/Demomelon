package com.example.demomelon.view;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.demomelon.R;
import com.example.demomelon.view.fragments.ActoresFragment;
import com.example.demomelon.view.fragments.DetallesFragment;
import com.example.demomelon.view.fragments.EpisodiosFragment;

public class ContenedorFragments extends AppCompatActivity {

    DetallesFragment fragmentDetalles;
    EpisodiosFragment fragmentEpisodios;
    ActoresFragment fragmentActores;
    TextView Titulo;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private ImageView imageViewizquierdo,imageViewderecho;
    private ImageButton imageButtonRegresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor_fragments);

        Titulo=findViewById(R.id.Titulo);

        radioGroup=findViewById(R.id.radioGroup);

        imageViewizquierdo=findViewById(R.id.logoIzquierdo);
        imageViewderecho=findViewById(R.id.logoDerecha);
        imageButtonRegresar=findViewById(R.id.imageBtnRegresar);


        imageViewizquierdo.setVisibility(View.GONE);
        imageViewderecho.setVisibility(View.VISIBLE);
        imageButtonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),BuscarActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();
        String NombreSerie = bundle.getString("NombreTitulo");
        Titulo.setText(NombreSerie);

        fragmentDetalles=new DetallesFragment();
        fragmentEpisodios=new EpisodiosFragment();
        fragmentActores=new ActoresFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.Contenedor,fragmentDetalles).commit();
    }
    public void checkButton(View v){
        int radioId=radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(radioId);
        String radio= String.valueOf(radioButton.getText());

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

        switch (radio){
            case "Detalles":
                fragmentTransaction.replace(R.id.Contenedor,fragmentDetalles);
                break;
            case "Episodios":
                fragmentTransaction.replace(R.id.Contenedor,fragmentEpisodios);
                break;
            case "Actores":
                fragmentTransaction.replace(R.id.Contenedor,fragmentActores);
                break;
        }

        fragmentTransaction.commit();
    }
}
