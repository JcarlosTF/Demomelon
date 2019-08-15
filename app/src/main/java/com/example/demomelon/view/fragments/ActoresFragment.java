package com.example.demomelon.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demomelon.R;
import com.example.demomelon.adapters.ActoresAdaptador;
import com.example.demomelon.interfaces.IActores;
import com.example.demomelon.model.entity.Actores;
import com.example.demomelon.presenter.ActorsPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActoresFragment extends Fragment implements IActores.ActoresView {
    private IActores.ActoresPresenter presenter;
    private List<Actores>actores;

    ActoresAdaptador actoresAdaptador;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public ActoresFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_actores, container, false);

        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerViewActores);
        presenter=new ActorsPresenter(this);

        presenter.getActores(getContext());

        return view;
    }

    @Override
    public void showActores(List<Actores> episodiosList) {
        Log.e("dada ",""+episodiosList);
        actores = new ArrayList<>();
        actoresAdaptador = new ActoresAdaptador(this, actores);

        layoutManager=new LinearLayoutManager(getContext());
        layoutManager=new GridLayoutManager(getContext(),3);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(actoresAdaptador);

        actores.addAll(episodiosList);
        actoresAdaptador.notifyDataSetChanged();
    }
}
