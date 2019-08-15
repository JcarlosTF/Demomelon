package com.example.demomelon.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.demomelon.adapters.ResultadoSeriesAdapter;
import com.example.demomelon.interfaces.IBuscarSeries;
import com.example.demomelon.model.entity.Series;
import com.example.demomelon.presenter.SearchSeriePresenter;
import com.example.demomelon.R;

import java.util.ArrayList;
import java.util.List;

public class BuscarActivity extends AppCompatActivity implements IBuscarSeries.LoginView {
    private SharedPreferences preferencia;
    private IBuscarSeries.LoginPresenter presenter;

    private EditText editText;
    private TextView errorSerie;
    private ProgressBar progressBar;

    private ImageButton btnBuscar,btnCancelar;


    private List<Series>seriesList;
    private RecyclerView recyclerView;
    ResultadoSeriesAdapter resultadoSeriesAdapter;
    private RecyclerView.LayoutManager layoutManager;

    boolean booleanBuscar=true;
    private String Serie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        preferencia = this.getSharedPreferences("preferencia", Context.MODE_PRIVATE);

        editText=findViewById(R.id.SerieaBuscar);

        btnBuscar= findViewById(R.id.imgBtnBuscar);
        btnCancelar= findViewById(R.id.imgBtnCancelar);

        progressBar=findViewById(R.id.progressBar);
        errorSerie=findViewById(R.id.serieError);

        presenter=new SearchSeriePresenter(this);
        recyclerView=findViewById(R.id.recyclerView);

        btnBuscar.setVisibility(View.VISIBLE);
        btnCancelar.setVisibility(View.GONE);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Serie=editText.getText().toString();
                if(Serie.isEmpty()){
                    presenter.EntradaVacio("Error dato vacio");
                }else{
                    editText.setOnKeyListener(new View.OnKeyListener() {
                        @Override
                        public boolean onKey(View v, int keyCode, KeyEvent event) {
                            if((event.getAction()==KeyEvent.ACTION_DOWN)&&(keyCode==KeyEvent.KEYCODE_ENTER)){
                                presenter.searchSeries(v.getContext(),Serie);

                                editText.setEnabled(false);

                                btnBuscar.setVisibility(View.GONE);
                                btnCancelar.setVisibility(View.VISIBLE);
                                booleanBuscar=false;
                                return true;
                            }
                            return false;

                        }

                    });
                    if(booleanBuscar){
                        btnBuscar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                presenter.searchSeries(v.getContext(),Serie);

                                editText.setEnabled(false);

                                btnBuscar.setVisibility(View.GONE);
                                btnCancelar.setVisibility(View.VISIBLE);
                                booleanBuscar=false;
                                Log.e("false ",""+booleanBuscar);
                                if(booleanBuscar==false){
                                    btnCancelar.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            editText.setEnabled(true);
                                            seriesList.clear();
                                            resultadoSeriesAdapter.notifyDataSetChanged();
                                            btnCancelar.setVisibility(View.GONE);
                                            btnBuscar.setVisibility(View.VISIBLE);

                                            booleanBuscar=true;

                                        }
                                    });
                                }
                            }
                        });
                    }
                }
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
    public void EntradaVacio(String vacio) {
        editText.setError(vacio);
    }

    @Override
    public void ErrorSerieBuscada(String Error) {
        errorSerie.setVisibility(View.VISIBLE);
        errorSerie.setText(Error);
    }
    @Override
    public void showSeries(final List<Series> seriesList1) {
        seriesList = new ArrayList<>();

        layoutManager=new LinearLayoutManager(this);

        resultadoSeriesAdapter=new ResultadoSeriesAdapter(seriesList,R.layout.cardview_resultado_series, new ResultadoSeriesAdapter.OnItemClicListener() {
            @Override
            public void onItemClick(String name, int position) {
                String IDS= String.valueOf(seriesList.get(position).getId());
                guardadId(IDS);
                Intent intent=new Intent(BuscarActivity.this, ContenedorFragments.class);
                String NombreSerie=seriesList.get(position).getSeriesName();
                intent.putExtra("NombreTitulo",NombreSerie);

                startActivity(intent);
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        seriesList.addAll(seriesList1);
        recyclerView.setAdapter(resultadoSeriesAdapter);
    }


    private void guardadId(String id){
        SharedPreferences.Editor editor=preferencia.edit();
        editor.putString("guardarid",id);
        editor.apply();
    }
}
