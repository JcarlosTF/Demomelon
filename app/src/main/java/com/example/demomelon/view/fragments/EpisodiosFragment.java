package com.example.demomelon.view.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demomelon.R;
import com.example.demomelon.adapters.EpisodiosAdapter;
import com.example.demomelon.adapters.Item;
import com.example.demomelon.adapters.TemporadasAdapter;
import com.example.demomelon.interfaces.IEpisodios;
import com.example.demomelon.model.entity.Episodios;
import com.example.demomelon.presenter.EpisodesPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EpisodiosFragment extends Fragment implements IEpisodios.EpisodiosView {
    private SharedPreferences preferenciaTempordaspresionado,preferencesDetalles;
    private IEpisodios.EpisodiosPresenter presenter;

    List<Episodios> episodios;
    EpisodiosAdapter episodiosAdapter;
    List<Item> items=new ArrayList<>() ;

    TemporadasAdapter temporadasAdapter;

    private RecyclerView recyclerView,recyclerViewBtn;
    private RecyclerView.LayoutManager layoutManagerBtn;

    int totalSeasons;

    public EpisodiosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_episodios, container, false);

        preferencesDetalles = getContext().getSharedPreferences("preferencia", Context.MODE_PRIVATE);
        preferenciaTempordaspresionado = getContext().getSharedPreferences("preferencia", Context.MODE_PRIVATE);

        recyclerView = (RecyclerView) view.findViewById(R.id.ReciclerViewEpisodios);
        recyclerViewBtn = (RecyclerView) view.findViewById(R.id.recyclerViewBotones);

        presenter = new EpisodesPresenter(this);

        //obtener Temporadas
        totalSeasons= Integer.parseInt(getIdPreferenciaTotalseasons());


        items.clear();
        LoadButtonTempo();


        String tempo="1";
        guardadTemporadasPresionado(tempo);

        presenter.getEpisodios(getContext(),tempo);
        return view;
    }

    @Override
    public void showEpisodios(List<Episodios> episodiosList) {
        episodios = new ArrayList<>();

        episodiosAdapter = new EpisodiosAdapter(this, episodios);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(episodiosAdapter);

        episodios.addAll(episodiosList);
        episodiosAdapter.notifyDataSetChanged();

    }

    public void LoadButtonTempo(){

        for(int i=1;i<=totalSeasons;i++) {
            Item item=new Item();
            item.setName(""+i);

            items.add(item);
        }

        layoutManagerBtn=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        temporadasAdapter=new TemporadasAdapter(items,R.layout.botones_cardview, new TemporadasAdapter.OnItemClicListener() {
            @Override
            public void onItemClick(String name, int position) {
                //obtener la posicion de los items dibujados
                String tempo=items.get(position).getName();
                //enviar al presenter el contexto y el numero de item del recyclerview seleccionado
                guardadTemporadasPresionado(tempo);

                String temporadaSelecionada=getTemporadasPresionado();
                presenter.getEpisodios(getContext(),temporadaSelecionada);
            }
        });

            recyclerViewBtn.setLayoutManager(layoutManagerBtn);
            recyclerViewBtn.setAdapter(temporadasAdapter);
    }

    //obtener datos de sharepreferences
    private String getIdPreferenciaTotalseasons(){
        return preferencesDetalles.getString("guardarTotalSeasons","");
    }

    private void guardadTemporadasPresionado(String id){
        SharedPreferences.Editor editor=preferenciaTempordaspresionado.edit();
        editor.putString("guardarNumTemporada",id);
        editor.apply();
    }

    private String getTemporadasPresionado(){
        return preferenciaTempordaspresionado.getString("guardarNumTemporada","");
    }

}
